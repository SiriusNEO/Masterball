package masterball.compiler.share.lang;

import java.util.ArrayList;
import java.util.Arrays;

public class RV32I {
    // --- Sys Config for RV ---

    public static final int ImmBound = (1 << 11);
    public static final int SpLowUnit = 16;
    public static final int I32Unit = 4;
    public static final int MaxStackSize = Integer.MAX_VALUE;

    // --- Register Related ---

    public static final int MaxArgRegNum = 8;
    public static final String VirtualRegPrefix = "v";
    public static final String FuncArgRegPrefix = "a";
    public static final String TempRegPrefix = "t";
    public static final String SavedRegPrefix = "s";
    public static final ArrayList<String> RV32Reg = new ArrayList<String>(Arrays.asList(
            "zero", "ra", "sp", "gp", "tp", "t0", "t1", "t2", "s0", "s1",
            "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11",
            "t3", "t4", "t5", "t6"
    ));

    // --- Byte Width Keyword ---

    public static final String ByteKeyword = "b";
    public static final String HalfWordKeyword = "h";
    public static final String WordKeyword = "w";

    // --- Compare Suffix ---

    public static final String GreaterEqualSuffix = "ge";
    public static final String LessSuffix = "lt";
    public static final String EqualSuffix = "eq";
    public static final String NotEqualSuffix = "ne";

    // --- RV32 Inst ---

    public static final String ITypeSuffix = "i";
    public static final String BrInstPrefix = "b";
    public static final String CallInst = "call";
    public static final String JmpInstPrefix = "j";
    public static final String LaInst = "la";
    public static final String LiInst = "li";
    public static final String LoadInstPrefix = "l";
    public static final String StoreInstPrefix = "s";
    public static final String LuiInst = "lui";
    public static final String MvInst = "mv";
    public static final String RetInst = "ret";
    public static final String SltInst = "slt";
    public static final String SeqzInst = "seqz";
    public static final String SnezInst = "snez";
    public static final String TailInst = "tail";

    public static final String AddInst = "add";
    public static final String SubInst = "sub";
    public static final String MulInst = "mul";
    public static final String AndInst = "and";
    public static final String OrInst = "or";
    public static final String XorInst = "xor";
    public static final String ShiftLeftInst = "sll";
    public static final String ShiftRightInst = "sra";
    public static final String DivInst = "div";
    public static final String ModInst = "rem";
}
