package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.backend.rvasm.operand.Register;

import java.util.*;

// Register Interference Graph

public class InterferenceGraph {

    public static int INF = 1145141919;

    public static class Edge {
        public Register u, v;
        public Edge(Register u, Register v) {
            this.u = u;
            this.v = v;
        }

        public boolean isLoop() {
            return this.u == this.v;
        }

        public Edge convert() {
            return new Edge(v, u);
        }

        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Edge && (((Edge) o).u == u && ((Edge) o).v == v);
        }
    }

    public static class Node {
        public HashSet<Register> adjList = new HashSet<>();
        public boolean precolored;
        public int degree;
        public double priority;
        public Set<AsmMvInst> moveList = new LinkedHashSet<>();

        public void init(boolean isPrecolored) {
            this.adjList.clear();
            this.moveList.clear();
            this.priority = 0;
            if (isPrecolored) this.degree = INF;
            else this.degree = 0;
            this.precolored = isPrecolored;
        }
    }

    public Set<Edge> adjSet = new LinkedHashSet<>();

    public void addEdge(InterferenceGraph.Edge edge) {
        if (!adjSet.contains(edge) && !edge.isLoop()) {
            adjSet.add(edge);
            adjSet.add(edge.convert());
            if (!edge.u.node.precolored) {
                edge.u.node.adjList.add(edge.v);
                edge.u.node.degree++;
            }
            if (!edge.v.node.precolored) {
                edge.v.node.adjList.add(edge.u);
                edge.v.node.degree++;
            }
        }
    }

    public void init() {
        adjSet.clear();
    }
}
