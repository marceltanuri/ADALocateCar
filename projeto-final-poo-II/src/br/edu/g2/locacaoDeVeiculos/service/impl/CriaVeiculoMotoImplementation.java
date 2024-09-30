package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.model.veiculo.TipoVeiculo;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

public class CriaVeiculoMotoImplementation extends VeiculoServiceImplementation {

    @Override
    public Veiculo criar(TipoVeiculo tipoVeiculo, String placa, String modelo) {
        Veiculo veiculoBase = new Veiculo(placa, 100, true, tipoVeiculo, modelo);
        return veiculoBase;
    }
}
