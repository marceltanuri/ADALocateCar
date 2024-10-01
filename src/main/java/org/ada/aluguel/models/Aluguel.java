package org.ada.aluguel.models;

import org.ada.agencia.models.Agencia;
import org.ada.basemodel.BaseModel;
import org.ada.cliente.models.Cliente;
import org.ada.comprovante.models.ComprovanteGeneratable;
import org.ada.veiculo.models.Veiculo;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Aluguel extends BaseModel implements ComprovanteGeneratable {

    private Cliente cliente;

    private Veiculo veiculo;

    private LocalDateTime dataAluguel;

    private Integer tempoLocacaoEmDias;

    private Agencia agenciaDeRetirada;

    private Agencia agenciaDeDevolucao;

    public Aluguel() {
    }

    public Aluguel(Cliente cliente, Veiculo veiculo, Agencia agenciaDeRetirada, Integer tempoLocacaoEmDias) {
        super();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.agenciaDeRetirada = agenciaDeRetirada;
        this.agenciaDeDevolucao = agenciaDeRetirada;
        this.tempoLocacaoEmDias = tempoLocacaoEmDias;
        this.dataAluguel = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Integer getTempoLocacaoEmDias() {
        return tempoLocacaoEmDias;
    }

    public void setTempoLocacaoEmDias(Integer tempoLocacaoEmDias) {
        this.tempoLocacaoEmDias = tempoLocacaoEmDias;
    }

    public Agencia getAgenciaDeRetirada() {
        return agenciaDeRetirada;
    }

    public void setAgenciaDeRetirada(Agencia agenciaDeRetirada) {
        this.agenciaDeRetirada = agenciaDeRetirada;
    }

    public Agencia getAgenciaDeDevolucao() {
        return agenciaDeDevolucao;
    }

    public void setAgenciaDeDevolucao(Agencia agenciaDeDevolucao) {
        this.agenciaDeDevolucao = agenciaDeDevolucao;
    }

    public double calcularValorDiarias() {
        return veiculo.getValorDiaria() * tempoLocacaoEmDias;
    }

    public boolean isMesmoLocalDeDevolucao() {
        return this.agenciaDeRetirada.equals(agenciaDeDevolucao);
    }

    @Override
    public String toString() {
        return "Aluguel:\n" +
                "Cliente: " + cliente +
                "\n Veiculo:" + veiculo +
                "\n Data do Aluguel=" + dataAluguel +
                ", tempoLocacaoEmDias= " + tempoLocacaoEmDias +
                "\n Agencia para Retirada= " + agenciaDeRetirada +
                "\n Agencia para Devolucao= " + agenciaDeDevolucao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(cliente, aluguel.cliente) && Objects.equals(dataAluguel, aluguel.dataAluguel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, dataAluguel);
    }
}
