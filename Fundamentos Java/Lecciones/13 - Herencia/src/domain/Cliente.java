package domain;

//EXTENDS señala que hereda el contenido NO PRIVADO de la clase persona
import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fechaRegistro;
    private boolean vip;
    private static int contadorCliente;
    
    public Cliente(){
        //Super() esta implicito aunque no se ponag, si se pone debe ir siempre primero 
        this.idCliente = ++Cliente.contadorCliente;
        this.fechaRegistro = new Date();        
    }
    
    public Cliente(String nombre, boolean vip){
        super(nombre);
        this.idCliente = ++Cliente.contadorCliente;
        this.fechaRegistro = new Date();
        this.vip = vip;
    }

    public Cliente(boolean vip, String nombre, char genero, int edad, String direccion) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++Cliente.contadorCliente;
        this.fechaRegistro = new Date();
        this.vip = vip;
    }    

    public int getIdCliente() {
        return this.idCliente;
    }
    
    //Id Cliente automaticamente seteado

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    //Fecha de registro automaticamente seteada

    public boolean isVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente=").append(this.idCliente);
        sb.append(", fechaRegistro=").append(this.fechaRegistro);
        sb.append(", vip=").append(this.vip);
        sb.append(", Persona=").append(super.toString());
        sb.append("}");
        return sb.toString();
    }
}
