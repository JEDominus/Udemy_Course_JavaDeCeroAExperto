package enumeracion;

public enum Continentes {
    //Se va a definir el numero de paises
    AFRICA(53),//Atriuto por variable en constructor
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);//Si vamos a seguir trabajando con atributos, hay que agregar ;
    
    //Podemos agregar atributos y metodos a los elementos
    private final int paises;//Se crea final ya que no queremos qu cambie una vez asignado
    
    //Se debe agregar un constructor con el atributo como argumento para poder asignarle un valor de variable a cada elemento
        //El identificador "public" no esta permitido para constructores
    Continentes(int paises){//Una vez definido el constructor, hay que agregar los valores a los elementos
        this.paises = paises;
    }
    
    //Debido a que paises es privado, ahora debemos crear sus getters y setters
    public int getPaises(){
        return this.paises;//ahora ya se puede acceder a los paises de cada elemento del enumerador
        //Esto con la notacion del punto
    }
}
