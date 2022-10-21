package org.example.dao;

import org.example.model.Pedido;

import java.io.IOException;
import java.util.function.Predicate;

public class PedidoDao extends Dao<Pedido, String> {

    public PedidoDao() throws IOException {
        super(Pedido.class);
    }

    @Override
    protected Predicate<Pedido> mismoId(String id) {
        return pedido -> pedido.getId().equals(id);
    }

    @Override
    protected Predicate<Pedido> distintoId(String id) {
        return pedido -> !(pedido.getId().equals(id));
    }
}
