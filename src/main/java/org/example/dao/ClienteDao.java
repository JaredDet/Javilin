package org.example.dao;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.model.Cliente;

import java.io.IOException;

public class ClienteDao extends Dao<Cliente, String> {

    public ClienteDao() throws IOException {
        super(Cliente.class);
    }

    @Override
    public Cliente get(String nombre) {
        return lector.parse()
                .stream()
                .filter(cliente -> cliente.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @Override
    public void eliminar(String nombre) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        var clientes = lector.parse()
                .stream()
                .filter(cliente -> !cliente.getNombre().equals(nombre));

        eliminarTodos();
        escritor.write(clientes);
    }
}
