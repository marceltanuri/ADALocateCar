package org.ada.app;

import org.ada.agencia.models.Agencia;
import org.ada.agencia.repository.AgenciaRepository;
import org.ada.agencia.repository.AgenciaRepositoryInMemoryImpl;
import org.ada.agencia.service.AgenciaService;
import org.ada.agencia.service.AgenciaServiceImpl;
import org.ada.agencia.validation.ValidadoresDeAgencia;
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

public  class TestesClientes {

    static ClienteRepository clienteRepository = new ClienteRepositoryInMemoryImpl();
    static ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    static Cliente clientePf1 = new ClientePessoaFisica("Joao", "123456789");
    static Cliente clientePf2 = new ClientePessoaFisica("Maria", "1111111111");
    static Cliente clientePj1 = new ClientePessoaJuridica("Aldebaran", "44444444444");
    static Cliente clientePj2 = new ClientePessoaJuridica("Kratos", "555555555");
    static Cliente clientePj3 = new ClientePessoaJuridica("Lucilda", "888888888");


    public static void main(String[] args) {
        clienteService.inserir(clientePf1);
        clienteService.inserir(clientePf2);
        clienteService.inserir(clientePj1);
        clienteService.inserir(clientePj2);
        clienteService.inserir(clientePj3);
        System.out.println("LISTA DE CLIENTES INSERIDOS: ");
        buscarTodosClientes();

        Cliente clientePf2Novo = new ClientePessoaFisica("Gpteco", "092388743");


        clienteService.alterar(clientePf2.getUuid(), clientePf2Novo);

        Cliente clienteNovoEncontrado = clienteService.buscaPorId(clientePf2.getUuid());
        System.out.println("\nCLIENTE ALTERADO: \n" + clienteNovoEncontrado);

        clienteService.deletar(clientePf2.getUuid());
        System.out.println("\nLISTA DE CLIENTES APÓS DELETAR PJ3: ");
        buscarTodosClientes();
    }

    public static void buscarTodosClientes(){
        for(Cliente cliente: clienteService.buscarTodosClientes()){
            System.out.println(cliente);
        }
    }

}
