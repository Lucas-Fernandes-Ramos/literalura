package br.com.alura.lucasfernandes.literalura.service;

import br.com.alura.lucasfernandes.literalura.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.lucasfernandes.literalura.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;


    public void listarAutores() {
        autorRepository.findAll()
                .stream()
                .forEach(System.out::println);
    }

    public void listarAutorPorAnoNascimento(Integer ano) {
        Optional<List<Autor>> autorNascimento = autorRepository.listarAutorPorAnoNascimento(ano);
        if (autorNascimento.isPresent()) {
            autorNascimento.get().forEach(System.out::println);
        } else {
            System.out.println("Autor não encontrado");
        }
    }

    public void listarAnoAutor(Integer ano) {
        Optional<List<Autor>> autorVivo = autorRepository.listarAutorPorAnoNascimento(ano);
        if (autorVivo.isPresent()) {
            autorVivo.get().stream().forEach(System.out::println);

        } else {
            System.out.println("Autor nao encontrado na data informada:");
        }
    }
}