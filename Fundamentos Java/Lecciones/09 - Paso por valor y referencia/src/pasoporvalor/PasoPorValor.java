package pasoporvalor;

public class PasoPorValor {
    public static void main(String[] args) {
        pasoPorValor();
    }
    
    public static void pasoPorValor(){//Pasa una copia del valor, solo con tipos primitivos
        //El paso por valor aplica a los tipos primitivos
        //Los tipos primitivos solo pasan una copia de su valor a los demas metodos
        var x = 10;
        System.out.println("x = " + x);
        //Al querer modificar su valor mediante un metodo, solo envia una copia de su valor, por lo que el original permanece
        cambiarValor(x);
        System.out.println("x nuevo valor= " + x);
    }
    
    public static void cambiarValor(int arg1){
        //Se recibe una copia del valor de X
        System.out.println("arg1 = " + arg1);//imprime el mismo valor que se recibe de X = 10
        arg1 = 15;//Al no tener acceso a la variable X, el valor no se actualiza en la variable original, si no en la copia 
    }
   
}
