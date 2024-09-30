package br.edu.g2.locacaoDeVeiculos.repository.impl;

import br.edu.g2.locacaoDeVeiculos.dataframework.CrudRepositoryExeption;
import br.edu.g2.locacaoDeVeiculos.model.veiculo.Veiculo;
import br.edu.g2.locacaoDeVeiculos.repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeiculoRepositoryInMemoryImpl implements VeiculoRepository {
    
    private List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public Veiculo inserir(Veiculo veiculo) {
        if(verificacaoVeiculo(veiculo.getPlaca())){
            throw new CrudRepositoryExeption("Veículo já registrado");
        } else{
            veiculos.add(veiculo);
            return veiculo;
        }
    }

    @Override
    public Veiculo alterar(Veiculo ve) {
        // Verifica se o veículo está registrado
        if (!verificacaoVeiculo(ve.getPlaca())) {
            throw new CrudRepositoryExeption("Veículo não registrado");
        }

        // Busca o índice do veículo com a placa informada
        int index = -1;
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equals(ve)) {
                index = i;
                break;
            }
        }

        // Se o veículo foi encontrado, solicita as novas informações
        if (index != -1) {
            Scanner sc = new Scanner(System.in);
            String novaPlaca;

            // Loop para verificar se a nova placa já está em uso
            while (true) {
                System.out.print("Digite a nova placa do veículo: ");
                novaPlaca = sc.nextLine().trim().toUpperCase();


                // Verifica se já existe um veículo com a nova placa
                String finalNovaPlaca = novaPlaca;
                boolean placaExistente = veiculos.stream()
                        .anyMatch(veiculo -> veiculo.getPlaca().equalsIgnoreCase(finalNovaPlaca));

                if (!placaExistente) {
                    break; // Sai do loop se a nova placa não existe
                } else {
                    System.out.println("A placa " + novaPlaca + " já está em uso. Por favor, digite uma nova placa.");
                }
            }

            System.out.print("Digite o novo modelo do veículo: ");
            String novoModelo = sc.nextLine();

            // Cria um novo objeto Veiculo com as informações atualizadas
            Veiculo veiculoNovo = new Veiculo(novaPlaca, ve.getValorDiaria(), ve.isDisponivel(), ve.getTipoVeiculo(), novoModelo);

            // Atualiza o veículo na lista
            veiculos.set(index, veiculoNovo);
            return veiculoNovo;
        } else {
            throw new CrudRepositoryExeption("Veículo com a placa " + ve.getPlaca() + " não encontrado para alteração.");
        }
    }

    @Override
    public Veiculo deletar(Veiculo veiculo) {
        if(verificacaoVeiculo(veiculo.getPlaca())){
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso");
            return veiculo;
        }else{
            throw new CrudRepositoryExeption("Veículo não encontrado para atualização.");
        }
    }

    @Override
    public Veiculo buscaPorId(String id) {
        Veiculo veiculo = veiculos.stream().filter(ve -> ve.getUuid().equalsIgnoreCase(id))
                .findFirst().orElse(null);
        if(veiculo != null){
            return veiculo;
        }else{
            throw new CrudRepositoryExeption("A pesquisa não retornou resultado");
        }
    }

    @Override
    public Veiculo deletarPorId(String id) {
        // Lógica para deletar veículo por ID
        Veiculo veiculo = veiculos.stream().filter(ve -> ve.getUuid().equalsIgnoreCase(id))
                .findFirst().orElse(null);

        if(veiculo != null){
            veiculos.remove(veiculo);
            return veiculo;
        }else{
            throw new CrudRepositoryExeption("o id não foi encontrado");
        }

    }

    @Override
    public List<Veiculo> buscarPorNome(String modeloIncompleto) {
        // Utiliza stream para filtrar a lista de veículos, verificando se a placa contém a parte fornecida
        List<Veiculo> resultados = veiculos.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(modeloIncompleto.toLowerCase()))
                .toList();


        if (resultados.isEmpty()) {
            throw new CrudRepositoryExeption("Nenhum veículo encontrado com esse nome.");
        }


        System.out.println("Veículos encontrados:");
        for (Veiculo veiculo : resultados) {
            System.out.println("Placa: " + veiculo.getPlaca() +
                    ", Modelo: " + veiculo.getModelo() +
                    ", Tipo: " + veiculo.getTipoVeiculo() +
                    ", Disponibilidade: " + veiculo.isDisponivel() +
                    ", Valor Diária: " + veiculo.getValorDiaria());
        }
        System.out.println("-----------------------------------------------------------------------------");

        return resultados;
    }

    @Override
    public Veiculo atualizarPorPlaca(String placa) {
        // Busca o veículo com a placa informada
        Veiculo veiculoParaAtualizar = veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);

        if (veiculoParaAtualizar != null) {
            // Chama o método deletar se o veículo for encontrado
            alterar(veiculoParaAtualizar);
        } else {
            throw new CrudRepositoryExeption("Veículo com a placa " + placa + " não encontrado para alteração.");
        }

        return veiculoParaAtualizar;
    }

    private boolean verificacaoVeiculo(String placa) {
        for (Veiculo veiculo : veiculos){
            if(veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

//    public void listarVeiculos() {
//        System.out.println("\nVeículos cadastrados:");
//            veiculos.forEach(veiculo -> {
//                System.out.println("Placa: " + veiculo.getPlaca());
//                System.out.println("Tipo: " + veiculo.getTipoVeiculo());
//                System.out.println("Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
//                System.out.println("Valor da diária: R$ " + veiculo.getValorDiaria());
//                System.out.println("----------------------");
//            });
//    }


//    public Veiculo deletarPorPlaca(String placa) {
//        // Busca o veículo com a placa informada
//        Veiculo veiculoParaRemover = veiculos.stream()
//                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa))
//                .findFirst()
//                .orElse(null);
//
//        if (veiculoParaRemover != null) {
//            // Chama o método deletar se o veículo for encontrado
//            deletar(veiculoParaRemover);
//        } else {
//            throw new CrudRepositoryExeption("Veículo com a placa " + placa + " não encontrado para remoção.");
//        }
//        return veiculoParaRemover;
//    }

}
