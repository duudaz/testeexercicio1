package br.edu.unoesc.prog2.MARIA.exercicio1;

import java.util.*;

public class Sistema {
    private final Map<TipoTransporte, Double> totalArrecadado = new EnumMap<>(TipoTransporte.class);
    private final Map<Usuario, Integer> viagensPorUsuario = new HashMap<>();

    public Sistema() {
        for (TipoTransporte t : TipoTransporte.values()) totalArrecadado.put(t, 0.0);
    }

    public void registrarViagem(Usuario usuario, CartaoTransporte cartao, Passagem passagem)
            throws SaldoInsuficienteException {
        Objects.requireNonNull(usuario);
        Objects.requireNonNull(cartao);
        Objects.requireNonNull(passagem);

        cartao.usar(passagem);
        double valor = passagem.calcularPreco();
        totalArrecadado.merge(passagem.getTipo(), valor, Double::sum);
        viagensPorUsuario.merge(usuario, 1, Integer::sum);
    }

    public Map<TipoTransporte, Double> getTotaisArrecadados() {
        return Collections.unmodifiableMap(totalArrecadado);
    }
    public Map<Usuario, Integer> getViagensPorUsuario() {
        return Collections.unmodifiableMap(viagensPorUsuario);
    }
}
