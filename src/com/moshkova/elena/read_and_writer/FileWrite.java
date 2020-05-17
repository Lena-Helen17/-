package com.moshkova.elena.read_and_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class FileWrite {

    public void CvsWriter(String fileName, Map dan) {

        try (Writer out = new FileWriter(fileName)) {
           out.write(dan.toString());
           out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
