package org.example.dao;

import org.example.model.Producto;

import java.io.IOException;
import java.util.function.Predicate;

public class ProductoDao extends Dao<Producto, String> {

    public ProductoDao() throws IOException {
        super(Producto.class);
    }

    @Override
    protected Predicate<Producto> mismoId(String id) {
        return producto -> producto.getNombre().equals(id);
    }

    @Override
    protected Predicate<Producto> distintoId(String id) {
        return producto -> !producto.getNombre().equals(id);
    }
}
