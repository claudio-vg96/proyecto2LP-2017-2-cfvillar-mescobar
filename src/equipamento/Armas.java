package equipamento;

public class Armas implements Equipamento {
    private int dano;
    private String nombre;
    private int nivel;

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    public Armas(){

    }

    public Armas (int level){
        this.setNivel(level);
        dano = 10 + level;
    }

    public void setDano(int dano){
        this.dano = dano + this.getNivel()*5;
    }

    public int getDano(){
        return dano;
    }
}
