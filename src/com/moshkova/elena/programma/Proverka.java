package com.moshkova.elena.programma;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

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

