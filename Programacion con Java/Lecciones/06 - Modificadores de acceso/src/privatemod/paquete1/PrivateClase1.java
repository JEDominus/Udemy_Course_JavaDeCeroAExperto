package privatemod.paquete1;

//El atributo privado no se puede aplicar a clases
    //private class... marca error
//Todo lo privado tambien es privado para las demas clases
public class PrivateClase1 {
    //Al ser privado, no se puede acceder ni modificar directamente desde otras clases, requiere getters y setters
    private String atributoPrivado = "Atributo privado desde la misma clase";
    
    //Al ser privado, no se puede usar por otras clases, nisiquiera de las hijas, solo dentro de esta misma clase
    private PrivateClase1(){
        System.out.println("Constructor privado desde la misma clase");
        System.out.println(this.atributoPrivado);
        this.metodoPrivado();
    }
    
    //Al ser privado, no se puede acceder desde otras clases, so0lo dentro de esta misma
    private void metodoPrivado(){
        System.out.println("Metodo privado desde la misma clase");
    }
    
    public PrivateClase1(String arg){
        this();//Llamada al constructor privadod entro de la misma clase
    }
}
