package exercicio2;

public class Candidato {
    private String nome;
    private String numeroMatricula;
    private double nota;

    public Candidato() {
    }

    public Candidato(String nome, String numeroMatricula, double nota) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
      return "Nome do Candidato: " + nome + "\nNúmero de Matricula: " + numeroMatricula + "\nNota do Candidato: " + nota;
    }
}
