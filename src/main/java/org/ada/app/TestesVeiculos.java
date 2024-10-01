package org.ada.app;

import org.ada.veiculo.models.TipoVeiculo;
import org.ada.veiculo.models.Veiculo;
import org.ada.veiculo.repository.VeiculoRepository;
import org.ada.veiculo.repository.VeiculoRepositoryInMemoryImpl;
import org.ada.veiculo.service.VeiculoService;
import org.ada.veiculo.service.VeiculoServiceImpl;

public  class TestesVeiculos {

    static VeiculoRepository veiculoRepository = new VeiculoRepositoryInMemoryImpl();
    static VeiculoService veiculoService = new VeiculoServiceImpl(veiculoRepository);

    static Veiculo caminhaoFh = new Veiculo("ASD1234", "Volvo", "FH", "2001", TipoVeiculo.CAMINHAO);
    static Veiculo caminhaoR = new Veiculo("JHJ1774", "Scania", "R", "2010", TipoVeiculo.CAMINHAO);
    static Veiculo carroCorolla = new Veiculo("ZXC4646", "Toyota", "Corolla", "2002", TipoVeiculo.CARRO);
    static Veiculo carroCivic = new Veiculo("GHG6666", "Honda", "Civic", "2003", TipoVeiculo.CARRO);
    static Veiculo motoCg = new Veiculo("FFF1111", "Honda", "CG150", "2012", TipoVeiculo.MOTO);
    static Veiculo motoSportster = new Veiculo("LLL9999", "Harley", "Sportster", "2015", TipoVeiculo.MOTO);

    public static void main(String[] args) {
        inserirVeiculos();

        System.out.println("LISTAGEM VEICULOS INSERIDOS: ");
        buscarTodosVeiculos();

        Veiculo novoCorolla = new Veiculo("CCC4444", "Toyota", "Corolla2.0", "2020", TipoVeiculo.CARRO);
        veiculoService.alterar(carroCorolla.getUuid(), novoCorolla);

        System.out.println("\nCARRO COROLLA ALTERADO: ");
        Veiculo veiculoAlterado = veiculoService.buscaPorId(carroCorolla.getUuid());
        System.out.println(veiculoAlterado);

        System.out.println("\nBUSCA POR PLACA LLL9999: ");
        Veiculo veiculoBuscaPorPlaca = veiculoService.buscarVeiculo("LLL9999");
        System.out.println(veiculoBuscaPorPlaca);

        System.out.println("\nLISTAGEM VEICULOS APÓS DELETAR CAMINHAO FH DA VOLVO: ");
        veiculoService.deletar(caminhaoFh.getUuid());
        buscarTodosVeiculos();
    }

    public static void inserirVeiculos(){

        veiculoService.inserir(caminhaoFh);
        veiculoService.inserir(caminhaoR);
        veiculoService.inserir(carroCorolla);
        veiculoService.inserir(carroCivic);
        veiculoService.inserir(motoCg);
        veiculoService.inserir(motoSportster);
    }

    public static void buscarTodosVeiculos(){
        for(Veiculo veiculo: veiculoService.buscarTodosVeiculos()){
            System.out.println(veiculo);
        }
    }



}
