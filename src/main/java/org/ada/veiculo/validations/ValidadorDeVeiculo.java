package org.ada.veiculo.validations;

import org.ada.veiculo.models.Veiculo;
import org.ada.veiculo.repository.VeiculoRepository;
import org.ada.veiculo.validations.exceptions.VeiculoInvalidoException;

import java.util.List;

public class ValidadorDeVeiculo {

    private final VeiculoRepository veiculoRepository;

    public ValidadorDeVeiculo(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public void checarSeExiste(Veiculo veiculo) {
        List<Veiculo> listaDeVeiculos = this.veiculoRepository.buscarTodosVeiculos();
        if (listaDeVeiculos.contains(veiculo)) {
            throw new VeiculoInvalidoException("Veiculo ja existe");
        }
    }

    public void checarSeNaoExiste(Veiculo veiculo) {
        List<Veiculo> listaDeVeiculos = this.veiculoRepository.buscarTodosVeiculos();
        if (!listaDeVeiculos.contains(veiculo)) {
            throw new VeiculoInvalidoException("Veiculo inexistente");
        }
    }

    public void checarPlaca(String placa) {
        if (placa.equals("") || placa == null) {
            throw new VeiculoInvalidoException("Placa invalida");
        }
    }
}
