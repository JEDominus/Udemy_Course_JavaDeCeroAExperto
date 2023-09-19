package domain;

//El IDE marca error y dice que debemos de implementar los metodos abstractos o hacer abstracta esta clase tambien
public class Rectangulo extends FiguraGeometrica{

    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }

    //Implementacion de metodo abstracto
        //No es sobreescritura pórque no se tenia una logica previa
    @Override//Implementacion de metodo abstracto: "Sin implementacion en padre"
    //Ya no se debe de poner el abstract porque esta clase no es abstracta
    //A la izquierda en lugar de "o" marca "i" ya que se implementa y no se sobreescribe
    public void dibujar() {
        //Obtener dinamicamente el nombre simple de la clase de este objeto
        System.out.println("Dibujando un " + this.getClass().getSimpleName());
    }
    
}
