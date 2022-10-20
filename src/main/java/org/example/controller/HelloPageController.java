package org.example.controller;

import io.javalin.http.Context;
import org.example.model.HelloPage;

import java.util.Collections;
import java.util.List;

public class HelloPageController {

    private static final String[] admin1 = {"Víctor Mardones", "Desarrollador", "v.mardones04@ufromail.cl", "v.mardones.com"};
    private static final String[] admin2 = {"Javier Márquez", "Desarrollador", "f.marquez01@ufromail.cl", ""};

    public static void renderHelloPage(Context ctx) {

        final var page1 = new HelloPage(admin1[0], admin1[1], admin1[2], admin1[3]);
        final var page2 = new HelloPage(admin2[0], admin2[1], admin2[2], admin2[3]);

        final var pages = List.of(page1, page2);
        ctx.render("hello.jte", Collections.singletonMap("pages", pages));

    }
}
