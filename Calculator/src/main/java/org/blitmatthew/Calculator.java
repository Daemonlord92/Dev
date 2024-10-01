package org.blitmatthew;

public class Calculator {

    private String cantChangeMe = "HAHAHAHAHA";

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero!");
        return a / b;
    }
}
