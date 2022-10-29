package org.example.model;

import java.util.function.BiFunction;

public enum Operacion {
    NINGUNA((x, y) -> {
        throw new IllegalStateException("Ninguna operación seleccionada");
    }),
    SUMA(Double::sum),
    RESTA((x, y) -> x - y),
    MULTIPLICACION((x, y) -> x * y),
    DIVISION((x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }

        return x / y;
    }),
    CUADRADO((x, y) -> Math.pow(x, 2)),
    RAIZ_CUADRADA((x, y) -> Math.sqrt(x)),
    RECIPROCO((x, y) -> {
        if (x == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return 1 / x;
    }),
    PORCENTAJE((x, y) -> x / 100);

    Operacion(BiFunction<Double, Double, Double> operacion) {
        this.operacion = operacion;
    }

    private final BiFunction<Double, Double, Double> operacion;

    public double calcular(double cache, double input) {
        return operacion.apply(cache, input);
    }
}
