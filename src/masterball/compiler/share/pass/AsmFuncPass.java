package masterball.compiler.share.pass;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;

public interface AsmFuncPass extends Pass {
    void runOnFunc(AsmFunction function);
}
