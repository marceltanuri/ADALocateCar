package org.ada.devolucao.service;


import org.ada.aluguel.models.Aluguel;
import org.ada.cliente.models.Cliente;
import org.ada.devolucao.models.Devolucao;
import org.ada.devolucao.repository.DevolucaoRepository;
import org.ada.devolucao.validations.ValidadorDeDevolucao;

import java.util.List;

public class DevolucaoServiceImpl implements DevolucaoService {

    private DevolucaoRepository devolucaoRepository;

    private ValidadorDeDevolucao validadorDeDevolucao;

    public DevolucaoServiceImpl(DevolucaoRepository devolucaoRepository, ValidadorDeDevolucao validadorDeDevolucao) {
        this.devolucaoRepository = devolucaoRepository;
        this.validadorDeDevolucao = validadorDeDevolucao;
    }


    @Override
    public Devolucao realizarDevolucao(Aluguel aluguel, DevolucaoCreateService devolucaoCreateService) {
        return devolucaoCreateService.devolver(aluguel);
    }


    @Override
    public Devolucao salvarDevolucao(Devolucao devolucao) {
        validadorDeDevolucao.checarSeExiste(devolucao);
        return devolucaoRepository.inserir(devolucao);
    }
    @Override
    public Devolucao atualizarDevolucao(String uuid, Devolucao devolucao) {
        validadorDeDevolucao.checarSeNaoExiste(devolucao);
        return devolucaoRepository.alterar(uuid, devolucao);
    }

    @Override
    public Devolucao buscarDevolucaoPorId(String id) {
        Devolucao devolucao = devolucaoRepository.buscarTodasDevolucoes()
                .stream().filter(dev -> dev.getUuid().equalsIgnoreCase(id)).findFirst().orElse(null);
        validadorDeDevolucao.checarSeNaoExiste(devolucao);
        return devolucaoRepository.buscaPorId(id);
    }

    @Override
    public List<Devolucao> buscarDevolucaoPorCliente(Cliente cliente) {
        validadorDeDevolucao.checarSeNaoExiste(cliente);
        return devolucaoRepository.buscarTodasDevolucoesDoCliente(cliente);
    }

    @Override
    public List<Devolucao> buscarTodasDevolucoes() {
        return devolucaoRepository.buscarTodasDevolucoes();
    }

}
