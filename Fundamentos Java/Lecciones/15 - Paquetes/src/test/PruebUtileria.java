//Este paquete esta a la altura de mx.
package test;

//Al importar una clase de un paquete se tiene acceso a lo que este poublico dentro de dicha clase
//En este caso, con este import ahora ya se tiene acceso al metodo imprimir
//De esta forma se importa solamente la clase Utileria
    //...globalmentory.*; carga en memoria las clases del paquete hasta que son usadas en el programa
    //Es decir, que el .* no sobrecarga la memoria con clases no utilizadas
import mx.com.globalmentory.Utileria;

//Existe otra sintaxis cuando trabajamos con metodos estaticos
//De esta forma ya no se tiene que llamar la clase, si no directamente el metodo
//Al indicat "static" significa que importaremos directamente un atributo o metodo
import static mx.com.globalmentory.Utileria.imprimir;

public class PruebUtileria {
    public static void main(String[] args) {
        imprimirDesdeClaseImprotada();
        imprimirDesdeMetodoEstaticoImportado();
        imprimirDesdeNombreCompletamenteCalificadoSinImport();
    }
    
    public static void imprimirDesdeClaseImprotada(){
        //Como ya se importo el paquete, ahora podemos usar la clase y sus metodos publicos/
        Utileria.imprimir("Imprimiendo desde clase importada");
    }
    
    public static void imprimirDesdeMetodoEstaticoImportado(){
        //Como ya se importo el metodo estatico, solo hay que invocarlo sin el nombre de la clase
        imprimir("Imprimiendo desde metodo estatico importado");
    }
    
    public static void imprimirDesdeNombreCompletamenteCalificadoSinImport(){
        //Se invoca el metodo anotando desde la direccion del paquete... No requiere import
        mx.com.globalmentory.Utileria.imprimir("Imprimiendo desde nombre completamente calificado");
    }     
}
