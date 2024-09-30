package br.edu.g2.locacaoDeVeiculos.model.agencia;

import br.edu.g2.locacaoDeVeiculos.model.BaseModel;

public class Agencia extends BaseModel {

    private String nome;
    private String logradouro;

    public Agencia(String nome, String logradouro) {
        super();
        this.nome = nome;
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}