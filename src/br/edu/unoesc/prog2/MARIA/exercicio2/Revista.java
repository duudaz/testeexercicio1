package br.edu.unoesc.prog2.MARIA.exercicio2;

public class Revista extends Publicacao {
    public Revista(String titulo, int anoPublicacao) { super(titulo, anoPublicacao); }
    @Override public String getTipo() { return "Revista"; }
}
