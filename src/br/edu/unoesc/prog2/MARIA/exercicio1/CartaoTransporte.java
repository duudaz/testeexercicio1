package br.edu.unoesc.prog2.MARIA.exercicio1;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class CartaoTransporte {
    private double saldo;
    private final String id;

    public CartaoTransporte() { this(UUID.randomUUID().toString()); }
    public CartaoTransporte(String id) { this.id = Objects.requireNonNull(id); }

    public double getSaldo() { return saldo; }
    public String getId() { return id; }

    public void carregarSaldo(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de recarga deve ser > 0");
        saldo += valor;
    }

    public void usar(Passagem p) throws SaldoInsuficienteException {
        double preco = p.calcularPreco();
        if (preco > saldo + 1e-9) {
            throw new SaldoInsuficienteException(
                    String.format("Necessário R$ %.2f, disponível R$ %.2f", preco, saldo)
            );
        }
        saldo -= preco;
    }

    @Override public String toString() {
        return "Cartao{" + id + ", saldo=" + String.format(Locale.US, "%.2f", saldo) + "}";
    }
}