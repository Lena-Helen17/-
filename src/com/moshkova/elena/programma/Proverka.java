package com.moshkova.elena.programma;

import java.util.ArrayList;
import java.util.List;

public class Proverka {

    public static void ProverkaListProduct (List<Product> list) {
        List<Product> listCopy = new ArrayList<>(list);
        for(int i = 0; i < listCopy.size(); i++) {
            Double xi = list.get(i).getPrice();
            if(xi < 0) {
                list.remove(i);
                System.out.println("Неверная цена" + list.get(i).toString());;
                }
            }
        }

    }

