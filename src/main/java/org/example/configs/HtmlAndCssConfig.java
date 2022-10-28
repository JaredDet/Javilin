package org.example.configs;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.config.JavalinConfig;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinJte;

import java.nio.file.Path;

public class HtmlAndCssConfig {

    private HtmlAndCssConfig() {
    }

    public static void configure(JavalinConfig config) {
        config.staticFiles.add("/static", Location.CLASSPATH);

        JavalinJte.init(createJteTemplateEngine());
    }

    private static TemplateEngine createJteTemplateEngine() {
        var codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }
}
