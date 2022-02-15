package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.HashSet;

public class LoopAnalyzer implements IRFuncPass {

    public static class LoopInfo {
        public IRBlock header; // the only entry which dominates all nodes
        public HashSet<IRBlock> blocks = new HashSet<>();
    }

    public void init(IRFunction function) {
        new DomTreeBuilder(false).runOnFunc(function);
        function.blocks.forEach(block -> block.belongLoops.clear());
    }

    @Override
    public void runOnFunc(IRFunction function) {

    }

}
