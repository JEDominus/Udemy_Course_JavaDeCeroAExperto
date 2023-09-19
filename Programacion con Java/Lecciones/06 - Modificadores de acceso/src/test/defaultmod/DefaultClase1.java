package test.defaultmod;

//Esta clase no tiene modificador, por lo tanto es default o Package
//Al ser default, no se puede usar fuera de este paquete defaultmod.paquete1
//Esta clase si puede acceder a otras clases publicas, pero no puede usarse fuera del paquete
class DefaultClase1 {
    //Al no tener modificador, atributo se convierte en protected y solo accesible desde este paquete
    String atributoDefault = "Atributo default";
    
    //Al no tener modificador, construictor se convierte en protected y solo accesible desde este paquete
    DefaultClase1(){
        System.out.println("Constructor default");
    }
    
    void metodoDefault(){
        System.out.println("Metodo default");
    }
}
