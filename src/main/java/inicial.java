import java.util.List;

import br.com.igorcrrea.sevendayscode.api.ImdbApi;
import br.com.igorcrrea.sevendayscode.model.FilmeRecord;
import br.com.igorcrrea.sevendayscode.model.HTMLGenerator;
import br.com.igorcrrea.sevendayscode.model.ParsingFilmes;
import br.com.igorcrrea.sevendayscode.model.ServiceFilme;

public class inicial {

	public static void main(String[] args) {
		
		try {
			String json = ImdbApi.getImbdJson("k_d4347co0");
			
			List<String> filmesString = ParsingFilmes.parse(json);
			
			List<FilmeRecord> filmesObj = ServiceFilme.createFilme(filmesString);
			
			filmesObj.forEach(filme -> {
				System.out.println(filme);
			});
			
			HTMLGenerator.gerar(filmesObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
