package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo {
    //atributos
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    //métodos
    @Override
    public void exibeFichaTecnica(){
        super.exibeFichaTecnica();
        System.out.println("Numero de temporadas: " + temporadas);
        System.out.println("Episodios por temporada: " + episodiosPorTemporada);
        System.out.println("A série está ativa? " + (ativa ? "Sim" : "Não"));
        System.out.println("Minutos por episodio " + minutosPorEpisodio);
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

}
