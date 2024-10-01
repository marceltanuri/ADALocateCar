package org.ada.veiculo.models;

import org.ada.basemodel.BaseModel;

import java.util.Objects;

public class Veiculo extends BaseModel {

    private String placa;
    private String marca;
    private String modelo;
    private String ano;
    private final TipoVeiculo tipoVeiculo;
    private boolean disponivel = true;

    public Veiculo(String placa, String marca, String modelo, String ano,TipoVeiculo tipoVeiculo ) {
        super();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValorDiaria() {
        return tipoVeiculo.getValorDiaria();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placa);
    }

    @Override
    public String toString() {
        return "Placa= " + placa +
                ", Marca= " + marca +
                ", Modelo= " + modelo +
                ", Ano= " + ano +
                ", tipo= " + tipoVeiculo;
    }
}
