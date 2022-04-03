package br.com.igorcrrea.sevendayscode.model;

import java.util.ArrayList;
import java.util.List;

public class ParsingFilmes {
	
	public static List<String> parse(String json) {
		
		List<String> lista = new ArrayList<String>();
		
		// faz o parsing do json inteiro deixando apesas o conteudo de dentro dos colchetes
		Integer firstBracket = json.indexOf("[")+1;
		Integer lastBracket = json.indexOf("]");
		String parse = json.substring(firstBracket, lastBracket);
		
		//separa cada linha objeto json
		String[] split = parse.split("}");
		
		//remove a virgula e chaves que ficaram junto com o objeto
		for (String filme : split) {
			
			if (filme.charAt(0) == ',') {
				filme = filme.replaceFirst(",", "");
			}
			filme = filme.substring(1);
			
			lista.add(filme);
		}
		
		return lista;
	}

}
