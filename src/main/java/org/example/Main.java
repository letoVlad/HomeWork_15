package org.example;

import org.example.cacheProxy.CacheProxy;
import org.example.calculator.Calculator;
import org.example.database.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Calculator calculator = context.getBean(Calculator.class);
        DatabaseConnection databaseConnection = context.getBean(DatabaseConnection.class);

        Calculator proxyCalculator = CacheProxy.createProxy(calculator, databaseConnection);
        System.out.println(proxyCalculator.factorial(7));
    }
}
