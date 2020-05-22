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
        String discount = propeties.personProperties.getProperty("discount");



        ReadCSVWithScanner readCSVFile = new ReadCSVWithScanner();
        ArrayList<Product> praceList = new ArrayList();
        readCSVFile.readCSV(praceList);
        Proverka.ProverkaListProduct(praceList);

        FileRead readOrderList = new FileRead();
        HashMap<Integer, Order> orderList = (HashMap)readOrderList.readGeneric("orderList.dat");
        System.out.println(orderList.toString());



        PraceFrame framePrace = new PraceFrame(praceList, set, orderList, discount);
        framePrace.setDefaultCloseOperation(3);
        framePrace.setVisible(true);
    }
}
