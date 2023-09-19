package test;

//Tiene que ver con tipos primitivos
public class TestAutoboxingUnboxing {
    public static void main(String[] args) {
        //fundamentals();
        //Autoboxing();
        //Unboxing();
        experimentals();
    }
    
    public static void fundamentals(){
        //Cada tipo primitivo en java tiene un a clase asociada conocida como "Wrapper" o "Envolvente"
        //Clases envolventes "Wrapper" (Tipo Object):
            //byte - Byte
            //short - Short
            //char - Character
            //int - Integer
            //long - Long
            //float - Float
            //double - Double
            //boolean - Boolean
        //Estas clases contienen atributos y metodos y se usan ya que la variable solo almacena valor
        //NOTA: Primitivo para algoritmos con muchos calculos - Wrapper para logicas sin calculos exaustivos
        int enteroPrimitivo = 10;//Variable primitiva puede ser asignada a variable de tipo wrapper directamente
        Integer enteroWrapper = enteroPrimitivo;//Variable de clase wrapper que revcibe valor primitivo
        System.out.println("enteroWrapper = " + enteroWrapper);//Valor literal int para calculos
        //Mediante el uso de metodos de la clase Wrapper, podemos obtener el mismo resultado
        //Sin embargo, la impresion usando la clase, es un string directamente
        System.out.println("enteroWrapper en string= " + enteroWrapper.toString());//Valor literal string para concatenaciones
        
        //Las clases envolventes contienen metodos para convertir de forma mas facil el valor asociado a la variable
            //i.e y.byte/double/short/floatValue() para hacer conversiones
        System.out.println("enteroWrapper en Byte = " + enteroWrapper.byteValue());
        System.out.println("enteroWrapper en Short = " + enteroWrapper.shortValue());
        System.out.println("enteroWrapper en Float = " + enteroWrapper.floatValue());
        System.out.println("enteroWrapper en Double = " + enteroWrapper.doubleValue());
    }
    
    public static void Autoboxing(){
        //Autoboxing - La literal primitiva se convierte a object
            //int -> Integer
        int numeroPrimitivo = 10;
        //Autoboxing - se mete el valor literal al objeto
        Integer numeroWrapper = numeroPrimitivo;
        System.out.println("Autoboxing");
        System.out.println("Primitivo = " + numeroPrimitivo);
        System.out.println("Wrapper = " + numeroWrapper);
    }
    
    public static void Unboxing(){
        //Unboxing - El objeto se convierte a tipo primitivo
            //Integer - int
            
        Integer numeroWrapper = 10;
        //Unboxing - Se saca el valor literal
        int numeroPrimitivo = numeroWrapper;   
        System.out.println("Unboxing");   
        System.out.println("Wrapper = " + numeroWrapper);  
        System.out.println("Primitivo = " + numeroPrimitivo);
    }
    
    public static void experimentals(){
        //Se puede hacer la conversion a otros tipos primitivos pasando por autoboxing 
        int enteroPrimitivo = 10;
        Integer enteroEnvolvente = enteroPrimitivo;
        double doublePrimitivoConvertido = enteroEnvolvente.doubleValue();
        
        //Otros envolventes
        Byte x_byte = 0;
        x_byte.toString();//conversiones
        x_byte.shortValue();
        x_byte.intValue();
        x_byte.longValue();
        x_byte.floatValue();
        x_byte.doubleValue();
        
        //Mismas conversion aplican para el resto de tipos         
        Short x_short = 0;
        Integer x_int = 0;
        Long x_long = 0L;
        Float x_float = 0.0F;
        Double x_double = 0.0D;
        
        //En un JSON, cuando un tipo Wrapper es null no se muestra        
    }
}
