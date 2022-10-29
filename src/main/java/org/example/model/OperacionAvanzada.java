package org.example.model;

import java.util.function.DoubleSupplier;

public enum OperacionAvanzada {
    CUADRADO(Calculadora::elevarAlCuadrado),
    RAIZ(Calculadora::sacarRaizCuadrada),
    RECIPROCO(Calculadora::sacarReciproco),
    PORCENTAJE(Calculadora::sacarPorcentaje),
    SIGNO(Calculadora::cambiarSigno);

    final DoubleSupplier funcion;

    OperacionAvanzada(DoubleSupplier funcion) {
        this.funcion = funcion;
    }
}
