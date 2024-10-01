package org.ada.devolucao.models;

import org.ada.aluguel.models.Aluguel;
import org.ada.basemodel.BaseModel;
import org.ada.comprovante.models.ComprovanteGeneratable;

import java.time.LocalDateTime;
import java.util.Objects;

public class Devolucao extends BaseModel implements ComprovanteGeneratable {

    private Aluguel aluguel;

    private LocalDateTime dataDaDevolucao;

    private Double valorFinal;

    private Double desconto;

    private Double taxaDeslocamento;

    public Devolucao(Aluguel aluguel, Double desconto, Double taxaDeslocamento) {
        this.aluguel = aluguel;
        this.desconto = desconto;
        this.taxaDeslocamento = taxaDeslocamento;
        this.dataDaDevolucao = LocalDateTime.now();
        this.valorFinal = getValorFinal();
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDateTime getDataDaDevolucao() {
        return dataDaDevolucao;
    }

    public void setDataDaDevolucao(LocalDateTime dataDaDevolucao) {
        this.dataDaDevolucao = dataDaDevolucao;
    }

    public Double getValorFinal() {
        return (aluguel.calcularValorDiarias() * (1-desconto)) + taxaDeslocamento;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTaxaDeslocamento() {
        return taxaDeslocamento;
    }

    public void setTaxaDeslocamento(Double taxaDeslocamento) {
        this.taxaDeslocamento = taxaDeslocamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devolucao devolucao = (Devolucao) o;
        return Objects.equals(aluguel, devolucao.aluguel);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(aluguel);
    }

    @Override
    public String toString() {
        return "Devolucao: \n" +
                "Aluguel: " + aluguel +
                "\n dataDaDevolucao= " + dataDaDevolucao +
                "\n valorFinal= " + valorFinal;
    }
}