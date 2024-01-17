package br.com.alura.screenmatch.principal;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.IllegalFormatWidthException;
import java.util.Scanner;

import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.*;

import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComBusca {

	public static void main(String[] args)  {

		Scanner buscaDeFilme = new Scanner(System.in);
		System.out.println("Digite um filme ou série para busca: ");
		var busca = buscaDeFilme.nextLine();
		busca = busca.replaceAll(" ", "+");
		System.out.println("###" + busca + "###");
		try {

			String enderecoHttp = "https://www.omdbapi.com/?t=" + busca + "&apikey=d42fcab8";
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(enderecoHttp)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			System.out.println(json);
			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
			//Titulo meuTitulo = gson.fromJson(json, Titulo.class);
			TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
			System.out.println(meuTituloOmdb);

			Titulo meuTitulo = new Titulo(meuTituloOmdb);
			System.out.println("ja convertido \n" + meuTitulo);
		} catch (IllegalArgumentException | IOException | InterruptedException e){
			System.out.println("Aconteceu um erro: " + e.getMessage());
		} finally

		{
			System.out.println("Acabou!!!");
		}


	}

}
