package personajes;

/**
 * Created by claudio on 12-11-17.
 */
public class Npc extends Personaje {
    private int resistencia;

    public Npc(int level){
        this.setNivel(level);
        this.setSalud(90 + level*10);
        resistencia = level;
    }
}
