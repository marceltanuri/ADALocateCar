package br.edu.g2.locacaoDeVeiculos.model.cobranca;

import br.edu.g2.locacaoDeVeiculos.model.agencia.Agencia;
import br.edu.g2.locacaoDeVeiculos.model.BaseModel;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel extends BaseModel {

    private Cliente cliente;

    private Veiculo veiculo;

    private Agencia agencia;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private double valorFinal;


    public Aluguel (Cliente cliente, Veiculo veiculo, Agencia agencia, LocalDate dataInicio){
        super();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.agencia = agencia;
        this.dataInicio = dataInicio;
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

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public double getDiasAlugado(){
        if(dataFim != null){
            return ChronoUnit.DAYS.between(dataInicio, dataFim);
        }else{
            dataFim = LocalDate.now();
            return getDiasAlugado();
        }
    }

}
