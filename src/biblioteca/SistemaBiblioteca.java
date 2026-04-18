package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaBiblioteca {

    private List<Livro>      livros     = new ArrayList<>();
    private List<Aluno>      alunos     = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Livro cadastrarLivro(String titulo, String autor, int quantidade) {
        Livro l = new Livro(titulo, autor, quantidade);
        livros.add(l);
        System.out.println("✅ Livro cadastrado: " + l);
        return l;
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public Aluno cadastrarAluno(String nome, String matricula) {
        Aluno a = new Aluno(nome, matricula);
        alunos.add(a);
        System.out.println("✅ Aluno cadastrado: " + a);
        return a;
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    public Emprestimo registrarEmprestimo(Aluno aluno, Livro livro, String data) {
        if (!livro.isDisponivel()) {
            throw new IllegalStateException(
                    "RN03 - Sem exemplares disponíveis do livro '" + livro.getTitulo() + "'.");
        }
        livro.emprestar();
        Emprestimo e = new Emprestimo(aluno, livro, data);
        emprestimos.add(e);
        System.out.println("✅ Empréstimo registrado: " + e);
        return e;
    }

    public void registrarDevolucao(Emprestimo emprestimo, String dataDevolucao) {
        emprestimo.registrarDevolucao(dataDevolucao);
        System.out.println("✅ Devolução registrada: " + emprestimo);
    }

    public List<Emprestimo> consultarEmprestimosEmAberto() {
        return emprestimos.stream()
                .filter(e -> !e.isDevolvido())
                .collect(Collectors.toList());
    }

    public List<Aluno> consultarAlunosComEmprestimosAbertos() {
        return emprestimos.stream()
                .filter(e -> !e.isDevolvido())
                .map(Emprestimo::getAluno)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return new ArrayList<>(emprestimos);
    }
}