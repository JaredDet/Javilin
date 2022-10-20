package org.example;

import io.javalin.Javalin;
import org.example.configs.HtmlAndCssConfig;
import org.example.controller.HelloPageController;
import org.example.dao.Dao;
import org.example.model.Cliente;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(new Dao<>(Cliente.class).getTodos());

        var app = Javalin.create(HtmlAndCssConfig::configure)
                .start(8080);

        app.get("/", HelloPageController::renderHelloPage);
    }
}