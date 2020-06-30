package com.moshkova.elena.files.read_and_writer_file.BD;


import com.moshkova.elena.files.Storage;
import com.moshkova.elena.files.read_and_writer_file.BD.Dao.OrderDao;
import com.moshkova.elena.files.read_and_writer_file.BD.Dao.ProducrDao;
import com.moshkova.elena.models.Order;
import com.moshkova.elena.models.Product;

import java.io.Serializable;
import java.sql.*;
import java.util.LinkedHashSet;
import java.sql.*;
import java.util.*;

public class BDReader implements Storage {

    Long idProduct = 0L;


    static String text = null;
 static {
     try {
         Class.forName("org.postgresql.Driver");
     } catch (ClassNotFoundException classNotFoundException) {
         System.out.println("Не удалось загрузить драйвер");
         System.exit(1);
     }
      }
    @Override
    public <T> T readGeneric(String fileName) {
        T newObject = null;
        OrderDao orderDao = new OrderDao();
        newObject = (T)orderDao.prindAll();

        return newObject;
    }

    @Override
    public void readCSV(LinkedHashSet<Product> empList) {
        ProducrDao producrDao = new ProducrDao();
        producrDao.pindAll(empList);
    }

    @Override
    public void CvsWriter(String fileName, Set dan) {
        
    }

    @Override
    public void writer(String fileName, Object dan) {

    }

    @Override
    public HashMap<Long, Product> newMap() {
     HashMap<Long, Product> map = new HashMapBD<Long, Product>() ;

        return map;
    }
     public class HashMapBD<K,V> extends HashMap<K,V> {


         @Override
         public V get(Object key) {
             idProduct = (Long) key;
             return super.get(key);
         }

     }

     @Override
    public void setBalanceStorage(Integer balance, Product product){
         ProducrDao producrDao = new ProducrDao();
         producrDao.save(idProduct, balance);
            //this.balance = balance;
        }
}
