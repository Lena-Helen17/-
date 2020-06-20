package com.moshkova.elena.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Order implements Serializable {            //заказ
    private String dataStart;
    private Person person;
    private Short discount;
    private String statusOrder;
    private ArrayList<ListProducts> listProductsList;

    public Order(String dataStart, Person person, Short discount, String statusOrder, ArrayList<ListProducts> listProductsArrayList) {
        this.dataStart = dataStart;
        this.person = person;
        this.discount = discount;
        this.statusOrder = statusOrder;
        listProductsList = listProductsArrayList;
    }



    public ArrayList<ListProducts> getListProductsList() {
        return listProductsList;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(dataStart, order.dataStart) &&
                Objects.equals(person, order.person) &&
                Objects.equals(discount, order.discount) &&
                Objects.equals(listProductsList, order.listProductsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataStart, person, discount, statusOrder, listProductsList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "dataStart=" + dataStart +
                ", person=" + person +
                ", discount=" + discount +
                ", statusOrder=" + statusOrder +
                ", listProducts=" + listProductsList.toString() +
                '}';
    }
}
