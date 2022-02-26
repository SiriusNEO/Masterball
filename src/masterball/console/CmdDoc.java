package masterball.console;

import masterball.compiler.share.lang.LLVM;

public class CmdDoc {

    private final static String TAB = "\t";

    public static String version() {
        StringBuilder ret = new StringBuilder("Masterball 1.0.0 using JDK 11\n");
        ret.append("Copyright (C) 2021 ACM Class 2020, SiriusNEO.\n");
        ret.append("Target: RISC-V 32 Integer\n");
        ret.append("OS Arch: x86_" + LLVM.PointerSize * 8 + "\n");
        return ret.toString();
    }

    public static String help() {
        StringBuilder ret = new StringBuilder("Overview: Masterball, a Mx* language compiler by SiriusNEO.\n");
        ret.append("Github: https://github.com/SiriusNEO/Masterball\n\n");
        ret.append("Usage: java -jar Masterball [options] file...\n");
        ret.append("Options\n");

        for (Config.Option option : Config.argSetting.keySet()) {
            ret.append(TAB).append(Config.argSetting.get(option).argName).append(TAB.repeat(3));
            switch (option) {
                case Help: {
                    ret.append("Display this information\n");
                    break;
                }
                case Version: {
                    ret.append("Display the version of the compiler\n");
                    break;
                }
                case Input: {
                    ret.append("Redirect the input of the compiler\n");
                    break;
                }
                case ASTOutput: {
                    ret.append("Redirect the AST output path of the compiler\n");
                    break;
                }
                case IROutput: {
                    ret.append("Redirect the LLVM IR output path of the compiler\n");
                    break;
                }
                case ASMOutput: {
                    ret.append("Redirect the RV32I Assembly output path of the compiler\n");
                    break;
                }
                case OptOutput: {
                    ret.append("Redirect the optimized LLVM IR output path of the compiler\n");
                    break;
                }
                case LogOutput: {
                    ret.append("Redirect the log output path of the compiler\n");
                    break;
                }
                case FSyntaxOnly: {
                    ret.append("Do the semantic check only\n");
                    break;
                }
                case IROnly: {
                    ret.append("Only Generate LLVM IR, no assembly\n");
                    break;
                }
                case Optimize: {
                    ret.append("Do optimization\n");
                    break;
                }
                case Wall: {
                    ret.append("Display the warning information when compiling\n");
                    break;
                }
                case OJMode: {
                    ret.append("Automatically fitted to Online Judge\n");
                    break;
                }
            }
        }
        return ret.toString();
    }
}
