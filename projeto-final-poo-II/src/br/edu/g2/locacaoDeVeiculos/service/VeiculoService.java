package br.edu.g2.locacaoDeVeiculos.service;

import br.edu.g2.locacaoDeVeiculos.model.veiculo.TipoVeiculo;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

public interface VeiculoService {
    Veiculo criar(TipoVeiculo tipoVeiculo, String placa, String modelo);
    Veiculo atualizar(Veiculo veiculo);
    //void apagar(Veiculo veiculo);
}
