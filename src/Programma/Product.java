package Programma;

import java.util.Objects;

public class Product {
    private final Integer article;
    private String nameProduct;
    private String color;
    private Double price;
    private Integer balance;

    public Product(String nameProduct, Double price, Integer balance) {
       this.article = ( 100000 + (int) (Math.random() * Integer.MAX_VALUE));
        this.nameProduct = nameProduct;
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Неверная цена.");
        }
        this.balance = balance;

    }

    public Integer getArticle() {
        return article;
    }

    public String getName() {
        return nameProduct;
    }

    public void setName(String name) {
        this.nameProduct = name;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance){this.balance = balance;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(article, product.article) &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(color, product.color) &&
                Objects.equals(price, product.price) &&
                Objects.equals(balance, product.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, nameProduct, color, price, balance);
    }

    @Override
    public String toString() {
        return "\n" + nameProduct + " - " + price + " руб. - " + balance + " шт." ;
    }
}
