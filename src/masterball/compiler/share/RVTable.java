package masterball.compiler.share;

import java.util.ArrayList;
import java.util.Arrays;

public class RVTable {
    // reg
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

    // byte width
    public static final String ByteKeyword = "b";
    public static final String HalfWordKeyword = "h";
    public static final String WordKeyword = "w";

    // operand

    // compare suffix
    public static final String GreaterSuffix = "gt";
    public static final String GreaterEqualSuffix = "ge";
    public static final String LessSuffix = "lt";
    public static final String LessEqualSuffix = "le";
    public static final String EqualSuffix = "eq";
    public static final String NotEqualSuffix = "ne";

    // inst
    public static final String BrInstPrefix = "b";
    public static final String JmpInstPrefix = "j";
    public static final String LiInst = "li";
    public static final String LoadInstPrefix = "l";
    public static final String StoreInstPrefix = "s";
    public static final String LuiInst = "lui";
    public static final String MoveInst = "mv";
    public static final String RetInst = "ret";

    public static final String ShiftLeftInst = "sll";
    public static final String ShiftRightInst = "sra";
    public static final String DivInst = "div";
    public static final String ModInst = "rem";
}
