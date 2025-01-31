package org.example.cacheProxy;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorImpl;
import org.example.database.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {
    @Bean
    public Calculator calculatorProxy(CalculatorImpl calculator, DatabaseConnection databaseConnection) {
        return CacheProxy.createProxy(calculator, databaseConnection);
    }
}