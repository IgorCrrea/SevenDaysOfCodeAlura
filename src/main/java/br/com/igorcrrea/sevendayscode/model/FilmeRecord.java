package br.com.igorcrrea.sevendayscode.model;

import br.com.igorcrrea.sevendayscode.interfaces.Content;

//Record eh usado para classes que serao so como DTO (uma classe apenas com getters, setters e construtores
//todos seus atributos são private final, ou seja, sao imutaveis
//voce seta no construtor e faz o get por um metodo criado pelo compilador, que tem o mesmo nome do atributo, ex: String nome;  nome()
//tamebem ja implementa os metodos equals, hashcode e toString.

//Obs. voce pode criar seus contrutores tambem, caso queira fazer parsing de valores, ou definir valores padrão caso não sejam passados e etc.
public record FilmeRecord(
		String id,
		Integer rank,
		String title,
		String fullTitle,
		Integer year,
		String image,
		String crew,
		Double imDbRating,
		Double imDbRatingCount) implements Content {
	
	public FilmeRecord(
			String id,
			String rank,
			String title,
			String fullTitle,
			String year,
			String image,
			String crew,
			String imDbRating,
			String imDbRatingCount) {
		this(id, Integer.valueOf(rank), title, fullTitle, Integer.valueOf(year), image, crew, Double.valueOf(imDbRating), Double.valueOf(imDbRatingCount));
	}
	
	@Override
	public String toString() {
		return rank+" | "+fullTitle+" | "+imDbRating;
	}

}
