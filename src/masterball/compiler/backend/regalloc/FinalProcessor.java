package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.RawStackOffset;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.compiler.share.pass.AsmModulePass;
import masterball.debug.Log;

public class FinalProcessor implements AsmModulePass, AsmFuncPass {

    @Override
    public void runOnModule(AsmModule module) {
        module.functions.forEach(this::runOnFunc);
    }

    private void eliminateMove(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            var it = block.instructions.listIterator();
            while (it.hasNext()) {
                AsmBaseInst inst = it.next();
                if (inst instanceof AsmMvInst && inst.rd.color == inst.rs1.color)
                    it.remove();
            }
        }
    }

    private void stackAllocate(AsmFunction function) {
        for (AsmBlock block : function.blocks)
            for (AsmBaseInst inst : block.instructions) {
                if (inst.imm instanceof RawStackOffset) {
                    switch (((RawStackOffset) inst.imm).level) {
                        case callerArg: {
                            inst.imm = new Immediate(inst.imm.value);
                            break;
                        }
                        case alloca: {
                            Log.report(inst.format());
                            inst.imm = new Immediate(inst.imm.value + function.callerArgStackUse);
                            break;
                        }
                        case spill: {
                            Log.report("function", function.identifier);
                            Log.report("spill", inst.imm, inst.imm.value);
                            inst.imm = new Immediate(inst.imm.value + function.callerArgStackUse + function.allocaStackUse);
                            Log.report("modified", inst.imm, inst.imm.value);
                            break;
                        }
                        case calleeArg: {
                            inst.imm = new Immediate(inst.imm.value + function.totalStackUse);
                            break;
                        }
                        case lowerSp: {
                            inst.imm = new Immediate(-function.totalStackUse);
                            break;
                        }
                        case raiseSp: {
                            inst.imm = new Immediate(function.totalStackUse);
                            break;
                        }
                    }
                }
            }
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        function.totalStackUse += function.callerArgStackUse + function.allocaStackUse + function.spillStackUse;

        if (function.totalStackUse % RV32I.SpLowUnit != 0)
            function.totalStackUse = (function.totalStackUse / RV32I.SpLowUnit + 1) * RV32I.SpLowUnit;

        Log.report(function.identifier, function.totalStackUse, function.callerArgStackUse, function.allocaStackUse, function.spillStackUse);

        eliminateMove(function);
        stackAllocate(function);
    }
}
