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
        sortByRPO(function.entryBlock);
        Collections.reverse(blocksInRPO);
        for (int i = 0; i < blocksInRPO.size(); i++)
            blocksInRPO.get(i).node.order = i;

        calculateDoms(function);
        calculateDF(function);
    }

    public static class Node {
        public int order;
        public IRBlock fromBlock;
        public Node idom = null;
        public List<Node> sons = new ArrayList<>();
        public List<IRBlock> domFrontier = new ArrayList<>();

        public Node(IRBlock fromBlock) {
            this.fromBlock = fromBlock;
        }
    }

    private final ArrayList<IRBlock> blocksInRPO = new ArrayList<>();

    private final HashSet<IRBlock> visited = new HashSet<>();

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
        Node startNode = function.entryBlock.node;
        startNode.idom = startNode;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRBlock block : blocksInRPO) {
                if (block.node == startNode) continue;
                Node newIdom = null;
                for (IRBlock pred : block.prevs) {
                    if (pred.node.idom == null) continue;
                    if (newIdom == null) newIdom = pred.node;
                    else newIdom = intersect(newIdom, pred.node);
                }
                if (block.node.idom != newIdom) {
                    block.node.idom = newIdom;
                    changed = true;
                }
            }
        }

        for (IRBlock block : function.blocks) {
            if (block.node != startNode && block.node.idom != null) {
                block.node.idom.sons.add(block.node);
            }
        }
    }

    private void calculateDF(IRFunction function) {
        for (IRBlock block : function.blocks) {
            var truePrevs = postDomTree ? block.nexts : block.prevs;
            if (truePrevs.size() < 2) continue;
            for (IRBlock pred : truePrevs) {
                Node runner = pred.node;
                while (runner != block.node.idom && runner != null) {
                    runner.domFrontier.add(block);
                    runner = runner.idom;
                }
            }
        }
    }
}
