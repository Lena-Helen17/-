package com.moshkova.elena.programma;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private Long id;
    private String nameProduct;
    private String color;
    private Double price;
    private Integer balance;

    public Product() {}

    public Product(Long id, String nameProduct, String color, Double price, Integer balance) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.color = color;
        this.price = price;
        this.balance = balance;
    }


    public void setId(Long id) {
         this.id = id;


    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return nameProduct;
    }

    public void setName(String name) {
        this.nameProduct = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price>0)
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance){
        if(balance>0)
        this.balance = balance;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\n" + id + ";" + nameProduct + "; " + price + " rub. ; " + balance + " kol." ;
    }
}
