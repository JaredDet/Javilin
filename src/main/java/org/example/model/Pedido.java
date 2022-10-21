package org.example.model;

import org.example.dao.ClienteDao;
import org.example.dao.PedidoDao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Pedido {

    private Cliente cliente;
    private List<Producto> productos;
    private String id;
    private LocalDate fechaPedido;

    public Pedido() {
        cliente = new Cliente();
        productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCliente(String idCliente) throws IOException {

        var optionalCliente = Cliente.getInstancia(idCliente);
        var clienteDao = new ClienteDao();

        optionalCliente.ifPresentOrElse(this::setCliente,
                () -> setCliente(clienteDao.get(idCliente)));
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}