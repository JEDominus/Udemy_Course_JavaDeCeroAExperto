package test;

import enumeracion.Continentes;
import enumeracion.Dias;
import static enumeracion.Dias.LUNES;

public class TestEnumeraciones {
    public static void main(String[] args) {
        //enumeracionesFundamentos();
        enumeracionConAtributos();
    }
    
    public static void enumeracionesFundamentos() {
        //Las enumeracion es un tipo similar a una clase
        //Este tipo de clase en aprticular contiene varios elementos definidos dentro.. Revisar Dias enum
        
        //Para acceder a los elementos de la enumeracion es como acceder a una constante publica de clase
            //Clase. + constante
        System.out.println("Dia 1 de la semana: " + Dias.LUNES);//son tratadas por default como cadenas
        
        //Se pueden pasar enumeradores como argumentos
        indicarDiaDeLaSemana(Dias.MIERCOLES);
        indicarDiaDeLaSemana(Dias.SABADO);
        indicarDiaDeLaSemana(Dias.JUEVES);
        //A pesar de ser tratado como cadena, no permite el parseo directo de tipo string
            //indicarDiaDeLaSemana("JUEVES");
    }
    
    //llama interna
    public static void indicarDiaDeLaSemana(Dias dia){
        switch(dia){//El switch ya sabe que utilizaremos un tipo enumeracion
            case LUNES://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Primer dia de la semana");
                break;
            case MARTES://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Segundo dia de la semana");
                break;
            case MIERCOLES://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Tercer dia de la semana");
                break;
            case JUEVES://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Cuarto dia de la semana");
                break;
            case VIERNES://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Quinto dia de la semana");
                break;
            case SABADO://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Secto dia de la semana");
                break;
            case DOMINGO://Por ello no hay que llamar la clase si no la constante directamente
                System.out.println("Septimo dia de la semana");
                break;
        }
    }
    
    public static void enumeracionConAtributos(){
        //Los valores de los enumeradores pueden ser elemtos cona tributos mas complejos 
        //Para acceder a los elementos, es igual que con el enumerador dias
        
            //Acceder al valor del enumerador completo
        System.out.println("Continente 4 = " + Continentes.AMERICA);//Imprime AMERICA
            //Acceder al numero de paises (atributo) de un elemento
        System.out.println("Paises de Continente 4 = " + Continentes.AMERICA.getPaises());//Imprime 34
            //Aplicable para cualquier elemento
        System.out.println("Continente 1: " + Continentes.AFRICA + ". Paises: " + Continentes.AFRICA.getPaises());
    }
}
