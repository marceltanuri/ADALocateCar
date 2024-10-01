package org.ada.veiculo.repository;

import org.ada.veiculo.models.Veiculo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class VeiculoRepositoryInMemoryImpl implements VeiculoRepository {
    private final Map<String, Veiculo> veiculosDatabase = new HashMap<>();

    @Override
    public Veiculo inserir(Veiculo veiculo) {
        veiculosDatabase.put(veiculo.getUuid(), veiculo);
        return veiculo;
    }

    @Override
    public Veiculo alterar(String uuid, Veiculo veiculo) {
        veiculosDatabase.put(uuid, veiculo);
        return veiculo;
    }

    @Override
    public Veiculo buscaPorId(String id) {
        return veiculosDatabase.get(id);
    }

    @Override
    public Veiculo deletar(String id) {
        return veiculosDatabase.remove(id);
    }

    @Override
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculosDatabase.values().stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos() {
        return veiculosDatabase.values().stream().toList();
    }
}
