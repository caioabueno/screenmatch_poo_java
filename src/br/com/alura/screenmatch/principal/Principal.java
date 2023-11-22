package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    //classe de aplicação
    public static void main(String[] args) {
        Filme filme = new Filme();
        System.out.println("Aba Filme");
        filme.setNome("The Matrix");
        filme.setAnoDeLancamento(1999);
        filme.setDuracaoEmMinutos(135);
        filme.setIncluidoNoPlano(true);
        filme.avalia(9);
        filme.avalia(8);
        filme.avalia(9);

        Filme filme1 = new Filme();
        filme1.setNome("Donnie Darko");
        filme1.setAnoDeLancamento(1998);
        filme1.setDuracaoEmMinutos(160);
        filme1.setIncluidoNoPlano(true);
        filme1.avalia(10);
        filme1.avalia(5);

        filme.exibeFichaTecnica();
        filme1.exibeFichaTecnica();

        System.out.println("Média de avaliações do filme: " + filme.pegaMedia());
        System.out.println(filme.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações do filme atualizada: " + filme.pegaMedia());

        Serie lost = new Serie();
        System.out.println("Aba Serie");
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setAtiva(false);
        lost.setMinutosPorEpisodio(50);
        lost.exibeFichaTecnica();
        System.out.println("Duração em minutos: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        System.out.println("Aba Calculadora de tempo");
        calculadora.inclui(filme);
        calculadora.inclui(filme1);
        calculadora.inclui(lost);
        System.out.println("Duração total: " + calculadora.getTempoTotal());

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);

        System.out.println("Aba Recomendações");
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme);
        filtro.filtra(filme1);
        filtro.filtra(episodio);
    }
}
