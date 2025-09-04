package br.edu.unoesc.prog2.MARIA.exercicio1;

public class Metro implements Passagem {
    private final int numeroEstacoes;
    private final double precoPorEstacao;

    public Metro(int numeroEstacoes, double precoPorEstacao) {
        if (numeroEstacoes <= 0) throw new IllegalArgumentException("Número de estações deve ser > 0");
        if (precoPorEstacao < 0) throw new IllegalArgumentException("Preço por estação inválido");
        this.numeroEstacoes = numeroEstacoes;
        this.precoPorEstacao = precoPorEstacao;
    }

    @Override public double calcularPreco() { return numeroEstacoes * precoPorEstacao; }
    @Override public TipoTransporte getTipo() { return TipoTransporte.METRO; }
}
