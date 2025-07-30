package br.com.alura.lucasfernandes.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        Long id,
        String title,
        List<String> subjects,
        List<String> languages,
        List<DadosAutor> authors,
        @JsonAlias("download_count") Integer downloadCount
) {
}
