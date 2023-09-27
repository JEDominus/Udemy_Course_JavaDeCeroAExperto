package domain;

//Clase Persona entidad que representa la tabla de la base de datos
public class Persona {
    //Definimos cada columna de la tabala como atributo
        //Asi podremos mapear las columnas con estas propiedad
    private int idPersona;
    private String nombre;//el tipo VarChar es un String
    private String apellido;
    private String email;
    private String telefono;
    
    public Persona(){
        
    }

    //Para el caso de DELETE FROM, solo se requiere el Id
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    //Para el caso de INSERT INTO, no se requiere el Id ya que es autogenerado
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    //Para el caso de UPDATE, si se requieren todos los atributos
    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //Creamos los metodos getter y setter para caad atributo
    public int getIdPersona() {
        return idPersona;
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

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Sobreescribimos metodo toString
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}
