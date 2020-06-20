package com.moshkova.elena;

import com.moshkova.elena.files.Storage;
import com.moshkova.elena.gui.PraceFrame;
import com.moshkova.elena.models.*;
import com.moshkova.elena.files.read_and_writer_file.*;



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



        Storage reader = new FiieReader();
        reader.readCSV(praceList);
        Proverka.ProverkaListProduct(praceList);
        startFlamePrace();
    }

    public static void startFlamePrace() {
        set = new HashSet();
        FileRead readOrderList = new FileRead();
        HashMap<Integer, Order> orderList = (HashMap)readOrderList.readGeneric("orderList.dat");
        //System.out.println(orderList.toString());

        PraceFrame framePrace = new PraceFrame(praceList, set, orderList, discount);
        framePrace.setDefaultCloseOperation(3);
        framePrace.setVisible(true);
    }
}
