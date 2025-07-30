package br.com.alura.lucasfernandes.literalura.service;

import br.com.alura.lucasfernandes.literalura.model.Idioma;
import br.com.alura.lucasfernandes.literalura.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepository idiomaRepository;

    public void listarLivroPorIdioma(String idioma){
        Optional<Idioma> novoIdioma = idiomaRepository.findByLanguage(idioma);
         if(novoIdioma.isPresent()){
             novoIdioma.get().getBooks().stream().forEach(System.out::println);
         }else{
             System.out.println("Idioma nao encontrado:");
         }
    }

    public void listarTodosIdiomas(){
        List<Idioma> idiomas = idiomaRepository.findAll();
        idiomas.stream().forEach(System.out::println);
    }
}
