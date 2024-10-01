package org.ada.veiculo.service;

import org.ada.veiculo.models.Veiculo;
import org.ada.veiculo.repository.VeiculoRepository;

import java.util.List;

public abstract class VeiculoService {
    protected final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo inserir(Veiculo veiculo) {
        return veiculoRepository.inserir(veiculo);
    }

    public Veiculo alterar(String uuid, Veiculo veiculo) {
        return veiculoRepository.alterar(uuid, veiculo);
    }

    public Veiculo buscaPorId(String id){ return veiculoRepository.buscaPorId(id); }

    public Veiculo deletar(String id) {
        return veiculoRepository.deletar(id);
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculoRepository.buscarVeiculoPorPlaca(placa);
    }

    public List<Veiculo> buscarTodosVeiculos() {
        return veiculoRepository.buscarTodosVeiculos();
    }
}
