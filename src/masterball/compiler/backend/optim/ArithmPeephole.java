package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmALUInst;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.pass.AsmFuncPass;

public class ArithmPeephole implements AsmFuncPass {

    @Override
    public void runOnFunc(AsmFunction function) {

        for (AsmBlock block : function.blocks) {
            var it = block.instructions.iterator();

            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                if (inst instanceof AsmALUInst) {
                    String op = ((AsmALUInst) inst).op;

                    switch (op) {
                        case RV32I.AddInst:
                        case RV32I.SubInst:
                        case RV32I.OrInst:
                        case RV32I.XorInst:
                        case RV32I.ShiftLeftInst:
                        case RV32I.ShiftRightInst: {
                            if (inst.rd.color == inst.rs1.color) {
                                if (inst.imm != null && inst.imm.value == 0) it.remove();
                                if (inst.rs2 != null && inst.rs2.color == PhysicalReg.reg("zero")) it.remove();
                            }
                            break;
                        }
                    }
                }
            }
        }

    }
}
