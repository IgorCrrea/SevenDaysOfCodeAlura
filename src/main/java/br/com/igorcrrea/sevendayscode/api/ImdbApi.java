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
import java.util.List;

import br.com.igorcrrea.sevendayscode.model.Filme;
import br.com.igorcrrea.sevendayscode.model.ParsingFilmes;
import br.com.igorcrrea.sevendayscode.model.ServiceFilme;

public class ImdbApi {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		//HttpRequest cria o corpo da requisicao
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(URI.create("https://imdb-api.com/pt-BR/API/Top250Movies/<chaveImdb>"))
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
		
		List<String> filmesString = ParsingFilmes.parse(json);
		
		List<Filme> filmesObj = ServiceFilme.createFilme(filmesString);
		
		filmesObj.forEach(filme -> {
			System.out.println(filme);
		});

	}
	
}
