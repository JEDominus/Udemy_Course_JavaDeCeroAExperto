package domain;

public class Usuario {
    private int usuarioId;
    private String usuarioNombre;
    private String usuarioPassword;

    public Usuario(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public Usuario(String usuarioNombre, String usuarioPassword) {
        this.usuarioNombre = usuarioNombre;
        this.usuarioPassword = usuarioPassword;
    }

    public Usuario(int usuarioId, String usuarioNombre, String usuarioPassword) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioPassword = usuarioPassword;
    }

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
