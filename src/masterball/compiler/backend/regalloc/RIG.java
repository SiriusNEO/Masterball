package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.backend.rvasm.operand.Register;

import java.util.*;

// Register Interference Graph

public class RIG {

    public static int INF = (Integer.MAX_VALUE << 1);

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
        public Set<Register> adjList = new LinkedHashSet<>();
        public boolean precolored;
        public int degree;
        public double weight;
        public Register alias;
        public Set<AsmMvInst> moveList = new LinkedHashSet<>();

        public void init(boolean isPrecolored) {
            this.adjList.clear();
            this.moveList.clear();
            this.weight = 0;
            this.alias = null;
            if (isPrecolored) this.degree = INF;
            else this.degree = 0;
            this.precolored = isPrecolored;
        }
    }

    public Set<Edge> adjSet = new LinkedHashSet<>();

    public void addEdge(RIG.Edge edge) {
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
}
