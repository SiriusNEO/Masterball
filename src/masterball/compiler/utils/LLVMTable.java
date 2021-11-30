package masterball.compiler.utils;

public class LLVMTable {
    // compile environment
    public static int PointerSize = 4;

    // default reg & label
    public static final String ConstAnon = "__const";
    // public static final String InstVirualRegAnon = "__inst_";

    public static final String Spliter = ".";

    public static final String InitFuncName = "glb" + Spliter + "init";

    public static final String EntryBlockLabel = "entry";
    public static final String ExitBlockLabel = "exit";
    public static final String IfTrueBlockLabel = "if" + Spliter + "true";
    public static final String IfFalseBlockLabel = "if" + Spliter + "false";
    public static final String IfExitBlockLabel = "if" + Spliter + "exit";
    public static final String ForCondBlockLabel = "for" + Spliter + "cond";
    public static final String ForIncrBlockLabel = "for" + Spliter + "incr";
    public static final String ForBodyBlockLabel = "for" + Spliter + "body";
    public static final String ForExitBlockLabel = "for" + Spliter + "exit";
    public static final String WhCondBlockLabel = "wh" + Spliter + "cond";
    public static final String WhBodyBlockLabel = "wh" + Spliter + "body";
    public static final String WhExitBlockLabel = "wh" + Spliter + "exit";


    // LLVM inst
    public static final String AllocaInst = "alloca";
    public static final String BitCastInst = "bitcast";
    public static final String BrInst = "br";
    public static final String CallInst = "call";
    public static final String GetElementPtrInst = "getelementptr";
    public static final String ICmpInst = "icmp";
    public static final String LoadInst = "load";
    public static final String StoreInst = "store";
    public static final String PhiInst = "phi";
    public static final String RetInst = "ret";

    // virtual reg suffix
    public static final String AddrSuffix = Spliter + "addr";
    public static final String CallSuffix = Spliter + CallInst;
    public static final String ResolveSuffix = Spliter + LoadInst;

    // binary
    public static final String AddInst = "add";
    public static final String SubInst = "sub";
    public static final String MulInst = "mul";
    public static final String DivInst = "sdiv";
    public static final String ModInst = "srem";
    public static final String ShiftLeftInst = "shl";
    public static final String ShiftRightInst = "ashr";
    public static final String AndInst = "and";
    public static final String OrInst = "or";
    public static final String XorInst = "xor";

    // icmp
    public static final String GreaterArg = "sgt";
    public static final String GreaterEqualArg = "sge";
    public static final String LessArg = "slt";
    public static final String LessEqualArg = "sle";
    public static final String EqualArg = "eq";
    public static final String NotEqualArg = "neq";
}