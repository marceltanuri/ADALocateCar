package org.ada.cliente.service;

import org.ada.cliente.models.Cliente;
import org.ada.cliente.repository.ClienteRepository;

import java.util.List;

public abstract class ClienteService {

    protected final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente inserir(Cliente cliente) {
       return clienteRepository.inserir(cliente);
    }

    public Cliente alterar(String uuid, Cliente cliente) {
        return clienteRepository.alterar(uuid, cliente);
    }

    public Cliente deletar(String id) {
        return clienteRepository.deletar(id);
    }

    public Cliente buscaPorId(String uuid) {
        return clienteRepository.buscaPorId(uuid);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.buscarTodosClientes();
    }

}

