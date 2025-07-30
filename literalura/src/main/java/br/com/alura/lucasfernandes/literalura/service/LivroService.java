package br.com.alura.lucasfernandes.literalura.service;

import br.com.alura.lucasfernandes.literalura.API.ConsomeApi;
import br.com.alura.lucasfernandes.literalura.API.ConverteDados;
import br.com.alura.lucasfernandes.literalura.model.*;
import br.com.alura.lucasfernandes.literalura.repository.AutorRepository;
import br.com.alura.lucasfernandes.literalura.repository.IdiomaRepository;
import br.com.alura.lucasfernandes.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private IdiomaRepository idiomaRepository;
    private ConsomeApi consomeDadosApi = new ConsomeApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/";



    public void adicionaLivro(String nomeLivro) {


        var json = consomeDadosApi.obterDados(nomeLivro.replace(" ", "%20"));

        DadosApi dadosApi = converteDados.obterDados(json, DadosApi.class);

        System.out.println(json.toString());
        System.out.println(ENDERECO);
        System.out.println(dadosApi);

        if (dadosApi.count() > 0) {
            salvaLivro(dadosApi.results());
            while (dadosApi.next() != null) {
                json = consomeDadosApi.obterDados(ENDERECO);
                dadosApi = converteDados.obterDados(json, DadosApi.class);
                salvaLivro(dadosApi.results());
            }
        }

    }

    private void salvaLivro(List<DadosLivro> livros) {
        livros.stream().forEach(livro -> {
                    Livro novoLivro = new Livro(livro);
                    Optional<Livro> livroRistrado = livroRepository.findByPublicId(novoLivro.getPublicId());
                    if (!livroRistrado.isPresent()) {
                        try {
                            List<Autor> authors = novoLivro.getAuthors().stream()
                                    .map(author -> {
                                        Optional<Autor> isAuthorThere = autorRepository
                                                .findByNome(author.getNome());
                                        if (isAuthorThere.isPresent()) {
                                            return isAuthorThere.get();
                                        } else {
                                            autorRepository.save(author);
                                            return author;
                                        }
                                    })
                                    .collect(Collectors.toList());

                            List<Idioma> languages = novoLivro.getLanguages().stream()
                                    .map(language -> {
                                        Optional<Idioma> isLanguageThere = idiomaRepository.findByLanguage(language.getLanguage());

                                        if (isLanguageThere.isPresent()) {
                                            return isLanguageThere.get();
                                        } else {
                                            idiomaRepository.save(language);
                                            return language;
                                        }
                                    }).collect(Collectors.toList());

                            novoLivro.setAuthors(authors);
                            novoLivro.setLanguages(languages);

                            livroRepository.save(novoLivro);
                        } catch (DataIntegrityViolationException e) {
                            System.out.println("Livro já existe na base de dados");
                        }
                    }

                    System.out.println(novoLivro);
                }
        );

    }

    public void listarLivros() {
        livroRepository.findAll().stream().forEach(System.out::println);


    }
}