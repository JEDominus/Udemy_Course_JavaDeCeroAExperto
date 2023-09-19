package test;

public class TestArgumentosVariables {
    public static void main(String[] args) {
        argumentosVariables();
    }
    
    public static void argumentosVariables(){
        //Es cuando vamos a pasar una argumento a un metodo
        //Cona rgumentos variables, no se tiene que especificar cuantos valores se le van a pasar al metodo
        //Tamaño de argumentos dinamico 
        
        //Se definieron 5 argumentos mediante argumentos variables
        imprimirNumeros(8,9);
        //Sin embargo podrian ser mas o menos indefinidamente
        imprimirNumeros(1,2,3);
        
        //enviar varios argumentos a un metodo con argumentos variables
        variosArgumentos("Javier", 4,5,6);
    }
    
    //Para definir argumentos variables, hay que poner el tipo de datos y 3 puntos
        //Al momento de recibir, el argumento se convierte en arreglo
        //A diferencia de pasar un arreglo int[] numeros... ya deberiamos saber el numero de elementos
            //varags, no requiere saber el numero de args, el arreglo si
    private static void imprimirNumeros(int... numeros){
        //Se itera el argumento variable como un array
        for (int i = 0; i < numeros.length; i++) {//La cantidad de elementos es indefinida hasta que se recibe el argumento
            System.out.println("Argumento variable " + i + ": " + numeros[i]);
        }        
    }
    
    //en caso de tener mas argumentos, el argumento variable debe ser el ultimo
    private static void variosArgumentos(String nombre, int... numeros){
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
    }
}
