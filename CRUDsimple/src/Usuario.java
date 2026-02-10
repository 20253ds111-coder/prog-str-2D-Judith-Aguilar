public class Usuario {
    int codigo;
    String nombreCompleto;
    boolean habilitado;

    public Usuario(int codigo, String nombreCompleto) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.habilitado = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Usuario: %s | Estado: Activo", codigo, nombreCompleto);
    }
}