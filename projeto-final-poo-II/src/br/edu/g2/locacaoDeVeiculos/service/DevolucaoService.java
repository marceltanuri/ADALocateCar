package br.edu.g2.locacaoDeVeiculos.service;

import br.edu.g2.locacaoDeVeiculos.model.cobranca.Aluguel;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Devolucao;

public interface DevolucaoService {
    Devolucao realizarDevolucao(Aluguel aluguel);
}
