package br.edu.unoesc.prog2.MARIA.exercicio2;

public abstract class Publicacao {
    private final String titulo;
    private final int anoPublicacao;
    private boolean disponivel = true;

    protected Publicacao(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() { return titulo; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public boolean isDisponivel() { return disponivel; }
    void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("%s: \"%s\" (%d)", getTipo(), titulo, anoPublicacao);
    }
}
