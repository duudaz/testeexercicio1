package br.edu.unoesc.prog2.MARIA.exercicio2;

public class Main {
    public static void main(String[] args) {
        Usuario ana = new Usuario("Ana");
        Usuario bruno = new Usuario("Bruno");

        Publicacao livro   = new Livro("Clean Code", 2008);
        Publicacao revista = new Revista("Science - Vol. 1", 2024);
        Publicacao tese    = new Tese("IA na Educação", 2023);

        Biblioteca bib = new Biblioteca();
        bib.adicionar(livro);
        bib.adicionar(revista);
        bib.adicionar(tese);

        try {
            bib.emprestar(livro, ana);
            bib.emprestar(revista, ana);
            // Vai falhar: livro já emprestado para Ana
            bib.emprestar(livro, bruno);
        } catch (ExemplarIndisponivelException e) {
            System.out.println("Falha no empréstimo: " + e.getMessage());
        }

        System.out.println("\nEmpréstimos de Ana:");
        bib.listarEmprestimos(ana).forEach(System.out::println);

        System.out.println("\nDevolução do livro pela Ana...");
        bib.devolver(livro, ana);

        try {
            // Agora deve dar certo
            bib.emprestar(livro, bruno);
        } catch (ExemplarIndisponivelException e) {
            System.out.println("Falha no empréstimo: " + e.getMessage());
        }

        System.out.println("\nEmpréstimos de Bruno:");
        bib.listarEmprestimos(bruno).forEach(System.out::println);
    }
}
