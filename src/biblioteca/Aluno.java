package biblioteca;

public class Aluno {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("RN07 - O nome do aluno não pode ser vazio.");
        }
        this.id = contadorId++;
        this.nome = nome.trim();
        this.matricula = (matricula != null) ? matricula.trim() : "";
    }

    public int getId()         { return id; }
    public String getNome()    { return nome; }
    public String getMatricula() { return matricula; }

    @Override
    public String toString() {
        return String.format("Aluno{id=%d, nome='%s', matricula='%s'}", id, nome, matricula);
    }
}