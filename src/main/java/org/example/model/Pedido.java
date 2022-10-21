package org.example.model;
import java.time.LocalDate;
import java.util.*;

public class Pedido {

	private Cliente cliente;
	private Collection<Producto> productos;
	private int id;
	private LocalDate fechaPedido;

	public Pedido() {
		cliente = new Cliente();
		productos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}
}