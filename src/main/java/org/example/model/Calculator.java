package org.example.model;

public class Calculator {

    public static double sum(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {

        if (y == 0) {
            return 0;
        }
        return x / y;
    }
}
