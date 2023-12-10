package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalLista {


    public static void main(String[] args) {

        Filme filme1 = new Filme("Barbie",2023);
        Filme filme2 = new Filme("Turma da monica: Laços", 2022);
        Filme filme3 = new Filme("Senhor dos anéis: As duas torres", 2002);
        Titulo filme4 = filme1;
        Serie serie1 = new Serie("Star trek",1972);
        Serie serie2 = new Serie("The Witcher", 2022);

        filme1.avalia(10);
        filme2.avalia(9);
        filme3.avalia(2);
        serie1.avalia(10);
        serie2.avalia(5);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);
        lista.add(serie2);

        System.out.println(lista);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao() + " Estrelas");
            } else if (item instanceof Serie serie && serie.getClassificacao() > 2) {
                System.out.println("Classificação: " + serie.getClassificacao() + " Estrelas");
            } else {
                System.out.println("Classificação não encontrada");
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Robert De Niro");
        buscaPorArtista.add("Nicole Kidman");
        buscaPorArtista.add("Adam Sandler");

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        System.out.println("Lista desordenada: ");
        System.out.println(lista);

        Collections.sort(lista);

        System.out.println("Lista ordenada: ");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista ordenada por ano: ");
        System.out.println(lista);



    }

}