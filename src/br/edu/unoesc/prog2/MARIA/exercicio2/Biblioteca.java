package br.edu.unoesc.prog2.MARIA.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Publicacao> acervo = new ArrayList<>();

    public void adicionar(Publicacao p) { acervo.add(p); }

    public void emprestar(Publicacao p, Usuario u) throws ExemplarIndisponivelException {
        if (!acervo.contains(p)) {
            throw new IllegalArgumentException("Publicação não está no acervo: " + p);
        }
        if (!p.isDisponivel()) {
            throw new ExemplarIndisponivelException("Exemplar indisponível: " + p);
        }
        p.setDisponivel(false);
        u.receber(p);
    }

    public void devolver(Publicacao p, Usuario u) {
        if (u.devolver(p)) {
            p.setDisponivel(true);
        }
    }

    public List<Publicacao> listarEmprestimos(Usuario u) {
        return u.getEmprestadas();
    }
}
