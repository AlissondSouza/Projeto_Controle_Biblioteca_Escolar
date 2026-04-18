package biblioteca;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   SISTEMA DE BIBLIOTECA ESCOLAR — PROJETO 1    ");
        System.out.println("=================================================\n");

        SistemaBiblioteca sistema = new SistemaBiblioteca();

        System.out.println("--- Cadastro de Livros ---");
        Livro dom       = sistema.cadastrarLivro("Dom Casmurro",          "Machado de Assis", 3);
        Livro pequeno   = sistema.cadastrarLivro("O Pequeno Príncipe",    "Antoine de Saint-Exupéry", 2);
        Livro hobbit    = sistema.cadastrarLivro("O Hobbit",              "J.R.R. Tolkien", 1);
        Livro bola      = sistema.cadastrarLivro("O Auto da Barca do Inferno", "Gil Vicente", 2);

        System.out.println("\n--- Teste RN01 — Título vazio ---");
        try {
            sistema.cadastrarLivro("", "Autor X", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Teste RN02 — Quantidade negativa ---");
        try {
            sistema.cadastrarLivro("Livro Inválido", "Autor Y", -3);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Cadastro de Alunos ---");
        Aluno ana    = sistema.cadastrarAluno("Ana Lima",     "2024001");
        Aluno bruno  = sistema.cadastrarAluno("Bruno Costa",  "2024002");
        Aluno carla  = sistema.cadastrarAluno("Carla Mendes", "2024003");

        System.out.println("\n--- Teste RN07 — Nome do aluno vazio ---");
        try {
            sistema.cadastrarAluno("", "2024999");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Registrar Empréstimos ---");
        Emprestimo e1 = sistema.registrarEmprestimo(ana,   dom,     "14/04/2026");
        Emprestimo e2 = sistema.registrarEmprestimo(bruno, pequeno, "14/04/2026");
        Emprestimo e3 = sistema.registrarEmprestimo(carla, hobbit,  "14/04/2026");
        Emprestimo e4 = sistema.registrarEmprestimo(ana,   bola,    "14/04/2026");

        System.out.println("\n--- Teste RN03 — Livro sem estoque (O Hobbit: 1 exemplar já emprestado) ---");
        try {
            sistema.registrarEmprestimo(bruno, hobbit, "14/04/2026");
        } catch (IllegalStateException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Empréstimos em Aberto (RN05) ---");
        List<Emprestimo> abertos = sistema.consultarEmprestimosEmAberto();
        abertos.forEach(System.out::println);

        System.out.println("\n--- Alunos com Empréstimos em Aberto (RN06) ---");
        List<Aluno> alunosAbertos = sistema.consultarAlunosComEmprestimosAbertos();
        alunosAbertos.forEach(System.out::println);

        System.out.println("\n--- Registrar Devolução (RN04) ---");
        sistema.registrarDevolucao(e2, "15/04/2026");
        sistema.registrarDevolucao(e3, "15/04/2026");


        System.out.println("\n--- Estoque após devoluções ---");
        System.out.println(pequeno);
        System.out.println(hobbit);

        System.out.println("\n--- Empréstimos em Aberto após Devoluções (RN05) ---");
        sistema.consultarEmprestimosEmAberto().forEach(System.out::println);

        System.out.println("\n--- Alunos com Empréstimos em Aberto após Devoluções (RN06) ---");
        sistema.consultarAlunosComEmprestimosAbertos().forEach(System.out::println);

        System.out.println("\n--- Teste: devolução duplicada ---");
        try {
            sistema.registrarDevolucao(e2, "16/04/2026");
        } catch (IllegalStateException ex) {
            System.out.println("❌ Erro esperado: " + ex.getMessage());
        }

        System.out.println("\n=================================================");
        System.out.println("   FIM DA SIMULAÇÃO — PROJETO 1                 ");
        System.out.println("=================================================");
    }
}