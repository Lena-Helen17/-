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
    public static HashSet<ListProducts> set;
    public static LinkedHashSet<Product> praceList = new LinkedHashSet();
    public static String discount;


    public static void main(String[] args) {
        Configuration propeties = Configuration.getInstance();
        discount = propeties.personProperties.getProperty("discount");



        ReadCSVWithScanner readCSVFile = new ReadCSVWithScanner();
        readCSVFile.readCSV(praceList);
        Proverka.ProverkaListProduct(praceList);

//        FileRead readOrderList = new FileRead();
//        HashMap<Integer, Order> orderList = (HashMap)readOrderList.readGeneric("orderList.dat");
        //System.out.println(orderList.toString());

        startFlamePrace();
    }

    public static void startFlamePrace() {
        set = new HashSet();
        PraceFrame framePrace = new PraceFrame(praceList, set, orderList, discount);
        framePrace.setDefaultCloseOperation(3);
        framePrace.setVisible(true);
    }
}
