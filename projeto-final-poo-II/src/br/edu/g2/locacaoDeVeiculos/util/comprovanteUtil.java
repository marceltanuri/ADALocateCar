package br.edu.g2.locacaoDeVeiculos.util;

import br.edu.g2.locacaoDeVeiculos.model.cobranca.Aluguel;
import br.edu.g2.locacaoDeVeiculos.model.cobranca.Devolucao;

public class comprovanteUtil {
    public static String comprovanteAluguel(Aluguel aluguel) {
        String comprovante;
        comprovante = "comprovante de aluguel %n" +
                "ID Aluguel: " + aluguel.getUuid() + "%n"+
                "Veículo" + aluguel.getVeiculo() + "%n"+
                "Agência: " + aluguel.getAgencia().getNome() +"%n"+
                "Cliente: " + aluguel.getCliente().getNome() + "%n"+
                "Data do Aluguel: " + aluguel.getDataInicio() + "%n";

        return comprovante;
    }


    public static String comprovanteDevolucao(Aluguel aluguel) {
        String comprovante = "Comprovante de Devolução%n" +
                "ID Aluguel: " + aluguel.getUuid() + "%n" +
                "Veículo: " + aluguel.getVeiculo() + "%n" +
                "Cliente: " + aluguel.getCliente().getNome() + "%n" +
                "Data da Devolução: " + aluguel.getDataFim() + "%n" +
                "Valor final:" + aluguel.getValorFinal() +  "%n";
        return comprovante;
    }

}
