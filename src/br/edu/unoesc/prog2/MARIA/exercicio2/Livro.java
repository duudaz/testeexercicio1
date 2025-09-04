package br.edu.unoesc.prog2.MARIA.exercicio2;

public class Livro extends Publicacao {
    public Livro(String titulo, int anoPublicacao) { super(titulo, anoPublicacao); }
    @Override public String getTipo() { return "Livro"; }
}
