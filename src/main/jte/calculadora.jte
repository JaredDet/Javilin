@import org.example.model.Calculadora
@import org.example.model.Operacion
@param Calculadora calculadora
@param boolean esPrimeraOperacion

!{var input = calculadora.operacion() == Operacion.NINGUNA ? "0" : calculadora.calcular();}

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
<form class="calculator">
    <div class="display">
        <div id="display">
            <input type="text" id="cache" name="cache" hidden readonly>
            <input type="text" id="operacion" name="operacion" hidden readonly>
            <input type="text" id="input" name="input" value="${input}" readonly>
            <input type="text" id="esPrimeraOperacion" name="esPrimeraOperacion" value="${esPrimeraOperacion}" hidden
                   readonly>
        </div>
    </div>
    <div class="keys">
        <div class="row-1">
            <input type="submit" id="clear" class="top" value="AC" onclick="borrarTodo()">
            <input type="button" class="top" id="negative" value="+/-" onclick="invertirSigno()">
            <input type="submit" class="top" id="${Operacion.PORCENTAJE.name()}" onclick="agregarOperacion()" value="%">
            <input type="submit" class="operator" id="${Operacion.DIVISION.name()}" onclick="agregarOperacion()"
                   value="/">
        </div>
        <div class="row-2">
            <input type="button" class="number" value="7" onclick="agregarNumero()">
            <input type="button" class="number" value="8" onclick="agregarNumero()">
            <input type="button" class="number" value="9" onclick="agregarNumero()">
            <input type="submit" class="operator" id="${Operacion.MULTIPLICACION.name()}" onclick="agregarOperacion()"
                   value="*">
        </div>
        <div class="row-3">
            <input type="button" class="number" value="4" onclick="agregarNumero()">
            <input type="button" class="number" value="5" onclick="agregarNumero()">
            <input type="button" class="number" value="6" onclick="agregarNumero()">
            <input type="submit" class="operator" id="${Operacion.RESTA.name()}" onclick="agregarOperacion()" value="-">
        </div>
        <div class="row-4">
            <input type="button" class="number" value="1" onclick="agregarNumero()">
            <input type="button" class="number" value="2" onclick="agregarNumero()">
            <input type="button" class="number" value="3" onclick="agregarNumero()">
            <input type="submit" class="operator" id="${Operacion.SUMA.name()}" onclick="agregarOperacion()" value="+">
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
    let entrada = document.getElementById("input");
    let operacion = document.getElementById("operacion");
    let cache = document.getElementById("cache");
    let esPrimeraOperacion = document.getElementById("esPrimeraOperacion");

    const agregarNumero = () => {
        let numero = event.target.value;

        if (operacion.value !== "${Operacion.NINGUNA.name()}") {
            entrada.value = numero;
            return;
        }

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
        operacion.value = null;
    }

    const invertirSigno = () => {

        if (entrada.value === "0") return;

        if (entrada.value.startsWith("-")) {
            entrada.value = entrada.value.slice(1);
        } else {
            entrada.value = "-" + entrada.value;
        }
    }

    const agregarOperacion = () => {

        if (esPrimeraOperacion.value) {
            event.preventDefault();
            cache.value = entrada.value;
        }
        operacion.value = event.target.id;
        entrada.value = "0";
    }

</script>
</body>
</html>
