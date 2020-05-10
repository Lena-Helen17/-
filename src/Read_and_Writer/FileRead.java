package Read_and_Writer;
import Programma.Product;

import java.io.*;
import java.util.Map;

public class FileRead {
    public void copy(String fileName, Object bam) {
        try(FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fis)) {
           // Чтение объектов из файла
                bam = in.readObject();
                }catch(Exception ex){
                ex.printStackTrace();
            }
    }
}