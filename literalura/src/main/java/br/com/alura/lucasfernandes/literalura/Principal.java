package br.com.alura.lucasfernandes.literalura;

import java.util.Scanner;

public class Principal {

    private final String API_URL = "https://gutendex.com/books/";
    private Scanner leitura = new Scanner(System.in);
    // private DadosAutor dadosAutor;

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar Livro pelo Titulo na Web
                    2 - Listar Livros Registrados
                    3-  Listar Autores Registrados
                    4 - Buscar Autor vivo pela data de nascimento
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

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void listarLivrosRegistrados() {

    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Buscando livro na api Gutendex");

    }
}
