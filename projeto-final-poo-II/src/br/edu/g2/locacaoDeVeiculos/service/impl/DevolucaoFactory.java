package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.model.cliente.TipoCliente;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Aluguel;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Devolucao;

public class DevolucaoFactory {
    public Devolucao devolverVeiculo(Aluguel aluguel){

        if(aluguel.getCliente().getTipoCliente().equals(TipoCliente.PESSOA_FISICA)){
            aluguel.getVeiculo().mudarDisponibilidade();
            return new DevolucaoServicePFImplementation().realizarDevolucao(aluguel);

        } else if (aluguel.getCliente().getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA)) {
            aluguel.getVeiculo().mudarDisponibilidade();
            return new DevolucaoServicePJImplementation().realizarDevolucao(aluguel);

        }else{
            throw new IllegalArgumentException("O tipo do cliente não é válido");
        }
    }
}
