package org.ada.aluguel.service;

import org.ada.agencia.models.Agencia;
import org.ada.aluguel.models.Aluguel;
import org.ada.aluguel.repository.AluguelRepository;
import org.ada.aluguel.repository.AluguelRepositoryImpl;
import org.ada.aluguel.validations.ValidadorDeAluguel;
import org.ada.cliente.models.Cliente;
import org.ada.veiculo.models.Veiculo;

public class AluguelServiceImpl extends AluguelService {

    ValidadorDeAluguel validadorDeAluguel;

    public AluguelServiceImpl(AluguelRepository aluguelRepository, ValidadorDeAluguel validadorDeAluguel) {
        super(aluguelRepository);
        this.validadorDeAluguel = validadorDeAluguel;
    }

    @Override
    public Aluguel inserirAluguel(Aluguel aluguel) {
        validadorDeAluguel.checarSeExiste(aluguel);
        validadorDeAluguel.checarSeClienteJaAluga(aluguel);
        validadorDeAluguel.checarSeVeiculoExisteNaAguencia(aluguel.getAgenciaDeRetirada(),aluguel.getVeiculo());
        aluguel.getVeiculo().setDisponivel(false);
        return super.inserirAluguel(aluguel);
    }

    @Override
    public Aluguel buscarAluguelPorCliente(Cliente cliente) {
        Aluguel aluguelDoCliente = aluguelRepository.buscarAluguelPorCliente(cliente);
        validadorDeAluguel.checarSeNaoExiste(aluguelDoCliente);
        return super.buscarAluguelPorCliente(cliente);
    }

    @Override
    public Aluguel alterarAluguel(String uuid, Aluguel aluguel) {
        Aluguel aluguelExistente = buscaPorId(uuid);
        aluguelExistente.setCliente(aluguel.getCliente());
        aluguelExistente.setVeiculo(aluguel.getVeiculo());
        aluguelExistente.setTempoLocacaoEmDias(aluguel.getTempoLocacaoEmDias());
        aluguelExistente.setAgenciaDeRetirada(aluguel.getAgenciaDeRetirada());
        validadorDeAluguel.checarSeNaoExiste(aluguelExistente);
        return super.alterarAluguel(uuid, aluguelExistente);
    }

}
