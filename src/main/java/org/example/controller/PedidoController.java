package org.example.controller;

import org.example.model.Pedido;

import java.util.List;

public class PedidoController {

    public Pedido getPedido(String idCliente, String idPedido) {
        var pedidos = new PedidoController().getPedidos(idCliente);
        return pedidos.stream()
                .filter(pedido -> pedido.getId().equals(idPedido))
                .findFirst().orElse(null);
    }

    private List<Pedido> getPedidos(String idCliente) {
        var cliente = new ClienteController().getClienteById(idCliente);
        return cliente.getPedidos();
    }
}
