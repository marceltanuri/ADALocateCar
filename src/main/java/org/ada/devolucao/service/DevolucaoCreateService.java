package org.ada.devolucao.service;

import org.ada.aluguel.models.Aluguel;
import org.ada.devolucao.models.Devolucao;

public interface DevolucaoCreateService {

    Devolucao devolver(Aluguel aluguel);
}
