package org.example;

import io.javalin.Javalin;
import org.example.configs.HtmlAndCssConfig;
import org.example.controller.CalculadoraController;
import org.example.controller.HelloPageController;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(HtmlAndCssConfig::configure);
        app.get("/", HelloPageController::renderHelloPage);
        app.get("/calculadora", CalculadoraController::renderPage);

        app.start(8080);
    }
}