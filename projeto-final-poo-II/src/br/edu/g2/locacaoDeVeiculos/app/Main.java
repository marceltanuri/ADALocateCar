package br.edu.g2.locacaoDeVeiculos.app;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepositoryExeption;
import br.edu.g2.locacaoDeVeiculos.model.cliente.Cliente;
import br.edu.g2.locacaoDeVeiculos.model.cliente.TipoCliente;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.TipoVeiculo;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;
import br.edu.g2.locacaoDeVeiculos.repository.ClienteRepository;
import br.edu.g2.locacaoDeVeiculos.repository.VeiculoRepository;
import br.edu.g2.locacaoDeVeiculos.repository.impl.ClienteRepositoryInMemoryImpl;
import br.edu.g2.locacaoDeVeiculos.repository.impl.VeiculoRepositoryInMemoryImpl;
import br.edu.g2.locacaoDeVeiculos.service.impl.CriaVeiculoFactory;

import java.util.Scanner;

public class Main {



    private static Scanner sc = new Scanner(System.in);
    private static ClienteRepository clienteRepository = new ClienteRepositoryInMemoryImpl();
    private static VeiculoRepository veiculoRepository = new VeiculoRepositoryInMemoryImpl();

    public static void main(String[] args) {
        while (true) {
            try {
                exibirMenu();
                int opcao = Integer.parseInt(sc.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarVeiculo(veiculoRepository);
                        break;
                    case 2:
                        alterarVeiculo(veiculoRepository);
                        break;
                    case 3:
                        buscarVeiculoPorNome(veiculoRepository);
                        break;
                    case 4:
                        //cadastrarAgencia();
                        break;
                    case 5:
                        //alterarAgencia();
                        break;
                    case 6:
                        // buscarAgencia();
                        break;
                    case 7:
                        cadastrarCliente();
                        break;
                    case 8:
                        buscarTodosClientes();
                        break;

                    case 9:
                        alterarCliente();
                        break;
                    case 10:
                        //alugarVeiculo();
                        break;
                    case 11:
                        //devolverVeiculo();
                        break;
                    case 12:
                        //gerarcomprovante()
                        break;
                    case 13:
                        System.out.println("Encerrando ...");
                        System.exit(0);
                    default:
                        System.out.println();
                        System.out.println("Opção inválida.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Digite uma Opçao Válida ");

            }
        }
    }


    private static void exibirMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("=== Sistema de Aluguel de Veículos ===");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("1.  Cadastrar Veículo");
        System.out.println("2.  Alterar Veículo");
        System.out.println("3.  Buscar Veículo por Nome");
        System.out.println("4.  Cadastrar Agência");
        System.out.println("5.  Alterar Agência");
        System.out.println("6.  Buscar Agência por Nome ou Logradouro");
        System.out.println("7.  Cadastrar Cliente");
        System.out.println("8.  Buscar Todos os Clientes");
        System.out.println("9.  Alterar Cliente");
        System.out.println("10. Alugar Veículo");
        System.out.println("11. Devolver Veículo");
        System.out.println("12. Gerar comprovante");
        System.out.println("13. Sair");
        System.out.print("Escolha uma opção: ");

    }

    private static void cadastrarCliente(){
        System.out.println("Digite : 1- pessoal Física, 2 - Pessoa Jurídica ");
        String tipo= sc.nextLine();
        TipoCliente tipoCliente = null;

        if(tipo.equals("1")){
            tipoCliente= TipoCliente.PESSOA_FISICA;
        }else if (tipo.equals("2")) {
            tipoCliente = TipoCliente.PESSOA_JURIDICA;

        }else{
            System.out.println("Tipo Inválido");}

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        String documento;
        if(tipoCliente == TipoCliente.PESSOA_JURIDICA){
            System.out.println("Digite o CNPJ");
            documento= sc.nextLine();
        }else{
            System.out.println("Digite o CPF");
            documento= sc.nextLine();
        }
        Cliente cliente = new Cliente(tipoCliente, nome, documento, telefone);
        try {
            clienteRepository.inserir(cliente);
            String id = cliente.getUuid();
            System.out.println("CLiente cadastrado com sucesso!");
            System.out.println(id);
            System.out.println("Documento: " + cliente.getDocumento() + " | Nome: " + cliente.getNome());
        }catch(CrudRepositoryExeption e){
            System.out.println("Erro ao cadastrar cliente,  " + e.getMessage());
        }
    }
    private static void buscarTodosClientes(){
        if(clienteRepository.getClientes().isEmpty()){
            System.out.println("Nenhuma cliente cadastrado");
        }
        for(Cliente c : clienteRepository.getClientes()){
            System.out.println();
            System.out.println("Tipo de Cliente: " + (c.getTipoCliente() == TipoCliente.PESSOA_FISICA ? "Pessoa Física" : "Pessoa Jurídica"));
            System.out.println("Id: " + c.getUuid());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Documento: " + c.getDocumento());
            System.out.println("-----------------------------------------------------------------------------");
        }



    }
    private static void alterarCliente() {
        System.out.print("Digite o ID do Cliente: ");
        String id = sc.nextLine();
        Cliente cliente = clienteRepository.buscaPorId(id);
        System.out.println("Novo nome");
        String novoNome = sc.nextLine();
        if(!novoNome.isEmpty()){
            cliente.setNome(novoNome);
        }
        System.out.println("Novo telefone ");
        String novoTelefone = sc.nextLine();
        if(!novoTelefone.isEmpty()){
            cliente.setTelefone(novoTelefone);
        }
        if (cliente.getTipoCliente() == TipoCliente.PESSOA_FISICA) {
            System.out.println("Novo CPf : ");
            String novoCpf = sc.nextLine();
            cliente.setDocumento(novoCpf);
        }else {
            System.out.println("Novo CNPJ : ");
            String novoCnpj = sc.nextLine();
            if(!novoCnpj.isEmpty()){
                cliente.setDocumento(novoCnpj);
            }
        }
        clienteRepository.alterar(cliente);
        System.out.println("Cliente alterado com sucesso.");

    }

    private static void cadastrarVeiculo(VeiculoRepository veiculoRepo) {
        System.out.println("\nCriação de Veículo");

        String placa;

        while (true) {
            System.out.print("Digite a placa: ");
            placa = sc.nextLine().trim().toUpperCase();

            // Validação da placa
            String regex = "^[A-Z]{3}\\d{1}[A-Z]{1}\\d{2}$";
            if (!placa.matches(regex)) {
                System.out.println("Placa inválida! A placa deve seguir o formato ABC1D23.");
                continue;
            }
            break;
        }


        System.out.print("Digite o modelo: ");
        String nome = sc.nextLine();

        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Caminhão");
        int tipoOpcao = sc.nextInt();
        sc.nextLine();

        TipoVeiculo tipoVeiculo = null;
        switch (tipoOpcao) {
            case 1:
                tipoVeiculo = TipoVeiculo.CARRO;
                break;
            case 2:
                tipoVeiculo = TipoVeiculo.MOTO;
                break;
            case 3:
                tipoVeiculo = TipoVeiculo.CAMINHAO;
                break;
            default:
                System.out.println("Opção inválida. Veículo não criado.");
                return;
        }

        boolean disponivel = true;

        // Usar a factory para criar o tipo específico de veículo
        CriaVeiculoFactory factory = new CriaVeiculoFactory();
        Veiculo veiculoFinal = factory.criarVeiculo(tipoVeiculo, placa, nome);

        // Adicionar o veículo no repositório
        veiculoRepo.inserir(veiculoFinal);
        System.out.println("Veículo do tipo " + tipoVeiculo + " criado com sucesso!");
    }

    private static void buscarVeiculoPorNome( VeiculoRepository veiculoRepo) {
        System.out.println("\nBusca de Veículo");

        System.out.print("Digite a parte do nome do modelo do veículo que deseja buscar: ");
        String modeloIncompleto = sc.nextLine();

        veiculoRepo.buscarPorNome(modeloIncompleto);
    }

    private static void alterarVeiculo(VeiculoRepository veiculoRepo) {
        System.out.println("\nAlteração de Veículo");

        System.out.print("Digite a placa do veículo que deseja alterar: ");
        String placaAntiga = sc.nextLine();

        // Chama o método para atualizar o veículo
        veiculoRepo.atualizarPorPlaca(placaAntiga);
    }

}
