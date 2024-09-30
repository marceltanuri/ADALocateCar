package br.edu.g2.locacaoDeVeiculos.dataframework;

public class CrudRepositoryExeption extends RuntimeException{
    public CrudRepositoryExeption(String message) {
        super(message);
    }
}
