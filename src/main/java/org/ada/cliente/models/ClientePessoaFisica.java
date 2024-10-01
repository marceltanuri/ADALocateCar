package org.ada.cliente.models;

import org.ada.aluguel.models.Aluguel;

public class ClientePessoaFisica extends Cliente{

    public ClientePessoaFisica(String nome, String documento) {
        super(nome, documento, TipoCliente.PESSOA_FISICA);
    }

    @Override
    public Double getDesconto(Aluguel aluguel) {
        if (aluguel.getTempoLocacaoEmDias() >=5) {
            return 0.05;
        }
        return 0.0;
    }
}
