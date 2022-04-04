package br.com.igorcrrea.sevendayscode.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

	public static void gerar(List<FilmeRecord> lista) throws IOException {

		String head = """
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
				</head>
				
				<body class="container" style="background-color: #6c7278">
					<div class="row">	
				""";
		
		String footer= """
					</div>
				</body>

				""";
		
		String divTemplate = """
				<div class=\"card text-white bg-dark mb-3 ml-5 col-md-4\" style=\"max-width: 18rem;\">
						<small class=\"card-header\">Rank #%s</small>
						<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					</div>
				</div>
				""";

		
		try(FileWriter arq = new FileWriter("index.html");
				PrintWriter writer = new PrintWriter(arq);) 
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
