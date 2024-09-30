package br.edu.g2.locacaoDeVeiculos.repository.impl;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepositoryExeption;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryInMemoryImpl implements ClienteRepository {

        private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> getClientes() {
        return clientes; // Retorna a lista de clientes
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        if(verificacaoCliente(cliente.getDocumento())){
            throw new CrudRepositoryExeption("Cliente já registrado");
        }  clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(Cliente cliente) {

        int indiceCliente = encontrarClientePorId(cliente.getUuid());
        if(indiceCliente != -1) {
            clientes.set(indiceCliente, cliente);
            return cliente;
        }
        throw new CrudRepositoryExeption("Cliente não encontrado para atualização.");
    }


    @Override
    public Cliente deletar(Cliente cliente) {
        if(clientes.remove(cliente)) {
            return cliente;
                    }
        throw new CrudRepositoryExeption("Cliente não encontrado para atualização.");

    }

    @Override
    public Cliente buscaPorId(String id) {
        for(Cliente cliente : clientes){
            if(cliente.getUuid().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        throw new CrudRepositoryExeption("Cliente não encontrado para atualização.");
    }

    public Cliente buscaPordoc(String doc) {
        for(Cliente cliente : clientes){
            if(cliente.getDocumento().equalsIgnoreCase(doc)) {
                return cliente;
            }
        }
        throw new CrudRepositoryExeption("Cliente não encontrado para atualização.");
    }

    @Override
    public Cliente deletarPorId(String id) {
        Cliente clienteEncontrado= buscaPorId(id);

        if(clientes.remove(clienteEncontrado)) {
            return clienteEncontrado;
        }
        throw new CrudRepositoryExeption("Cliente não encontrado para atualização.");
    }


    private int encontrarClientePorId(String id) {
    for(int i = 0; i < clientes.size(); i++){
        if(clientes.get(i).getUuid().equalsIgnoreCase(id)){
            return i;
        }
    }return -1;

    }

    private boolean verificacaoCliente(String documento) {
        for (Cliente cliente : clientes){
            if(cliente.getDocumento().equalsIgnoreCase(documento)) {
                throw new CrudRepositoryExeption("Cliente já registrado.");
            }
        }
        return false;
    }
}
