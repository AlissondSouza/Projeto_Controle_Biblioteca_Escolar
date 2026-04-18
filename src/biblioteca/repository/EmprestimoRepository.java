package biblioteca.repository;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoRepository {

    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void salvar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> buscarTodos() {
        return new ArrayList<>(emprestimos);
    }

    public List<Emprestimo> buscarEmAberto() {
        return emprestimos.stream()
                .filter(e -> !e.isDevolvido())
                .collect(Collectors.toList());
    }

    public List<Aluno> buscarAlunosComEmprestimosAbertos() {
        return emprestimos.stream()
                .filter(e -> !e.isDevolvido())
                .map(Emprestimo::getAluno)
                .distinct()
                .collect(Collectors.toList());
    }
}