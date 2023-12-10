package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void espacamento() {
        System.out.println("""
               
               ||||||||||||||||||||||||||||||||||||||||
               ||||||||||||||||||||||||||||||||||||||||
               """);
    }

    //classe de aplicação
    public static void main(String[] args) {

        espacamento();

        System.out.println("Aba Filme");
        System.out.println();

        Filme filme = new Filme("The Matrix", 1999 );
        //filme.setNome("The Matrix");
        //filme.setAnoDeLancamento(1999);
        filme.setDuracaoEmMinutos(135);
        filme.setIncluidoNoPlano(true);
        filme.avalia(9);
        filme.avalia(8);
        filme.avalia(9);



        Filme filme1 = new Filme("Donnie Darko", 1998);
        //filme1.setNome("Donnie Darko");
        //filme1.setAnoDeLancamento(1998);
        filme1.setDuracaoEmMinutos(160);
        filme1.setIncluidoNoPlano(true);
        filme1.avalia(10);
        filme1.avalia(5);

        var filme2 = new Filme("Clube da luta", 1996);
        //filme2.setNome("Clube da luta");
        //filme2.setAnoDeLancamento(1996);
        filme1.setDuracaoEmMinutos(160);
        filme1.setIncluidoNoPlano(true);
        filme1.avalia(10);
        filme1.avalia(9);

        filme.exibeFichaTecnica();
        espacamento();
        filme1.exibeFichaTecnica();
        espacamento();
        filme2.exibeFichaTecnica();
        espacamento();

        System.out.println("Média de avaliações do filme: " + filme.pegaMedia());
        System.out.println(filme.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações do filme atualizada: " + filme.pegaMedia());

        espacamento();

        System.out.println("Aba Serie");
        System.out.println();

        Serie lost = new Serie("Lost", 2000);
        //lost.setNome("Lost");
        //lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setAtiva(false);
        lost.setMinutosPorEpisodio(50);

        var serie1 = new Serie("Stranger Things", 2012);
        serie1.setTemporadas(5);
        serie1.setEpisodiosPorTemporada(8);
        serie1.setAtiva(true);
        serie1.setMinutosPorEpisodio(60);

        serie1.exibeFichaTecnica();
        espacamento();
        lost.exibeFichaTecnica();
        espacamento();

        System.out.println("Aba Calculadora de tempo");
        System.out.println();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(filme1);
        calculadora.inclui(lost);
        System.out.println("Duração total: " + calculadora.getTempoTotal());

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);

        espacamento();

        System.out.println("Aba Recomendações");
        System.out.println();

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme);
        filtro.filtra(filme1);
        filtro.filtra(episodio);

        espacamento();

        System.out.println("Aba Coleção");
        System.out.println();

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaDeFilmes.get(0).getNome());
        //laço para printar os filmes da lista
        for (int i = 0; i < listaDeFilmes.size(); i++) {
            System.out.println((i + 1) + " Filme da lista: " + listaDeFilmes.get(i).getNome());
        }

        System.out.print("filme: " + listaDeFilmes.get(0).getNome());
        System.out.print("| classificação: " + listaDeFilmes.get(0).getClassificacao() + " estrelas");
        System.out.print("| duração em minutos: " + listaDeFilmes.get(0).getDuracaoEmMinutos());

        System.out.println();
        System.out.println(filme);

    }
}
