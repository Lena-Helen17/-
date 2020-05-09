package Read_and_Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWrite {
    String FILE_NAME;

    public void writer(String fileName, String dan) {
        FILE_NAME = fileName;
        try (Writer out = new FileWriter(FILE_NAME, false)) {
            String text = dan;
            out.write(dan);

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
