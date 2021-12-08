package masterball.compiler.backend;

import masterball.compiler.backend.rvasm.AsmCurrent;
import masterball.compiler.middleend.llvmir.IRVisitor;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
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
        // new ASMRTypeInst();
    }

    @Override
    public void visit(IRBitCastInst inst) {

    }

    @Override
    public void visit(IRBrInst inst) {

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
