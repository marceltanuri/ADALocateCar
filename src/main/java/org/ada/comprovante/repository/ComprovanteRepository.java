package org.ada.comprovante.repository;

import org.ada.comprovante.models.Comprovante;
import org.ada.comprovante.models.ComprovanteGeneratable;
import org.ada.dataframework.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ComprovanteRepository<T extends ComprovanteGeneratable> extends CrudRepository<Comprovante<T>, String> {
    List<Comprovante<T>> buscarComprovantesPorData(LocalDateTime dataEmissao);
    List<Comprovante<T>> buscarTodosComprovantes();
}
