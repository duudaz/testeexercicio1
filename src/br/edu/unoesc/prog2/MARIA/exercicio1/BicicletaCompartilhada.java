package br.edu.unoesc.prog2.MARIA.exercicio1;

public class BicicletaCompartilhada implements Passagem {
    private final int minutosDeUso;
    private final double precoPorMinuto;

    public BicicletaCompartilhada(int minutosDeUso, double precoPorMinuto) {
        if (minutosDeUso <= 0) throw new IllegalArgumentException("Minutos deve ser > 0");
        if (precoPorMinuto < 0) throw new IllegalArgumentException("Preço por minuto inválido");
        this.minutosDeUso = minutosDeUso;
        this.precoPorMinuto = precoPorMinuto;
    }

    @Override public double calcularPreco() { return minutosDeUso * precoPorMinuto; }
    @Override public TipoTransporte getTipo() { return TipoTransporte.BICICLETA_COMPARTILHADA; }
}