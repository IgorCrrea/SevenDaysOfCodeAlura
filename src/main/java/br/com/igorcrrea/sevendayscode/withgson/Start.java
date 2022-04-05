package br.com.igorcrrea.sevendayscode.withgson;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.igorcrrea.sevendayscode.api.ImdbApi;

public class Start {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		try (Scanner scanner = new Scanner(System.in);) {
			
			//entrada da chave
			System.out.println("Digite seu codigo do IMDB:");
			String entrada = scanner.next();
			
			//pega json completo
			String json = ImdbApi.getImbdJson(entrada);
			
			//cria o contrutor Gson
			Gson gson = (new GsonBuilder()).create();
			
			//transforma Json em no Objeto
			Objetos objetos = gson.fromJson(json, Objetos.class);
			
			//pega os itens e printa
			List<Item> item = objetos.getItems();
			item.forEach(System.out::println);
			
			System.out.println("Finalizado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
