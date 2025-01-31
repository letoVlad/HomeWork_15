package org.example.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@Primary
public class CalculatorImpl implements Calculator {

    @Override
    public BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
