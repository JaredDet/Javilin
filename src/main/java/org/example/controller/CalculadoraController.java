package org.example.controller;

import io.javalin.http.Context;
import org.example.model.Calculadora;
import org.example.model.Operacion;

import java.util.Map;

public class CalculadoraController {

    private CalculadoraController() {
    }

    public static void renderPage(Context ctx) {
        if (ctx.queryParam("operacion") == null) {
            ctx.render("calculadora.jte", Map.of("calculadora", new Calculadora()));
        } else {
            var calculadora = new Calculadora(ctx.queryParam("cache"),
                    ctx.queryParam("operacion"), ctx.queryParam("input"));

            ctx.render("calculadora.jte", Map.of("calculadora", calculadora));
        }
    }
}
