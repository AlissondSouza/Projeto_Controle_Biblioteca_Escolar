package biblioteca.repository;

import biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroRepository {

    private final List<Livro> livros = new ArrayList<>();

    public void salvar(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarTodos() {
        return new ArrayList<>(livros);
    }

    public Optional<Livro> buscarPorId(int id) {
        return livros.stream().filter(l -> l.getId() == id).findFirst();
    }
}