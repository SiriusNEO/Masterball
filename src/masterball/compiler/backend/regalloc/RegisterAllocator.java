package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmLoadInst;
import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.backend.rvasm.inst.AsmStoreInst;
import masterball.compiler.backend.rvasm.operand.*;
import masterball.compiler.backend.rvasm.operand.RawStackOffset.RawType;
import masterball.compiler.share.error.runtime.StackOverflowError;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.compiler.share.pass.AsmModulePass;
import masterball.debug.Log;
import masterball.compiler.backend.regalloc.InterferenceGraph.Edge;

import java.util.*;

import static masterball.compiler.backend.rvasm.operand.PhysicalReg.phyRegs;

public class RegisterAllocator implements AsmModulePass, AsmFuncPass {

    private static final int K = PhysicalReg.assignable.size();

    // info
    private AsmFunction curFunc;

    /*
     * reg container
     * Registers can only present in one of these
     * Registers in coalescedNodes and selectStack are "deleted"
     */
    private final Set<Register>
    precolored = new LinkedHashSet<>(phyRegs.values()),
    initial = new LinkedHashSet<>(),
    simplifyWorklist = new LinkedHashSet<>(),
    freezeWorklist = new LinkedHashSet<>(),
    spillWorklist = new LinkedHashSet<>(),
    spilledNodes = new LinkedHashSet<>(),
    coalescedNodes = new LinkedHashSet<>(),
    coloredNodes = new LinkedHashSet<>();
    private final Stack<Register> selectStack = new Stack<>();

    /* moves
     * coalescedMoves: have been coalesced.
     * constrainedMoves: rd and rs have an edge
     * frozenMoves: have been frozen, no need to consider it.
     * worklistMoves and activeMoves are moves "exists"
     */
    private final Set<AsmMvInst>
    coalescedMoves = new LinkedHashSet<>(),
    constrainedMoves = new LinkedHashSet<>(),
    frozenMoves = new LinkedHashSet<>(),
    worklistMoves = new LinkedHashSet<>(),
    activeMoves = new LinkedHashSet<>();

    /* graph */
    private final InterferenceGraph G = new InterferenceGraph();

    /* utils */
    private final Set<Register> introducedTemp = new HashSet<>();

    @Override
    public void runOnModule(AsmModule module) {
        Log.report("K", K);

        module.functions.forEach(this::runOnFunc);
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        Log.report("color func: ", function);

        curFunc = function;

        while (true) {
            init();
            Set<Register> backupInitial = new HashSet<>(initial);

            Log.mark();
            Log.report(initial);

            LivenessAnalyzer analyzer = new LivenessAnalyzer();
            analyzer.runOnFunc(function);
            build(analyzer);

            makeWorklist();

            Log.report("simplify", simplifyWorklist);
            Log.report("freeze", freezeWorklist);
            Log.report("spill", spillWorklist);

            do {
                if (!simplifyWorklist.isEmpty()) simplify();
                else if (!worklistMoves.isEmpty()) coalesce();
                else if (!freezeWorklist.isEmpty()) freeze();
                else if (!spillWorklist.isEmpty()) selectSpill();
            } while (!simplifyWorklist.isEmpty() || !worklistMoves.isEmpty() || !freezeWorklist.isEmpty() || !spillWorklist.isEmpty());

            coalescedNodes.forEach(n -> Log.report("alias", n, n.node.alias));

            assignColors();

            if (!spilledNodes.isEmpty()) {
                rewriteProgram();
            }
            else {
                backupInitial.forEach(reg -> Log.report("color", reg.identifier, reg.color));
                return;
            }
        }
    }

    private void init() {
        initial.clear();
        simplifyWorklist.clear();
        freezeWorklist.clear();
        spillWorklist.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selectStack.clear();

        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        worklistMoves.clear();
        activeMoves.clear();

        // init the graph
        G.init();

        // all physical registers are precolored
        precolored.forEach(reg -> {
            reg.color = (PhysicalReg) reg;
            reg.node.init(true);
        });

        curFunc.blocks.forEach(block -> block.instructions.forEach(inst -> {
            initial.addAll(inst.uses());
            initial.addAll(inst.defs());
        }));
        initial.removeAll(precolored);
        initial.forEach(reg -> {
            reg.color = null;
            reg.node.init(false);
        });

        // this priority calculation is quite simple
        // every reg's priority = sigma (use+def)*10^(the level of the block)

        for (AsmBlock block : curFunc.blocks) {
            double weight = Math.pow(10, Double.min(block.prevs.size(), block.nexts.size()));
            block.instructions.forEach(inst -> {
                inst.defs().forEach(def -> def.node.priority += weight);
                inst.uses().forEach(use -> use.node.priority += weight);
            });
        }
    }

    private void build(LivenessAnalyzer analyzer) {
        /*
         * build the InterferenceGraph
         * for inst from tail to head because we start with "liveOut"
         * for each inst, defs() and lives interference.
         * Then before move to pre inst, we do update: all defs() are dead while all uses() are live.
         * Notice that for Move we have to remove their uses()
         */

        for (AsmBlock block : curFunc.blocks) {
            HashSet<Register> lives = analyzer.getLiveOut(block);

            for (int i = block.instructions.size()-1; i >= 0; i--) {
                AsmBaseInst inst = block.instructions.get(i);
                if (inst instanceof AsmMvInst) {
                    lives.removeAll(inst.uses());
                    HashSet<Register> moveRelated = new HashSet<>(inst.defs());
                    moveRelated.addAll(inst.uses());
                    moveRelated.forEach(reg -> reg.node.moveList.add((AsmMvInst) inst));
                    worklistMoves.add((AsmMvInst) inst);
                }

                lives.add(PhysicalReg.reg("zero"));
                lives.addAll(inst.defs());

                Log.report("lives", lives);

                for (Register def : inst.defs())
                    for (Register live : lives)
                        G.addEdge(new Edge(def, live));

                lives.removeAll(inst.defs());
                lives.addAll(inst.uses());
            }
        }
    }

    private void makeWorklist() {
        /*
         * dispatch the node in initial to three worklists.
         */
        var it = initial.iterator();
        while (it.hasNext()) {
            Register reg = it.next();
            it.remove();
            Log.report("deg", reg.identifier, reg.node.degree);
            Log.report(reg.node.adjList);
            if (reg.node.degree >= K) spillWorklist.add(reg);
            else if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    private void enableMoves(Set<Register> regs) {
        /*
         * enable a move: from activeMoves to worklist
         */
        for (Register reg : regs)
            for (AsmMvInst move : nodeMoves(reg))
                if (activeMoves.contains(move)) {
                    activeMoves.remove(move);
                    worklistMoves.add(move);
                }
    }

    private void decrementDegree(Register reg) {
        /*
         * decrease the degree of reg
         * if the degree from K to K-1, then the moves of the adjacent nodes is possible to be enabled.
         */
        reg.node.degree--;
        if (reg.node.degree < K) {
            HashSet<Register> enableMovesWorklist = new HashSet<>(adjacent(reg));
            enableMovesWorklist.add(reg);
            enableMoves(enableMovesWorklist);
            spillWorklist.remove(reg);
            if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    private void simplify() {
        /*
         * delete a node in simplifyWorklist, and decrement degree of its adjacent.
         */
        var it = simplifyWorklist.iterator();
        Register reg = it.next();
        Log.report("simplify", reg);
        it.remove();
        selectStack.push(reg);
        adjacent(reg).forEach(this::decrementDegree);
    }

    private void addWorklist(Register reg) {
        if (!reg.node.precolored && !moveRelated(reg) && reg.node.degree < K) {
            freezeWorklist.remove(reg);
            simplifyWorklist.add(reg);
        }
    }

    private void combine(Register u, Register v) {
        if (freezeWorklist.contains(v)) freezeWorklist.remove(v);
        else spillWorklist.remove(v);
        coalescedNodes.add(v);
        v.node.alias = u;
        u.node.moveList.addAll(v.node.moveList);
        enableMoves(Collections.singleton(v));
        for (Register t : adjacent(v)) {
            G.addEdge(new Edge(t, u));
            decrementDegree(t);
        }
        if (u.node.degree >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    private void coalesce() {
        /*
         * a union-set coalesce algorithm
         */
        var it = worklistMoves.iterator();
        AsmMvInst move = it.next();
        
        Log.report("coalesce", move.rd, move.rs1);
        
        Register rdAlias = getAlias(move.rd), rs1Alias = getAlias(move.rs1);
        Edge edge;
        if (rs1Alias.node.precolored) edge = new Edge(rs1Alias, rdAlias);
        else edge = new Edge(rdAlias, rs1Alias);
        it.remove();

        if (edge.isLoop()) {
            coalescedMoves.remove(move);
            addWorklist(edge.u);
        }
        else if (edge.v.node.precolored || G.adjSet.contains(edge)) {
            constrainedMoves.add(move);
            addWorklist(edge.u);
            addWorklist(edge.v);
        }
        else if ((edge.u.node.precolored && georgeStrategy(edge.u, edge.v))
                 || (!edge.u.node.precolored && conservative(adjacent(edge.u, edge.v)))) { // briggs strategy
            Log.mark();
            Log.report(edge.u, edge.v);

            coalescedMoves.add(move);
            combine(edge.u, edge.v);
            addWorklist(edge.u);
        }
        else {
            activeMoves.add(move);
        }
    }

    private void freezeMoves(Register u) {
        for (AsmMvInst move : nodeMoves(u)) {
            Register v;
            if (getAlias(u) == getAlias(move.rs1)) v = getAlias(move.rd);
            else v = getAlias(move.rs1);
            activeMoves.remove(move);
            frozenMoves.add(move);
            if (nodeMoves(v).isEmpty() && v.node.degree < K) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    private void freeze() {
        var it = freezeWorklist.iterator();
        Register reg = it.next();
        Log.report("freeze", reg);
        it.remove();
        simplifyWorklist.add(reg);
        freezeMoves(reg);
    }

    private void selectSpill() {
        Register minReg = null;
        double minCost = Double.POSITIVE_INFINITY;

        for (Register reg : spillWorklist) {
            if (introducedTemp.contains(reg)) continue;
            double regCost = reg.node.priority / reg.node.degree;
            if (regCost < minCost) {
                minReg = reg;
                minCost = regCost;
            }
        }

        // those introduced by rewrite
        if (minReg == null) {
            for (Register reg : spillWorklist) {
                double regCost = reg.node.priority / reg.node.degree;
                if (regCost < minCost) {
                    minReg = reg;
                    minCost = regCost;
                }
            }
        }

        Log.report("selectSpill", minReg);

        spillWorklist.remove(minReg);
        simplifyWorklist.add(minReg);
        freezeMoves(minReg);
    }

    private void assignColors() {
        while (!selectStack.empty()) {
            Register reg = selectStack.pop();
            ArrayList<PhysicalReg> okColors = new ArrayList<>(PhysicalReg.assignable);
            HashSet<Register> coloredSet = new HashSet<>(precolored);

            coloredSet.addAll(coloredNodes);

            for (Register neighbor : reg.node.adjList) {
                if (coloredSet.contains(getAlias(neighbor)))
                    okColors.remove(getAlias(neighbor).color);
            }

            if (okColors.isEmpty()) spilledNodes.add(reg);
            else {
                coloredNodes.add(reg);
                reg.color = okColors.iterator().next();
            }
        }

        for (Register reg : coalescedNodes) {
            Log.report("coales", reg, getAlias(reg));
            reg.color = getAlias(reg).color;
        }
    }

    private void rewriteProgram() {
        // really a big job...
        // allocate stack space for these nodes
        Log.report("rewrite");

        for (Register reg : spilledNodes) {
            reg.stackOffset = new RawStackOffset(curFunc.spillStackUse, RawType.spill);
            curFunc.spillStackUse += 4;
        }

        Set<Register> newTemps = new HashSet<>();

        for (AsmBlock block : curFunc.blocks) {
            ListIterator<AsmBaseInst> it = block.instructions.listIterator();
            // instruction insert & delete, use iterator

            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                for (Register use : inst.uses()) {
                    if (use.stackOffset == null) continue;

                    if (!inst.defs().contains(use)) {
                        if (inst instanceof AsmMvInst && inst.rd.stackOffset == null) {
                            // move rd reg -> load rd stackPos(sp)
                            assert use.equals(inst.rs1);
                            AsmBaseInst loadInst = new AsmLoadInst(((VirtualReg) use).size, inst.rd, PhysicalReg.reg("sp"), use.stackOffset, null);
                            it.set(loadInst);
                        }
                        else {
                            VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                            AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                            inst.replaceUse(use, temp); // will it miss?
                            it.previous();
                            it.add(loadInst);
                            it.next();
                            newTemps.add(temp);
                        }
                    }
                    else {
                        // if it is also in defs()
                        VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                        AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        AsmBaseInst storeInst = new AsmStoreInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        inst.replaceUse(use, temp);
                        inst.replaceDef(use, temp);
                        it.previous();
                        it.add(loadInst);
                        it.next();
                        it.add(storeInst);
                        newTemps.add(temp);
                    }
                }

                for (Register def : inst.defs()) {
                    if (def.stackOffset == null) continue;
                    if (inst.uses().contains(def)) continue; // has been considered previously
                    if (inst instanceof AsmMvInst && inst.rs1.stackOffset == null) {
                        AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), inst.rs1, def.stackOffset, null);
                        it.set(storeInst);
                    } else {
                        VirtualReg temp = new VirtualReg(((VirtualReg) def).size);
                        inst.replaceDef(def, temp);
                        AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), temp, def.stackOffset, null);
                        it.add(storeInst);
                        newTemps.add(temp);
                    }
                }
            }
            introducedTemp.addAll(newTemps);
        }
    }

    /* tool functions */
    private HashSet<Register> adjacent(Register reg) {
        /*
         * return a set of adjacent nodes
         * notice that here we should move nodes in selectStack and coalescedNodes (which is considered to be deleted)
         */
        HashSet<Register> ret = new HashSet<>(reg.node.adjList);
        selectStack.forEach(ret::remove);
        ret.removeAll(coalescedNodes);
        return ret;
    }

    private HashSet<Register> adjacent(Register reg1, Register reg2) {
        /*
         * return a set of adjacent nodes
         * notice that here we should move nodes in selectStack and coalescedNodes (which is considered to be deleted)
         */
        HashSet<Register> ret = new HashSet<>(adjacent(reg1));
        ret.addAll(adjacent(reg2));
        return ret;
    }

    private HashSet<AsmMvInst> nodeMoves(Register reg) {
        /*
         * return a set of this nodes move insts
         * only those in workList or active are valid.
         */
        HashSet<AsmMvInst> ret = new HashSet<>(activeMoves);
        ret.addAll(worklistMoves);
        ret.retainAll(reg.node.moveList);
        return ret;
    }

    private boolean moveRelated(Register reg) {
        return !nodeMoves(reg).isEmpty();
    }

    private boolean ok(Register t, Register r) {
        return t.node.degree < K || t.node.precolored || G.adjSet.contains(new Edge(t, r));
    }

    private boolean georgeStrategy(Register u, Register v) {
        for (Register t : adjacent(v)) if (!ok(t, u)) return false;
        return true;
    }

    private boolean conservative(HashSet<Register> regs) {
        /*
         * a conservative strategy
         */
        int k = 0;
        for (Register reg : regs)
            if (reg.node.degree >= K) k++;
        return k < K;
    }

    private Register getAlias(Register reg) {
        /*
         * union-set
         */
        if (coalescedNodes.contains(reg)) {
            var ret = getAlias(reg.node.alias);
            ret.node.alias = ret;
            return ret;
        }

        return reg;
    }
}