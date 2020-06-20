package com.moshkova.elena.files;

import com.moshkova.elena.models.Product;

import java.util.LinkedHashSet;

public interface Storage {
    public void readCSV (LinkedHashSet<Product> empList);
}
