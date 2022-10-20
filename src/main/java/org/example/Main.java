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
        var name = "Víctor Mardones";
        var title = "Desarrollador";
        var email = "v.mardones04@ufromail.cl";
        var website = "v.mardones.com";

        var page1 = new HelloPage(name, title, email, website);

        name = "Javier Márquez";
        title = "Desarrollador";
        email = "f.marquez01@ufromail.cl";
        website = "";

        var page2 = new HelloPage(name, title, email, website);


        var pages = List.of(page1, page2);
        ctx.render("hello.jte", Collections.singletonMap("pages", pages));
    }

    private static void configure(JavalinConfig config) {
        JavalinJte.configure(createTemplateEngineHTML());
        config.addStaticFiles(staticFileConfig -> staticFileConfig.hostedPath = "/public");
    }

    private static TemplateEngine createTemplateEngineHTML() {
        DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }
}