package equipamento;

public class Armaduras implements Equipamento {
    private String nombre;
    private int nivel;
    private int resistencia;

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

    public void setResistencia(int resistencia){
        this.resistencia = resistencia + this.getNivel()*2;
    }

    public int getResistencia(){
        return resistencia;
    }


}
