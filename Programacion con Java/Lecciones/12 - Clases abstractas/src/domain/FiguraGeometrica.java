package domain;

//Se debe de poner la palabra abstract 
public abstract class FiguraGeometrica {
    protected String tipoFigura;
    
    protected FiguraGeometrica(String tipoFigura){
        this.tipoFigura = tipoFigura;
    }
    
    //Se debe de poner la palabra abstract en los metodos sin implementacion
    //No requiere llaves ya que no implementa fiuncionalidad
        //Con 1 solo metodo abstracto, toda la clase se debe marcar como abstracta
    public abstract void dibujar();

    public String getTipoFigura() {
        return this.tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{" + "tipoFigura=" + this.tipoFigura + '}';
    }
}
