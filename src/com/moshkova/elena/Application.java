package com.moshkova.elena;

import com.moshkova.elena.frame.OrderFrame;
import com.moshkova.elena.programma.*;
import com.moshkova.elena.read_and_writer.*;


import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Application {
    public static List<Person> listPerson = new ArrayList<>();


    public static void main(String[] args) {




       Configuration propeties = Configuration.getInstance();
        String cvsFileName = "product.csv";

        Map<Integer, Product> listProduct = new HashMap<>();
       // Product product1 = new Product("ручка", 59.4, 8);
        //Product product2 = new Product("Pent", 6.6, 100);
        //Product product3 = new Product("стерка",1.0,5);
        //listProduct.put(product1.getId(),product1 );
        //listProduct.put(product2.getId(), product2);
        //listProduct.put(product3.getId(), product3);


        //System.out.println(listProduct);
        /////////////////////////////
//        ritering.writer("product.csv",listProduct);
        //ObjectWrite writering = new ObjectWrite();
//        //FileWrite writering = new FileWrite();
//        w
      //  writering.CvsWriter(cvsFileName,listProduct);

//        FileRead reading = new FileRead();
//        String listProductCopy =  reading.readGeneric(cvsFileName);
//        System.out.println(listProductCopy);

    ReadCSVWithScanner readCSVFile = new ReadCSVWithScanner();
        List<Product> empList = new ArrayList<>();
        readCSVFile.readCSV(empList);
        Proverka.ProverkaListProduct(empList);

        Person person1 = new Person("Катя", "г.Москва", 89245687744L);
      Person person2 = new Person("Рома", "г.СПб", 89276354422L);
      Person person3 = new Person("Helen", "USA", 556567712L);

        HashSet<ListProducts> set = new HashSet<ListProducts>();
        set.add(new ListProducts(empList.get(2),2));
        set.add(new ListProducts(empList.get(7),5));

     Order order1 = new Order(LocalDate.now(), person1, (short) 10, Status.READING, set);
      Order order2 = new Order(LocalDate.now(), person2, (short) 5, Status.DELITED, new HashSet<ListProducts> ());

      order2.addListProductsHashSet(new ListProducts(empList.get(3),4));
      order2.addListProductsHashSet(new ListProducts(empList.get(8),35));
      order2.addListProductsHashSet(new ListProducts(empList.get(2),2));




      System.out.println(order1);
        System.out.println(order2);
        //System.out.println(listProduct);

        //______________________________________________
//        Login_in frame = new Login_in();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        OrderFrame frame = new OrderFrame(order2.getListProductsHashSet());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //___________________________________________
    }
}
