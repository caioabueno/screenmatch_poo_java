package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.excecoes.ConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        var busca = "";
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o nome de um filme:");
            busca = leitura.nextLine().replace(" ", "+");

            if(busca.equalsIgnoreCase("sair")){ break; }

            String pesquisa = "https://www.omdbapi.com/?t=" + busca + "&apikey=bff4088e";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(pesquisa))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("objeto já convertido:");
                System.out.println(titulo);

                titulos.add(titulo);

                FileWriter escrita = new FileWriter("filmes.txt");
                escrita.write(titulos.toString());
                escrita.close();

            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro \n " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Argumento é inválido, verifique se a URL é compativel");
                System.out.println(e.getMessage());
            } catch (ConversaoDeAnoException e) {
                System.out.println("Ocorreu um erro \n" + e.getMessage());
            }
        }


        FileWriter fileWriter = new FileWriter("filmes.json");
        fileWriter.write(gson.toJson(titulos));
        fileWriter.close();

        System.out.println(titulos);
        System.out.println("Fim do programa!");

    }
}