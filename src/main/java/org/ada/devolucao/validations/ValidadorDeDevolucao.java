package org.ada.devolucao.validations;

import org.ada.cliente.models.Cliente;
import org.ada.devolucao.models.Devolucao;
import org.ada.devolucao.repository.DevolucaoRepository;
import org.ada.devolucao.validations.exceptions.DevolucaoInvalidaException;

import java.util.List;

public class ValidadorDeDevolucao {

    private final DevolucaoRepository devolucaoRepository;

    public ValidadorDeDevolucao(DevolucaoRepository devolucaoRepository) {
        this.devolucaoRepository = devolucaoRepository;
    }

    public void checarSeExiste(Devolucao devolucao) {
        List<Devolucao> listaDeDevolucoes = devolucaoRepository.buscarTodasDevolucoes();
        if (listaDeDevolucoes.contains(devolucao)) {
            throw new DevolucaoInvalidaException("Devolucao ja realizada");
        }
    }

    public void checarSeNaoExiste(Devolucao devolucao) {
        List<Devolucao> listaDeDevolucoes = devolucaoRepository.buscarTodasDevolucoes();
        if (!listaDeDevolucoes.contains(devolucao) || devolucao == null) {
            throw new DevolucaoInvalidaException("Devolucao nao realizada");
        }
    }

    public void checarSeNaoExiste(Cliente cliente) {
        List<Devolucao> listaDeDevolucoesDoCliente = devolucaoRepository.buscarTodasDevolucoes()
                .stream().filter(devolucao -> devolucao.getAluguel().getCliente().equals(cliente)).toList();
        if (listaDeDevolucoesDoCliente.isEmpty()) {
            throw new DevolucaoInvalidaException("Cliente nao realizou devolucoes");
        }
    }

}
