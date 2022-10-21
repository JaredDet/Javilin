package org.example.dao;

import org.example.model.Cliente;

import java.io.IOException;
import java.util.function.Predicate;

public class ClienteDao extends Dao<Cliente, String> {


    public ClienteDao() throws IOException {
        super(Cliente.class);
    }

    @Override
    protected Predicate<Cliente> mismoId(String id) {
        return cliente -> cliente.getNombre().equals(id);
    }

    @Override
    protected Predicate<Cliente> distintoId(String id) {
        return cliente -> !cliente.getNombre().equals(id);
    }
}
