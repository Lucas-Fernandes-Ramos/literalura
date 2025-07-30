package br.com.alura.lucasfernandes.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.lucasfernandes.literalura.model.Autor;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String name);
    @Query("SELECT p FROM Autor p WHERE p.anoNascimento <= :year AND p.anoFalecimento >= :year")
    Optional<List<Autor>> listarAutorPorAnoNascimento(Integer year);
}