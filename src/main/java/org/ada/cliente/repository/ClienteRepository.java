package org.ada.cliente.repository;

import org.ada.cliente.models.Cliente;
import org.ada.dataframework.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

    List<Cliente> buscarTodosClientes();

}
