package kaem0n;

import com.github.javafaker.Faker;
import kaem0n.entities.Customer;
import kaem0n.entities.Order;
import kaem0n.entities.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static final Faker faker = new Faker(Locale.ITALY);

    public static void main(String[] args) {
        Customer customer1 = new Customer(faker.name().name(), 2);
        Customer customer2 = new Customer(faker.name().name(), 1);
        Customer customer3 = new Customer(faker.name().name(), 3);
        Customer customer4 = new Customer(faker.name().name(), 2);

        List<Product> inventory = new ArrayList<>();
        inventory.add(new Product(faker.book().title(), "Books", 9.90));
        inventory.add(new Product(faker.book().title(), "Books", 9.90));
        inventory.add(new Product(faker.beer().name(), "Alcoholics", 2.99));
        inventory.add(new Product(faker.beer().name(), "Alcoholics", 2.59));
        inventory.add(new Product(faker.food().vegetable(), "Food", 1.99));
        inventory.add(new Product(faker.food().vegetable(), "Food", 0.99));

        List<Order> totalOrders = new ArrayList<>();
        totalOrders.add(new Order(customer1));
        totalOrders.add(new Order(customer1));
        totalOrders.add(new Order(customer1));
        totalOrders.add(new Order(customer2));
        totalOrders.add(new Order(customer2));
        totalOrders.add(new Order(customer3));
        totalOrders.add(new Order(customer3));
        totalOrders.add(new Order(customer4));

        totalOrders.forEach(order -> {
            for (int i = 0; i < new Random().nextInt(1, 11); i++) {
                order.addProduct(inventory.get(new Random().nextInt(1, inventory.size())));
            }
        });

        System.out.println();
        System.out.println("==== EXERCISE 1 ====");
        getOrdersByCustomer(customer1, totalOrders);
        System.out.println();
        getOrdersByCustomer(customer2, totalOrders);
        System.out.println();
        getOrdersByCustomer(customer3, totalOrders);
        System.out.println();
        getOrdersByCustomer(customer4, totalOrders);
        System.out.println();
        System.out.println("==== EXERCISE 2 ====");
    }

    public static Map<String, List<Order>> getOrdersByCustomer(Customer customer, List<Order> orderList) {
        Map<String, List<Order>> ordersByCustomer = orderList.stream().filter(order -> order.getCustomer().equals(customer))
                .collect(Collectors.groupingBy(order -> order.getCustomer().getName()));
        ordersByCustomer.forEach((customerName, orders) -> {
            System.out.println("Customer: " + customerName + "; Number of orders: " + orders.size());
            orders.forEach(order -> System.out.println("- " + order));
        });
        return ordersByCustomer;
    }
}
