package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.*;

public class DomTreeBuilder implements IRFuncPass {

    private final boolean postDomTree;

    private IRBlock startBlock;

    public DomTreeBuilder(boolean postDomTree) {
        this.postDomTree = postDomTree;
    }

    @Override
    public void runOnFunc(IRFunction function) {
        init(function);
        startBlock = postDomTree ? function.exitBlock : function.entryBlock;

        sortByRPO(startBlock);
        Collections.reverse(blocksInRPO);
        for (int i = 0; i < blocksInRPO.size(); i++)
            blocksInRPO.get(i).dtNode.order = i;

        calculateIDom(function);
        calculateDF(function);
        calculateDoms(startBlock);
    }

    public static class Node {
        public int order;
        public IRBlock fromBlock;
        public Node idom;
        public HashSet<Node> doms;
        public List<Node> sons;
        public List<IRBlock> domFrontier;

        public Node(IRBlock fromBlock) {
            this.fromBlock = fromBlock;
        }

        public void init() {
            order = 0;
            idom = null;
            doms = new HashSet<>();
            sons = new ArrayList<>();
            domFrontier = new ArrayList<>();
        }
    }

    private final ArrayList<IRBlock> blocksInRPO = new ArrayList<>();

    private final HashSet<IRBlock> visited = new HashSet<>();

    private void init(IRFunction function) {
        function.blocks.forEach(block -> block.dtNode.init());
    }

    private void sortByRPO(IRBlock block) {
        visited.add(block);

        var trueNext = postDomTree ? block.prevs : block.nexts;

        for (IRBlock suc : trueNext)
            if (!visited.contains(suc)) sortByRPO(suc);
        blocksInRPO.add(block);
    }

    private Node intersect(Node u, Node v) {
        /*
         * LCA in DomTree
         */
        while (u != v) {
            while (u.order > v.order) u = u.idom;
            while (u.order < v.order) v = v.idom;
        }
        return u;
    }

    private void calculateIDom(IRFunction function) {
        Node startNode = startBlock.dtNode;
        startNode.idom = startNode;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRBlock block : blocksInRPO) {
                if (block.dtNode == startNode) continue;
                Node newIdom = null;
                var truePrevs = postDomTree ? block.nexts : block.prevs;
                for (IRBlock pred : truePrevs) {
                    if (pred.dtNode.idom == null) continue;
                    if (newIdom == null) newIdom = pred.dtNode;
                    else newIdom = intersect(newIdom, pred.dtNode);
                }
                if (block.dtNode.idom != newIdom) {
                    block.dtNode.idom = newIdom;
                    changed = true;
                }
            }
        }

        for (IRBlock block : function.blocks) {
            if (block.dtNode != startNode && block.dtNode.idom != null) {
                block.dtNode.idom.sons.add(block.dtNode);
            }
        }
    }

    private void calculateDF(IRFunction function) {
        for (IRBlock block : function.blocks) {
            var truePrevs = postDomTree ? block.nexts : block.prevs;
            if (truePrevs.size() < 2) continue;
            for (IRBlock pred : truePrevs) {
                Node runner = pred.dtNode;
                while (runner != block.dtNode.idom && runner != null) {
                    runner.domFrontier.add(block);
                    runner = runner.idom;
                }
            }
        }
    }

    private void calculateDoms(IRBlock block) {
        if (block.dtNode.idom != null) {
            block.dtNode.doms.addAll(block.dtNode.idom.doms);
        }
        block.dtNode.doms.add(block.dtNode.idom);
        block.dtNode.sons.forEach(node -> calculateDoms(node.fromBlock));
    }
}
