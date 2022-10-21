package org.example.model;

import org.example.dao.PedidoDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Cliente {

    private String clienteId;

    private String nombre;
    private String contrasenia;
    private double creditos;
    private final List<Pedido> pedidos;

    private static final List<Cliente> instancias = new ArrayList<>();

    public Cliente() {
        pedidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setPedidos(String ids) throws IOException {
        var lista = ids.split(";");
        var pedidoDao = new PedidoDao();
        var listaPedidos = Arrays.stream(lista)
                .map(pedidoDao::get).toList();
        pedidos.addAll(listaPedidos);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void quitarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public void setClienteId(String id){
        clienteId = id;
    }

    public void pagar(Pago pago) {
        //TODO bla bla bla
    }

    public static void setCliente(Cliente cliente){
        instancias.add(cliente);
    }

    public static Optional<Cliente> getInstancia(String id){
        return instancias.stream().filter(cliente -> cliente.clienteId.equals(id))
                .findFirst();
    }
}