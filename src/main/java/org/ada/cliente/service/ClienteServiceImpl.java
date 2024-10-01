package org.ada.cliente.service;

import org.ada.cliente.models.Cliente;
import org.ada.cliente.repository.ClienteRepository;
import org.ada.cliente.validations.ValidadorDeCliente;

public class ClienteServiceImpl extends ClienteService {

    private final ValidadorDeCliente validadorDeCliente = new ValidadorDeCliente(clienteRepository);

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        super(clienteRepository);
    }

    @Override
    public Cliente inserir(Cliente cliente) {
//        try {
            validadorDeCliente.isClienteExistente(cliente.getDocumento());
            validadorDeCliente.documentoInvalido(cliente.getDocumento());
//        } catch (ClienteInvalidoException e) {
//            return null;
//        }
        return super.inserir(cliente);
    }

    @Override
    public Cliente alterar(String uuid, Cliente cliente){
        Cliente clienteExistente = buscaPorId(uuid);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setDocumento(cliente.getDocumento());
        clienteExistente.setTipoCliente(cliente.getTipoCliente());
        validadorDeCliente.clienteInexistenteNoBD(buscaPorId(uuid).getDocumento());
        validadorDeCliente.documentoInvalido(clienteExistente.getDocumento());
        return super.alterar(uuid, clienteExistente);
    }

    @Override
    public Cliente deletar(String id) {
        validadorDeCliente.idClienteInexistenteNoBD(id);
        return super.deletar(id);
    }

    @Override
    public Cliente buscaPorId(String uuid) {
        validadorDeCliente.idClienteInexistenteNoBD(uuid);
        return super.buscaPorId(uuid);
    }

}
