package operaciones;

public class Operaciones {
    //Se crea de tipo static para no tener que instanciar el objeto operaciones
    //Si solo es este metodo, no aplica la sobrecarga de metodos
    public static int sumar(int a, int b){
        System.out.println("Sumando con ints");
        return a + b;
    }
    
    //Mismo nombre, mismos argumentos pero diferente tipo de dato de retorno y de argumentos
    //A esto se le conoce como sobrecarga de metodo
    //Como el anterior es public, este no puede ser private o default, tiene que se public tambien 
    public static double sumar(double a, double b){
        System.out.println("Sumando con doubles");
        return a + b;
    }
}
