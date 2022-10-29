package org.example.model;

public class Calculadora {

    private static String input = "";
    private static double cache = 0;

    private Calculadora() {
    }

    public static String getResultado(Operacion operacion, double x) {

        var resultado = operacion.funcion.apply(x);

        try {
            cache = resultado;
        } catch (IllegalArgumentException e) {
            cache = 0;
            System.err.println(e.getMessage());
        }

        return "" + resultado;
    }

    public static String getResultado(OperacionAvanzada operacion) {

        var resultado = operacion.funcion.getAsDouble();
        try {
            cache = resultado;
        } catch (IllegalArgumentException e) {
            cache = 0;
            System.err.println(e.getMessage());
        }
        return "" + resultado;
    }

    public static double sumar(double x) {
        return cache + x;
    }

    public static double restar(double x) {
        return cache - x;
    }

    public static double multiplicar(double x) {
        return x * cache;
    }

    public static double dividir(double x) {

        if (x == 0) {
            var error = "No se puede dividir entre cero";
            System.out.println(error);
            throw new IllegalArgumentException(error);
        }
        return cache / x;
    }

    public static double elevarAlCuadrado() {
        return Math.pow(cache, 2);
    }

    public static double sacarRaizCuadrada() {
        return Math.sqrt(cache);
    }

    public static double sacarReciproco() {

        if (cache == 0) {
            var error = "No se puede dividir entre cero";
            System.out.println(error);
            throw new IllegalArgumentException(error);
        }
        return 1 / cache;
    }

    public static double sacarPorcentaje() {
        return cache / 100;
    }

    public static double cambiarSigno() {
        return -cache;
    }

    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        Calculadora.input = input;
    }
}
