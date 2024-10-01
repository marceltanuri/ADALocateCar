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
import org.ada.devolucao.models.Devolucao;
import org.ada.devolucao.repository.DevolucaoRepository;
import org.ada.devolucao.repository.DevolucaoRepositoryImpl;
import org.ada.devolucao.service.*;
import org.ada.devolucao.validations.ValidadorDeDevolucao;
import org.ada.veiculo.models.TipoVeiculo;
import org.ada.veiculo.models.Veiculo;

import java.util.ArrayList;

public class TestesDevolucao {

    static DevolucaoRepository devolucaoRepository = new DevolucaoRepositoryImpl();

    static ValidadorDeDevolucao validadorDeDevolucao = new ValidadorDeDevolucao(devolucaoRepository);

    static DevolucaoCreateService devolucaoCreatorPF = new DevolucaoCreatorServicePF();
    static DevolucaoCreateService devolucaoCreatorPJ = new DevolucaoCreatorServicePJ();

    static DevolucaoService devolucaoService = new DevolucaoServiceImpl(devolucaoRepository,validadorDeDevolucao);
    static AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemoryImpl();
    static ValidadoresDeAgencia validadoresDeAgencia = new ValidadoresDeAgencia(agenciaRepository);
    static AgenciaService agenciaService = new AgenciaServiceImpl(agenciaRepository, validadoresDeAgencia);


    static AluguelRepository aluguelRepository = new AluguelRepositoryImpl();
    static AluguelService aluguelService = new AluguelServiceImpl(aluguelRepository, new ValidadorDeAluguel(aluguelRepository));

    static ClienteRepository clienteRepository = new ClienteRepositoryInMemoryImpl();
    static ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    static Veiculo veiculo1 = new Veiculo("FFF1212", "marca1", "modelo1", "2007", TipoVeiculo.CARRO);
    static Veiculo veiculo2 = new Veiculo("LKK7676", "marca2", "modelo2", "2007", TipoVeiculo.MOTO);
    static Veiculo veiculo3 = new Veiculo("TRT3333", "marca3", "modelo3", "2555", TipoVeiculo.CAMINHAO);

    static Agencia agencia1 = new Agencia("Agencia 1", "Rua 1", new ArrayList<>());
    static Agencia agencia2 = new Agencia("Agencia 2", "Rua 2", new ArrayList<>());

    static Cliente clientePf1 = new ClientePessoaFisica("Joao", "123456789");
    static Cliente clientePf2 = new ClientePessoaFisica("Marcus", "987651284");
    static Cliente clientePj1 = new ClientePessoaJuridica("Aldebaran", "44444444444");
    static Cliente clientePj2 = new ClientePessoaJuridica("Zezinho", "00000000");

    static Aluguel aluguel1 = new Aluguel(clientePf1, veiculo1, agencia1, 15);
    static Aluguel aluguel2 = new Aluguel(clientePj1, veiculo2, agencia2, 8);
    static Aluguel aluguel3 = new Aluguel(clientePj2, veiculo3, agencia2, 30);



    public static void main(String[] args) {
        inicializarAgenciasEClientes();

        aluguelService.inserirAluguel(aluguel1);
        aluguelService.inserirAluguel(aluguel2);
        aluguelService.inserirAluguel(aluguel3);

        System.out.println("REALIZANDO DEVOLUCAO");
        Devolucao devolucaoPf1 = devolucaoService.realizarDevolucao(aluguel1,devolucaoCreatorPF);
        Devolucao devolucaoPj1 = devolucaoService.realizarDevolucao(aluguel2,devolucaoCreatorPJ);
        Devolucao devolucaoPj2 = devolucaoService.realizarDevolucao(aluguel3,devolucaoCreatorPJ);

        System.out.println(devolucaoService.salvarDevolucao(devolucaoPf1));
        System.out.println(devolucaoService.salvarDevolucao(devolucaoPj1));

        System.out.println("LISTANDO DEVOLUCOES");
        buscarTodasDevolucoes();

        System.out.println("BUSCA DE DEVOLUCAO POR CLIENTE \n" +
                devolucaoService.buscarDevolucaoPorCliente(clientePf1)+
                "\n"+ devolucaoService.buscarDevolucaoPorCliente(clientePj1));

        System.out.println("BUSCA POR ID \n" + devolucaoService.buscarDevolucaoPorId(devolucaoPf1.getUuid()));

        Devolucao devolucaoPj3 = devolucaoService.realizarDevolucao(aluguel2,devolucaoCreatorPJ);
        devolucaoService.atualizarDevolucao(devolucaoPj1.getUuid(),devolucaoPj3);

        //Devolucao nao existe, (nao foi salva no repo)
        //System.out.println(devolucaoService.buscarDevolucaoPorId(devolucaoPj2.getUuid()));

        //Cliente sem devolucoes
        //System.out.println(devolucaoService.buscarDevolucaoPorCliente(clientePf2));


        //Devolucao ja realizada
        Devolucao devolucaoPf2 = devolucaoService.realizarDevolucao(aluguel1,devolucaoCreatorPF); //mesma dev1
        //devolucaoService.salvarDevolucao(devolucao2);








    }

    public static void buscarTodasDevolucoes(){
        for(Devolucao devolucao: devolucaoService.buscarTodasDevolucoes()){
            System.out.println(devolucao);
        }
    }

    public static void inicializarAgenciasEClientes(){
        agenciaService.criarAgencia(agencia1);
        agenciaService.criarAgencia(agencia2);
        agenciaService.adicionarVeiculo(agencia1, veiculo1);
        agenciaService.adicionarVeiculo(agencia2, veiculo2);
        agenciaService.adicionarVeiculo(agencia2, veiculo3);
        clienteService.inserir(clientePf1);
        clienteService.inserir(clientePj1);
    }
}
