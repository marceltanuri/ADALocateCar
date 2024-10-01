package org.ada.app;

import org.ada.agencia.models.Agencia;
import org.ada.agencia.repository.AgenciaRepository;
import org.ada.agencia.repository.AgenciaRepositoryInMemoryImpl;
import org.ada.agencia.service.AgenciaService;
import org.ada.agencia.service.AgenciaServiceImpl;
import org.ada.agencia.validation.ValidadoresDeAgencia;
import org.ada.veiculo.models.TipoVeiculo;
import org.ada.veiculo.models.Veiculo;

import java.util.ArrayList;

public  class TestesAgencias {

    static AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemoryImpl();
    static ValidadoresDeAgencia validadoresDeAgencia = new ValidadoresDeAgencia(agenciaRepository);
    static AgenciaService agenciaService = new AgenciaServiceImpl(agenciaRepository, validadoresDeAgencia);

    static Agencia agencia1 = new Agencia("Agencia 1", "Rua 1", new ArrayList<>());
    static Agencia agencia2 = new Agencia("Agencia 2", "Rua 2", new ArrayList<>());

    public static void main(String[] args) {
        agenciaService.criarAgencia(agencia1);
        agenciaService.criarAgencia(agencia2);

        agenciaService.adicionarVeiculo(agencia1, new Veiculo("LKK7676", "marca2", "modelo2", "2007", TipoVeiculo.MOTO));
        agenciaService.adicionarVeiculo(agencia1, new Veiculo("JJJ4321", "marca3", "modelo3", "2015", TipoVeiculo.MOTO));
        agenciaService.adicionarVeiculo(agencia2, new Veiculo("FFF1212", "marca1", "modelo1", "2007", TipoVeiculo.CARRO));
        agenciaService.adicionarVeiculo(agencia2, new Veiculo("AAA1111", "marca4", "modelo4", "2018", TipoVeiculo.CAMINHAO));

        System.out.println("BUSCAR TODAS AS AGENCIAS: ");
        buscarTodasAgencias();

        Agencia agenciaEncontrada = agenciaService.buscarAgencia("Agencia 1");
        System.out.println("\nBUSCA AGENCIA POR NOME: \n" + agenciaEncontrada);

        Agencia agencia1Nova = new Agencia("Agencia1Nova", "Rua1Nova", agencia1.getListaDeVeiculos());
        agenciaService.alterar(agencia1.getUuid(), agencia1Nova);

        Agencia agenciaEncontradaPorId = agenciaService.buscaPorId(agencia1.getUuid());
        System.out.println("\nBUSCA AGENCIA ALTERADA POR ID: \n" + agenciaEncontradaPorId);

        System.out.println("\n Buscar Agencia por parte do nome: agen");
        agenciaService.procurarAgenciaPorNome("Agen").forEach(agencia -> System.out.println(agencia.toString()));

        System.out.println("\n Buscar Agencia por parte do nome da rua: rua");
        agenciaService.procurarAgenciaPorEndereco("rua").forEach(agencia -> System.out.println(agencia.toString()));

        agenciaService.deletar(agencia1.getUuid());
        System.out.println("\n AGENCIAS APÓS DELETAR AGENCIA 1: ");
        buscarTodasAgencias();

        System.out.println("\n Buscar veiculo por placa dentro de agencia: FF1212");
        Veiculo veiculoFFF1212 = agenciaService.buscarVeiculoPorPlaca(agencia2, "fff1212");
        System.out.println(veiculoFFF1212.toString());

        System.out.println("\n Editar Veiculo dentro de agencia:");
        Veiculo novoVeiculo = new Veiculo("QNV4B95", "honda", "civic", "1998", TipoVeiculo.CARRO);
        agenciaService.editarVeiculo(agencia2, veiculoFFF1212.getPlaca(), novoVeiculo);
        System.out.println(agenciaService.buscarVeiculoPorPlaca(agencia2, novoVeiculo.getPlaca()).toString());

        System.out.println("\n Deletar Veiculo por placa:");
        agenciaService.deletarVeiculoPorPlaca(agencia2, "AAA1111");
        System.out.println(agenciaService.buscarAgencia("Agencia 2").toString());

        System.out.println("\n Buscar veiculo por nome:");
        agenciaService.procurarVeiculoPorModelo(agencia2, "civ").forEach(veiculo -> System.out.println(veiculo.toString()));

    }

    public static void buscarTodasAgencias(){
        for(Agencia agencia: agenciaService.buscarTodasAgencias()){
            System.out.println(agencia);
        }
    }

}
