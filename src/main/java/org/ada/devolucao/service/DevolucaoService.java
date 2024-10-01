package org.ada.devolucao.service;


import org.ada.aluguel.models.Aluguel;
import org.ada.cliente.models.Cliente;
import org.ada.devolucao.models.Devolucao;

import java.util.List;

public interface DevolucaoService {


    Devolucao realizarDevolucao(Aluguel aluguel, DevolucaoCreateService devolucaoCreateService);

    Devolucao salvarDevolucao(Devolucao devolucao);

    Devolucao atualizarDevolucao(String uuid, Devolucao devolucao);

    Devolucao buscarDevolucaoPorId(String id);

    List<Devolucao> buscarDevolucaoPorCliente(Cliente cliente);

    List<Devolucao> buscarTodasDevolucoes();
}
