package com.moshkova.elena.files.read_and_writer_file;

import com.moshkova.elena.files.Storage;
import com.moshkova.elena.models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FiieReader  implements Storage {

    @Override
    public void readCSV (LinkedHashSet<Product> empList) {
        // открываем файл
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
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
}
