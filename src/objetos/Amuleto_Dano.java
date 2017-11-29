package objetos;

import personajes.Usuario;

public class Amuleto_Dano implements Items {
    private String nombre;
    private String descripcion;
    Usuario user;
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

    public Amuleto_Dano (Usuario user){
        user.getArma().setDano(user.getArma().getDano()+10);
    }
}
