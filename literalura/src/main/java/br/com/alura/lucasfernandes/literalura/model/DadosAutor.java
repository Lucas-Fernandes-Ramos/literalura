package br.com.alura.lucasfernandes.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
        Long id,
        @Column(unique = true)
        String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear
) {
}
