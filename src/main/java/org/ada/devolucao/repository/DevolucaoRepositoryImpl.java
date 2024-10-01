package org.ada.devolucao.repository;

import org.ada.cliente.models.Cliente;
import org.ada.devolucao.models.Devolucao;
import org.ada.devolucao.service.DevolucaoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevolucaoRepositoryImpl implements DevolucaoRepository {

    private Map<String, Devolucao> devolucaoDatabase = new HashMap<>();

    @Override
    public Devolucao inserir(Devolucao devolucao) {
        devolucaoDatabase.put(devolucao.getUuid(),devolucao);
        return devolucao;
    }

    @Override
    public Devolucao alterar(String uuid, Devolucao devolucao) {
        return devolucaoDatabase.replace(uuid, devolucao);
    }

    @Override
    public Devolucao deletar(String id) {
        return devolucaoDatabase.remove(id);
    }

    @Override
    public Devolucao buscaPorId(String id) {
        return devolucaoDatabase.get(id);
    }

    @Override
    public List<Devolucao> buscarTodasDevolucoesDoCliente(Cliente cliente) {
        return devolucaoDatabase.values().stream().filter(devolucao -> devolucao.getAluguel().getCliente().equals(cliente)).toList();
    }

    @Override
    public List<Devolucao> buscarTodasDevolucoes() {
        return devolucaoDatabase.values().stream().toList();
    }
}
