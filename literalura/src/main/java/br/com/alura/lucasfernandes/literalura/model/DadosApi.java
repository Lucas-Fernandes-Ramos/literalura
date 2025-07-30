package br.com.alura.lucasfernandes.literalura.model;

import java.util.List;

public record DadosApi(Integer count,
                       String next,
                       String previous,
                       List<DadosLivro> results) {
}
