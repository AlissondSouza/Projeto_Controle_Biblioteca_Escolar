package biblioteca.repository;

import biblioteca.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoRepository {

    private final List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> buscarTodos() {
        return new ArrayList<>(alunos);
    }

    public Optional<Aluno> buscarPorId(int id) {
        return alunos.stream().filter(a -> a.getId() == id).findFirst();
    }
}