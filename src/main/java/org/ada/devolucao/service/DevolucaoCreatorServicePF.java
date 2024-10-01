package org.ada.devolucao.service;

import org.ada.aluguel.models.Aluguel;
import org.ada.devolucao.models.Devolucao;

public class DevolucaoCreatorServicePF implements DevolucaoCreateService {

    private static final Double DESCONTO = 0.05;
    private static final Integer DIAS_PARA_DESCONTO = 5;

    private static final Double TAXA_DESLOCAMENTO = 0.1;
    @Override
    public Devolucao devolver(Aluguel aluguel) {
        Double desconto = calcularDesconto(aluguel);
        Double taxaDeslocamento = calcularTaxaDeslocamento(aluguel);
        return new Devolucao(aluguel,desconto,taxaDeslocamento);
    }

    private Double calcularDesconto(Aluguel aluguel) {
        if (aluguel.getTempoLocacaoEmDias() >= DIAS_PARA_DESCONTO) {
            return DESCONTO;
        }
        return 0d;
    }

    private Double calcularTaxaDeslocamento(Aluguel aluguel) {
        if (aluguel.isMesmoLocalDeDevolucao()) return 0d;
        return TAXA_DESLOCAMENTO;
    }

}
