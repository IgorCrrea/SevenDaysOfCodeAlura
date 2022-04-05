package br.com.igorcrrea.sevendayscode.model;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class ServiceFilme {
	
	public static List<FilmeRecord> createFilme(List<String> lista){
		
		List<FilmeRecord> listaFilme = new ArrayList<FilmeRecord>();
		
		//percorre todas as linhas da lista passadas pelo construtor
		lista.forEach(f -> {
			
			//regex passado direto no metodo split, ele faz o split sempre que houver a string entre os parenteses -> (":")
			String[] atributo = f.split("\":\"");
			
			FilmeRecord filme = new FilmeRecord(
				//pega cada atributo e remove o que sebrou, pegando apenas a primeira parte da String
				atributo[1].split("\"")[0],
				atributo[2].split("\"")[0],
				atributo[3].split("\"")[0],
				atributo[4].split("\"")[0],
				atributo[5].split("\"")[0],
				atributo[6].split("\"")[0],
				atributo[7].split("\"")[0],
				atributo[8].split("\"")[0],
				atributo[9].split("\"")[0]
			);
			listaFilme.add(filme);
		});
		
		return listaFilme;
	}

}
