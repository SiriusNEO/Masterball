package masterball.engine;

import masterball.compiler.backend.regalloc.StackNightmare;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.AsmPrinter;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;

import java.util.ArrayList;

public class CodeGenEngine {

    public final AsmModule module;

    public final ArrayList<AsmFunction> functions = new ArrayList<>();

    public CodeGenEngine(IRGenEngine ire, IOEngine ioEngine) {
        this.module = new AsmBuilder(ire.module).module;
        // new RegisterAllocator().runOnModule(this.module);
        this.module.functions.forEach(func -> new StackNightmare().runOnFunc(func));
        new AsmPrinter(IOEngine.getFileName(ioEngine.llvmOutputPath), ioEngine.asmGenStream).runOnModule(this.module);
    }

}
