
import java.util.Scanner;


public class SentenciasDeControl {

    public static void main(String args[]) {
        //estructuraDeControlIfElse();
        //ejercicioIfElse();
        //calculoDeEstacionIfElse();
        //sentenciaSwitch();
        //calculoDeEstacionSwitch();
        tareaSistemaDeCalificaciones();
    }

    private static void estructuraDeControlIfElse() {
        //Esta comprobacion es de tipo booleana
        var condition = false;

        if (condition) {
            System.out.println("Condicion verdadera");
        } else {
            System.out.println("Condicion falsa"); //La condicione hecuta esto
        }
    }
    
    private static void ejercicioIfElse(){
        var numero = 3;
        var numeroTexto = "Numero desconocido";
        
        if(numero == 1){
            numeroTexto = "Numero Uno";
        }else if(numero == 2){
            numeroTexto = "Numero Dos";
        }else if(numero == 3){
            numeroTexto = "Numero Tres";
        }else if(numero == 4){
            numeroTexto = "Numero Cuatro";
        }else{
            numeroTexto = "Numero no encotrado";
        }
        
        System.out.println("numeroTexto = " + numeroTexto); // Imprime Numero 3
    }
    
    private static void calculoDeEstacionIfElse(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese el numero de mes");
        var mes = Integer.parseInt(consola.nextLine());//Usuario ingresa numero
        var estacion = "Estacion Desconocida";
        
        if(mes == 1 || mes == 2 || mes == 12){
            estacion = "Invierno";
        }else if(mes == 3 || mes == 4 || mes == 5){
            estacion = "Primavera";
        }else if(mes == 6 || mes == 7 || mes == 8){
            estacion = "Verano";
        }else if(mes == 9 || mes == 10 || mes == 11){
            estacion = "Otoño";
        }
        
        System.out.println("estacion = " + estacion);
    }
    
    private static void sentenciaSwitch(){
        //Esta comprobacion puede ser de tipo numericda o string 
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa un numero:");
        var numero = Integer.parseInt(consola.nextLine());
        var numeroTexto = "Numero desconocido";
        
        switch(numero){
            case 1://Comprobacion numerica
                numeroTexto = "UNO";
                break;//Termina de comprobar los demas casos
            case 2:
                numeroTexto = "DOS";
                break;
            case 3:
                numeroTexto = "TRES";
                break;
            case 4:
                numeroTexto = "CUATRO";
                break;
            default:
                numeroTexto = "Caso no encontrado";
                //No requiere break dado que es el ultimo caso
        }
        
        System.out.println("numeroTexto = " + numeroTexto);
    }
    
    private static void calculoDeEstacionSwitch(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa el mes del año");
        var mes = Integer.parseInt(consola.nextLine());
        var estacion = "Estacion desconocida";
        
        switch (mes){
            case 1: case 2: case 12:
                estacion = "Invierno";
                break;
            case 3: case 4: case 5:
                estacion = "Primavera";
                break;
            case 6: case 7: case 8:
                estacion = "Verano";
                break;
            case 9: case 10: case 11:
                estacion = "Otoño";
                break;
            default:
                estacion = "CAso no encontrado";
        }
        
        System.out.println("estacion = " + estacion);
    }
    
    private static void tareaSistemaDeCalificaciones(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Proporciona un valor entre 0 y 10:");
        int numero = Integer.parseInt(consola.nextLine());
        String calificacion = "X";
        
        if(numero >= 0 && numero <6){
            calificacion = "F";
        }else if(numero >= 6 && numero <7){
            calificacion = "D";            
        }else if(numero >= 7 && numero <8){
            calificacion = "C";            
        }else if(numero >= 8 && numero <9){
            calificacion = "B";            
        }else if(numero >= 9 && numero <=10){
            calificacion = "A";            
        }else{
            calificacion = "Calificacion incalculable";
        }
        
        System.out.println("calificacion = " + calificacion);
    }
}
