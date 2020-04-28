import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private LocalDate dataStart;
    private Person person;
    private Short discount;
    private Status statusOrder;
    private ListProducts listProducts;

    public Order(LocalDate dataStart, Person person, Short discount, Status statusOrder, ListProducts listProducts) {
        this.dataStart = dataStart;
        this.person = person;
        this.discount = discount;
        this.statusOrder = statusOrder;
        this.listProducts = listProducts;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
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

    public Status getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Status statusOrder) {
        this.statusOrder = statusOrder;
    }

    public ListProducts getListProducts() {
        return listProducts;
    }

    public void setListProducts(ListProducts listProducts) {
        this.listProducts = listProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(dataStart, order.dataStart) &&
                Objects.equals(person, order.person) &&
                Objects.equals(discount, order.discount) &&
                statusOrder == order.statusOrder &&
                Objects.equals(listProducts, order.listProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataStart, person, discount, statusOrder, listProducts);
    }

    @Override
    public String toString() {
        return "Order{" +
                "dataStart=" + dataStart +
                ", person=" + person +
                ", discount=" + discount +
                ", statusOrder=" + statusOrder +
                ", listProducts=" + listProducts +
                '}';
    }
}
