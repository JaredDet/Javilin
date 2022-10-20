package org.example;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.http.Context;
import io.javalin.plugin.rendering.template.JavalinJte;
import org.example.model.HelloPage;


import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(Main::configure)
                .start(8080);
        app.get("/", Main::renderHelloPage);
    }

    private static void renderHelloPage(Context ctx) {
        var page1 = new HelloPage();
        page1.name = "Víctor Mardones";
        page1.title = "Desarrollador";
        page1.email = "v.mardones04@ufromail.cl";
        page1.website = "v.mardones.com";

        var page2 = new HelloPage();
        page2.name = "Javier Márquez";
        page2.title = "Desarrollador";
        page2.email = "f.marquez01@ufromail.cl";
        page2.website = "";

        var pages = List.of(page1, page2);
        ctx.render("hello.jte", Collections.singletonMap("pages", pages));
    }
    private static void configure(JavalinConfig config) {
        JavalinJte.configure(createTemplateEngine());
    }

    private static TemplateEngine createTemplateEngine() {
        DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }
}