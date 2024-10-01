package org.blitmatthew;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
       Calculator calculator = new Calculator();
//        System.out.println(calculator.divide(0, 15));
        Class<?> calClass = calculator.getClass();
        Field secretField = calClass.getDeclaredField("cantChangeMe");
        secretField.setAccessible(true);
        System.out.println(secretField.get(calculator));
        secretField.set(calculator, "I've been changed");
        System.out.println((String) secretField.get(calculator));
    }
}