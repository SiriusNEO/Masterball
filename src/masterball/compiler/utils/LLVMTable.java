package masterball.compiler.utils;

public class LLVMTable {
    // compile environment
    public static int PointerSize = 4;

    // default reg & label
    public static final String ConstAnon = "__const";
    // public static final String InstVirualRegAnon = "__inst_";

    public static final String InitFuncName = "init";

    public static final String EntryBlockLabel = "entry";
    public static final String ExitBlockLabel = "exit";

    // virtual reg suffix
    public static final String SuffixSpliter = ".";
    public static final String AddrSuffix = SuffixSpliter + "addr";
    public static final String ResolvedSuffix = SuffixSpliter + "resolved";

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
}
