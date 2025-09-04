package br.edu.unoesc.prog2.MARIA.exercicio1;

public class Onibus implements Passagem {
    private final double precoFixo;

    public Onibus(double precoFixo) {
        if (precoFixo < 0) throw new IllegalArgumentException("Preço fixo inválido");
        this.precoFixo = precoFixo;
    }

    @Override public double calcularPreco() { return precoFixo; }
    @Override public TipoTransporte getTipo() { return TipoTransporte.ONIBUS; }
}