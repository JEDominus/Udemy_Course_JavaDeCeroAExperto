package domain;

public class Persona {
    private int idPersona;//Id que se va incrementando dado un id a cada objeto
    private String nombre;
    private static int contadorPersonas; //Permite saber cuantos objetos de este tipo se van creando
    
    public Persona(String nombre){//Solo un argummento dado que el contador y el Id se aumentan y setean automaticamente
        this.nombre = nombre;
        //Incrementar el contador por cada objeto agregado
        //this no se recomienda para campos estaticos, dado que trabajan a nivel clase y no objeto
        Persona.contadorPersonas++;//En lugar de this, usamos el nombre de la clase y el atributo estatico.. Se incrementa el valor
        this.idPersona = Persona.contadorPersonas;//Se asigna el valor incrementado
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Agregamos la encapsulacion de lo estatico al final
    public static int getContadorPersonas() {
        return Persona.contadorPersonas;
    }

    public static void setContadorPersonas(int aContadorPersonas) {
        Persona.contadorPersonas = aContadorPersonas;
    }

    //Sobreescritura de un metodo
    @Override//Anotacion para agregar informacion extra al metodo que estamos sobreescribiendo
    public String toString() {
        return "Persona{" + "idPersona=" + this.idPersona + ", nombre=" + this.nombre + '}';
    }
}
