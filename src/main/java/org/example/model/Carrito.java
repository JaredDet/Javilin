package org.example.model;
import java.util.*;

public class Carrito {

	private Collection<Pedido> pedidos;

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void agregar(Pedido pedido) {
		pedidos.add(pedido);
	}

	public void sacar(Pedido pedido) {
		pedidos.remove(pedido);
	}
}