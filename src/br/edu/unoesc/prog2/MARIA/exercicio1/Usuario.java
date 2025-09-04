package br.edu.unoesc.prog2.MARIA.exercicio1;

import java.util.*;

public class Usuario {
    private final String nome;
    private final String documento;
    private final List<CartaoTransporte> cartoes = new ArrayList<>();

    public Usuario(String nome, String documento) {
        this.nome = Objects.requireNonNull(nome);
        this.documento = Objects.requireNonNull(documento);
    }

    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
    public List<CartaoTransporte> getCartoes() { return Collections.unmodifiableList(cartoes); }
    public void adicionarCartao(CartaoTransporte c) { cartoes.add(Objects.requireNonNull(c)); }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario u = (Usuario) o;
        return documento.equals(u.documento);
    }
    @Override public int hashCode() { return Objects.hash(documento); }
    @Override public String toString() { return nome + " (" + documento + ")"; }
}