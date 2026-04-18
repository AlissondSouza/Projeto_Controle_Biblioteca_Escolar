package biblioteca.controller;

import biblioteca.model.Livro;
import biblioteca.repository.LivroRepository;

import java.util.List;

public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrar(String titulo, String autor, int quantidade) {
        Livro livro = new Livro(titulo, autor, quantidade);
        repository.salvar(livro);
        return livro;
    }

    public List<Livro> listarTodos() {
        return repository.buscarTodos();
    }
}