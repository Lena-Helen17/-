package com.moshkova.elena.programma;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Order {            //заказ
    private String dataStart;
    private Person person;
    private Short discount;
    private String statusOrder;
    private HashSet<ListProducts> listProductsHashSet;

    public Order(String dataStart, Person person, Short discount, String statusOrder, HashSet<ListProducts> listProductsHashSet) {
        this.dataStart = dataStart;
        this.person = person;
        this.discount = discount;
        this.statusOrder = statusOrder;
        this.listProductsHashSet = listProductsHashSet;
    }

    public Order(String text, Person person, String text1, HashSet<ListProducts> hashSet) {
    }


    public HashSet<ListProducts> getListProductsHashSet() {
        return listProductsHashSet;
    }

    public void addListProductsHashSet(ListProducts listProducts) {
        listProductsHashSet.add(listProducts);
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
                Objects.equals(listProductsHashSet, order.listProductsHashSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataStart, person, discount, statusOrder, listProductsHashSet);
    }

    @Override
    public String toString() {
        return "Order{" +
                "dataStart=" + dataStart +
                ", person=" + person +
                ", discount=" + discount +
                ", statusOrder=" + statusOrder +
                ", listProducts=" + listProductsHashSet.toString() +
                '}';
    }
}
