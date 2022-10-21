package org.example.controller;

import org.example.dao.ClienteDao;
import org.example.model.Cliente;

import java.util.List;

public class ClienteController {

    private final ClienteDao dao = new ClienteDao();

    public List<Cliente> getClientes() {
        return dao.getTodos();
    }

    public Cliente getClienteById(String id) {
        return dao.get(id);
    }

    public String pagar(int idCliente) {
        //Utiliza la función de pago de la clase Pago y retorna la boleta
        return "nueva boleta";
    }

}
