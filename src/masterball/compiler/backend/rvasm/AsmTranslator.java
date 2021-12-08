package masterball.compiler.backend.rvasm;

public class AsmTranslator {

    public static String translateByteWidth(int byteWidth) {
        switch (byteWidth) {
            case 1: return "b";
            case 2: return "h";
            case 4: return "w";
        }
        return "?";
    }

}
