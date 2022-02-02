package masterball.debug;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Register;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LivenessPrinter {

    private static final String INDENT = "..";

    private final Map<AsmBlock, HashSet<Register>> uses, defs, liveIn, liveOut;

    public LivenessPrinter(Map<AsmBlock, HashSet<Register>> uses, Map<AsmBlock, HashSet<Register>> defs) {
        this.uses = uses;
        this.defs = defs;
        this.liveIn = new HashMap<>();
        this.liveOut = new HashMap<>();
    }

    public void print() {
        liveOut.keySet().forEach(block -> {
            System.out.println(block.identifier + ":");
            System.out.print(INDENT + "uses:");
            System.out.println(uses.get(block));
            System.out.print(INDENT + "defs:");
            System.out.println(defs.get(block));
            System.out.print(INDENT + "liveIn:");
            System.out.println(liveIn.get(block));
            System.out.print(INDENT + "liveOut:");
            System.out.println(liveOut.get(block));
        });
    }
}
