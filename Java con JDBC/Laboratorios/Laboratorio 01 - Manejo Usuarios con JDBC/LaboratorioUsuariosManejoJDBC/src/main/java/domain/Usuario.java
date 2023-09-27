package domain;

//Clase entidad, con los atributos de las columnas de la BD
public class Usuario {
    //Atributo por columna
    private int usuarioId;
    private String usuarioNombre;
    private String usuarioPassword;

    //Sobrecarga de constructores
    public Usuario(int usuarioId) { //Definicion para DELETE
        this.usuarioId = usuarioId;
    }
    
    public Usuario(String usuarioNombre, String usuarioPassword) { //Definicion para INSERT
        this.usuarioNombre = usuarioNombre;
        this.usuarioPassword = usuarioPassword;
    }

    public Usuario(int usuarioId, String usuarioNombre, String usuarioPassword) { //Definicion para UPDATE
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioPassword = usuarioPassword;
    }

    //Metodos de acceso y escritura
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    //Sobreescritura de toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("usuarioId=").append(usuarioId);
        sb.append(", usuarioNombre=").append(usuarioNombre);
        sb.append(", usuarioPassword=").append(usuarioPassword);
        sb.append('}');
        return sb.toString();
    }
}
