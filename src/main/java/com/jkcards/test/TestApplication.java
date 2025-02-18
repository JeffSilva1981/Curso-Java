package com.jkcards.test;

import com.jkcards.entities.Order;
import com.jkcards.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.jkcards"})
public class TestApplication implements CommandLineRunner {

    private OrderService orderService;

    public TestApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the product code: ");
        Integer productCode = scanner.nextInt();
        System.out.println("Enter the basic value of the product: ");
        Double basicValue = scanner.nextDouble();
        System.out.println("Enter the discount of the product: ");
        Double discont = scanner.nextDouble();

        Order order = new Order(productCode, basicValue, discont);

        System.out.println("Order code: " + order.getCode());
        System.out.println("Total value: " + orderService.total(order));

    }
}
