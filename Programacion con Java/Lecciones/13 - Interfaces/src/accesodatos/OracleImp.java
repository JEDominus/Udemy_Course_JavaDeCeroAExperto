package accesodatos;

public class OracleImp implements IAccesoDatos{

    @Override
    public void insertar() {
        System.out.println("Oracle - Insertando");
    }

    @Override
    public void listar() {
        System.out.println("Oracle - Listando");
    }

    @Override
    public void actualizar() {
        System.out.println("Oracle - Actualizando");
    }

    @Override
    public void eliminar() {
        System.out.println("Oracle - Eliminando");
    }
    
}
