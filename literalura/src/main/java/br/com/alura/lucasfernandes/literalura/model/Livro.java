package br.com.alura.lucasfernandes.literalura.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long publicId;
    private String title;
    private List<String> subjects;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "livros_idiomas",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "idiomas_id"))
    private List<Idioma> languages;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "livros_pessoas",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoas_id"))
    private List<Autor> autor;
    private Integer downloadCount;

    public Livro() {
    }

    public Livro(Long id, String title, List<String> subjects,
                 List<Idioma> languages, List<Autor> authors, Integer downloadCount) {
        this.publicId = id;
        this.title = title;
        this.subjects = subjects;
        this.languages = languages;
        this.autor = authors;
        this.downloadCount = downloadCount;
    }

    public Livro(DadosLivro bookData) {
        List<Autor> authors = bookData.authors().stream().map(Autor::new).collect(Collectors.toList());
        List<Idioma> languages = bookData.languages().stream().map(Idioma::new).collect(Collectors.toList());

        this.publicId = bookData.id();
        this.title = bookData.title();
        this.subjects = bookData.subjects();
        this.languages = languages;
        this.autor = authors;
        this.downloadCount = bookData.downloadCount();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", publicId=" + publicId +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                ", languages=" + languages +
                ", authors=" + autor +
                ", downloadCount=" + downloadCount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublicId() {
        return publicId;
    }

    public void setPublicId(Long publicId) {
        this.publicId = publicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Idioma> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Idioma> languages) {
        this.languages = languages;
    }

    public List<Autor> getAuthors() {
        return autor;
    }

    public void setAuthors(List<Autor> authors) {
        this.autor = authors;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
