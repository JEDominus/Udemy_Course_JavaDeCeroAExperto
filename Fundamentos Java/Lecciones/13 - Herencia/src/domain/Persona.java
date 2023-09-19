package domain;

//Todo lo que sea PRIVATE en esta clase NO SE HEREDA
//Todo lo que sea PROTECTED ene sta clase SI SE HEREDA
public class Persona extends Object{//... extends Object - Todas las clases heredan de object si no heredan de otra
    //Con PROTECTED, als clases hijas podran acceder al atributo/metodo aunque esten en otro 
    protected String nombre;//No se hereda a la clase hija... debera ser publico o protected
    protected char genero;
    protected int edad;//A estos protected attributes se puede acceder si el getter, pero solo los hijos
    protected String direccion;
    //Seleccionar "encapsulate" al crear getters con el IDE, cambi de PROTECTED A PRIVATE ... Inaccesible para hijos 
    
    //PUBLIC - Cualquiera accede, de cualquier paquete
    //PRIVATE - Nadie accede, aun del mismo pauete
    //PROTECTED - solo los hijos acceden, aun de otro paquete
    
    //Los constructores no se heredan a los hijos... pero sona ccesibles mediante super()
    public Persona(){}
    
    public Persona(String nombre){
        this.nombre = nombre;
    }
    
    //Insert code - Constructor - Sellect all attributes
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Insert code - toString - select all
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", direccion=" + direccion + ", Referencia=" + super.toString() + '}';
    }
    
    //Con un super.toString se hara llamada a la clase Object y nos traera la referencia @24876 del objeto en memoria
    
}
