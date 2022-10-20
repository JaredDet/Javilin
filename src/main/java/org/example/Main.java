package org.example;

import io.javalin.Javalin;
import org.example.configs.HTMLAndCSSFilesConfigs;
import org.example.controller.HelloPageController;


public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(HTMLAndCSSFilesConfigs::configure)
                .start(8080);
        app.get("/", HelloPageController::renderHelloPage);
    }
}