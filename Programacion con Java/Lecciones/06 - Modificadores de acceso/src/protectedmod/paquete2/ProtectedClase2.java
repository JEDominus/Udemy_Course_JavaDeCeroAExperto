package protectedmod.paquete2;

import protectedmod.paquete1.ProtectedClase1;

public class ProtectedClase2 extends ProtectedClase1 {//Se puede heredar de una clase en otro paquete
    
    public ProtectedClase2(){
        //constructor Protected si se puede acceder desde este hijo
        super();//Esta clase hija si puede acceder al constructor de la clase padre protected
        this.atributoProtected = super.atributoProtected;//Esta clase hija puede acceder al atributo protected del padre
        System.out.println(this.atributoProtected);
        this.metodoProtected();//Se puede llamar a los metodo protected de la clase padre desde clase hija
    } 
}
