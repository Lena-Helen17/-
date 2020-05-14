package com.moshkova.elena.read_and_writer;


import java.io.*;


public class ObjectWrite {
    String FILE_NAME;

     public void writer(String fileName, Object dan) {
        FILE_NAME = fileName;
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fos)){
            // Запись объектов в файл
            out.writeObject(dan);
            } catch (IOException e) {
            System.out.println("Oшибка записи файла");
            e.printStackTrace();
        }

    }}
