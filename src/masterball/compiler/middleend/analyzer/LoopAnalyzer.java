package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.misc.Pair;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.*;

public class LoopAnalyzer implements IRFuncPass {

    public static class Loop {
        public HashSet<IRBlock> blocks = new HashSet<>();
        public HashSet<Loop> nestedLoops = new HashSet<>();
    }

    // <head, tail>
    private Map<IRBlock, Loop> headLoop = new HashMap<>();
    private ArrayList<Pair<IRBlock, IRBlock> > backEdge = new ArrayList<>();

    private void init(IRFunction function) {
        new CFGBuilder().runOnFunc(function);
        new DomTreeBuilder(false).runOnFunc(function);
        function.blocks.forEach(block -> block.loopDepth = 0);
    }

    private void collectBackEdge(IRFunction function) {
        for (IRBlock block : function.blocks) {
            for (IRBlock suc : block.nexts) {
                if (block.dtNode.doms.contains(suc.dtNode)) {
                    backEdge.add(new Pair<>(suc, block));
                    break;
                }
            }
        }
    }

    private void buildNaturalLoop(IRBlock edgeHead, IRBlock edgeTail) {
        headLoop.putIfAbsent(edgeHead, new Loop());
        headLoop.get(edgeHead).blocks.add(edgeHead);
        headLoop.get(edgeHead).blocks.add(edgeTail);

        Queue<IRBlock> workQueue = new LinkedList<>();
        workQueue.offer(edgeTail);

        while (!workQueue.isEmpty()) {
            IRBlock nowBlock = workQueue.poll();
            for (IRBlock pre : nowBlock.prevs)
                if (!headLoop.get(edgeHead).blocks.contains(pre)) {
                    headLoop.get(edgeHead).blocks.add(pre);
                    workQueue.offer(pre);
                }
        }
    }

    private Stack<Loop> loopStack = new Stack<>();
    private HashSet<IRBlock> visited = new HashSet<>();

    private void buildLoopNestTree(IRBlock block) {
        if (visited.contains(block)) return;
        visited.add(block);

        // Log.info("build", block.identifier());

        // filter the inner loop
        Loop outerLoop = null;
        if (!loopStack.empty()) {
            outerLoop = loopStack.peek();
            while (!outerLoop.blocks.contains(block)) {
                loopStack.pop();
                if (loopStack.empty()) {
                    outerLoop = null;
                    break;
                }
                outerLoop = loopStack.peek();
            }
        }

        if (headLoop.containsKey(block)) {
            if (outerLoop != null) outerLoop.nestedLoops.add(headLoop.get(block));
            loopStack.push(headLoop.get(block));
        }

        block.loopDepth = loopStack.size();

        for (IRBlock suc : block.nexts) buildLoopNestTree(suc);
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("loop analyse", function.identifier());

        init(function);
        collectBackEdge(function);
        backEdge.forEach(edge -> buildNaturalLoop(edge.first(), edge.second()));
        buildLoopNestTree(function.entryBlock);

        // backEdge.forEach(edge -> Log.info("back edge", edge.first().identifier(), edge.second().identifier()));

        /*
        function.blocks.forEach(block -> {
            Log.info("depth", block.identifier(), block.loopDepth);
        });
        */
    }

}
