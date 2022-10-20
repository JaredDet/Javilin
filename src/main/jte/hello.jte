@import org.example.model.HelloPage
@import java.util.List
@param List<HelloPage> pages

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenida</title>
    <link rel="stylesheet" href="/public/hello.css" type="text/css">
</head>
<body>

!{var index = 0}

@for(var page : pages)

    !{index++}

    <div class="card" id="card${index}">
        <div class="card-back">
            <div class="line-numbers">
                <div>1</div>
                <div>2</div>
                <div>3</div>
                <div>4</div>
                <div>5</div>
                <div>6</div>
                <div>7</div>
                <div>8</div>
                <div>9</div>
            </div>
            <code><span class="variable">const </span><span class="function">Acerca de mí: </span><span
                        class="operator">= </span><span>{</span>
                <div class="indent"><span class="property">nombre</span><span class="operator">: </span><span
                            class="string">${page.name()}</span><span>,</span>
                </div>
                <div class="indent"><span class="property">ocupación</span><span class="operator">: </span><span
                            class="string">${page.title()}</span><span>,</span>
                </div>
                <div class="indent"><span class="property">contacto</span><span class="operator">: </span><span>{</span>
                    <div class="indent"><span class="property">email</span><span class="operator">: </span><span
                                class="string">${page.email()}</span><span>,</span></div>
                    <div class="indent"><span class="property">sitio web</span><span class="operator">:</span><span
                                class="string">${page.website()}</span></div>
                    <span>}</span>
                </div>
                <span>}</span>
            </code>
        </div>
        <div class="card-front">
            <div class="line-numbers">
                <div>1</div>
                <div>2</div>
                <div>3</div>
                <div>4</div>
                <div>5</div>
                <div>6</div>
                <div>7</div>
                <div>8</div>
                <div>9</div>
            </div>
            <code><span class="variable">this</span><span>.</span><span
                        class="method">addEventListener</span><span>(</span><span
                        class="string">'mouseover'</span><span>, </span><span
                        class="function">() => </span><span>{ </span>
                <div class="indent"><span class="variable">this</span><span>.</span><span
                            class="property">flipCard </span><span>= </span><span
                            class="boolean">true</span><span>;</span>
                </div>
                <span>});</span>
            </code>
        </div>
    </div>
@endfor

</body>
</html>