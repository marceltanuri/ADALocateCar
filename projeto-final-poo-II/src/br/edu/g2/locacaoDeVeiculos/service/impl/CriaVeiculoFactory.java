package br.edu.g2.locacaoDeVeiculos.service.impl;

import br.edu.g2.locacaoDeVeiculos.model.veiculo.TipoVeiculo;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

public class CriaVeiculoFactory{
    public Veiculo criarVeiculo(TipoVeiculo tipoVeiculo, String placa, String modelo){
        if(tipoVeiculo.equals(TipoVeiculo.MOTO)){
            return new CriaVeiculoMotoImplementation().criar(tipoVeiculo, placa, modelo);
        } else if(tipoVeiculo.equals(TipoVeiculo.CAMINHAO)){
            return new CriaVeiculoCaminhaoImplementation().criar(tipoVeiculo, placa, modelo);
        } else if(tipoVeiculo.equals(TipoVeiculo.CARRO)){
            return new CriaVeiculoCarroImplementation().criar(tipoVeiculo, placa, modelo);
        }else{
            throw new IllegalArgumentException("O tipo de veiculo não é válido");
        }
    }
}
