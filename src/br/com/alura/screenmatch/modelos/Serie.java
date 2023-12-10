package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Serie extends Titulo implements Classificavel {
    //atributos
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    //métodos
    @Override
    public void exibeFichaTecnica(){
        super.exibeFichaTecnica();
        System.out.println("Numero de temporadas: " + temporadas);
        System.out.println("Episodios por temporada: " + episodiosPorTemporada);
        //operador ternário
        System.out.println("A série está ativa? " + (ativa ? "Sim" : "Não"));
        System.out.println("Minutos por episodio " + minutosPorEpisodio);
        System.out.println("Duração em minutos: " + getDuracaoEmMinutos());
    }

    @Override
    public int getDuracaoEmMinutos(){
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }


    //getters setters
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public String toString(){
        return "Série: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }

    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }
}
