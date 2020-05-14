package com.moshkova.elena.programma;

import java.util.List;
import java.util.Objects;

public class ListProducts {
    private Product product;
     private Integer count;
     private final Double priceCheckList;

    public ListProducts(Product product, Integer count) {
        this.product = product;
//        if (product.getBalance() > count) {
            this.count = count;
//            product.setBalance(product.getBalance() - count);
//        }
        this.priceCheckList = product.getPrice();
    }

    public void addListProducts (List listProducts) {
       //listProducts.add()
    }

    public Product getProduct() {
        return product;
    }

    public Integer getCount() {
        return count;
    }

    public Double getPriceCheckList() {
        return priceCheckList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListProducts)) return false;
        ListProducts that = (ListProducts) o;
        return Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct());
    }

    @Override
    public String toString() {
        return "ListProducts{" +
                "product=" + product +
                ", count=" + count +
                ", priceCheckList=" + priceCheckList +
                '}';
    }
}
