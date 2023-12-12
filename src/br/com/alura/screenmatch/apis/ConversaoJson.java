package br.com.alura.screenmatch.apis;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConversaoJson {

    private Titulo tituloConvertido;
    private TituloOmdb objetoConvertido;
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    public TituloOmdb desserializa(String json){

        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println("convertido com sucesso.");
        this.objetoConvertido = tituloOmdb;
        return this.objetoConvertido;

    }

    public void gravaTitulo(List titulos){
        try {
            FileWriter fileWriter = new FileWriter("json/filmes.json");
            fileWriter.write(gson.toJson(titulos));
            fileWriter.close();
        } catch (IOException e){
            System.out.println("houve um erro ao escrever no arquivo.\n" + e.getMessage());
        }
    }

    public Titulo converteTitulo(TituloOmdb tituloOmdb){
        Titulo tituloConvertido = new Titulo(tituloOmdb);
        this.tituloConvertido = tituloConvertido;
        System.out.println("titulo convertido com sucesso.");
        return this.tituloConvertido;
    }

    public Titulo getTituloConvertido() {
        return tituloConvertido;
    }

    public TituloOmdb getObjetoConvertido() {
        return objetoConvertido;
    }
}
