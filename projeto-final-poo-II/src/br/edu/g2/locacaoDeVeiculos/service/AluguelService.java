package br.edu.g2.locacaoDeVeiculos.service;

import br.edu.g2.locacaoDeVeiculos.model.agencia.Agencia;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Aluguel;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

import java.time.LocalDate;

public interface AluguelService {
    Aluguel alugar(Cliente cliente, Veiculo veiculo, Agencia agencia);
    Aluguel alugar(Cliente cliente, Veiculo veiculo, Agencia agencia, LocalDate data);

    default boolean isVeiculoDisponivel(Veiculo veiculo){
        return veiculo.isDisponivel();
    }
}
