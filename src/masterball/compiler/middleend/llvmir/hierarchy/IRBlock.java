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

    public void addInst(IRBaseInst inst) {
        if (inst instanceof IRMoveInst) {
            // move insert after terminator
            this.addInstBeforeTerminator(inst);
        }
        else if (inst instanceof IRPhiInst) {
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
}
