package org.ada.dataframework;


public interface CrudRepository<T, I> {

    T inserir(T obj);

    T alterar(I uuid, T obj);

    T buscaPorId(I uuid);

    T deletar(I id);
}
