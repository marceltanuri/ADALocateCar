package org.ada.comprovante.service;

import org.ada.comprovante.models.Comprovante;
import org.ada.comprovante.models.ComprovanteGeneratable;
import org.ada.comprovante.repository.ComprovanteRepository;
import org.ada.comprovante.validations.ValidadorDeComprovante;

public class ComprovanteServiceImpl<T extends ComprovanteGeneratable> extends ComprovanteService<T> {

    private final ValidadorDeComprovante<T> validadorDeComprovante;

    public ComprovanteServiceImpl(ComprovanteRepository<T> comprovanteRepository, ValidadorDeComprovante<T> validadorDeComprovante) {
        super(comprovanteRepository);
        this.validadorDeComprovante = validadorDeComprovante;
    }

    @Override
    public Comprovante<T> criarComprovante(Comprovante<T> comprovante) {
        validadorDeComprovante.checarSeExiste(comprovante);
        return super.criarComprovante(comprovante);
    }

    @Override
    public Comprovante<T> atualizarComprovante(String uuid, Comprovante<T> comprovante) {
        validadorDeComprovante.checarSeNaoExiste(comprovante);
        return super.atualizarComprovante(uuid, comprovante);
    }
}
