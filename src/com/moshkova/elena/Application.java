package com.moshkova.elena;

import com.moshkova.elena.files.FileReader;
import com.moshkova.elena.files.Storage;
import com.moshkova.elena.files.read_and_writer_file.BD.BDReader;
import com.moshkova.elena.files.read_and_writer_file.BD.ConnectionManadger;
import com.moshkova.elena.gui.PraceFrame;
import com.moshkova.elena.models.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Application {
    public static List<Person> listPerson = new ArrayList();
    public static HashMap<Integer, Order> orderList = new HashMap();
    public static HashSet<ListProducts> set = new HashSet<>();
    public static LinkedHashSet<Product> praceList = new LinkedHashSet();
    public static String discount;
    public static Storage reader = new BDReader();


    public static void startFlamePrace() {
       orderList = (HashMap)reader.readGeneric("orderList.dat");
        //System.out.println(orderList.toString());


        PraceFrame framePrace = new PraceFrame(praceList, set, orderList, discount);
        framePrace.setDefaultCloseOperation(3);
        framePrace.setVisible(true);
    }


    public static void main(String[] args) {

        Configuration propeties = Configuration.getInstance();
        discount = propeties.personProperties.getProperty("discount");

        reader.readCSV(praceList);
        Proverka.ProverkaListProduct(praceList);
        startFlamePrace();
    }









}
