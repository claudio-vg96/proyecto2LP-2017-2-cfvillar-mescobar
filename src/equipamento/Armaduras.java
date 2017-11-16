package equipamento;

public class Armaduras extends Equipamento {
    private int resistencia;
    public void setResistencia(int resistencia){
        this.resistencia = resistencia + super.getNivel()*2;
    }

    public int getResistencia(){
        return resistencia;
    }
}
