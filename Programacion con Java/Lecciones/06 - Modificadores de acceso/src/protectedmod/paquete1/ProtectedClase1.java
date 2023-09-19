package protectedmod.paquete1;

//El modificador protected no aplica a nivel clase 
    //protected class... Marca error
public class ProtectedClase1 {
    //Atributo heredadop solo para clases hijas
    protected String atributoProtected = "Atributo protected";
    
    //Constructor accesible solo para clases hijas "No heredad" pero accesible
    protected ProtectedClase1(){
        System.out.println("Constructor protected");
    }
    
    //Metodo heredado solo para clases hijas
    protected void metodoProtected(){
        System.out.println("Metodo protected");
    }
}
