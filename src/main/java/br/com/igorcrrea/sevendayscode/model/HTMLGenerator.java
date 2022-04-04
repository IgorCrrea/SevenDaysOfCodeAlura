package br.com.igorcrrea.sevendayscode.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import br.com.igorcrrea.sevendayscode.resources.RecursosEstaticos;

public class HTMLGenerator {

	public static void gerar(List<FilmeRecord> lista) {

		//pega todos os recursos estaticos necessarios
		RecursosEstaticos recursos = new RecursosEstaticos();
		String head = recursos.getHead();
		String divTemplate = recursos.getDivTemplate();
		String footer = recursos.getFooter();

		
		//Usa try with resources para criar e escrever o arquivo
		try(FileWriter file = new FileWriter("index.html");
				PrintWriter writer = new PrintWriter(file);) 
		{
			writer.println(head);
			lista.forEach(f -> {
			
			// usando o template com os dados do filme
			writer.println(String.format(divTemplate,f.rank(), f.title(), f.image(), f.title(), f.imDbRating(),f.year()));
			
			});
			writer.println(footer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}
}
