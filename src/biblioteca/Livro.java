package biblioteca;

public class Livro {

    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String autor;
    private int quantidadeTotal;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidadeTotal) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("RN01 - O título do livro não pode ser vazio.");
        }
        if (quantidadeTotal < 0) {
            throw new IllegalArgumentException("RN02 - A quantidade de livros não pode ser negativa.");
        }
        this.id = contadorId++;
        this.titulo = titulo.trim();
        this.autor = (autor != null) ? autor.trim() : "Desconhecido";
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
    }

    public void emprestar() {
        if (quantidadeDisponivel <= 0) {
            throw new IllegalStateException(
                    "RN03 - Não há exemplares disponíveis do livro '" + titulo + "'.");
        }
        quantidadeDisponivel--;
    }

    public void devolver() {
        if (quantidadeDisponivel >= quantidadeTotal) {
            throw new IllegalStateException(
                    "Todos os exemplares já estão disponíveis. Devolução inválida.");
        }
        quantidadeDisponivel++;
    }

    public boolean isDisponivel() {
        return quantidadeDisponivel > 0;
    }

    public int getId()                    { return id; }
    public String getTitulo()             { return titulo; }
    public String getAutor()              { return autor; }
    public int getQuantidadeTotal()       { return quantidadeTotal; }
    public int getQuantidadeDisponivel()  { return quantidadeDisponivel; }

    @Override
    public String toString() {
        return String.format("Livro{id=%d, titulo='%s', autor='%s', disponivel=%d/%d}",
                id, titulo, autor, quantidadeDisponivel, quantidadeTotal);
    }
}