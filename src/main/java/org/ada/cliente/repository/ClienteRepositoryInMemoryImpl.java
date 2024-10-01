package org.ada.cliente.repository;

import org.ada.cliente.models.Cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteRepositoryInMemoryImpl implements ClienteRepository{

    private final Map<String, Cliente> clienteDatabase = new HashMap<>();
    @Override
    public Cliente inserir(Cliente cliente) {
        clienteDatabase.put(cliente.getUuid(),cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(String uuid, Cliente cliente) {
        return clienteDatabase.replace(uuid,cliente);
    }

    @Override
    public Cliente buscaPorId(String id) {
        return clienteDatabase.get(id);
    }

    @Override
    public Cliente deletar(String id) {
        return clienteDatabase.remove(id);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return clienteDatabase.values().stream().toList();
    }

}
