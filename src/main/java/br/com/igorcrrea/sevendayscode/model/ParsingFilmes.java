package br.com.igorcrrea.sevendayscode.model;

import java.util.ArrayList;
import java.util.List;

public class ParsingFilmes {
	
	List<String> lista;
	
	public static List<String> parse(String json) {
		List<String> lista = new ArrayList<String>();
		Integer firstBracket = json.indexOf("[")+1;
		Integer lastBracket = json.indexOf("]");
		
		String parse = json.substring(firstBracket, lastBracket);
		
		String[] split = parse.split("}");
		
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
