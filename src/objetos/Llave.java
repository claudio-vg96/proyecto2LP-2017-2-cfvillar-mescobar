package objetos;

public class Llave implements Items {
    private String nombre;
    private String descripcion;
    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
