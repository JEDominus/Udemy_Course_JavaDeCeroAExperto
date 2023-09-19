
public class Ciclos {
    public static void main(String[] args) {
        //cicloWhile();
        //cicloDoWhile();
        //cicloFor();
        //palabraBreakAndContinue();
        usoDeEtiquetas();
    }
    
    private static void cicloWhile(){
        //Se ejecuta mientras la evaluacion sea verdadera
        var contador = 0;
        
        //Add watcher para ver el estado de la condicion en cada ciclo
        while(contador < 3){//mientras sea true, se ejecuta el codigo
            System.out.println("contador = " + contador);
            contador++;//Se incrementa el contador
        }
    }
    
    private static void cicloDoWhile(){
        //El orden de ejecucion es diferente
        //Primero se ejecuta el codigo y luego evalua la condicion
        //El codigo se ejecuta por lo menos una vez 
        var contador = 0;
        
        do {
            System.out.println("contador = " + contador); //Imprime una vez ya que la evaluacion es al final
            contador++;
        }while(contador < 0);//Evalua despus de ejecutar
    }
    
    private static void cicloFor(){
        for(var contador = 0; contador < 3; contador++){
            System.out.println("contador = " + contador);
        }
    }
    
    private static void palabraBreakAndContinue(){
        //Break - Permite romper un ciclo 
        System.out.println("Palabra break");
        for(var contador = 0; contador < 7; contador++){
            //Solo imprimir numeros pares
            if(contador % 2 == 0){
                System.out.println("contador = " + contador);
                break; //Rompe el ciclo y solo imprime el primer par encontrado
            }
        }
        
        //Continue - Permite romper un ciclo 
        System.out.println("Palabra continue");
        for(var contador = 0; contador < 7; contador++){
            //Solo imprimir numeros pares
            if(contador % 2 != 0){//Si es impar, va por la siguiente iteracion
                continue; //interrumpe la iteracion y continua con la siguiente del ciclo
            }
            System.out.println("contador = " + contador);//Si es par, lo imprime
        }
    }
    
    private static void usoDeEtiquetas(){
        //Labels - Permite ir a un lugar especifico del programa usando break y continue
        //Poco recomendable - Programacion de tipo "go to"
        
        //Se pueden usar para romper ciclos anidados yendo a la etiqueta del primer ciclo
        inicio: //Nombrado de la etiqueta donde comienza la seccion
        for(var contador = 0; contador < 7; contador++){
            if(contador % 2 != 0){//Si es impar, va por la siguiente iteracion
                continue inicio; //Indica a donde hay que ir segun el nombre de la etiqueta
                //break inicio; //Aplica igual para break
            }
            System.out.println("contador = " + contador);//Si es par, lo imprime
        }
    }
    
}
