package test;

import domain.*;

public class TestClaseAbstracta {
    public static void main(String[] args) {
        claseAbstracta();
    }
    
    public static void claseAbstracta(){
        //Una clase padre abstracta define metodos abstractos sin implementacion
        //Las hijas que heredan definen el comportamiento
            //No se pueden llamar los metodos abstractos de la clase padre, mas bien, se llaman la de los hijos
            
            //No se pueden instanciar clases abstractas
        //FiguraGeometrica figura = new FiguraGeometrica("Cuadrilatero");
        
        //Creacion de objeto que hereda de clase abstracta
        Rectangulo rectangulo = new Rectangulo("Cudrilatero");
        
        //Se puede aplicar polimorfismo a este ejemplo con objeto figura y creacion rectangulo
        FiguraGeometrica figura = new Rectangulo("Rectangulo");//Upcasting, no requiere el tipo explicito (Figura)
        //Este metodo no se podria ejecutar si no fuera de tipo rectangulo, pues el de figura es abstracto
        figura.dibujar();//Se ejecuta el metodo en comun de las 2 clases 
        
    }
}
