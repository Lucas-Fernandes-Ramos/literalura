package br.com.alura.lucasfernandes.literalura.repository;

import br.com.alura.lucasfernandes.literalura.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

    Optional<Idioma> findByLanguage(String language);
}
