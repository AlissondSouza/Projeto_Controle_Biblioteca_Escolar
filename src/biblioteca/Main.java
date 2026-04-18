package biblioteca;

import biblioteca.controller.AlunoController;
import biblioteca.controller.EmprestimoController;
import biblioteca.controller.LivroController;
import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.repository.AlunoRepository;
import biblioteca.repository.EmprestimoRepository;
import biblioteca.repository.LivroRepository;
import biblioteca.view.BibliotecaView;

public class Main {

    public static void main(String[] args) {

        BibliotecaView view = new BibliotecaView();

        LivroRepository     livroRepo      = new LivroRepository();
        AlunoRepository     alunoRepo      = new AlunoRepository();
        EmprestimoRepository emprestimoRepo = new EmprestimoRepository();

        LivroController     livroCtrl      = new LivroController(livroRepo);
        AlunoController     alunoCtrl      = new AlunoController(alunoRepo);
        EmprestimoController emprestimoCtrl = new EmprestimoController(emprestimoRepo);

        view.exibirTitulo();

        view.exibirSeparador("Cadastro de Livros");
        Livro dom     = livroCtrl.cadastrar("Dom Casmurro",               "Machado de Assis",          3);
        view.exibirLivroCadastrado(dom);
        Livro pequeno = livroCtrl.cadastrar("O Pequeno Príncipe",         "Antoine de Saint-Exupéry",  2);
        view.exibirLivroCadastrado(pequeno);
        Livro hobbit  = livroCtrl.cadastrar("O Hobbit",                   "J.R.R. Tolkien",            1);
        view.exibirLivroCadastrado(hobbit);
        Livro bola    = livroCtrl.cadastrar("O Auto da Barca do Inferno", "Gil Vicente",               2);
        view.exibirLivroCadastrado(bola);

        view.exibirSeparador("Teste RN01 — Título vazio");
        try {
            livroCtrl.cadastrar("", "Autor X", 5);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirSeparador("Teste RN02 — Quantidade negativa");
        try {
            livroCtrl.cadastrar("Livro Inválido", "Autor Y", -3);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirSeparador("Cadastro de Alunos");
        Aluno ana   = alunoCtrl.cadastrar("Ana Lima",     "2024001");
        view.exibirAlunoCadastrado(ana);
        Aluno bruno = alunoCtrl.cadastrar("Bruno Costa",  "2024002");
        view.exibirAlunoCadastrado(bruno);
        Aluno carla = alunoCtrl.cadastrar("Carla Mendes", "2024003");
        view.exibirAlunoCadastrado(carla);

        view.exibirSeparador("Teste RN07 — Nome do aluno vazio");
        try {
            alunoCtrl.cadastrar("", "2024999");
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirSeparador("Registrar Empréstimos");
        Emprestimo e1 = emprestimoCtrl.registrar(ana,   dom,     "14/04/2026");
        view.exibirEmprestimoRegistrado(e1);
        Emprestimo e2 = emprestimoCtrl.registrar(bruno, pequeno, "14/04/2026");
        view.exibirEmprestimoRegistrado(e2);
        Emprestimo e3 = emprestimoCtrl.registrar(carla, hobbit,  "14/04/2026");
        view.exibirEmprestimoRegistrado(e3);
        Emprestimo e4 = emprestimoCtrl.registrar(ana,   bola,    "14/04/2026");
        view.exibirEmprestimoRegistrado(e4);

        view.exibirSeparador("Teste RN03 — Livro sem estoque (O Hobbit: 1 exemplar)");
        try {
            emprestimoCtrl.registrar(bruno, hobbit, "14/04/2026");
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirEmprestimosEmAberto(emprestimoCtrl.consultarEmAberto());

        view.exibirAlunosComEmprestimosAbertos(emprestimoCtrl.consultarAlunosComEmprestimosAbertos());

        view.exibirSeparador("Registrar Devoluções (RN04)");
        emprestimoCtrl.registrarDevolucao(e2, "15/04/2026");
        view.exibirDevolucaoRegistrada(e2);
        emprestimoCtrl.registrarDevolucao(e3, "15/04/2026");
        view.exibirDevolucaoRegistrada(e3);

        view.exibirSeparador("Estoque após devoluções");
        view.exibirEstoqueLivro(pequeno);
        view.exibirEstoqueLivro(hobbit);

        view.exibirEmprestimosEmAberto(emprestimoCtrl.consultarEmAberto());
        view.exibirAlunosComEmprestimosAbertos(emprestimoCtrl.consultarAlunosComEmprestimosAbertos());

        view.exibirSeparador("Teste — Devolução duplicada");
        try {
            emprestimoCtrl.registrarDevolucao(e2, "16/04/2026");
        } catch (IllegalStateException ex) {
            view.exibirErro(ex.getMessage());
        }

        view.exibirRodape();
    }
}