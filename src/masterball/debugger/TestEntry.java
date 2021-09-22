package masterball.debugger;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestEntry {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, This is Masterball Test func.");

        String fileName = "test.mx";
        InputStream input = new FileInputStream(fileName);

    }
}
