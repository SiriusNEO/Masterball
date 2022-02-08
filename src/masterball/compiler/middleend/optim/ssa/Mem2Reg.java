package masterball.compiler.middleend.optim.ssa;

import masterball.compiler.middleend.analyzer.DomTreeBuilder;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.NullptrConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.*;

/**
 * implement a simple Mem2Reg algorithm
 * eliminate AllocaInst, and remove some load/store
 *
 * @requirement: CFGBuilder, DomTreeBuilder
 *
 * @reference:
 *      DomTree algorithm is based on the book "Engineering a Compiler"
 *      variable renaming part is based on SSA Book
 */

public class Mem2Reg implements IRFuncPass {

    private final ArrayList<IRBaseInst> allocated = new ArrayList<>();

    private final Map<String, Stack<Value>> nameStack = new HashMap<>();

    private final Map<IRPhiInst, String> phiAllocaName = new HashMap<>();

    private void collectAllocated(IRFunction function) {
        for (IRBaseInst inst : function.entryBlock.instructions)
            if (inst instanceof IRAllocaInst) allocated.add(inst);
    }

    private ArrayList<IRBaseInst> collectAllocaDefs(IRBaseInst allocaInst) {
        ArrayList<IRBaseInst> ret = new ArrayList<>();
        // alloca itself is a def
        ret.add(allocaInst);
        for (User user : allocaInst.users) {
            if (user instanceof IRStoreInst && ((IRStoreInst) user).storePtr() == allocaInst) {
                // store to %allocaPtr
                ret.add((IRBaseInst) user);
            }
        }
        return ret;
    }

    @Override
    public void runOnFunc(IRFunction function) {
        new DomTreeBuilder(false).runOnFunc(function);
        phiInsertion(function);
        variableRenaming(function.entryBlock);
    }

    private void phiInsertion(IRFunction function) {
        /*
         * b1: %i.addr = alloca i32, align 4
         * b2: %store val, %i.addr
         * -> b2: phi [b1, val]
         */

        // Log.mark("phi insertion: " + function.identifier());
        /*
        function.blocks.forEach(block -> Log.report("idom: ", block.identifier(), block.node.idom.fromBlock.identifier()));
        function.blocks.forEach(block -> block.node.domFrontier.forEach(
                df -> Log.report("df", block.identifier(), df.identifier())
        ));
        */
        collectAllocated(function);

        for (IRBaseInst allocaVar : allocated) {
            Queue<IRBlock> workQueue = new LinkedList<>();
            var defs = collectAllocaDefs(allocaVar);
            var visited = new HashSet<IRBlock>();

            defs.forEach(defInst -> workQueue.offer(defInst.parentBlock));

            while (!workQueue.isEmpty()) {
                var runner = workQueue.poll();
                for (var frontier : runner.node.domFrontier) {
                    if (visited.contains(frontier)) continue;
                    visited.add(frontier);

                    workQueue.offer(frontier);
                    // Log.mark("new phi");
                    var phi = new IRPhiInst(((PointerType) allocaVar.type).pointedType, null);
                    frontier.tAddPhi(phi);
                    phiAllocaName.put(phi, allocaVar.name);
                }
            }
        }
    }

    private Value getReplace(String name) {
        if (!nameStack.containsKey(name) || nameStack.get(name).empty()) {
            // init
            return new NullptrConst();
        }
        return nameStack.get(name).lastElement();
    }

    private void updateReplace(String name, Value replace) {
        if (!nameStack.containsKey(name)) nameStack.put(name, new Stack<>());
        nameStack.get(name).push(replace);
    }

    private void variableRenaming(IRBlock block) {
        ArrayList<String> rollbackRecord = new ArrayList<>();

        for (var phi : block.phiInsts) {
            if (phiAllocaName.containsKey(phi)) {
                // Log.report("phi: ", phi.format(), phiAllocaName.get(phi));
                updateReplace(phiAllocaName.get(phi), phi);
                rollbackRecord.add(phiAllocaName.get(phi));
            }
        }

        var it = block.instructions.iterator();

        while (it.hasNext()) {
            var inst = it.next();

            if (inst instanceof IRAllocaInst) {
                // remove alloca
                it.remove();
            }
            else if (inst instanceof IRLoadInst) {
                if (allocated.contains(((IRLoadInst) inst).loadPtr())) {
                    String name = ((IRLoadInst) inst).loadPtr().name;
                    Value replace = getReplace(name);
                    // Log.report("load r", ((IRLoadInst) inst).loadPtr().identifier(), name, replace.identifier());
                    it.remove(); // remove load
                    inst.replaced(replace);
                }
            }
            else if (inst instanceof IRStoreInst) {
                if (allocated.contains(((IRStoreInst) inst).storePtr())) {
                    String name = ((IRStoreInst) inst).storePtr().name;
                    // Log.report("store r", ((IRStoreInst) inst).storeValue().identifier(), name);
                    updateReplace(name, ((IRStoreInst) inst).storeValue());
                    rollbackRecord.add(name);
                    it.remove(); // remove store
                }
            }
        }

        for (IRBlock suc : block.nexts) {
            for (var sucPhi : suc.phiInsts) {
                if (phiAllocaName.containsKey(sucPhi)) {
                    sucPhi.addBranch(getReplace(phiAllocaName.get(sucPhi)), block);
                }
            }
        }

        block.node.sons.forEach(son -> variableRenaming(son.fromBlock));

        rollbackRecord.forEach(name -> nameStack.get(name).pop());
    }
}
