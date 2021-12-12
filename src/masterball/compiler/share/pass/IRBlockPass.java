package masterball.compiler.share.pass;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;

public interface IRBlockPass extends Pass {
    void runOnBlock(IRBlock block);
}
