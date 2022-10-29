package org.example.model;

public record Calculadora(double cache, Operacion operacion, double input) {

    public Calculadora(String cache, String operacion, String input) {
        this(Double.parseDouble(cache), Operacion.valueOf(operacion), Double.parseDouble(input));
    }

    public Calculadora() {
        this(0, Operacion.NINGUNA, 0);
    }

    public String calcular() {
        try {
            return "" + operacion.calcular(cache, input);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
    }
}
