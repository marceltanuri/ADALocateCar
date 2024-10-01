package org.ada.cliente.models;

import org.ada.aluguel.models.Aluguel;

public class ClientePessoaJuridica extends Cliente{

    public ClientePessoaJuridica(String nome, String documento) {
        super(nome,documento,TipoCliente.PESSOA_JURIDICA);
    }

    @Override
    public Double getDesconto(Aluguel aluguel) {
        if (aluguel.getTempoLocacaoEmDias() >=3) {
            return 0.1;
        }
        return 0.0;
    }
}
