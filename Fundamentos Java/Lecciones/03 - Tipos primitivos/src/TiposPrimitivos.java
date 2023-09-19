
import java.util.Scanner;

public class TiposPrimitivos {
    public static void main(String[] args) {
        //tiposPrimitivosEnteros();       
        //tiposPrimitivosFlotantes();
        //inferenciaDeTiposConPrimitivosEnterosYFlotantes();
        //tipoPrimitivoChar();
        //tiposPrimitivosBooleanos();
        conversionDeTiposPrimitivos();
    }    
    
    private static void tiposPrimitivosEnteros() { //Solo permite recibir valores enteros 
        /*
            Tipos primitivos entors: byte 8, short 16, int 32, long 64 bytes
            El tipo int ahorra la mayor cantidad de espacio
        */
        
        byte malByte = (byte) 128; // Mala conversion por eceso de valor
        System.out.println("numeroByte = " + malByte);
        System.out.println("Valor minimo: " + Byte.MIN_VALUE + ".\nValor maximo: " + Byte.MAX_VALUE + "\n");
        
        short numeroShort = (short) 32768; // Mala conversion por eceso de valor
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("Valor minimo: " + Short.MIN_VALUE + ".\nValor maximo: " + Short.MAX_VALUE + "\n");
        
        int numeroInt = (int) 2147483648L; // Supera el valor maximo permitido int, requiere convertirse a long 
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("Valor minimo: " + Integer.MIN_VALUE + ".\nValor maximo: " + Integer.MAX_VALUE + "\n");
        
        long numeroLong = (long)9223372036854775808F;// Supera el valor maximo permitido long, requiere conversion a float o a double
        System.out.println("numeroLong = " + numeroLong);
        System.out.println("Valor minimo: " + Long.MIN_VALUE + ".\nValor maximo: " + Long.MAX_VALUE + "\n");
    }
    
    private static void tiposPrimitivosFlotantes(){// Permite recibir valores con decimales 
        /*
            Tipos primitivos flotantes: float 32, double 64
        */
        
        float numeroFloat = (float)3.4028236E38D;
        System.out.println("numeroFloat = " + numeroFloat);
        System.out.println("Valor minimo: " + Float.MIN_VALUE + ".\nValor maximo: " + Float.MAX_VALUE + "\n");
        
        double numeroDouble = 1.7976931348623157E308; 
        System.out.println("numeroDouble = " + numeroDouble);
        System.out.println("Valor minimo: " + Double.MIN_VALUE + ".\nValor maximo: " + Double.MAX_VALUE + "\n");
    }
    
    private static void inferenciaDeTiposConPrimitivosEnterosYFlotantes(){
        //Solo se pueden inferir los tipos int, long, double y float usando las liteares L, D y F
        
        var numeroEntero = 10; //Por default la inferencia es a tipo int... Debugear para ver tipo
        System.out.println("numeroEntero = " + numeroEntero);
        
        var numeroDouble = 10.0;//Con poner el ., ya infirere que es de tipo double, revisar debug 
        System.out.println("numeroDouble = " + numeroDouble);
        
        var numeroFloat = 10.0F; // Literal F ya infiere que es de tipo float y no double 
        System.out.println("numeroFloat = " + numeroFloat);
    }
    
    private static void tipoPrimitivoChar(){
        //Tiene 16 bits, al igual que short
        char numeroChar = 'A'; // Solo alamacena 1 caracter y requiere comilla simple 
        System.out.println("numeroChar = " + numeroChar);
        
        /* 
            Estos caracteres se da por la lista de caracteres unicode 
            La lista de caracteres unicode se puede usar mediante el codigo, el glypho o el numero decimal
            i.e. "U+0021", "!", "33"
        
            El short puede almacenar solo decimales, pero el char literales y decimales 
        */
        
        char varChar = '\u0021'; // Caracter de admiracion ! 
        System.out.println("varChar = " + varChar); // Imprime !
        
        char varCharDecimal = 33; //Convierte el vvalor a char y no a int dado el tipo de dato
        System.out.println("varCharDecimal = " + varCharDecimal);// Imprime !
        
        char varcharSimbolo = '!';
        System.out.println("varcharSimbolo = " + varcharSimbolo);
        
        //Inferenfia de tipo 
        
        var varCharInf = '\u0021'; // Infiere unicode
        System.out.println("varCharInf = " + varCharInf); // Imprime !
        
        var varCharDecimalInf = (char)33;
        System.out.println("varCharDecimalInf = " + varCharDecimalInf);// Imprime !
        
        var varcharSimboloInf = '!'; //Infiere char dado que es solo un caracter
        System.out.println("varcharSimboloInf = " + varcharSimboloInf);
        
        int variableEnteraConSimbolo = '!'; // Un char se puede asignar a un tipo entero
        System.out.println("variableEnteraConSimbolo = " + variableEnteraConSimbolo);//Imprime 33 porque al ser int, se convierte en su decimal
        
        int letra = 'a';
        System.out.println("letra = " + letra); //Imprime 97, su valor char decimal 
    }
    
    private static void tiposPrimitivosBooleanos(){
        //Almacena valores falso o verdadero
        boolean varBoolean = false; // Tambien conocidos como valores de tipo bandera 
        System.out.println("varBoolean = " + varBoolean);
        
        if(varBoolean){
            System.out.println("La bandera es verdadera");
        }else{
            System.out.println("La bandera es falsa");
        }
        
        var edad = 13; 
        var esAdulto = edad >= 18;
        
        if(esAdulto){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("No es mayor de edad");
        }
    }
    
    private static void conversionDeTiposPrimitivos(){
        //Coversion de tipo String a un int
        var edad1 = Integer.parseInt("20"); //Convierte un string y lo convierte a integer 
        System.out.println("edad1 = " + (edad1 + 1)); //Suma dada la conversion, luego concatena
        
        var edad2 = "20";        
        System.out.println("edad2 = " + (edad2 + 1)); //No suma dado que no hay conversion, solo concatena 
        
        //Conversion de tipo String a double 
        var pi = Double.parseDouble("3.1416");
        System.out.println("pi = " + pi);
        
        // Conversion pidiendo un valor 
        var consola = new Scanner(System.in);
        System.out.println("Ingresa tu edad");
        var edad3 = Integer.parseInt(consola.nextLine());
        System.out.println("Tu edad es: " + edad3);
        
        // Convertir un tipo int a String
        var edadTexto = String.valueOf(10 );
        System.out.println("edadTexto = " + edadTexto);
        
        //Recuperar un caracter de una cadena 
        var caracter = "hola".charAt(2);
        System.out.println("caracter = " + caracter);//Recupera el caracter del indice selecciona, L en este caso 
        
        System.out.println("Proporciona un caracter");
        caracter = consola.nextLine().charAt(0);//ChaAt solo lo contienen los tipo Stringf 
        System.out.println("caracter = " + caracter);
        
    }
}
