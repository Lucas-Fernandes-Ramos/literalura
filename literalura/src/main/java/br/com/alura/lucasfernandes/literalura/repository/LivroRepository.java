package br.com.alura.lucasfernandes.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.lucasfernandes.literalura.model.Livro;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByPublicId(Long publicId);
}