package operaciones;

public class Aritmetica {
    //Operandos - Atributos
    int a; //Al ser un tipo primitivo, en lugar de null, es 0... en booleanos es falso
    int b; 
    
    //Constructores
    //Constructo vacio... Solo se manda a llamar cuando se crea un objeto con new 
    //Este constructor se agrega automaticamente solo si no se tiene otro......
    public Aritmetica(){
        System.out.println("Ejecutando constructor");
    };
    
    //Sobercarga de constructores - Agregar uno o mas constructores
    //Constructor con inicializaci9on de valores
    //....La creacion de constructor cona rgumentos, ya no agrega automaticamente el constructor por default
    public Aritmetica(int arg1, int arg2){//No se puede usar var 
        this.a = arg1;//requiere el this ya que si no se asignaria ela rgumento al mismo argumento
        this.b = arg2;
        System.out.println("Ejecutando constructor con argumentos");
    }
    
    public void sumar(){
        int resultado = a + b;
        System.out.println("resultado interno = " + resultado);
    }
    
    public int sumarConRetorno(){
        return this.a + this.b;
    }
    
    public int sumarConRetornoYArgumentos(int arg1, int arg2){//Argumento cuando se defgine
        //This solo se puede usar en atributos de una clase y en sus metodos
        this.a = arg1;//El argumento a se asigna al atributo this.a
        this.b = arg2;//Se sua para referir a los atributos de un objeto en particular
        //return a + b;
        return sumarConRetorno();
    }
}
