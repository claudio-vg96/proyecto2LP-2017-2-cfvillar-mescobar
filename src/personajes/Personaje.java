package personajes;

/**
 * Created by claudio on 12-11-17.
 */
public abstract class Personaje {
    private String nombre;
    private int salud;
    private int nivel;

    public int getNivel(){
        return nivel;
    }

    public void subirNivel(){
        this.salud += 150;
        this.nivel++;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setNombre(String name){
        this.nombre = name;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public int getSalud(){
        return salud;
    }

    public void restarSalud(int danio){
        if(danio >0){
            this.salud -= danio;
        }
    }

    public String getNombre(){
        return nombre;
    }


}
