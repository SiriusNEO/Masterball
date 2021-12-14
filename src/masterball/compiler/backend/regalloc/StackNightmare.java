package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.*;
import masterball.compiler.backend.rvasm.operand.*;

import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

/*
 * after register allocation, refresh the program.
 * move eliminator & stack allocator
 */

public class StackNightmare implements AsmFuncPass {

    public void virtualSet(Register reg, AsmFunction function) {
        if (reg instanceof VirtualReg) {
            if (reg.stackOffset == null)
                reg.stackOffset = new StackOffset(((VirtualReg) reg).num * 4, 2, function);
        }
    }

    public void violentAllocator(AsmFunction function) {
        function.blocks.forEach(block -> {
            block.instructions.forEach(inst -> {
                virtualSet(inst.rd, function);
                virtualSet(inst.rs1, function);
                virtualSet(inst.rs2, function);
            });
        });

        for (AsmBlock block : function.blocks) {
            var it = block.instructions.listIterator();
            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                if (inst.rs1 instanceof VirtualReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((VirtualReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("sp"), inst.rs1.stackOffset, null));
                    it.next();
                    inst.rs1 = PhysicalReg.t(2);
                }
                else if (inst.rs1 instanceof ArgumentReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((ArgumentReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("sp"), inst.rs1.stackOffset, null));
                    it.next();
                    inst.rs1 = PhysicalReg.t(2);
                }

                if (inst.rs2 instanceof VirtualReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((VirtualReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("sp"), inst.rs2.stackOffset, null));
                    it.next();
                    inst.rs2 = PhysicalReg.t(3);
                }
                else if (inst.rs2 instanceof ArgumentReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((ArgumentReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("sp"), inst.rs2.stackOffset, null));
                    it.next();
                    inst.rs2 = PhysicalReg.t(3);
                }

                if (inst.rd instanceof VirtualReg) {
                    it.add(new AsmStoreInst(((VirtualReg) inst.rd).size, PhysicalReg.reg("sp"), PhysicalReg.t(1), inst.rd.stackOffset, null));
                    inst.rd = PhysicalReg.t(1);
                }
                else if (inst.rd instanceof ArgumentReg) {
                    it.add(new AsmStoreInst(((ArgumentReg) inst.rd).size, PhysicalReg.reg("sp"), PhysicalReg.t(1), inst.rd.stackOffset, null));
                    inst.rd = PhysicalReg.t(1);
                }
            }
        }
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        // align
        Log.report("STACK USE REPORT: " + function.identifier);
        Log.report(function.callStackUse, function.allocaStackUse, function.virtualStackUse);

        function.totalStackUse += function.callStackUse + function.allocaStackUse + function.virtualStackUse;
        if (function.totalStackUse % RV32I.StackAllocUnit != 0)
            function.totalStackUse = (function.totalStackUse / RV32I.StackAllocUnit + 1) * RV32I.StackAllocUnit;

        // todo: overflow
        // if (function.stackBase > RV32I.MaxStackSize) throw new StackOverflowError();

        function.entryBlock().instructions.addFirst(
                new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                        new StackOffset(-function.totalStackUse, 0, function), null)
        );

        var fpInstPtr = function.entryBlock().instructions.listIterator();
        fpInstPtr.next(); // ra
        fpInstPtr.next(); // s0
        fpInstPtr.next(); // arrive
        fpInstPtr.add(
                new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s0"), PhysicalReg.reg("sp"),
                        new StackOffset(function.totalStackUse, 0, function), null)
        );

        new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                new StackOffset(function.totalStackUse, 0, function), function.exitBlock());
        new AsmRetInst(function.exitBlock());

        violentAllocator(function);

        StackOffset.collection.forEach(offset -> {
            if (offset.parentFunction == function) {
                if (offset.level == 1) offset.setStackBase(function.callStackUse);
                else if (offset.level == 2) offset.setStackBase(function.callStackUse + function.allocaStackUse);
            }
        });
    }
}
