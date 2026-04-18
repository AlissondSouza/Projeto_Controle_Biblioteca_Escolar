package biblioteca.model;

public class Emprestimo {

    private static int contadorId = 1;

    private int id;
    private Aluno aluno;
    private Livro livro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Aluno aluno, Livro livro, String dataEmprestimo) {
        this.id = contadorId++;
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        this.devolvido = false;
    }

    public void registrarDevolucao(String dataDevolucao) {
        if (this.devolvido) {
            throw new IllegalStateException("Este empréstimo já foi devolvido.");
        }
        this.dataDevolucao = dataDevolucao;
        this.devolvido = true;
        this.livro.devolver();
    }

    public int getId()                { return id; }
    public Aluno getAluno()           { return aluno; }
    public Livro getLivro()           { return livro; }
    public String getDataEmprestimo() { return dataEmprestimo; }
    public String getDataDevolucao()  { return dataDevolucao; }
    public boolean isDevolvido()      { return devolvido; }

    @Override
    public String toString() {
        String status = devolvido ? "Devolvido em " + dataDevolucao : "Em aberto";
        return String.format(
                "Emprestimo{id=%d, aluno='%s', livro='%s', emprestado='%s', status='%s'}",
                id, aluno.getNome(), livro.getTitulo(), dataEmprestimo, status);
    }
}