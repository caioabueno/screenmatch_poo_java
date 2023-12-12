package br.com.alura.screenmatch.api;

import java.net.URI;
import java.util.Scanner;

public class BuscaFilme {
    private String busca = "";
    private URI endereco;
    Scanner leitura = new Scanner(System.in);
    public URI leBusca() {

        System.out.println("Digite o nome de um filme:");
        this.busca = leitura.nextLine().replace(" ", "+");
        this.endereco = URI.create("https://www.omdbapi.com/?t=" + busca + "&apikey=bff4088e");
        return this.endereco;
    }

    public String getBusca() {
        return busca;
    }

    public URI getEndereco() {
        return endereco;
    }

}
