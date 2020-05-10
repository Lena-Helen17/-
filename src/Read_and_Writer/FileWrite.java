package Read_and_Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class FileWrite {
    String FILE_NAME;

    public void CvsWriter(String fileName, Map dan) {
        FILE_NAME = fileName;
        try (Writer out = new FileWriter(FILE_NAME)) {
           out.write(dan.toString());
           out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
