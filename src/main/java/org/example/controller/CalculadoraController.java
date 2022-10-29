package org.example.controller;

import io.javalin.http.Context;
import org.example.model.Calculadora;
import org.example.model.Operacion;

import java.util.Map;

public class CalculadoraController {

    private CalculadoraController() {
    }

    public static void renderNew(Context ctx) {
        ctx.render("calculadora.jte", Map.of("calculadora", new Calculadora()));
    }

    public static void renderCalculation(Context ctx) {
        ctx.render("calculadora.jte",
                Map.of("calculadora", new Calculadora("1", "SUMA", "1"))
        );
    }
}
