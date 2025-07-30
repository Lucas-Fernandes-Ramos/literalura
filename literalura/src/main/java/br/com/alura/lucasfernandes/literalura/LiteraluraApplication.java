package br.com.alura.lucasfernandes.literalura;

import br.com.alura.lucasfernandes.literalura.repository.AutorRepository;
import br.com.alura.lucasfernandes.literalura.repository.LivroRepository;
import br.com.alura.lucasfernandes.literalura.service.AutorService;
import br.com.alura.lucasfernandes.literalura.service.IdiomaService;
import br.com.alura.lucasfernandes.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private AutorService autorService;
	@Autowired
   private IdiomaService idiomaService;
	@Autowired
   private LivroService livroService;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroService, autorService, idiomaService);
		principal.exibeMenu();

	}
}
