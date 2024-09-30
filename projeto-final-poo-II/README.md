# Locadora de Veículos (POO II)

_Este é um projeto em grupo desenvolvido no final do módulo de Programação Orientada a Objetos II do curso Santander Coders 2024.1 da AdaTech. Abaixo segue uma descrição das principais classes e funcionalidades implementadas na aplicação de locadora de veículos._

---

## Estrutura do Projeto

### 1. Aluguel

#### `public class Aluguel`
Classe responsável por armazenar os dados do aluguel de veículos. Para criar uma nova instância de `Aluguel`, deve-se utilizar a classe `AluguelService`.

#### `public class AluguelServiceImpl`
Classe que gerencia o processo de aluguel de veículos, com dois métodos principais:

- **Método alugar (sem data)**: Define a data e hora atuais como início do aluguel.
- **Método alugar (com data)**: Permite definir a data de início e verifica se o veículo está disponível. Caso não esteja, uma exceção é lançada.

---

### 2. Devolução

#### `public class DevolucaoFactory`
Fábrica de instâncias de `public record Devolucao` através do método `devolverVeiculo(Aluguel aluguel)`.

- O método verifica o tipo de cliente (físico ou jurídico) para aplicar o desconto correto e utiliza o serviço apropriado (`DevolucaoService`).

#### `public interface DevolucaoServiceBase`
Interface base para as diferentes implementações de serviço de devolução de veículos.

---

### 3. Cliente

#### `public class Cliente`
Classe que representa as informações de um cliente (nome, documentos, contato), utilizado no processo de aluguel de veículos.

#### `public class ClienteRepositoryInMemoryImpl`
Repositório que armazena dados de clientes em memória, simulando um banco de dados. Gerencia operações de CRUD:

- **Salvar**: Adiciona um novo cliente.
- **Buscar**: Retorna um cliente com base no documento.
- **Atualizar**: Atualiza informações do cliente.
- **Remover**: Remove um cliente com base no documento.

---

### 4. Repositórios

#### `public interface CrudRepository`
Interface que define operações CRUD (criar, ler, atualizar e excluir) para qualquer implementação.

#### `public interface AgenciaRepository`
Extensão de `CrudRepository`, direcionando as operações para uma lista de `Agencia`.

#### `public class AgenciaRepositoryInMemoryImpl`
Implementação do CRUD de agências, salvando os dados em memória utilizando uma `List<Agencia>`.

---

### 5. Veículo

#### `public class Veiculo`
Classe que representa um veículo cadastrado no sistema. Para criar, alterar, ou buscar veículos, deve-se utilizar o serviço `VeiculoService`.

#### `public class VeiculoServiceImpl`
Classe responsável por gerenciar veículos, oferecendo métodos para criar, deletar, alterar e realizar buscas.

#### `public class VeiculoFactory`
Fábrica de instâncias de `Veiculo`, através do método `criarVeiculo(TipoVeiculo tipoVeiculo, String placa, String modelo)`, que cria um veículo de acordo com o tipo especificado.

---

## Funcionalidades da Aplicação

A aplicação gerencia o processo de aluguel e devolução de veículos, com as seguintes funcionalidades obrigatórias:

1. **Cadastrar veículos**.
2. **Alterar veículos cadastrados**.
3. **Buscar veículo por parte do nome**.
4. **Cadastrar agência de aluguel/devolução**.
5. **Alterar agência de aluguel/devolução**.
6. **Buscar agência por parte do nome ou logradouro**.
7. **Cadastrar cliente (físico/jurídico)**.
8. **Alterar cliente (físico/jurídico)**.
9. **Alugar veículo para pessoa física**.
10. **Alugar veículo para pessoa jurídica**.
11. **Devolver veículo para pessoa física**.
12. **Devolver veículo para pessoa jurídica**.
13. **Gerar comprovante de aluguel** (detalhes a serem definidos pelo grupo).
14. **Gerar comprovante de devolução** (detalhes a serem definidos pelo grupo).

---

## Observações Finais

Este projeto exemplifica a aplicação dos conceitos de POO em um cenário realista de locadora de veículos, incluindo padrões de projeto como fábrica e repositórios, além da separação de responsabilidades entre serviços, entidades e repositórios.
