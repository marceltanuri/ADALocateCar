package br.edu.g2.locacaoDeVeiculos.repository;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepository;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

    public Veiculo inserir(Veiculo v);

    public Veiculo alterar(Veiculo v);

    public Veiculo deletar(Veiculo v);

    public Veiculo buscaPorId(String id);

    public Veiculo deletarPorId(String id);

    // Método para buscar por parte do nome
    public List<Veiculo> buscarPorNome(String nome);
    public Veiculo atualizarPorPlaca(String placa);
}
