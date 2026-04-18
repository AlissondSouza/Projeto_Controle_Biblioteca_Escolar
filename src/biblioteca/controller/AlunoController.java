package biblioteca.controller;

import biblioteca.model.Aluno;
import biblioteca.repository.AlunoRepository;

import java.util.List;

public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno cadastrar(String nome, String matricula) {
        Aluno aluno = new Aluno(nome, matricula);
        repository.salvar(aluno);
        return aluno;
    }

    public List<Aluno> listarTodos() {
        return repository.buscarTodos();
    }
}