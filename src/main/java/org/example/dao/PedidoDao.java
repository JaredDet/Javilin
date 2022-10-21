package org.example.dao;

import org.example.model.Pedido;

import java.io.IOException;
import java.util.function.Predicate;

public class PedidoDao extends Dao<Pedido, Integer> {

    public PedidoDao() throws IOException {
        super(Pedido.class);
    }

    @Override
    protected Predicate<Pedido> mismoId(Integer id) {
        return pedido -> pedido.getId() == id;
    }

    @Override
    protected Predicate<Pedido> distintoId(Integer id) {
        return pedido -> !(pedido.getId() == id);
    }
}
