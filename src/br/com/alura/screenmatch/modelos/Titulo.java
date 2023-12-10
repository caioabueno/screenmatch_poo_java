package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecoes.ConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {
    //atributos
    //@SerializedName("Title")
    private String nome;
    //@SerializedName("Year")
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    //construtores
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        //trata os dados recebidos via record TituloOmdb
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length() > 4){
            throw new ConversaoDeAnoException
                    ("não é possivel converter o ano de lançamento," +
                            "o ano possui mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,2));
    }

    //métodos
    public void exibeFichaTecnica() {
        System.out.println("Nome do título: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    //getters setters
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome = " + nome +
                ", ano de lançamento = " + anoDeLancamento +
                ", duração em minutos = " + duracaoEmMinutos + ")";
    }
}
