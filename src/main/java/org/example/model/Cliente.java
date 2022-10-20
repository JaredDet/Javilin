package org.example.model;

import java.util.*;

public class Cliente {

    private Carrito carrito;
    private Collection<Pedido> pedidos;
    private String nombre;
    private String contrasenia;
    private double creditos;

    public Cliente() {
        carrito = new Carrito();
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

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void pagar(Pago pago) {
		//TODO bla bla bla
    }
}