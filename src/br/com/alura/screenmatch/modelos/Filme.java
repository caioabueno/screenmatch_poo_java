package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    //atributos
    private String diretor;

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

}