package gg.jte.generated.ondemand;
import org.example.model.HelloPage;
import java.util.List;
public final class JtehelloGenerated {
	public static final String JTE_NAME = "hello.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,14,16,16,18,18,20,20,20,36,36,36,39,39,39,43,43,43,45,45,45,75,75,78};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<HelloPage> pages) {
		jteOutput.writeContent("\n<html lang=\"es\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Bienvenida</title>\n    <link rel=\"stylesheet\" href=\"hello.css\" type=\"text/css\">\n</head>\n<body>\n\n");
		var index = 0;
		jteOutput.writeContent("\n\n");
		for (var page : pages) {
			jteOutput.writeContent("\n\n    ");
			index++;
			jteOutput.writeContent("\n\n    <div class=\"card\" id=\"card");
			jteOutput.setContext("div", "id");
			jteOutput.writeUserContent(index);
			jteOutput.writeContent("\">\n        <div class=\"card-back\">\n            <div class=\"line-numbers\">\n                <div>1</div>\n                <div>2</div>\n                <div>3</div>\n                <div>4</div>\n                <div>5</div>\n                <div>6</div>\n                <div>7</div>\n                <div>8</div>\n                <div>9</div>\n            </div>\n            <code><span class=\"variable\">const </span><span class=\"function\">Acerca de mí: </span><span\n                        class=\"operator\">= </span><span>{</span>\n                <div class=\"indent\"><span class=\"property\">nombre</span><span class=\"operator\">: </span><span\n                            class=\"string\">");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.name());
			jteOutput.writeContent("</span><span>,</span>\n                </div>\n                <div class=\"indent\"><span class=\"property\">ocupación</span><span class=\"operator\">: </span><span\n                            class=\"string\">");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.title());
			jteOutput.writeContent("</span><span>,</span>\n                </div>\n                <div class=\"indent\"><span class=\"property\">contacto</span><span class=\"operator\">: </span><span>{</span>\n                    <div class=\"indent\"><span class=\"property\">email</span><span class=\"operator\">: </span><span\n                                class=\"string\">");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.email());
			jteOutput.writeContent("</span><span>,</span></div>\n                    <div class=\"indent\"><span class=\"property\">sitio web</span><span class=\"operator\">:</span><span\n                                class=\"string\">");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.website());
			jteOutput.writeContent("</span></div>\n                    <span>}</span>\n                </div>\n                <span>}</span>\n            </code>\n        </div>\n        <div class=\"card-front\">\n            <div class=\"line-numbers\">\n                <div>1</div>\n                <div>2</div>\n                <div>3</div>\n                <div>4</div>\n                <div>5</div>\n                <div>6</div>\n                <div>7</div>\n                <div>8</div>\n                <div>9</div>\n            </div>\n            <code><span class=\"variable\">this</span><span>.</span><span\n                        class=\"method\">addEventListener</span><span>(</span><span\n                        class=\"string\">'mouseover'</span><span>, </span><span\n                        class=\"function\">() => </span><span>{ </span>\n                <div class=\"indent\"><span class=\"variable\">this</span><span>.</span><span\n                            class=\"property\">flipCard </span><span>= </span><span\n                            class=\"boolean\">true</span><span>;</span>\n                </div>\n                <span>});</span>\n            </code>\n        </div>\n    </div>\n");
		}
		jteOutput.writeContent("\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<HelloPage> pages = (List<HelloPage>)params.get("pages");
		render(jteOutput, jteHtmlInterceptor, pages);
	}
}
