package br.edu.g2.locacaoDeVeiculos.model.veiculo;

import br.edu.g2.locacaoDeVeiculos.model.BaseModel;



public class Veiculo extends BaseModel {

    private String placa;

    private double valorDiaria;

    private boolean disponivel;

    private TipoVeiculo tipoVeiculo;

    private String modelo;


    public Veiculo(String placa, double valorDiaria, boolean disponivel, TipoVeiculo tipoVeiculo, String modelo) {
        super();
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
        this.tipoVeiculo = tipoVeiculo;
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void mudarDisponibilidade() {
        disponivel = !disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getModelo() {
        return modelo;
    }
}