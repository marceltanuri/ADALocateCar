package org.ada.devolucao.repository;

import org.ada.cliente.models.Cliente;
import org.ada.dataframework.CrudRepository;
import org.ada.devolucao.models.Devolucao;

import java.util.List;

public interface DevolucaoRepository extends CrudRepository<Devolucao, String> {

    List<Devolucao> buscarTodasDevolucoesDoCliente(Cliente cliente);

    List<Devolucao> buscarTodasDevolucoes();

}
