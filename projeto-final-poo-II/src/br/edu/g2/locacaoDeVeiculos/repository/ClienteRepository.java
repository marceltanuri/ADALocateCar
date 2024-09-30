package br.edu.g2.locacaoDeVeiculos.repository;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepository;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

    public Cliente inserir(Cliente cliente);

    public Cliente alterar(Cliente cliente);

    public Cliente deletar(Cliente cliente);

    public Cliente buscaPorId(String id);

    public Cliente deletarPorId(String id);

    public Cliente buscaPordoc(String doc);

    List<Cliente> getClientes();

}
