package org.example.controller;

import io.javalin.http.Context;

public class CalculadoraController {

    private CalculadoraController() {

    }

    public static void renderPage(Context ctx) {
        ctx.render("calculadora.jte");
    }
}
