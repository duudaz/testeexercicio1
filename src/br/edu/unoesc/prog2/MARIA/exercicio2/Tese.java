package br.edu.unoesc.prog2.MARIA.exercicio2;

public class Tese extends Publicacao {
    public Tese(String titulo, int anoPublicacao) { super(titulo, anoPublicacao); }
    @Override public String getTipo() { return "Tese"; }
}

