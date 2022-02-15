package masterball;

import masterball.compiler.backend.BackEnd;
import masterball.compiler.frontend.FrontEnd;
import masterball.compiler.middleend.MiddleEnd;
import masterball.compiler.share.error.CompileError;
import masterball.console.*;
import masterball.console.error.ConsoleError;
import masterball.debug.Timer;

import java.util.concurrent.TimeoutException;

/**
 * Masterball, a Compiler for Mx* language
 * see github in: https://github.com/SiriusNEO/Masterball
 *
 * Actually, it is a toy compiler for course project.
 * Therefore, many implementations are quite simple and there may be some bugs.
 * It will compile Mx* language (a language for this project) code to RISC-V 32 Integer assembly.
 * It is implemented in Java, JDK 11. And the lexer and parser in the FrontEnd are supported by antlr v4 framework.
 *
 * Main Architecture:
 *  code            -> Console (input from stdin)
 *  char stream     -> FrontEnd (antlr v4 parser, and custom AST builder & semantic check for Mx*)
 *  AST             -> MiddleEnd (LLVM IR builder, and many optimizations)
 *  IR (optimized)  -> BackEnd (assembly builder and register allocator, and some LIR optimizations)
 *  Assembly        -> Assembler: ravel
 *  Result          -> Judge
 *  
 * @author: SiriusNEO, https://github.com/SiriusNEO
 */

public class Masterball {

    public static void main(String[] args) throws Exception {
        try {
            Timer timer = new Timer();

            Console console = new Console(args);
            if (console.showHelp || console.showVersion) return;

            FrontEnd frontEnd = new FrontEnd(console);
            if (console.fsyntaxOnly) return;
            MiddleEnd middleEnd = new MiddleEnd(frontEnd, console);

            if (timer.getTime() > 20000) throw new TimeoutException();

            if (console.irOnly) return;
            BackEnd backEnd = new BackEnd(middleEnd, console);

            timer.display();
        }
        catch (Exception e) {
            errorHandle(e);
        }
        System.exit(0);
    }

    private static void errorHandle(Exception e) {
        if (e instanceof CompileError) {
            ((CompileError) e).tell();
            throw new RuntimeException();
        }
        else if (e instanceof ConsoleError) {
            ((ConsoleError) e).tell();
            throw new RuntimeException();
        }
        else {
            e.printStackTrace();
        }
    }
}