package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.Loop;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.misc.Pair;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.*;

public class LoopAnalyzer implements IRFuncPass {

    // <head, tail>
    private Map<IRBlock, Loop> headToLoopMap = new HashMap<>();
    private ArrayList<Pair<IRBlock, IRBlock> > backEdge = new ArrayList<>();

    private void init(IRFunction function) {
        new CFGBuilder().runOnFunc(function);
        new DomTreeBuilder(false).runOnFunc(function);
        function.topLevelLoops.clear();
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
        headToLoopMap.putIfAbsent(edgeHead, new Loop(edgeHead));
        headToLoopMap.get(edgeHead).tailers.add(edgeTail);
        headToLoopMap.get(edgeHead).blocks.add(edgeHead);
        headToLoopMap.get(edgeHead).blocks.add(edgeTail);

        Queue<IRBlock> workQueue = new LinkedList<>();
        workQueue.offer(edgeTail);

        while (!workQueue.isEmpty()) {
            IRBlock nowBlock = workQueue.poll();
            for (IRBlock pre : nowBlock.prevs)
                if (!headToLoopMap.get(edgeHead).blocks.contains(pre)) {
                    headToLoopMap.get(edgeHead).blocks.add(pre);
                    workQueue.offer(pre);
                }
        }
    }

    private Stack<Loop> loopStack = new Stack<>();
    private HashSet<IRBlock> visited = new HashSet<>();

    private void buildLoopNestTree(IRFunction function, IRBlock block) {
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

        if (headToLoopMap.containsKey(block)) {
            var nowLoop = headToLoopMap.get(block);
            if (outerLoop != null) {
                outerLoop.nestedLoops.add(nowLoop);
            }
            else {
                function.topLevelLoops.add(nowLoop);
            }
            loopStack.push(nowLoop);
        }

        block.loopDepth = loopStack.size();

        for (IRBlock suc : block.nexts) buildLoopNestTree(function, suc);
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("loop analyse", function.identifier());

        init(function);
        collectBackEdge(function);
        backEdge.forEach(edge -> buildNaturalLoop(edge.first(), edge.second()));
        buildLoopNestTree(function, function.entryBlock);

        // backEdge.forEach(edge -> Log.info("back edge", edge.first().identifier(), edge.second().identifier()));

        /*
        function.blocks.forEach(block -> {
            Log.info("depth", block.identifier(), block.loopDepth);
        });
        */
    }
}