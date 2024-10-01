package org.ada.cliente.models;

public enum TipoCliente {
    PESSOA_FISICA(0.05),
    PESSOA_JURIDICA(0.10);

    private final Double valorDesconto;
    TipoCliente(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }
}