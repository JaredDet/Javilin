package org.example.configs;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.core.JavalinConfig;
import io.javalin.plugin.rendering.template.JavalinJte;

import java.nio.file.Path;

public class HTMLAndCSSFilesConfigs {

    public static void configure(JavalinConfig config) {
        JavalinJte.configure(createTemplateEngineHTML());
        config.addStaticFiles(staticFileConfig -> staticFileConfig.hostedPath = "/public");
    }

    private static TemplateEngine createTemplateEngineHTML() {
        DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }
}
