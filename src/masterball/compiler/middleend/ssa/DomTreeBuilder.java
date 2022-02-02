package masterball.compiler.middleend.ssa;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.*;

public class DomTreeBuilder implements IRFuncPass {

    @Override
    public void runOnFunc(IRFunction function) {
        sortByRPO(function.entryBlock());
        Collections.reverse(blocksInRPO);
        for (int i = 0; i < blocksInRPO.size(); i++)
            blocksInRPO.get(i).node.order = i;

        calculateDoms(function.entryBlock().node);
        calculateDF(function);
    }

    public static class Node {
        IRBlock block;
        int order;

        Node idom = null;

        List<IRBlock> domFrontier = new ArrayList<>();

        public Node(IRBlock block) {
            this.block = block;
        }
    }

    private final ArrayList<IRBlock> blocksInRPO = new ArrayList<>();

    private final HashSet<IRBlock> visited = new HashSet<>();

    private void sortByRPO(IRBlock block) {
        visited.add(block);
        for (IRBlock suc : block.nexts)
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

    private void calculateDoms(Node startNode) {
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
    }

    private void calculateDF(IRFunction function) {
        for (IRBlock block : function.blocks) {
            if (block.prevs.size() <= 2) continue;
            for (IRBlock pred : block.prevs) {
                Node runner = pred.node;
                while (runner != block.node.idom) {
                    runner.domFrontier.add(block);
                    runner = runner.idom;
                }
            }
        }
    }
}
