@import org.example.model.Calculadora
@import org.example.model.Operacion
@param Calculadora calculadora

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenida</title>
    <link rel="stylesheet" href="calculadora.css" type="text/css">
</head>

<body>
<form class="calculator" >
    <div class="display">
        <div id="display">
            <input type="text" id="entrada" name="entrada" readonly>
            <input type="text" id="operacion" name="operacion" hidden readonly>
        </div>
    </div>
    <div class="keys">
        <div class="row-1">
            <button id="clear" class="top" type="button">AC</button>
            <button class="top" id="negative"><sup>+</sup>/-</button>
            <button class="top" id="percent">%</button>
            <button class="operator" value="/">&#247;</button>
        </div>
        <div class="row-2">
            <button class="number" onclick="agregarNumero()" value="7" type="button">7</button>
            <button class="number" onclick="agregarNumero()" value="8" type="button">8</button>
            <button class="number" onclick="agregarNumero()" value="9" type="button">9</button>
            <button class="operator" value="*">&times;</button>
        </div>
        <div class="row-3">
            <button class="number" onclick="agregarNumero()" value="4" type="button">4</button>
            <button class="number" onclick="agregarNumero()" value="5" type="button">5</button>
            <button class="number" onClick="agregarNumero()" value="6" type="button">6</button>
            <button class="operator" value="-">-</button>
        </div>
        <div class="row-4">
            <button class="number" onclick="agregarNumero()" value="1" type="button">1</button>
            <button class="number" onclick="agregarNumero()" value="2" type="button">2</button>
            <button class="number" onclick="agregarNumero()" value="3" type="button">3</button>
            <button class="operator" value="+">+</button>
        </div>
        <div class="row-5">
            <button class="number" onclick="agregarNumero()" value="0" id="zero" type="button">0</button>
            <button id="decimal" value=".">.</button>
            <button id="equals" type="submit">=</button>
            <button type="button" onclick="borrarNumero()">BORRAR</button>
        </div>
    </div>
</form>

<script>
    const agregarNumero = () => {
        document.getElementById("entrada").value += event.target.innerHTML
    }

    const borrarNumero = () => {
        let entrada = document.getElementById("entrada")

        entrada.value = entrada.value.slice(0, -1)
    }
</script>
</body>
</html>
