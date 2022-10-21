package org.example.controller;

public class CarritoController {
    private final ClienteController clienteController = new ClienteController();
    private final PedidoController pedidoController = new PedidoController();

    public Carrito getCarrito(String idCliente) {
        var cliente = clienteController.get(idCliente);
        return cliente.getCarrito();
    }

    public void agregarPedido(String idPedido, String idCliente) {
        var cliente = clienteController.getClienteById(idCliente);
        var carrito = cliente.getCarrito();
        var pedido = pedidoController.getPedido(idCliente, idPedido);
        carrito.agregar(pedido);
    }
}
