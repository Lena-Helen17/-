package com.moshkova.elena.programma;

import java.util.List;
import java.util.Objects;

public class ListProducts {
    private Product product;
    private Integer count;
    private final Double priceCheckList;

    public ListProducts(Product product, Integer count) {
        this.product = product;
        this.count = count;
        this.priceCheckList = product.getPrice();
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
        if (o == null || getClass() != o.getClass()) return false;
        ListProducts that = (ListProducts) o;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    public String toString() {
        return "ListProducts{product=" + product + ", count=" + count + ", priceCheckList=" + priceCheckList ;
    }
}

