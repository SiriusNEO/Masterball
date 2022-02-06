package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.middleend.llvmir.type.LabelType;
import masterball.compiler.middleend.ssa.DomTreeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;

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
    public DomTreeBuilder.Node node = new DomTreeBuilder.Node(this);

    public IRBlock(String label, IRFunction parentFunction) {
        super(label, new LabelType());
        this.parentFunction = parentFunction;
        if (parentFunction != null) parentFunction.blocks.add(this);
    }

    // only phi can add Inst after terminated
    // for other inst add to different position, please explicitly use other methods

    public void addInst(IRBaseInst inst) {
        if (inst instanceof IRPhiInst) {
            // phi insert after terminator
            phiInsts.add((IRPhiInst) inst);
        }
        else if (isTerminated) return;
        else {
            instructions.addLast(inst);
        }

        if (inst.isTerminator()) isTerminated = true;
    }

    public IRBaseInst terminator() {
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
