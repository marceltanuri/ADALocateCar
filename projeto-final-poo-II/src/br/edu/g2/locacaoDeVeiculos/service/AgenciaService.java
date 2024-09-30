package br.edu.g2.locacaoDeVeiculos.service;

import br.edu.g2.locacaoDeVeiculos.model.agencia.Agencia;
import br.edu.g2.locacaoDeVeiculos.repository.AgenciaRepository;

public abstract class AgenciaService {

    protected final AgenciaRepository agenciaRepository;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public abstract Agencia inserirAgencia(Agencia a);

}