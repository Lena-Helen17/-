package Programma;

import java.util.Objects;

public class ListProducts {
    private Product product;
     private Integer count;
     private final Double priceCheckList;

    public ListProducts(Product product, Integer count) {
        this.product = product;
        if (product.getBalance() > count) {
            this.count = count;
            product.setBalance(product.getBalance() - count);
        }
        this.priceCheckList = product.getPrice() * count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListProducts that = (ListProducts) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(count, that.count) &&
                Objects.equals(priceCheckList, that.priceCheckList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, count, priceCheckList);
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
