package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.apis.BuscaFilme;
import br.com.alura.screenmatch.apis.ConversaoJson;
import br.com.alura.screenmatch.apis.Requisicao;
import br.com.alura.screenmatch.modelos.Titulo;
import java.util.ArrayList;
import java.util.List;


public class PrincipalBusca {
    public static void main(String[] args) {

        Requisicao requisicao = new Requisicao();
        ConversaoJson conversaoJson = new ConversaoJson();
        BuscaFilme buscador = new BuscaFilme();

        List<Titulo> titulos = new ArrayList<>();

        String busca = buscador.getBusca();

        while (!busca.equalsIgnoreCase("sair")) {
            buscador.leBusca();
            busca = buscador.getBusca();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.println("abrindo requisição...");
            requisicao.abreRequisicao(buscador.getEndereco());

            var resposta = requisicao.getResposta();
            System.out.println("resposta da requisição: " + requisicao.getResposta());

            System.out.println("convertendo para objeto...");
            conversaoJson.desserializa(resposta);
            var tituloOmdb = conversaoJson.getObjetoConvertido();
            System.out.println("record convertido: " + tituloOmdb);

            System.out.println("convertendo para objeto local...");
            var titulo = conversaoJson.converteTitulo(tituloOmdb);
            System.out.println("titulo convertido: " + titulo);

            System.out.println("adicionando filma à lista...");
            titulos.add(titulo);
            System.out.println("gravando em arquivo...");
            conversaoJson.gravaTitulo(titulos);

            System.out.println("finalizado.");

        }
        System.out.println(titulos);
        System.out.println("Fim do programa!");
    }
}