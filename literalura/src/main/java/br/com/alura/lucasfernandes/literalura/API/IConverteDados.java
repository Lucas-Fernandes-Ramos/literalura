package br.com.alura.lucasfernandes.literalura.API;

public interface IConverteDados {

    <T> T  obterDados(String json, Class<T> classe);
}
