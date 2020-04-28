import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Integer, Product> listProduct = new HashMap<>();
        Product product1 = new Product("ручка", 59.4, 8);
        Product product2 = new Product("карандаш", 6., 100);
        Product product3 = new Product("стерка",-1.,5);
        listProduct.put(product1.getArticle(),product1 );
        listProduct.put(product2.getArticle(), product2);
        listProduct.put(product3.getArticle(), product3);

        System.out.println(listProduct);

      Person person1 = new Person("Катя", "г.Москва", 89245687744L);
      Person person2 = new Person("Рома", "г.СПб", 89276354422L);
      Person person3 = new Person("Helen", "USA", 556567712L);

      Order order1 = new Order(LocalDate.now(), person1, (short) 10, Status.READING, new ListProducts(product1, 6));
      Order order2 = new Order(LocalDate.now(), person2, (short) 5, Status.DELITED, new ListProducts(product2, 40));

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(listProduct);
    }
}
