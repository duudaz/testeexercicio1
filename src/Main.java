package br.edu.unoesc.prog2.MARIA.exercicio1;

public class Main {
    public static void main(String[] args) {
        Usuario ana = new Usuario("Ana Silva", "111.222.333-44");
        CartaoTransporte cAna = new CartaoTransporte("ANA-CARD");
        cAna.carregarSaldo(50.0);
        ana.adicionarCartao(cAna);

        Usuario bruno = new Usuario("Bruno Souza", "555.666.777-88");
        CartaoTransporte cBruno = new CartaoTransporte("BRUNO-CARD");
        cBruno.carregarSaldo(8.0);
        bruno.adicionarCartao(cBruno);

        Sistema sistema = new Sistema();

        try {
            sistema.registrarViagem(ana, cAna, new Onibus(4.40));
            sistema.registrarViagem(ana, cAna, new Metro(8, 0.75));
            sistema.registrarViagem(ana, cAna, new BicicletaCompartilhada(30, 0.20));

            // Deve falhar: saldo insuficiente
            sistema.registrarViagem(bruno, cBruno, new Metro(15, 0.80));
        } catch (SaldoInsuficienteException e) {
            System.out.println("Falha na viagem: " + e.getMessage());
        }

        System.out.printf("Saldo Ana: R$ %.2f%n", cAna.getSaldo());
        System.out.printf("Saldo Bruno: R$ %.2f%n", cBruno.getSaldo());

        System.out.println("Totais arrecadados:");
        sistema.getTotaisArrecadados().forEach((tipo, total) ->
                System.out.printf(" - %s: R$ %.2f%n", tipo, total)
        );

        System.out.println("Viagens por usuário:");
        sistema.getViagensPorUsuario().forEach((u, qtd) ->
                System.out.printf(" - %s: %d%n", u, qtd)
        );
    }
}
