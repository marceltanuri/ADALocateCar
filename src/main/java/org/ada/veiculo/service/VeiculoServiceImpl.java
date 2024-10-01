package org.ada.veiculo.service;

import org.ada.veiculo.models.Veiculo;
import org.ada.veiculo.repository.VeiculoRepository;

import java.util.List;

public class VeiculoServiceImpl extends VeiculoService {
    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        super(veiculoRepository);
    }

    @Override
    public Veiculo inserir(Veiculo veiculo) {
        //logica
        return super.inserir(veiculo);
    }

    @Override
    public Veiculo alterar(String uuid, Veiculo veiculo) {
        //logica
        return super.alterar(uuid, veiculo);
    }

    @Override
    public Veiculo buscaPorId(String id){
        return super.buscaPorId(id);
    }

    @Override
    public Veiculo deletar(String id) {
        //logica
        return super.deletar(id);
    }

    @Override
    public Veiculo buscarVeiculo(String placa) {
        //logica
        return super.buscarVeiculo(placa);
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos() {
        return super.buscarTodosVeiculos();
    }
}
