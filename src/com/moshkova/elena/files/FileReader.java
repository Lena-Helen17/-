package com.moshkova.elena.files;

import com.moshkova.elena.models.Order;
import com.moshkova.elena.models.Product;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FileReader implements Storage {

    @Override
    public void readCSV (LinkedHashSet<Product> empList) {
        // открываем файл
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(
                    "product.csv"));

            // считываем построчно
            String line = null;
            Scanner scanner = null;
            int index = 0;


            while ((line = reader.readLine()) != null) {
                Product product = new Product();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()) {
                    String text = scanner.next();
                    if (index == 0)
                        product.setId(Long.parseLong(text));
                    else if (index == 1)
                        product.setName(text);
                    else if (index == 2)
                        product.setColor(text);
                    else if (index == 3)
                        product.setPrice(Double.parseDouble(text));
                    else if (index == 4) {
                        if (text.equals("null")) {
                            product.setBalance(0);
                        }else
                            product.setBalance(Integer.parseInt(text));
                    }
                    else
                        System.out.println("Некорректные данные::" + text);
                    index++;
                }
                index = 0;
                empList.add(product);
            }

            //закрываем наш ридер
            reader.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T readGeneric(String fileName) {
        T newObject = null;

        File file = new File(fileName);
        if(file.exists()) {

            try (FileInputStream fis = new FileInputStream(fileName);
                 ObjectInputStream in = new ObjectInputStream(fis)) {
                // Чтение объектов из файла
                newObject = (T) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newObject;
    }
    @Override
    public void CvsWriter(String fileName, Set dan) {

        try (Writer out = new FileWriter(fileName)) {
            for (Object pear : dan) {
                out.write(pear.toString());}
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writer(String fileName, Object dan) {

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fos)){
            // Запись объектов в файл
            out.writeObject(dan);
        } catch (IOException e) {
            System.out.println("Oшибка записи файла");
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Long, Product> newMap() {
        return new HashMap<Long, Product>();
    }

    @Override
    public void setBalanceStorage(Integer balance, Product product) {
      product.setBalance(balance);
    }
}
