package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.ArrayType;
import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;
import masterball.debug.Log;

public class StringConst extends GlobalValue {

    public String constData;

    public StringConst(String constData) {
        super(LLVMTable.StrConstAnon,
                new PointerType(new ArrayType(new IntType(8), constData.length()+1))
                );
        this.constData = constData;
    }

    public String constDataFormat() {
        return "c\"" +
                constData.replace("\\", "\\5C")
                        .replace("\n", "\\0A")
                        .replace("\0", "\\00")
                        .replace("\t", "\\09")
                        .replace("\"", "\\22")
                + "\\00\"";
    }
}
