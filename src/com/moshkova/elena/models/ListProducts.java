package com.moshkova.elena.models;

import java.io.Serializable;
import java.util.Objects;

public class ListProducts implements Serializable {
    private Product product;
    private Integer count;
    private Double priceCheckList;
    private Double orderPrice;
  //  String formattedDouble = new DecimalFormat("#0.00").format(orderPrice);
    private Double discount;

    public ListProducts(Product product, Integer count, Double orderPrice, Double discount ){
        this.count = count;
        this.discount = discount;
        this.product = product;
        this.orderPrice = orderPrice;
        priceCheckList = product.getPrice();
    };

    public ListProducts(Product product, Integer count, String dist) {
        this.product = product;
        this.count = count;
        priceCheckList = product.getPrice();
        discount = Double.parseDouble(dist);
        orderPrice = priceCheckList * count * ((100 - discount)/100.0);
    }

    public Product getProduct() {
        return product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if (count > 0) {
        this.count = count;
        orderPrice = priceCheckList * count  * ((100 - discount)/100.0);
        }
    }

    public Double getOrderPrice() {
        return orderPrice;
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
        return "ListProducts{product=" + product + ", count=" + count + ", priceCheckList=" + orderPrice ;
    }
}

