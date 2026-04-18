package biblioteca.view;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;

import java.util.List;

public class BibliotecaView {

    public void exibirTitulo() {
        System.out.println("=================================================");
        System.out.println("   SISTEMA DE BIBLIOTECA ESCOLAR — PROJETO 2    ");
        System.out.println("              (Padrão MVC)                       ");
        System.out.println("=================================================\n");
    }

    public void exibirLivroCadastrado(Livro livro) {
        System.out.println("✅ Livro cadastrado: " + livro);
    }

    public void exibirAlunoCadastrado(Aluno aluno) {
        System.out.println("✅ Aluno cadastrado: " + aluno);
    }

    public void exibirEmprestimoRegistrado(Emprestimo emprestimo) {
        System.out.println("✅ Empréstimo registrado: " + emprestimo);
    }

    public void exibirDevolucaoRegistrada(Emprestimo emprestimo) {
        System.out.println("✅ Devolução registrada: " + emprestimo);
    }

    public void exibirErro(String mensagem) {
        System.out.println("❌ Erro: " + mensagem);
    }

    public void exibirSeparador(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }

    public void exibirEmprestimosEmAberto(List<Emprestimo> emprestimos) {
        exibirSeparador("Empréstimos em Aberto (RN05)");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo em aberto.");
        } else {
            emprestimos.forEach(System.out::println);
        }
    }

    public void exibirAlunosComEmprestimosAbertos(List<Aluno> alunos) {
        exibirSeparador("Alunos com Empréstimos em Aberto (RN06)");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno com empréstimos em aberto.");
        } else {
            alunos.forEach(System.out::println);
        }
    }

    public void exibirEstoqueLivro(Livro livro) {
        System.out.println("📚 Estoque atualizado: " + livro);
    }

    public void exibirRodape() {
        System.out.println("\n=================================================");
        System.out.println("   FIM DA SIMULAÇÃO — PROJETO 2 (MVC)           ");
        System.out.println("=================================================");
    }
}