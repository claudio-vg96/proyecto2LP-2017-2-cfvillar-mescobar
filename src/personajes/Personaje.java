package personajes;
import equipamento.Armas;
import pocion.Pocion;
import java.util.ArrayList;

public abstract class Personaje {

    private String nombre;
    private int salud;
    private Armas arma;
    private int nivel;
    private String ubicacion;
    ArrayList<Pocion> pociones; //FALTA METODOS PARA PASARLO A PRIVATE

    public int getNivel() {
        return nivel;
    }

    public void subirNivel(){
        this.salud += 150;
        this.nivel++;
    }

    public void setUbicacion(String u){ this.ubicacion = u; }

    public String getUbicacion(){ return ubicacion; }

    public ArrayList<Pocion> getPociones() {
        return pociones;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setNombre(String name){
        this.nombre = name;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public void restarSalud(int dano){
        if (dano > 0){
            this.salud -= dano;
        }
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public Armas getArma() {
        return arma;
    }

    public String getNombre() {
        return nombre;
    }
}