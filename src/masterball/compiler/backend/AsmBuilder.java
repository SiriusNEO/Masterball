package masterball.compiler.backend;

import masterball.compiler.backend.rvasm.AsmCurrent;
import masterball.compiler.backend.rvasm.AsmTranslator;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.inst.AsmArithmInst;
import masterball.compiler.backend.rvasm.inst.AsmBrInst;
import masterball.compiler.backend.rvasm.inst.AsmJmpInst;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.IRVisitor;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.share.RVTable;
import masterball.compiler.share.error.runtime.UnknownError;

// implements @IRVisitor and @InstVisitor

public class AsmBuilder implements IRVisitor, InstVisitor {

    AsmCurrent cur;

    // Builder

    @Override
    public void visit(IRModule module) {

    }

    @Override
    public void visit(IRFunction function) {

    }

    @Override
    public void visit(IRBlock block) {

    }

    // InstSelector

    @Override
    public void visit(IRAllocaInst inst) {
        throw new UnknownError(this);
    }

    @Override
    public void visit(IRBinaryInst inst) {
        // TODO: Optimize
        new AsmArithmInst(AsmTranslator.translateOp(inst.op),
                          cur.regGen(inst), cur.regGen(inst.lhs()), cur.regGen(inst.rhs()), null, cur.block);
    }

    @Override
    public void visit(IRBitCastInst inst) {

    }

    @Override
    public void visit(IRBrInst inst) {
        // TODO: Optimize
        new AsmBrInst(RVTable.NotEqualSuffix, cur.regGen(inst.condition()), cur.regGen(new IntConst(0)),
                (AsmBlock) inst.ifTrueBlock().asmOperand, cur.block);
        new AsmJmpInst((AsmBlock) inst.ifFalseBlock().asmOperand, cur.block);
    }

    @Override
    public void visit(IRCallInst inst) {

    }

    @Override
    public void visit(IRGetElementPtrInst inst) {

    }

    @Override
    public void visit(IRICmpInst inst) {

    }

    @Override
    public void visit(IRLoadInst inst) {

    }

    @Override
    public void visit(IRPhiInst inst) {
        throw new UnknownError(this);
    }

    @Override
    public void visit(IRRetInst inst) {

    }

    @Override
    public void visit(IRStoreInst inst) {

    }

    @Override
    public void visit(IRTruncInst inst) {

    }

    @Override
    public void visit(IRZextInst inst) {

    }

    @Override
    public void visit(IRMoveInst inst) {

    }
}
