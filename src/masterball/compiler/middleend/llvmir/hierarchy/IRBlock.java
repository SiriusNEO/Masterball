package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.middleend.llvmir.type.LabelType;
import masterball.compiler.middleend.analyzer.DomTreeBuilder;
import masterball.compiler.share.error.runtime.InternalError;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

// BasicBlock is also a Value

public class IRBlock extends Value {
    public LinkedList<IRBaseInst> instructions = new LinkedList<>();

    // phi inst will be eliminated by SSADestructor
    public ArrayList<IRPhiInst> phiInsts = new ArrayList<>();

    public IRFunction parentFunction;

    public boolean isTerminated = false;

    // control flow graph
    public ArrayList<IRBlock> prevs = new ArrayList<>(), nexts = new ArrayList<>();

    // info in DomTree, assigned in DomTreeBuilder
    public DomTreeBuilder.Node dtNode = new DomTreeBuilder.Node(this);

    // info in Loop
    public int loopDepth = 0;

    public IRBlock(String label, IRFunction parentFunction) {
        super(label, new LabelType());
        this.parentFunction = parentFunction;
        if (parentFunction != null) parentFunction.blocks.add(this);
    }

    /**
     * Add Convention:
     *    add before terminated, use new Inst(..., parentBlock) to automatically push back
     *    add after terminated, use new Inst(..., null) + tAddInst, to manually add in some places
     */

    public void addInst(IRBaseInst inst) {
        if (isTerminated) return;

        if (inst instanceof IRPhiInst) {
            phiInsts.add((IRPhiInst) inst);
        }
        else {
            instructions.addLast(inst);
        }

        if (inst.isTerminator()) isTerminated = true;
    }

    /**
     * "tAdd series" are used to add inst after terminated
     * mainly used in Optimization
     */

    public void tAddFirst(IRBaseInst inst) {
        inst.parentBlock = this;
        instructions.addFirst(inst);
    }

    public void tAddLast(IRBaseInst inst) {
        inst.parentBlock = this;
        instructions.addLast(inst);
    }

    public void tAddPhi(IRPhiInst phi) {
        phi.parentBlock = this;
        phiInsts.add(phi);
    }

    public void tAddBeforeTerminator(IRBaseInst inst) {
        inst.parentBlock = this;
        if (instructions.isEmpty()) return;
        instructions.add(instructions.size() - 1, inst);
    }

    public void tAddByIterator(IRBaseInst inst, ListIterator<IRBaseInst> it) {
        inst.parentBlock = this;
        it.add(inst);
    }

    public void tReplaceTerminator(IRBaseInst newTerminator) {
        newTerminator.parentBlock = this;
        instructions.removeLast();
        instructions.addLast(newTerminator);
    }

    public void removePhiBranch(IRBlock remove) {
        var it = this.phiInsts.iterator();
        while (it.hasNext()) {
            var phi = it.next();
            for (int i = 1; i < phi.operandSize(); i += 2) {
                if (phi.getOperand(i) == remove) {
                    // remove the branch
                    phi.operands.remove(i-1);
                    phi.operands.remove(remove);
                }
            }
            if (phi.operandSize() == 2) {
                // can not remove from users because its register will be saved
                it.remove();
                IRMoveInst move = new IRMoveInst(phi, phi.getOperand(0), null); // terminated
                this.tAddFirst(move);
            }
        }
    }

    public IRBaseInst terminator() {
        if (instructions.isEmpty()) throw new InternalError("empty IRBLock! no terminator! " + this.name);
        return instructions.getLast();
    }

    public void setComment() {
        StringBuilder ret = new StringBuilder("preds = ");
        if (!prevs.isEmpty()) {
            prevs.forEach(pre -> ret.append(pre.identifier()).append(", "));
            ret.delete(ret.length() - 2, ret.length() - 1);
        }
        if (!nexts.isEmpty()) {
            ret.append(" | nexts = ");
            nexts.forEach(suc -> ret.append(suc.identifier()).append(", "));
            ret.delete(ret.length()-2, ret.length()-1);
        }
        comment = ret.toString();
    }

    // link blocks related

    public void linkBlock(IRBlock toBlock) {
        this.nexts.add(toBlock);
        toBlock.prevs.add(this);
    }

    public void redirectPreBlock(IRBlock oldPre, IRBlock newPre) {
        this.prevs.remove(oldPre);
        this.prevs.add(newPre);
        for (IRPhiInst phi : this.phiInsts) {
            for (int i = 1; i < phi.operandSize(); i += 2) {
                if (phi.getOperand(i) == oldPre)
                    phi.resetOperand(i, newPre);
            }
        }
    }

    public void redirectSucBlock(IRBlock oldSuc, IRBlock newSuc) {
        this.nexts.remove(oldSuc);
        this.nexts.add(newSuc);
        for (IRBaseInst inst : this.instructions) {
            if (inst instanceof IRBrInst) {
                if (((IRBrInst) inst).isJump()) {
                    if (((IRBrInst) inst).destBlock() == oldSuc) ((IRBrInst) inst).resetDestBlock(newSuc);
                } else {
                    if (((IRBrInst) inst).ifTrueBlock() == oldSuc) ((IRBrInst) inst).resetIfTrueBlock(newSuc);
                    if (((IRBrInst) inst).ifFalseBlock() == oldSuc) ((IRBrInst) inst).resetIfFalseBlock(newSuc);
                }
            }
        }
    }
}
