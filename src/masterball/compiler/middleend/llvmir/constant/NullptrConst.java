package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.share.lang.LLVM;

public class NullptrConst extends BaseConst {
    public NullptrConst() {
        super(LLVM.ConstAnon, IRTranslator.nullType);
    }

    @Override
    public boolean equals(Object o) {return o instanceof NullptrConst;}

    @Override
    public String identifier() {return "null";}
}
