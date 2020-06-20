package com.moshkova.elena.models;

import java.util.LinkedHashSet;

public class Proverka {

    public static void ProverkaListProduct (LinkedHashSet<Product> set) {
        LinkedHashSet<Product> setCopy = new LinkedHashSet(set);
        for (Product text : set) {
            Double xi = text.getPrice();
            if(xi < 0) {
                set.remove(text);
                System.out.println("Неверная цена" + text.toString());;
                }
            }
        }

    }

