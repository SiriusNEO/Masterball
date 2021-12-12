package masterball.compiler.share.pass;

import masterball.compiler.backend.rvasm.hierarchy.AsmModule;

public interface AsmModulePass extends Pass {
    void runOnModule(AsmModule module);
}
