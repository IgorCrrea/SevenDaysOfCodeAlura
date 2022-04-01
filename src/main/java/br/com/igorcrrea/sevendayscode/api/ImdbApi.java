package br.com.igorcrrea.sevendayscode.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ImdbApi {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		//HttpRequest cria o corpo da requisi��o
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(URI.create("https://imdb-api.com/pt-BR/API/Top250Movies/k_d4347co0"))
	            .header("Content-Type", "application/json")
	            .timeout(Duration.ofMinutes(1))
	            .GET()
	            .build();
		
		//HttpClient executa a requisi��o ja criada
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofMinutes(1))
				.followRedirects(Redirect.NORMAL)
				.build();
		
		//HttpResponse � o retorno da HttpCliente apos fazer a requisicao
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		//System.out.println(response.statusCode());
		//System.out.println(response.headers());
	}
	
}
