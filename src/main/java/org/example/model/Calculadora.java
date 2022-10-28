package org.example.model;

import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;

public class Calculadora {

    private static double cache = 0;

    private Calculadora() {
    }

    public static String getResultado(Operacion operacion, double x) {

        var resultado = operacion.operacionCalculadora.apply(x);
        try {
            cache = resultado;
        } catch (IllegalArgumentException e) {
            cache = 0;
            System.err.println(e.getMessage());
        }
        return "" + resultado;
    }

    public static String getResultado(OperacionAvanzada operacion) {

        var resultado = operacion.operacionCalculadora.getAsDouble();
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

    public static String getCache() {
        return cache + "";
    }

    public static void setCache(String newCache) {
        cache = Double.parseDouble(newCache);
    }
}

public enum Operacion {
    SUMA(Calculadora::sumar),
    RESTA(Calculadora::restar),
    MULTIPLICACION(Calculadora::multiplicar),
    DIVISION(Calculadora::dividir);

    final DoubleFunction<Double> operacionCalculadora;

    Operacion(DoubleFunction<Double> operacionCalculadora) {
        this.operacionCalculadora = operacionCalculadora;
    }
}

enum OperacionAvanzada {
    CUADRADO(Calculadora::elevarAlCuadrado),
    RAIZ(Calculadora::sacarRaizCuadrada),
    RECIPROCO(Calculadora::sacarReciproco),
    PORCENTAJE(Calculadora::sacarPorcentaje),
    SIGNO(Calculadora::cambiarSigno);

    final DoubleSupplier operacionCalculadora;

    OperacionAvanzada(DoubleSupplier operacionCalculadora) {
        this.operacionCalculadora = operacionCalculadora;
    }
}