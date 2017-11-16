package equipamento;

public abstract class Equipamento {
    private String nombre;
    private int nivel;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getNivel(){
        return nivel;
    }
}
