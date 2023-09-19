package domain;

public class Persona {
    private final int idPersona;//Variable no estatica
    private static int contadorPersonas;//Variable estatica
    
    //Bloque de inicializacion estatico
    //Se ejecuta ANTES del constructor y ANTES de los bloques no estaticos
        //Este bloque se ejecuta cuando se carga la clase en memoria 1 SOLA VEZ (Contexto estatico)
    static{//no requiere mas que la palabra static - bloque estatico
        //Se puede aprtovbechar para inicializar variables estaticas nadamas
        System.out.println("1.- Ejecucion de bloque estatico: contexto estatico");
        ++Persona.contadorPersonas;//podemos aprovechar para incrementar variables estaticas
        //idPersona no se puede acceder aqui porque no es estatico
    }
    
    //Bloque de inicializacion no estatico
    //Se ejecuta ANTES del constructor pero DESPUES del bloque ESTATICO
        //Este bloque se ejecuta CADA QUE SE CREA UN OBJETO (Contexto Dinamico)
    {
        System.out.println("2.- Ejecucion de bloque no estatico: contexto dinamico");
        this.idPersona = Persona.contadorPersonas++;//Ahora ya tenemos acceso al operador this, contexto dinamico
        //ahora se deb hacer el postincremento ya que el pre solo se ejecuta 1 vez, el post incrementara la proxima lectura
    }
    
    public Persona(){
        System.out.println("3.- Ejecucion del constructor");
    }
    
    public int getIdPersona(){
        return this.idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + '}';
    }
}
