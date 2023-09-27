package domain;

//1.- Comenzamos  renombrando la clase entidaed con el patron de diseño DTO
public class UsuarioDto {
    private int usuarioId;
    private String usuarioNombre;
    private String usuarioPassword;

    public UsuarioDto(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public UsuarioDto(String usuarioNombre, String usuarioPassword) {
        this.usuarioNombre = usuarioNombre;
        this.usuarioPassword = usuarioPassword;
    }

    public UsuarioDto(int usuarioId, String usuarioNombre, String usuarioPassword) {
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
