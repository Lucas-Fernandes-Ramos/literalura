package br.com.alura.lucasfernandes.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "idiomas")
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
    @ManyToMany(mappedBy = "languages", fetch = FetchType.EAGER)
    private List<Livro> books;

    public Idioma() {
    }

    public Idioma(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Livro> getBooks() {
        return books;
    }

    public void setBooks(List<Livro> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return this.language;
    }
}
