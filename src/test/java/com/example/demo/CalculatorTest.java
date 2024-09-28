package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void add(){
        Calculator calc = new Calculator();
        int result = calc.add(1,2);

        assertEquals(3,result);
    }
    @Test
    public void divide(){
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(2,0);
        });
    }
}