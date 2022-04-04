import java.util.List;
import java.util.Scanner;

import br.com.igorcrrea.sevendayscode.api.ImdbApi;
import br.com.igorcrrea.sevendayscode.model.FilmeRecord;
import br.com.igorcrrea.sevendayscode.model.HTMLGenerator;
import br.com.igorcrrea.sevendayscode.model.ParsingFilmes;
import br.com.igorcrrea.sevendayscode.model.ServiceFilme;

public class inicial {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Digite seu codigo do IMDB:");
			String entrada = scanner.next();
			
			String json = ImdbApi.getImbdJson(entrada);
			
			List<String> filmesJson = ParsingFilmes.parse(json);
			
			List<FilmeRecord> filmes = ServiceFilme.createFilme(filmesJson);
			
			filmes.forEach(System.out::println);
			
			HTMLGenerator.gerar(filmes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
