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

    public void virtualSet(Register reg) {
        if (reg instanceof VirtualReg) {
            if (reg.stackOffset == null)
                reg.stackOffset = new StackOffset(((VirtualReg) reg).num * 4, 2);
        }
    }

    public void violentAllocator(AsmFunction function) {
        function.blocks.forEach(block -> {
            block.instructions.forEach(inst -> {
                virtualSet(inst.rd);
                virtualSet(inst.rs1);
                virtualSet(inst.rs2);
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

                if (inst.rs2 instanceof VirtualReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((VirtualReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("sp"), inst.rs2.stackOffset, null));
                    it.next();
                    inst.rs2 = PhysicalReg.t(3);
                }

                if (inst.rd instanceof VirtualReg) {
                    it.add(new AsmStoreInst(((VirtualReg) inst.rd).size, PhysicalReg.reg("sp"), PhysicalReg.t(1), inst.rd.stackOffset, null));
                    inst.rd = PhysicalReg.t(1);
                }

                if (inst.rs1 instanceof ArgumentReg) {
                    if (inst.rs1.color != null) {
                        inst.rs1 = inst.rs1.color;
                    }
                    else {
                        it.previous();
                        it.add(new AsmLoadInst(((ArgumentReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("s0"), inst.rs1.stackOffset, null));
                        it.next();
                        inst.rs1 = PhysicalReg.t(2);
                    }
                }

                if (inst.rs2 instanceof ArgumentReg) {
                    if (inst.rs2.color != null) {
                        inst.rs2 = inst.rs2.color;
                    }
                    else {
                        it.previous();
                        it.add(new AsmLoadInst(((ArgumentReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("s0"), inst.rs2.stackOffset, null));
                        it.next();
                        inst.rs2 = PhysicalReg.t(3);
                    }
                }
            }
        }
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        // align
        Log.report("STACK USE REPORT");
        Log.report(function.callStackUse, function.allocaStackUse, function.virtualStackUse);

        function.totalStackUse += function.callStackUse + function.allocaStackUse + function.virtualStackUse;
        if (function.totalStackUse % RV32I.StackAllocUnit != 0)
            function.totalStackUse = (function.totalStackUse / RV32I.StackAllocUnit + 1) * RV32I.StackAllocUnit;

        // todo: overflow
        // if (function.stackBase > RV32I.MaxStackSize) throw new StackOverflowError();

        function.entryBlock().instructions.addFirst(
                new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                        new StackOffset(-function.totalStackUse, 0), null)
        );

        var fpInstPtr = function.entryBlock().instructions.listIterator();
        fpInstPtr.next(); // ra
        fpInstPtr.next(); // s0
        fpInstPtr.next(); // arrive
        fpInstPtr.add(
                new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s0"), PhysicalReg.reg("sp"),
                        new StackOffset(function.totalStackUse, 0), null)
        );

        new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                new StackOffset(function.totalStackUse, 0), function.exitBlock());
        new AsmRetInst(function.exitBlock());

        for (int i = 0; i < Integer.min(RV32I.MaxArgRegNum, function.arguments.size()); ++i) {
            Log.report(function.identifier, function.arguments.get(i).identifier);
            function.arguments.get(i).color = PhysicalReg.a(i);
        }

        violentAllocator(function);

        StackOffset.collection.forEach(offset -> {
            if (offset.level == 1) offset.setStackBase(function.callStackUse);
            else if (offset.level == 2) offset.setStackBase(function.callStackUse + function.allocaStackUse);
        });
    }
}
