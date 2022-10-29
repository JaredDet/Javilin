package org.example.model;

import java.util.function.DoubleFunction;

public enum Operacion {
    SUMA(Calculadora::sumar),
    RESTA(Calculadora::restar),
    MULTIPLICACION(Calculadora::multiplicar),
    DIVISION(Calculadora::dividir);

    final DoubleFunction<Double> funcion;

    Operacion(DoubleFunction<Double> funcion) {
        this.funcion = funcion;
    }
}
