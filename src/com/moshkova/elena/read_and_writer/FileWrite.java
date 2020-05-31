package com.moshkova.elena.read_and_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

public class FileWrite {

    public void CvsWriter(String fileName, Set dan) {

        try (Writer out = new FileWriter(fileName)) {
            for (Object pear : dan) {
           out.write(pear.toString());}
           out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
