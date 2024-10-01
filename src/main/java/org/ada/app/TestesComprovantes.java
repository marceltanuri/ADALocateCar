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
import org.ada.cliente.repository.ClienteRepository;
import org.ada.cliente.repository.ClienteRepositoryInMemoryImpl;
import org.ada.cliente.service.ClienteService;
import org.ada.cliente.service.ClienteServiceImpl;
import org.ada.comprovante.models.Comprovante;
import org.ada.comprovante.repository.ComprovanteRepository;
import org.ada.comprovante.repository.ComprovanteRepositoryImpl;
import org.ada.comprovante.service.ComprovanteService;
import org.ada.comprovante.service.ComprovanteServiceImpl;
import org.ada.comprovante.validations.ValidadorDeComprovante;
import org.ada.veiculo.models.TipoVeiculo;
import org.ada.veiculo.models.Veiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestesComprovantes {
    static AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemoryImpl();
    static ValidadoresDeAgencia validadoresDeAgencia = new ValidadoresDeAgencia(agenciaRepository);
    static AgenciaService agenciaService = new AgenciaServiceImpl(agenciaRepository, validadoresDeAgencia);

    static ClienteRepository clienteRepository = new ClienteRepositoryInMemoryImpl();
    static ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    static Veiculo veiculo1 = new Veiculo("FFF1212", "marca1", "modelo1", "2007", TipoVeiculo.CARRO);
    static Veiculo veiculo2 = new Veiculo("LKK7676", "marca2", "modelo2", "2007", TipoVeiculo.MOTO);

    static Agencia agencia1 = new Agencia("Agencia 1", "Rua 1", new ArrayList<>());
    static Cliente clientePf1 = new ClientePessoaFisica("Joao", "123456789");

    static AluguelRepository aluguelRepository = new AluguelRepositoryImpl();
    static AluguelService aluguelService = new AluguelServiceImpl(aluguelRepository, new ValidadorDeAluguel(aluguelRepository));

    static Aluguel aluguel1 = new Aluguel(clientePf1, veiculo1, agencia1, 15);

    static ComprovanteRepository<Aluguel> comprovanteRepository = new ComprovanteRepositoryImpl<>();
    static ValidadorDeComprovante<Aluguel> validadorDeComprovante = new ValidadorDeComprovante<>(comprovanteRepository);
    static ComprovanteService<Aluguel> comprovanteService = new ComprovanteServiceImpl<>(comprovanteRepository, validadorDeComprovante);

    public static void main(String[] args) {
        agenciaService.criarAgencia(agencia1);
        agenciaService.adicionarVeiculo(agencia1, veiculo1);
        agenciaService.adicionarVeiculo(agencia1, veiculo2);

        clienteService.inserir(clientePf1);
        aluguelService.inserirAluguel(aluguel1);

        Comprovante<Aluguel> comprovanteAluguel1 = new Comprovante<>(aluguel1);
        comprovanteService.criarComprovante(comprovanteAluguel1);

        System.out.println("Comprovante de Aluguel criado:");
        System.out.println("ID: " + comprovanteAluguel1.comprovanteId());
        System.out.println("Data de Emissão: " + comprovanteAluguel1.dataEmissao());
        System.out.println("Dados: " + comprovanteAluguel1.dados());

        LocalDateTime data = comprovanteAluguel1.dataEmissao();
        System.out.println("Comprovantes emitidos em " + data + ": " + comprovanteService.buscarComprovantesPorData(data));

        Comprovante<Aluguel> comprovanteAlterado = new Comprovante<>(comprovanteAluguel1.comprovanteId(), LocalDateTime.now(), aluguel1);
        comprovanteService.atualizarComprovante(comprovanteAlterado.comprovanteId(), comprovanteAlterado);

        System.out.println("Comprovante atualizado: " + comprovanteAlterado);

        comprovanteService.deletarComprovante(comprovanteAlterado.comprovanteId());
        System.out.println("Comprovante deletado.");

        Comprovante<Aluguel> comprovanteDeleted = comprovanteService.buscarComprovantePorId(comprovanteAlterado.comprovanteId());
        System.out.println("Comprovante após deleção: " + comprovanteDeleted);
    }
}

