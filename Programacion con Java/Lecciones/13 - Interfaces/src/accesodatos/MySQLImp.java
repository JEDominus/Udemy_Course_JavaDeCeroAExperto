package accesodatos;

//Para implementar el comportamiento de una interfaz se usa "implements"
    //Con esto la clase esta obligada a agregar el comportamiento de los metodos en la interfaz
    //Si no los implementamos, debemos definirla como abstracta
//Una clase puede heredar solo de una, pero puede implementar multiples interfaces simultaneamente
public class MySQLImp implements IAccesoDatos{

    //Muestra "i" en el editor ya que se implementa por primera vez
    @Override
    public void insertar() {
        System.out.println("SQL - Insertando");
    }

    @Override
    public void listar() {
        System.out.println("SQL - Listando");
    }

    @Override
    public void actualizar() {
        System.out.println("SQL - Actualizando");
    }

    @Override
    public void eliminar() {
        System.out.println("SQL - Eliminando");
    }
    
}
