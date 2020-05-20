package com.moshkova.elena;

import com.moshkova.elena.frame.OrderFrame;
import com.moshkova.elena.frame.PraceFrame;
import com.moshkova.elena.programma.*;
import com.moshkova.elena.read_and_writer.*;


import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Application {
    public static List<Person> listPerson = new ArrayList();
    public static HashMap<Integer, Order> orderList = new HashMap();
    public static HashSet<ListProducts> set = new HashSet();

    public Application() {
    }

    public static void main(String[] args) {
        Configuration propeties = Configuration.getInstance();
        String cvsFileName = "product.csv";

        ReadCSVWithScanner readCSVFile = new ReadCSVWithScanner();
        ArrayList<Product> praceList = new ArrayList();
        readCSVFile.readCSV(praceList);
        Proverka.ProverkaListProduct(praceList);

        ObjectWrite whiterOrderList = new ObjectWrite();
        whiterOrderList.writer("orderList.dat", orderList);
        FileRead readOrderList = new FileRead();
        HashMap<Integer, Order> orderListCopy = (HashMap)readOrderList.readGeneric("orderList.dat");
        System.out.println(orderListCopy.toString());

        PraceFrame framePrace = new PraceFrame(praceList, set, orderList);
        framePrace.setDefaultCloseOperation(3);
        framePrace.setVisible(true);
    }
}
