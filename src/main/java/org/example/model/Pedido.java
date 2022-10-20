package org.example.model;
import java.time.LocalDate;
import java.util.*;

public class Pedido {

	Cliente cliente;
	Collection<Producto> productos;
	private int id;
	private LocalDate fechaPedido;

}