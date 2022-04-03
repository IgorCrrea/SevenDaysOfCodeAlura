package br.com.igorcrrea.sevendayscode.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ImdbApi {
	
	public static String getImbdJson(String chave) throws IOException, InterruptedException{
		
		//HttpRequest cria o corpo da requisicao
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(URI.create("https://imdb-api.com/pt-BR/API/Top250Movies/"+chave))
	            .header("Content-Type", "application/json")
	            .timeout(Duration.ofMinutes(1))
	            .GET()
	            .build();
		
		//HttpClient executa a requisicao ja criada
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofMinutes(1))
				.followRedirects(Redirect.NORMAL)
				.build();
		
		//HttpResponse eh o retorno da HttpCliente apos fazer a requisicao
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		String json = response.body();
	
		return json;
	}

}
