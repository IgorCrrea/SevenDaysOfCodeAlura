import java.util.List;
import java.util.Scanner;

import br.com.igorcrrea.sevendayscode.api.ImdbApi;
import br.com.igorcrrea.sevendayscode.model.FilmeRecord;
import br.com.igorcrrea.sevendayscode.model.HTMLGenerator;
import br.com.igorcrrea.sevendayscode.model.ParsingFilmes;

public class inicial {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in);) {
			
			//entrada da chave
			System.out.println("Digite seu codigo do IMDB:");
			String entrada = scanner.next();
			
			String json = ImdbApi.getImbdJson(entrada);
			List<FilmeRecord> filmesJson = new ParsingFilmes().parse(json);
			//filmesJson.forEach(System.out::println);
			HTMLGenerator.gerar(filmesJson);
			
			System.out.println("Finalizado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
