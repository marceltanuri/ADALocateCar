package br.edu.g2.locacaoDeVeiculos.model.cobranca;

public record Devolucao (Aluguel aluguel, double desconto) {

    public void setValorFinal(){
        double valorFinal = aluguel.getVeiculo().getValorDiaria() * aluguel.getDiasAlugado() * (1 - desconto);
        aluguel.setValorFinal(valorFinal);
    }

    @Override
    public String toString(){
        String saida = "Cliente: " + aluguel.getCliente().getNome()
                + " ficou com o carro por: " + aluguel.getDiasAlugado() + " dias."
                + "totalizando r$ " + aluguel.getValorFinal();
        if(desconto > 0){
            saida = saida + " o desconto foi de : " + desconto * 100 + "%";
        }
        return saida;
    }
}
