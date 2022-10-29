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
<form class="calculator" method="post" >
    <div class="display">
        <div id="display">
            !{var placeholder = calculadora.operacion() == Operacion.NINGUNA ? "0" : calculadora.calcular();}
            <input type="text" id="entrada" name="entrada" placeholder="${placeholder}" readonly>
            <input type="text" id="cache" name="cache" hidden readonly>
            <input type="text" id="operacion" name="operacion" hidden readonly>
        </div>
    </div>
    <div class="keys">
        <div class="row-1">
            <input type="button" id="clear" class="top" value="AC" onclick="borrarTodo()">
            <input type="button" class="top" id="negative" value="+/-" onclick="invertirSigno()">
            <input type="button" class="top" id="percent" value="%">
            <input type="button" class="operator" value="/">
        </div>
        <div class="row-2">
            <input type="button" class="number" value="7" onclick="agregarNumero()">
            <input type="button" class="number" value="8" onclick="agregarNumero()">
            <input type="button" class="number" value="9" onclick="agregarNumero()">
            <input type="button" class="operator" value="*">
        </div>
        <div class="row-3">
            <input type="button" class="number" value="4" onclick="agregarNumero()">
            <input type="button" class="number" value="5" onclick="agregarNumero()">
            <input type="button" class="number" value="6" onclick="agregarNumero()">
            <input type="button" class="operator" value="-">
        </div>
        <div class="row-4">
            <input type="button" class="number" value="1" onclick="agregarNumero()">
            <input type="button" class="number" value="2" onclick="agregarNumero()">
            <input type="button" class="number" value="3" onclick="agregarNumero()">
            <input type="button" class="operator" value="+">
        </div>
        <div class="row-5">
            <input type="button" class="number" value="0" onclick="agregarNumero()" id="zero">
            <input type="button" id="decimal" value=".">.
            <input type="submit" id="equals" value="=">
            <input type="button" value="BORRAR" onclick="borrarNumero()">
        </div>
    </div>
</form>

<script>
    let entrada = document.getElementById("entrada");

    const agregarNumero = () => {
        let numero = event.target.value;

        if (entrada.value === "0") {
            entrada.value = numero;
        } else {
            entrada.value += numero;
        }
    }

    const borrarNumero = () => {
        if (entrada.value.length <= 1) {
            entrada.value = "0";
        } else {
            entrada.value = entrada.value.slice(0, -1);
        }
    }

    const borrarTodo = () => {
       entrada.value = "";
    }

    const invertirSigno = () => {
        if (entrada.value.startsWith("-")) {
            entrada.value = entrada.value.slice(1);
        } else {
            entrada.value = "-" + entrada.value;
        }
    }

</script>
</body>
</html>
