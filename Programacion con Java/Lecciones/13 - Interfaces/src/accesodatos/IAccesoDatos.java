package accesodatos;

//Se anota como "interface"
//Al no ser una clase, no hereda de la clase OBJECT
//Sin embargo, si podemos extender de otras interfaces
public interface IAccesoDatos {
    //Los atributos son de tipo constante en automatico (Public+static+final)
        //Todos los atributos deben ser inicializados ya que las interfaces no tienen constructores
    int MAX_REGISTROS = 10;//ctrl ya muestra ñ public static final
    
    //cualqueir metodo ya va a ser publico y abstracto, entonces no requiere ni el public ni el abstract
        //ctrl se ve que ya agrega el publlic abstract
    //Si lo agregamos se vuelve redundante
    void insertar();//al ser abstracto no lleva cuerpo
    
    void listar();
    
    void actualizar();
    
    void eliminar();
}
