package masterball.compiler.share.lang;

public class LLVM {
    // --- compile environment. 64bit in my machine. ---

    public static final int PointerSize = 8;

    // --- Splitter --

    public static final String Splitter = ".";

    // function name use different splitter because "." is invalid in C++ function name
    public static final String FuncNameSplitter = "_";

    // --- Default reg & label ---

    public static final String Anon = "anon";
    public static final String Nullptr = "null";

    public static final String TypeAnon = "anon" + Splitter + "type";
    public static final String ConstAnon = "anon" + Splitter + "const";
    public static final String StrConstAnon = "anon" + Splitter + "strconst";

    // this appears in SCCP
    public static final String UncertainConst = "internal" + Splitter + "uncertain";

    public static final String ThisArg = "internal" + Splitter + "this";
    public static final String RetReg = "internal" + Splitter + "ret";
    public static final String TParaReg = "internal" + Splitter + "tpara";

    public static final String InitFuncName = FuncNameSplitter + "glb" + FuncNameSplitter + "init";

    public static final String EntryBlockLabel = "entry";
    public static final String ExitBlockLabel = "exit";
    public static final String MidBlockLabel = "mid";

    public static final String IfTrueBlockLabel = "if" + Splitter + "true";
    public static final String IfFalseBlockLabel = "if" + Splitter + "false";
    public static final String IfExitBlockLabel = "if" + Splitter + "exit";

    public static final String ForCondBlockLabel = "for" + Splitter + "cond";
    public static final String ForIncrBlockLabel = "for" + Splitter + "incr";
    public static final String ForBodyBlockLabel = "for" + Splitter + "body";
    public static final String ForExitBlockLabel = "for" + Splitter + "exit";

    public static final String WhCondBlockLabel = "wh" + Splitter + "cond";
    public static final String WhBodyBlockLabel = "wh" + Splitter + "body";
    public static final String WhExitBlockLabel = "wh" + Splitter + "exit";

    public static final String LogicNoCutBlockLabel = "lg" + Splitter + "nocut";
    public static final String LogicExitBlockLabel = "lg" + Splitter + "exit";

    public static final String SplitBlockLabel = "split";
    public static final String PreHeaderBlockLabel = "ph";
    public static final String TRNewHeaderBlockLabel = "trnew";

    // --- Prefix ---

    public static final String StrMethodPrefix = FuncNameSplitter + "str" + FuncNameSplitter;
    public static final String BottomPrefix = FuncNameSplitter + "bot" + FuncNameSplitter;
    public static final String BottomStrFuncPrefix = FuncNameSplitter + "bot" + StrMethodPrefix;

    public static final String StructPrefix = "class" + Splitter;

    // this is for Glo2Loc
    public static final String LocalPrefix = "local" + Splitter;

    public static final String CommentPrefix = "                                                ; ";

    // --- LLVM inst ---

    // standard inst
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
    public static final String TruncInst = "trunc";
    public static final String ZextInst = "zext";
    public static final String MoveInst = "move";

    // binary inst type
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

    // compare inst type
    public static final String GreaterArg = "sgt";
    public static final String GreaterEqualArg = "sge";
    public static final String LessArg = "slt";
    public static final String LessEqualArg = "sle";
    public static final String EqualArg = "eq";
    public static final String NotEqualArg = "ne";

    // str
    public static final String StrCatArg = "cat";

    // --- Suffix ---

    public static final String AddrSuffix = Splitter + "addr";
    public static final String ArrayElementSuffix = Splitter + "elem";
    public static final String CallSuffix = Splitter + CallInst;
    public static final String ResolveSuffix = Splitter + LoadInst;
    // this is for inline
    public static final String InlineSuffix = Splitter + "i";
}
