package br.com.igorcrrea.sevendayscode.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceFilme {
	
	public static List<Filme> createFilme(List<String> lista){
		List<Filme> listaFilme = new ArrayList<Filme>();
		
		lista.forEach(f -> {
			String[] atributo = f.split("\":\"");
			Filme filme = new Filme();
			filme.setId(atributo[1].split("\"")[0]);
			filme.setRank(atributo[2].split("\"")[0]);
			filme.setTitle(atributo[3].split("\"")[0]);
			filme.setFullTitle(atributo[4].split("\"")[0]);
			filme.setYear(atributo[5].split("\"")[0]);
			filme.setImage(atributo[6].split("\"")[0]);
			filme.setCrew(atributo[7].split("\"")[0]);
			filme.setImDbRating(atributo[8].split("\"")[0]);
			filme.setImDbRatingCount(atributo[9].split("\"")[0]);
			
			listaFilme.add(filme);
		});
		
		return listaFilme;
	}

}
