package org.ada.app;

import org.ada.agencia.models.Agencia;
import org.ada.agencia.repository.AgenciaRepository;
import org.ada.agencia.repository.AgenciaRepositoryInMemoryImpl;
import org.ada.agencia.service.AgenciaService;
import org.ada.agencia.service.AgenciaServiceImpl;
import org.ada.agencia.validation.ValidadoresDeAgencia;
import org.ada.aluguel.models.Aluguel;
import org.ada.aluguel.repository.AluguelRepository;
import org.ada.aluguel.repository.AluguelRepositoryImpl;
import org.ada.aluguel.service.AluguelService;
import org.ada.aluguel.service.AluguelServiceImpl;
import org.ada.aluguel.validations.ValidadorDeAluguel;
import org.ada.cliente.models.Cliente;
import org.ada.cliente.models.ClientePessoaFisica;
import org.ada.cliente.models.ClientePessoaJuridica;
import org.ada.cliente.repository.ClienteRepository;
import org.ada.cliente.repository.ClienteRepositoryInMemoryImpl;
import org.ada.cliente.service.ClienteService;
import org.ada.cliente.service.ClienteServiceImpl;
import org.ada.veiculo.models.TipoVeiculo;
import org.ada.veiculo.models.Veiculo;

import java.util.ArrayList;

public class TestesAluguel {

    static AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemoryImpl();
    static ValidadoresDeAgencia validadoresDeAgencia = new ValidadoresDeAgencia(agenciaRepository);
    static AgenciaService agenciaService = new AgenciaServiceImpl(agenciaRepository, validadoresDeAgencia);

    static ClienteRepository clienteRepository = new ClienteRepositoryInMemoryImpl();
    static ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    static Veiculo veiculo1 = new Veiculo("FFF1212", "marca1", "modelo1", "2007", TipoVeiculo.CARRO);
    static Veiculo veiculo2 = new Veiculo("LKK7676", "marca2", "modelo2", "2007", TipoVeiculo.MOTO);
    static Veiculo veiculo3 = new Veiculo("TRT3333", "marca3", "modelo3", "2555", TipoVeiculo.CAMINHAO);

    static Agencia agencia1 = new Agencia("Agencia 1", "Rua 1", new ArrayList<>());
    static Agencia agencia2 = new Agencia("Agencia 2", "Rua 2", new ArrayList<>());

    static Cliente clientePf1 = new ClientePessoaFisica("Joao", "123456789");
    static Cliente clientePj1 = new ClientePessoaJuridica("Aldebaran", "44444444444");
    static Cliente clientePj2 = new ClientePessoaJuridica("Zezinho", "00000000");

    static AluguelRepository aluguelRepository = new AluguelRepositoryImpl();
    static AluguelService aluguelService = new AluguelServiceImpl(aluguelRepository, new ValidadorDeAluguel(aluguelRepository));

    static Aluguel aluguel1 = new Aluguel(clientePf1, veiculo1, agencia1, 15);
    static Aluguel aluguel2 = new Aluguel(clientePj1, veiculo2, agencia2, 8);

    public static void main(String[] args) {

        inicializarAgenciasEClientes();

        aluguelService.inserirAluguel(aluguel1);
        aluguelService.inserirAluguel(aluguel2);
        System.out.println("LISTAGEM DE ALUGUEIS: ");
        buscarTodosAlugueis();

        System.out.println("\nBUSCA DE ALUGUEL PELO CLIENTEPF1: \n"+
        aluguelService.buscarAluguelPorCliente(clientePf1));

        System.out.println("\nBUSCA DE ALUGUEL PELO ID: \n"+ aluguelService.buscaPorId(aluguel2.getUuid()));

        aluguelService.alterarAluguel(aluguel2.getUuid() ,new Aluguel(clientePj2, veiculo3, agencia2, 6));

        System.out.println("\nBUSCA DE ALUGUEL PELO CLIENTEPJ2: \n"+ aluguelService.buscarAluguelPorCliente(clientePj2));

        aluguelService.deletarAluguel(aluguel1.getUuid());
        System.out.println("\nLISTAGEM DE ALUGUEIS APOS ALTERAR : ");
        buscarTodosAlugueis();




    }

    public static void buscarTodosAlugueis(){
        for(Aluguel aluguel: aluguelService.buscarTodosAlugueis()){
            System.out.println(aluguel);
        }
    }

    public static void inicializarAgenciasEClientes(){
        agenciaService.criarAgencia(agencia1);
        agenciaService.criarAgencia(agencia2);
        agenciaService.adicionarVeiculo(agencia1, veiculo1);
        agenciaService.adicionarVeiculo(agencia2, veiculo2);
        clienteService.inserir(clientePf1);
        clienteService.inserir(clientePj1);
    }
}
