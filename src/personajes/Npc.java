package personajes;

import equipamento.Armas;
import pocion.Pocion;

import java.util.ArrayList;


public class Npc extends Personaje{

    private int resistencia;
    private String id;

    public Npc(){
        pociones = new ArrayList<>();
    }

    public Npc(int level){

        pociones = new ArrayList<>();
        Pocion pocion0 = new Pocion();
        Pocion pocion1 = new Pocion();

        pocion0.setNivel(level);
        pocion1.setNivel(level);
        pocion0.setPotencia();
        pocion1.setPotencia();

        this.pociones.add(pocion0);
        this.pociones.add(pocion1);

        this.setNivel(level);
        this.setSalud(300 + level*10);
        resistencia = level;

        Armas arma_generica = new Armas(level);
        this.setArma(arma_generica);

    }

    public int getLargoPociones(){
        return pociones.size();
    }

    public void sanarNpc(){
        this.setSalud(this.getSalud() + this.pociones.get(0).getPotencia());
        if (pociones.size() == 1) {
            pociones.clear();
        }
        else {
            this.pociones.remove(0);
        }
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setID(String id){this.id = id;}

    public String getID(){ return id;}

}
