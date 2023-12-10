package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;


public class Filme extends Titulo implements Classificavel {
    //atributos
    private String diretor;

    //construtor
    public Filme(String nome, int anoDeLancamento){
        super(nome, anoDeLancamento);
    }

    //métodos
    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }

    //getters setters
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString(){
        //Apresentação antes da classe PrincipalLista ser implementada
//        return "Filme: " + this.getNome() + "\nLançamento (" + this.getAnoDeLancamento() + ")" +
//                "\nDuração em minutos: " + this.getDuracaoEmMinutos() + "\nClassificação: " +
//                this.getClassificacao() + " Estrelas\n";

        return "Filme: " + this.getNome() + " (" + getAnoDeLancamento() + ")";
    }
}