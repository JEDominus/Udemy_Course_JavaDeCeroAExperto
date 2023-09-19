package publicmod.paquete1;

//clase publica accesible desde cualquier otra clase
public class PublicClase1 {
    //Atributo publico accesible desde cualquier otra clase
    public String atributoPublico = "Atributo Publico";
    
    //Constructor publico accesible desde cualquier otra clase
    public PublicClase1(){
        System.out.println("Constructor publico");
    }
    
    //Metodo publico accesible desde cualquier otro objeto de este tipo en cualquier otra clase
    public void metodoPublico(){
        System.out.println("Metodo publico");
    }
}
