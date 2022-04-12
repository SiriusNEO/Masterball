package darksword.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LLVMReader {

    private final BufferedReader bufferedReader;

    public Module module;

    public LLVMReader(InputStream inputStream) {
        InputStreamReader isReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(isReader);
    }

    public void read() throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
