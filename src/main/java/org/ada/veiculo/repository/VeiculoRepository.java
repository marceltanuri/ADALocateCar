package org.ada.veiculo.repository;

import org.ada.dataframework.CrudRepository;
import org.ada.veiculo.models.Veiculo;

import java.util.List;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

    Veiculo buscarVeiculoPorPlaca(String placa);

    List<Veiculo> buscarTodosVeiculos();

}
