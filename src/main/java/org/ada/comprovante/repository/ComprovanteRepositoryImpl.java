package org.ada.comprovante.repository;

import org.ada.comprovante.models.Comprovante;
import org.ada.comprovante.models.ComprovanteGeneratable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComprovanteRepositoryImpl<T extends ComprovanteGeneratable> implements ComprovanteRepository<T> {

    private final Map<String, Comprovante<T>> comprovanteDatabase = new HashMap<>();

    @Override
    public Comprovante<T> inserir(Comprovante<T> comprovante) {
        return comprovanteDatabase.put(comprovante.comprovanteId(), comprovante);
    }

    @Override
    public Comprovante<T> alterar(String uuid, Comprovante<T> comprovante) {
        return comprovanteDatabase.replace(uuid, comprovante);
    }

    @Override
    public Comprovante<T> buscaPorId(String id) {
        return comprovanteDatabase.get(id);
    }

    @Override
    public Comprovante<T> deletar(String id) {
        return comprovanteDatabase.remove(id);
    }

    @Override
    public List<Comprovante<T>> buscarComprovantesPorData(LocalDateTime dataEmissao) {
        return comprovanteDatabase.values()
                .stream()
                .filter(comprovante -> comprovante.dataEmissao().isEqual(dataEmissao))
                .collect(Collectors.toList());
    }

    @Override
    public List<Comprovante<T>> buscarTodosComprovantes() {
        return new ArrayList<>(comprovanteDatabase.values());
    }
}
