package org.ada.cliente.validations;

import org.ada.cliente.models.Cliente;
import org.ada.cliente.repository.ClienteRepository;
import org.ada.cliente.validations.exception.ClienteInvalidoException;

import java.util.List;

public class ValidadorDeCliente {

    ClienteRepository clienteRepository;

    public ValidadorDeCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void isClienteExistente(String documento) {
        List<Cliente> listaDeClientes = clienteRepository.buscarTodosClientes();
        if (listaDeClientes.stream().anyMatch(cliente -> cliente.getDocumento().equalsIgnoreCase(documento))){
            throw new ClienteInvalidoException("Cliente ja existe");
        }
    }

    public void clienteInexistenteNoBD(String documento) {
        List<Cliente> listaDeClientes = clienteRepository.buscarTodosClientes();
        if (listaDeClientes.stream().noneMatch(cliente -> cliente.getDocumento().equalsIgnoreCase(documento))) {
            throw new ClienteInvalidoException("Cliente inexistente");
        }
    }

    public void idClienteInexistenteNoBD(String id) {
        List<Cliente> listaDeClientes = clienteRepository.buscarTodosClientes();
        if (listaDeClientes.stream().noneMatch(cliente -> cliente.getUuid().equalsIgnoreCase(id))) {
            throw new ClienteInvalidoException("Cliente inexistente");
        }
    }

    public void documentoInvalido(String documento) {
        if (documento.equals("") || documento == null) {
            throw new ClienteInvalidoException("Documento invalido");
        }
    }
}
