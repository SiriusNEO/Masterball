package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.*;

public class DomTreeBuilder implements IRFuncPass {

    private final boolean postDomTree;

    public DomTreeBuilder(boolean postDomTree) {
        this.postDomTree = postDomTree;
    }

    @Override
    public void runOnFunc(IRFunction function) {
        init(function);
        sortByRPO(function.entryBlock);
        Collections.reverse(blocksInRPO);
        for (int i = 0; i < blocksInRPO.size(); i++)
            blocksInRPO.get(i).dtNode.order = i;

        calculateDoms(function);
        calculateDF(function);
    }

    public static class Node {
        public int order;
        public IRBlock fromBlock;
        public Node idom;
        public List<Node> sons;
        public List<IRBlock> domFrontier;

        public Node(IRBlock fromBlock) {
            this.fromBlock = fromBlock;
        }

        public void init() {
            order = 0;
            idom = null;
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

        var trueNexts = postDomTree ? block.prevs : block.nexts;

        for (IRBlock suc : trueNexts)
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

    private void calculateDoms(IRFunction function) {
        Node startNode = function.entryBlock.dtNode;
        startNode.idom = startNode;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRBlock block : blocksInRPO) {
                if (block.dtNode == startNode) continue;
                Node newIdom = null;
                for (IRBlock pred : block.prevs) {
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
}
