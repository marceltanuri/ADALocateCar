package org.ada.aluguel.repository;

import org.ada.aluguel.models.Aluguel;
import org.ada.cliente.models.Cliente;
import org.ada.dataframework.CrudRepository;

import java.util.List;

public interface AluguelRepository extends CrudRepository<Aluguel, String> {

    Aluguel buscarAluguelPorCliente(Cliente cliente);

    List<Aluguel> buscarTodosAlugueis();

}
