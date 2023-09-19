package clases;//Especifdica el nombre del paquete que estamos trabajando

public class Persona {//La clase debe ser publica para acceder desde otro paquete
    //Atributo - caracteristica de una clase
    String nombre;
    String apellido;
    
    //Metodo - Parte de codigo reutilizable mediante llamadas
    //puede recebir valores "argumentos" y puede regresar "valor de retorno"
    public void desplegarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
    }
}
