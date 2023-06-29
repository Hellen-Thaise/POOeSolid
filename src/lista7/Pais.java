package lista7;

import java.util.ArrayList;

public class Pais {
    private String codigoISO;
    private String nome;
    private double tamanhoPopulacao;
    private double dimensao;

    private ArrayList<String> vizinhos;

    public Pais(String codigoISO, String nome, double tamanhoPopulacao, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.dimensao = dimensao;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public void setTamanhoPopulacao(double tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public ArrayList<String> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(ArrayList<String> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public double densidade()
    {
        if (dimensao == 0)
            return 0;
        else
            return (double) tamanhoPopulacao / dimensao;
    }

    public boolean equals(Pais p) {
        return codigoISO.equals(p.codigoISO);
    }

    public boolean seVizinho (Pais p){
        return (vizinhos.indexOf(p.codigoISO.toUpperCase()) >= 0);
    }


}
