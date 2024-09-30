package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.service.DevolucaoServiceBase;


public class DevolucaoServicePFImplementation extends DevolucaoServiceBase {

    @Override
    public double calcularDescontoCliente(long diasAlugado) {

        return diasAlugado > 5L ? 0.05 : 0.0;
    }
}
