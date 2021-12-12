package masterball.compiler.share.pass;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;

public interface AsmBlockPass extends Pass {
    void runOnBlock(AsmBlock block);
}
