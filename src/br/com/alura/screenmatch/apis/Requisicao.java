package br.com.alura.screenmatch.apis;

import br.com.alura.screenmatch.excecoes.ConversaoDeAnoException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Requisicao {

    private String resposta;
    public String abreRequisicao(URI endereco) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("resposta obtida.");
            this.resposta = response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro \n " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento é inválido, verifique se a URL é compativel \n" + e.getMessage());
        } catch (ConversaoDeAnoException e) {
            System.out.println("Ocorreu um erro \n" + e.getMessage());
        }
        return resposta;
    }

    public String getResposta() {
        return resposta;
    }
}

