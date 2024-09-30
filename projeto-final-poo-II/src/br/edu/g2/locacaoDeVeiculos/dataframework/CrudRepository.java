package br.edu.g2.locacaoDeVeiculos.dataframework;

import java.util.List;

public interface CrudRepository <T, I> {

    T inserir(T obj);

    T alterar(T obj);

    T deletar(T obj);

    T buscaPorId(I id);

    T deletarPorId(I id);
}