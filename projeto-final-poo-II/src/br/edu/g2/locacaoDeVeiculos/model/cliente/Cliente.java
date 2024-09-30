package br.edu.g2.locacaoDeVeiculos.model.cliente;

import br.edu.g2.locacaoDeVeiculos.model.BaseModel;

public class Cliente extends BaseModel {

    private String nome;
    private String telefone;
    private String documento;
    private TipoCliente tipoCliente;

    public Cliente(TipoCliente tipoCliente, String nome, String documento, String telefone) {
        super();
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}