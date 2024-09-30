package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.service.DevolucaoServiceBase;

public class DevolucaoServicePJImplementation extends DevolucaoServiceBase {

    @Override
    public double calcularDescontoCliente(long diasAlugado) {

        return diasAlugado > 3L ? 0.1 : 0.0;
    }
}
