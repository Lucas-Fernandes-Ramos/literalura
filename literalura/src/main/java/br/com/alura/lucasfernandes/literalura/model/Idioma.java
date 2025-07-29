package br.com.alura.lucasfernandes.literalura.model;

public enum Idioma {
    es("Espanhol"),
    en("Ingles"),
    fr("Frances"),
    pt("Portugues"),
    nd("Não disponivel"),
    ;

    private String idiomaCompleto;

    Idioma(String idiomaCompleto) {
        this.idiomaCompleto = idiomaCompleto;
    }

    public static Idioma stringToEnum(String idioma) {
        for (Idioma item : Idioma.values()) {
            if (item.name().equalsIgnoreCase(idioma)) {
                return item;
            }
        }
        return nd;
    }
    public static void listarIdiomas(){
        for (Idioma idioma:Idioma.values()){
            System.out.println(idioma.name()+" - "+idioma.getIdiomaCompleto());
        }
    }
    public String getIdiomaCompleto() {
        return idiomaCompleto;
    }
}
