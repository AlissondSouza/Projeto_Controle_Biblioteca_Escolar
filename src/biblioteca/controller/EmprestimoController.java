package biblioteca.controller;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.repository.EmprestimoRepository;

import java.util.List;

public class EmprestimoController {

    private final EmprestimoRepository repository;

    public EmprestimoController(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public Emprestimo registrar(Aluno aluno, Livro livro, String data) {
        if (!livro.isDisponivel()) {
            throw new IllegalStateException(
                    "RN03 - Sem exemplares disponíveis do livro '" + livro.getTitulo() + "'.");
        }
        livro.emprestar();
        Emprestimo emprestimo = new Emprestimo(aluno, livro, data);
        repository.salvar(emprestimo);
        return emprestimo;
    }

    public void registrarDevolucao(Emprestimo emprestimo, String dataDevolucao) {
        emprestimo.registrarDevolucao(dataDevolucao);
    }

    public List<Emprestimo> consultarEmAberto() {
        return repository.buscarEmAberto();
    }

    public List<Aluno> consultarAlunosComEmprestimosAbertos() {
        return repository.buscarAlunosComEmprestimosAbertos();
    }

    public List<Emprestimo> listarTodos() {
        return repository.buscarTodos();
    }
}