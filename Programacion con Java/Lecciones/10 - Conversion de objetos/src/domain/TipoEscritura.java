package domain;

//Este enumerador se suara para el atributo en la clase Escritor
public enum TipoEscritura {
    CLASICO("A mano"),
    MODERNO("Digital");
    
    private final String description;
    
    private TipoEscritura(String description){
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
