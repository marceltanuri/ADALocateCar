package org.ada.aluguel.service;

import org.ada.aluguel.models.Aluguel;
import org.ada.aluguel.repository.AluguelRepository;
import org.ada.cliente.models.Cliente;

import java.util.List;

public abstract class AluguelService {

    protected final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Aluguel inserirAluguel(Aluguel aluguel) {
        return aluguelRepository.inserir(aluguel);
    }

    public Aluguel buscarAluguelPorCliente(Cliente cliente) {
        return aluguelRepository.buscarAluguelPorCliente(cliente);
    }

    public Aluguel buscaPorId(String uuid) {
        return aluguelRepository.buscaPorId(uuid);
    }

    public Aluguel alterarAluguel(String uuid, Aluguel aluguel) {
        return aluguelRepository.alterar(uuid, aluguel);
    }

    public Aluguel deletarAluguel(String id){ return aluguelRepository.deletar(id);}

    public List<Aluguel> buscarTodosAlugueis(){return aluguelRepository.buscarTodosAlugueis();}
}
