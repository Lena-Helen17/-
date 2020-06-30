package com.moshkova.elena.files;

import com.moshkova.elena.models.Product;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public interface Storage {
    public void readCSV (LinkedHashSet<Product> empList);

    public <T> T readGeneric(String fileName);

    public void CvsWriter(String fileName, Set dan);

    public void writer(String fileName, Object dan);

    public HashMap<Long, Product> newMap();

    public void setBalanceStorage(Integer balance, Product product);
}
