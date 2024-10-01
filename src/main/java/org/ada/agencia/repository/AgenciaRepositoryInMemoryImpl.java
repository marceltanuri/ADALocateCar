package org.ada.agencia.repository;

import org.ada.agencia.models.Agencia;
import org.ada.veiculo.models.Veiculo;

import java.util.*;
import java.util.stream.Collectors;

public class AgenciaRepositoryInMemoryImpl implements AgenciaRepository {

    private final Map<String, Agencia> agenciaDatabase = new HashMap<>();

    @Override
    public List<Agencia> buscarTodasAgencias() {
        return agenciaDatabase.values().stream().toList();
    }

    @Override
    public String adicionarVeiculo(String nomeAgencia, Veiculo veiculo) {
        buscarAgencia(nomeAgencia).getListaDeVeiculos().add(veiculo);
        return "veiculo adicionado com sucesso";
    }

    @Override
    public Agencia buscarAgencia(String nomeAgencia) {
        return agenciaDatabase.values().stream().filter(agencia -> agencia.getNome().equalsIgnoreCase(nomeAgencia)).findFirst().orElse(null);
    }
    
    @Override
    public Agencia inserir(Agencia agencia) {
        agenciaDatabase.put(agencia.getUuid(),agencia);
        return agencia;
    }

    @Override
    public Agencia alterar(String uuid, Agencia agencia) {
        return agenciaDatabase.replace(uuid,agencia);
    }

    @Override
    public Agencia buscaPorId(String id) {
        return agenciaDatabase.get(id);
    }

    @Override
    public Agencia deletar(String id) {
        return agenciaDatabase.remove(id);
    }

    @Override
    public List<Agencia> procurarAgenciaPorNome(String nomeAgencia) {
        List<Agencia> agenciasEncontradas = agenciaDatabase.values().stream()
                .filter(agencia -> agencia.getNome().toLowerCase().contains(nomeAgencia.toLowerCase().trim()))
                .collect(Collectors.toList());
        if (agenciasEncontradas.isEmpty()) {
            throw new IllegalArgumentException("No agencies found with the given name: " + nomeAgencia);
        }

        return agenciasEncontradas;
    }

    @Override
    public List<Agencia> procurarAgenciaPorEndereco(String enderecoAgencia) {
        List<Agencia> agenciasEncontradas = agenciaDatabase.values().stream()
                .filter(agencia -> agencia.getEndereco().toLowerCase().contains(enderecoAgencia.toLowerCase().trim()))
                .collect(Collectors.toList());
        if (agenciasEncontradas.isEmpty()) {
            throw new IllegalArgumentException("No agencies found with the given adress: " + enderecoAgencia);
        }

        return agenciasEncontradas;
    }



}
