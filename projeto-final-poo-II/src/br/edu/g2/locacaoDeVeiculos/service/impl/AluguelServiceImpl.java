package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.model.agencia.Agencia;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Aluguel;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;
import br.edu.g2.locacaoDeVeiculos.service.AluguelService;

import java.time.LocalDate;

public class AluguelServiceImpl implements AluguelService {


    @Override
    public Aluguel alugar(Cliente cliente, Veiculo veiculo, Agencia agencia) {

        if(isVeiculoDisponivel(veiculo)){
            return this.alugar(cliente, veiculo, agencia, LocalDate.now());
        }else{
            throw new IllegalArgumentException("O veiculo não está disponível");
        }
    }

    @Override
    public Aluguel alugar(Cliente cliente, Veiculo veiculo, Agencia agencia, LocalDate data) {

        if(isVeiculoDisponivel(veiculo)){
            veiculo.mudarDisponibilidade();
            return new Aluguel(cliente, veiculo, agencia, data);
        }else{
            throw new IllegalArgumentException("O veiculo não está disponível");
        }
    }
}
