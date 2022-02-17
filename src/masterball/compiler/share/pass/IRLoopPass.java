package masterball.compiler.share.pass;

import masterball.compiler.middleend.llvmir.hierarchy.Loop;

public interface IRLoopPass extends Pass {
    void runOnLoop(Loop loop);
}
