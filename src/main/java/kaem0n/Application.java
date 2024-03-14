package kaem0n;

import com.github.javafaker.Faker;
import kaem0n.entities.Customer;
import kaem0n.entities.Order;
import kaem0n.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
    }
}
