package br.com.alura.lucasfernandes.literalura;

import br.com.alura.lucasfernandes.literalura.API.ConsomeApi;
import br.com.alura.lucasfernandes.literalura.API.ConverteDados;
import br.com.alura.lucasfernandes.literalura.model.Autor;
import br.com.alura.lucasfernandes.literalura.model.DadosLivro;
import br.com.alura.lucasfernandes.literalura.model.Livro;
import br.com.alura.lucasfernandes.literalura.repository.AutorRepository;
import br.com.alura.lucasfernandes.literalura.repository.IdiomaRepository;
import br.com.alura.lucasfernandes.literalura.repository.LivroRepository;
import br.com.alura.lucasfernandes.literalura.service.AutorService;
import br.com.alura.lucasfernandes.literalura.service.IdiomaService;
import br.com.alura.lucasfernandes.literalura.service.LivroService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private IdiomaRepository idiomaRepository;

    private LivroService livroService;
    private AutorService autorService;
    private IdiomaService idiomaService;

    private final String API_URL = "https://gutendex.com/books/";
    private Scanner leitura = new Scanner(System.in);
    private List<DadosLivro> dadosSeries = new ArrayList<>();
    ConsomeApi consomeApi = new ConsomeApi();// private DadosAutor dadosAutor;
    private ConverteDados converteDados = new ConverteDados();

     Principal(LivroService livroService, AutorService autorService, IdiomaService idiomaService){
        this.livroService = livroService;
        this.autorService = autorService;
        this.idiomaService = idiomaService;
     }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar Livro pelo Titulo na Web
                    2 - Listar Livros Registrados
                    3-  Listar Autores Registrados
                    4 - Buscar Autor vivo em determinado ano
                    5 - Buscar Livro pelo idioma
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmDeterminadaData();
                    break;
                case 5:
                    listarLivroPeloIdioma();
                    break;
                case 0:
                    System.out.println("Finalizando a aplicação...");

                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void listarLivroPeloIdioma() {
        System.out.println("Digite qual idioma para pesquisa");
        idiomaService.listarTodosIdiomas();
        var idiomas = leitura.nextLine();
        idiomaService.listarLivroPorIdioma(idiomas);
    }

    private void listarAutoresVivosEmDeterminadaData() {
        System.out.println("Digite a Data do Autor");
        try {
            Integer ano = leitura.nextInt();
            leitura.nextLine();
            autorService.listarAutorPorAnoNascimento(ano);
        } catch (InputMismatchException e) {
            System.out.println("Data invalida ...");
        }
    }

    private void listarAutoresRegistrados() {
        System.out.println("Listando autores registrado:");
        autorService.listarAutores();
    }

    private void listarLivrosRegistrados() {
        System.out.println("Listando livros registrado:");
        livroService.listarLivros();



    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Digite o titulo do livro");
        String livro = leitura.nextLine();
        livroService.adicionaLivro(livro);

    }



}



