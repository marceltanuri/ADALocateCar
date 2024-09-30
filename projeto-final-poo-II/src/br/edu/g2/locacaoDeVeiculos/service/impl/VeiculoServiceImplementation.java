package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.model.veiculo.TipoVeiculo;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;
import br.edu.g2.locacaoDeVeiculos.service.VeiculoService;
import br.edu.g2.locacaoDeVeiculos.repository.impl.VeiculoRepositoryInMemoryImpl;

public abstract class VeiculoServiceImplementation implements VeiculoService {

    public abstract Veiculo criar(TipoVeiculo tipoVeiculo, String placa, String modelo);

    @Override
    public Veiculo atualizar(Veiculo veiculo) {
        Veiculo veiculoAtualizado = new VeiculoRepositoryInMemoryImpl().alterar(veiculo);
        return veiculoAtualizado;
    }

    //@Override
    //public void apagar(Veiculo veiculo) {
       // Veiculo deletar = new VeiculoRepositoryInMemoryImpl().deletar(veiculo);
    //}
}
