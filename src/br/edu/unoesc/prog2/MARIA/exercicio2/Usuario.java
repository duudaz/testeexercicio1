package br.edu.unoesc.prog2.MARIA.exercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private final String nome;
    private final List<Publicacao> emprestadas = new ArrayList<>();

    public Usuario(String nome) { this.nome = nome; }
    public String getNome() { return nome; }

    // composição: o usuário "tem" publicações emprestadas
    public List<Publicacao> getEmprestadas() {
        return Collections.unmodifiableList(emprestadas);
    }

    void receber(Publicacao p) { emprestadas.add(p); }
    boolean devolver(Publicacao p) { return emprestadas.remove(p); }

    @Override public String toString() { return nome; }
}
