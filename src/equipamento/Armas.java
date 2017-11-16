package equipamento;

public class Armas extends Equipamento {
    private int danio;

    public Armas(){

    }

    public Armas(int level){
        super.setNivel(level);
        danio = 10 + level;
    }

    public void setDaño(int danio){
        this.danio = danio + super.getNivel()*5;
    }

    public int getDaño(){
        return danio;
    }
}
