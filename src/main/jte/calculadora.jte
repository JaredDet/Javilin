@import org.example.model.Calculadora
@import org.example.model.Operacion

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
<div class="calculator">
    <div class="display">
        <div id="display">
            <input type="text" id="entrada" name="entrada" value = ${Calculadora.getCache()} required readonly>
        </div>
    </div>
    <div class="keys">
        <div class="row-1">
            <button id="clear" class="top">AC</button>
            <button class="top" id="negative"><sup>+</sup>/-</button>
            <button class="top" id="percent">%</button>
            <button class="operator" value="/">&#247;</button>
        </div>
        <div class="row-2">
            <button class="number" onClick="agregarNumero()" value="7">7</button>
            <button class="number" onClick="agregarNumero()" value="8">8</button>
            <button class="number" onClick="agregarNumero()" value="9">9</button>
            <button class="operator" value="*">&times;</button>
        </div>
        <div class="row-3">
            <button class="number" onClick="agregarNumero()" value="4">4</button>
            <button class="number" onClick="agregarNumero()" value="5">5</button>
            <button class="number" onClick="agregarNumero()" value="6">6</button>
            <button class="operator" value="-">-</button>
        </div>
        <div class="row-4">
            <button class="number" onClick="agregarNumero()" value="1">1</button>
            <button class="number" onClick="agregarNumero()" value="2">2</button>
            <button class="number" onClick="agregarNumero()" value="3">3</button>
            <button class="operator" value="+">+</button>
        </div>
        <div class="row-5">
            <button class="number" onClick="agregarNumero()" value="0" id="zero">0</button>
            <button id="decimal" value=".">.</button>
            <button id="equals">=</button>
        </div>
    </div>
</div>
</body>
</html>
