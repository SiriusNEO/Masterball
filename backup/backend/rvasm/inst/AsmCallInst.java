package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.share.lang.RV32I;
import masterball.debug.Log;

public class AsmCallInst extends AsmBaseInst {
    private final String symbol;

    public AsmCallInst(String symbol, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.symbol = symbol;
    }

    @Override
    public String format() {
        // call symbol
        return String.format("%s\t%s", RV32I.CallInst, symbol);
    }
}
