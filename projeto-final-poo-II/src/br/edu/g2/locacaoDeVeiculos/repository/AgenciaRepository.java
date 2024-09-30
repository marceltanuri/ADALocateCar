package br.edu.g2.locacaoDeVeiculos.repository;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepository;
import br.edu.g2.locacaoDeVeiculos.model.agencia.Agencia;

public interface AgenciaRepository extends CrudRepository<Agencia, String> {

    public Agencia inserir(Agencia ag);

    public Agencia alterar(Agencia ag);

    public Agencia deletar(Agencia ag);

    public Agencia buscaPorId(String id);

    public Agencia deletarPorId(String id);
}
