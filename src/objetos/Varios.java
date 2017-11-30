package objetos;

public class Varios implements Items {
    private String nombre;
    private String descripcion;
    private String id;
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
    public String getNombre() { return nombre; }

    public void setID(String id) { this.id = id; }

    public String getID() { return id; }

}