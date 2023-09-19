
import java.util.Scanner;


public class Operadores {

    public static void main(String args[]) {
        //operadoresAritmeticos();
        //operadoresDeAsignacion();
        //operadoresUnarios();
        //operadorDeAsignacionYRelacionales();
        //operadoresCondicionales();
        //operadorTernario();
        //presedenciaDeOperadores();
        //tareaRectangulo();
        tareaMayorDeDosNumeros();
    }

    private static void operadoresAritmeticos() {
        //Operacion aritmetica de suma 
        int a = 3, b = 2; //Declaracion multiple unilinear 
        var resultado = a + b;
        System.out.println("resultado = " + resultado);

        //Operacion aritmetica de resta 
        resultado = a - b;
        System.out.println("resultado = " + resultado);

        //Operacion aritmetica de multiplicacion
        resultado = a * b;
        System.out.println("resultado = " + resultado);

        //Operacion aritmetica division
        resultado = a / b;//Resultado de tipo entero por inferencia 
        System.out.println("resultado = " + resultado); //No incluye punto flotante

        var resultado2 = 3.0 / b; //Ahora se crea la variable de tipo flotante  
        System.out.println("resultado2 = " + resultado2);

        //Operacoina ritmetica residuo o modulo
        resultado = a % b;
        System.out.println("resultado = " + resultado);

        if (b % 2 == 0) {
            System.out.println(b + " es un numero par");
        } else {
            System.out.println(b + " es un numero impar");
        }
    }

    private static void operadoresDeAsignacion() {
        //Operador de asignacion
        int a = 3, b = 2;
        int c = a + 5 - b;//operador de asignacion, asigna un valor a una avriable
        System.out.println("c = " + c);

        //Operadores de asignaicon de composiscion
        a += 1; // a = a + 1... La variable se incrementa en uno 
        System.out.println("a = " + a);

        a += 3;// a = a + 3
        System.out.println("a = " + a);

        a -= 2;// a = a - 2
        System.out.println("a = " + a);

        a *= 2;// a = a * 2;
        System.out.println("a = " + a);

        a /= 2;// a = a / 2;
        System.out.println("a = " + a);

        a %= 5;// a = a % 5;
        System.out.println("a = " + a);
    }

    private static void operadoresUnarios() {
        //Operador unario de cambio de signo
        var a = 3;
        var b = -a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //Operador unario de negacion
        var c = true;
        var d = !c;
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        //Operador unario incremento 
        // Preincremento, simbolo antes de la variable
        var e = 3;
        var f = ++e; //Primo incrementa la variable e, y luegop se ustiliza el valor para F
        //++e dice que antes de tomar el valor de e, hay que incrementarle uno, despues ya se toma el valor final 
        System.out.println("e = " + e);// 4... Es 4 ya que se inctremento antes de este llamdo
        System.out.println("f = " + f);// 4 ... Es 4 ya que se le asigno el valor a f despues del incremento

        //Posincremento
        var g = 5;
        var h = g++;//Primero se utiliza el valor de g, luego se incrementa en 1 para g, no para h
        System.out.println("g = " + g);//6... Ya que se incremento despues de asignarse a h
        System.out.println("h = " + h);//5... Ya que g se incremento despues de tomar el valor

        //Operador unario decremento
        //Predecremento, simbolo antes de la variuable
        var i = 2;
        var j = --i;
        System.out.println("i = " + i);// 1
        System.out.println("j = " + j);// 1... Tomo el valor de i despues de decrementarse

        //Postdecremento, simbolo despues de la variable 
        var k = 4;
        var l = k--;
        System.out.println("k = " + k);//1 ya que se decrementa hasta esta lectura
        System.out.println("l = " + l);//2 ya que toma el valor de K antes del decremento 

    }

    private static void operadorDeAsignacionYRelacionales() {
        var a = 3;
        var b = 2;

        //Operador de igualdad ==
        var c = (a == b); //Regresa true o false
        System.out.println("c = " + c);// false

        //Operador dif¿erente a
        var d = a != b;
        System.out.println("d = " + d);// true

        //Operador de comparacion en objetos
        var cadena1 = "hola";
        var cadena2 = "adios";

        //Queremos preguntar si el valor de ambas cadenas es igual
        var e = cadena1 == cadena2;
        System.out.println("e = " + e);// falso, compara referencia de objeto

        var f = cadena1.equals(cadena2);// compara contenido de la cadena
        System.out.println("f = " + f);// NO tiene el mismo contenido

        var g = !cadena1.equals(cadena2);//true ya que no son iguales, se niega la expresion con !
        System.out.println("g = " + g);

        //Operadores relacionales 
        var h = a > b;// 3 > 2 ... true
        System.out.println("h = " + h);

        var i = a >= b;// mayor o igual... true
        System.out.println("i = " + i);

        //Numero apr o impar 
        if (a % 2 == 0) {
            System.out.println("Numero par");
        } else {
            System.out.println("Numero impar");
        }

        var edad = 100;
        var adulto = 18;

        if (edad >= adulto) {
            System.out.println("Es un adulto");
        } else {
            System.out.println("Es menor de edad");
        }

    }

    private static void operadoresCondicionales() {
        var a = 10;
        int minimo = 0, maximo = 10;

        //Operador AND 
        var resultado = a >= minimo && a <= maximo; //Ambos lados deben ser verdaderos

        if (resultado) {
            System.out.println("Dentro de rango"); // verdadero
        } else {
            System.out.println("Fuera de rango");
        }

        //Operador Or .. con un solo valor true, todo es true
        var vacaciones = false;
        var descanso = true;

        if (vacaciones || descanso) {//Con una que se cumpla es suficiente
            System.out.println("Puede asistir al juego");
        } else {
            System.out.println("El padre esta ocupado");
        }
    }

    private static void operadorTernario() {
        //Tiene 3 partes, expresion, resultado para true y resaultado para false
        //Condicion a evaluar yt de ahi, regresaqr uno u otro valor
        var resultado = (1 > 2) ? "Es verdadero" : "Es falso";//Se evalua un booleano, antes de : si es true, despue de : si es false
        System.out.println("resultado = " + resultado);

        var numero = 8;
        resultado = numero % 2 == 0 ? "Es par" : "Es impar";
        System.out.println("resultado = " + resultado);
    }
    
    private static void presedenciaDeOperadores(){
        //Presendecia es el orden con la que se van a evaluar los operadores
        var x = 5;
        var y = 10;
        var z = ++x + y--;
        System.out.println("x = " + x);// valor 6
        System.out.println("y = " + y);// valor 9
        System.out.println("z = " + z);// Valor 16, ya que Y seguia siendo 10
        
        var resultado = 4 + 5 * 6 / 3;// *, /, +
        System.out.println("resultado = " + resultado);// resultado 14
        
        resultado = (4 + 5) * 6 / 3;// Se ejecutan primero los parentesis 
        System.out.println("resultado = " + resultado); // 18
    }
    
    private static void tareaRectangulo(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Proporciona el Alto: ");    
        int alto = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el Ancho: ");    
        int ancho = Integer.parseInt(consola.nextLine());
        System.out.println("Area: " + (alto * ancho));
        System.out.println("Perimetro: " + (alto * 2 + ancho * 2));
    }
    
    private static void tareaMayorDeDosNumeros(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Introduzcs el primer numero");
        var a = Integer.parseInt(consola.next());
        System.out.println("Introduzcs el primer numero");
        var b = Integer.parseInt(consola.next());
        var resultado = a > b ? a + " es mayor que " + b : b + " es mayor que " + a;
            System.out.println("resultado = " + resultado);
    }
}
