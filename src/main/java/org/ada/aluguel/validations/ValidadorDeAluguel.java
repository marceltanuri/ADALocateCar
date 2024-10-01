package org.ada.aluguel.validations;

import org.ada.agencia.models.Agencia;
import org.ada.aluguel.models.Aluguel;
import org.ada.aluguel.repository.AluguelRepository;
import org.ada.aluguel.validations.exceptions.AluguelInvalidoException;
import org.ada.veiculo.models.Veiculo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ValidadorDeAluguel {

    private final AluguelRepository aluguelRepository;

    public ValidadorDeAluguel(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public void checarSeExiste(Aluguel aluguel) {
        List<Aluguel> todosAlugueis = aluguelRepository.buscarTodosAlugueis();
        if (todosAlugueis.contains(aluguel)) {
            throw new AluguelInvalidoException("Aluguel ja existe");
        }
    }

    public void checarSeNaoExiste(Aluguel aluguel) {
        List<Aluguel> todosAlugueis = aluguelRepository.buscarTodosAlugueis();
        if (!todosAlugueis.contains(aluguel)) {
            throw new AluguelInvalidoException("Aluguel não existe");
        }
    }

    public void checarSeClienteJaAluga(Aluguel aluguel) {
        List<Aluguel> todosAlugueis = aluguelRepository.buscarTodosAlugueis();
        boolean clienteJaPossuiAluguelAtivo = todosAlugueis.stream()
                .anyMatch(aluguelExistente -> aluguelExistente.getCliente().equals(aluguel.getCliente()) && aluguelAindaAtivo(aluguelExistente));
        if (clienteJaPossuiAluguelAtivo) {
            throw new AluguelInvalidoException("Cliente já possui aluguel ativo.");
        }
    }


    public void checarSeVeiculoExisteNaAguencia(Agencia agencia, Veiculo veiculo) {
        List<Veiculo> veiculosDaAgencia = agencia.getListaDeVeiculos();
        if (!veiculosDaAgencia.contains(veiculo)) {
            throw new AluguelInvalidoException("Agencia nao possui este veiculo");
        }
    }
    private boolean aluguelAindaAtivo(Aluguel aluguel) {
        LocalDateTime dataPrevistaDevolucao = aluguel.getDataAluguel().plusDays(aluguel.getTempoLocacaoEmDias());
        return LocalDateTime.now().isBefore(dataPrevistaDevolucao);
    }
}
