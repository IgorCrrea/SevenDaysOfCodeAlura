import java.util.List;

import br.com.igorcrrea.sevendayscode.api.ImdbApi;
import br.com.igorcrrea.sevendayscode.model.FilmeRecord;
import br.com.igorcrrea.sevendayscode.model.ParsingFilmes;
import br.com.igorcrrea.sevendayscode.model.ServiceFilme;

public class inicial {

	public static void main(String[] args) {
		
		try {
			String json = ImdbApi.getImbdJson("<Sua Chave>");
			
			List<String> filmesString = ParsingFilmes.parse(json);
			
			List<FilmeRecord> filmesObj = ServiceFilme.createFilme(filmesString);
			
			filmesObj.forEach(filme -> {
				System.out.println(filme);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}