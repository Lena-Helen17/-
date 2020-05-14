package com.moshkova.elena.read_and_writer;

import java.io.*;

public class FileRead {
    public <T> T readGeneric(String fileName) {
        T newObject = null;
        try(FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fis)) {
           // Чтение объектов из файла
                newObject = (T) in.readObject();
                }catch(Exception e){
                e.printStackTrace();
            }
        return newObject;
    }
}