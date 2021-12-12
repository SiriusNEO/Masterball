package masterball.engine;

import masterball.compiler.backend.regalloc.RegisterAllocator;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.AsmPrinter;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;

import java.io.PrintStream;
import java.util.ArrayList;

public class CodeGenEngine {

    public final AsmModule module;

    public final ArrayList<AsmFunction> functions = new ArrayList<>();

    public CodeGenEngine(IRGenEngine ire, PrintStream astGenStream) {
        this.module = new AsmBuilder(ire.module).module;
        new RegisterAllocator().runOnModule(this.module);
        new AsmPrinter(astGenStream).runOnModule(this.module);
    }

}
