package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.middleend.llvmir.type.LabelType;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

// BasicBlock is also a Value

public class IRBlock extends Value {
    public LinkedList<IRBaseInst> instructions = new LinkedList<>();
    public ArrayList<IRPhiInst> phiInsts = new ArrayList<>();
    public HashSet<IRBlock> prevs = new HashSet<>(), nexts = new HashSet<>();
    public IRFunction parentFunction;

    public boolean isTerminated = false;

    public IRBlock(String label, IRFunction parentFunction) {
        super(label, new LabelType());
        this.parentFunction = parentFunction;
        if (parentFunction != null) parentFunction.blocks.add(this);
    }

    public void addInst(IRBaseInst inst) {
        if (inst instanceof IRMoveInst) this.addInstBeforeTerminator(inst);
        if (isTerminated) return;
        if (inst instanceof IRPhiInst) phiInsts.add((IRPhiInst) inst);
        else instructions.addLast(inst);
        if (inst.isTerminator()) isTerminated = true;
    }

    public void addInstBeforeTerminator(IRBaseInst inst) {
        instructions.add(instructions.size()-1, inst);
    }

    public void setComment() {
        if (prevs.isEmpty()) return;
        StringBuilder ret = new StringBuilder("preds = ");
        prevs.forEach(prevBlock -> ret.append(prevBlock.identifier()).append(", "));
        ret.delete(ret.length()-2, ret.length()-1);
        comment = ret.toString();
    }

    // link blocks related

    public void linkBlock(IRBlock toBlock) {
        this.nexts.add(toBlock);
        toBlock.prevs.add(this);
    }

    public void relinkBlock(IRBlock oldToBlock, IRBlock newToBlock) {
        this.nexts.remove(oldToBlock);
        this.nexts.add(newToBlock);
        for (IRBaseInst inst : this.instructions) {
            if (inst instanceof IRBrInst) {
                if (((IRBrInst) inst).isJump()) {
                    if (((IRBrInst) inst).destBlock() == oldToBlock) ((IRBrInst) inst).resetDestBlock(newToBlock);
                } else {
                    if (((IRBrInst) inst).ifTrueBlock() == oldToBlock) ((IRBrInst) inst).resetIfTrueBlock(newToBlock);
                    if (((IRBrInst) inst).ifFalseBlock() == oldToBlock) ((IRBrInst) inst).resetIfFalseBlock(newToBlock);
                }
            }
        }
    }

    public void linkParentBlock(IRBrInst inst) {
        if (inst.isJump()) linkBlock(inst.destBlock());
        else {
            Log.report(inst.operandSize());
            linkBlock(inst.ifTrueBlock());
            linkBlock(inst.ifFalseBlock());
        }
    }



}
