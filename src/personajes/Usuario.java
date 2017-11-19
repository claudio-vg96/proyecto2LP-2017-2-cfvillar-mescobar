package personajes;

import equipamento.Armaduras;
import equipamento.Armas;
import objetos.Items;
import pocion.Pocion;

import java.util.ArrayList;


public class Usuario extends Personaje{

    private Armaduras armadura;
    private ArrayList<Items> equipaje;

    public Usuario(){

        this.setNivel(1);
        equipaje = new ArrayList<>();
        pociones = new ArrayList<>();

        Armaduras armadura_inicial = new Armaduras();
        armadura_inicial.setNivel(this.getNivel());
        armadura_inicial.setResistencia(10);
        armadura_inicial.setNombre("Armadura Inicial");

        armadura = armadura_inicial;

        Armas nudillos = new Armas();
        nudillos.setDaño(25);
        nudillos.setNombre("Nudillos");
        nudillos.setNivel(1);

        this.setArma(nudillos);
    }

    public void agregarEquipaje(Items item) {
        this.equipaje.add(item);
    }

    public ArrayList<Items> getEquipaje() {
        return equipaje;
    }

    public void equiparPocion(Pocion pocion){
        this.pociones.add(pocion);
    }

    public void setArmadura(Armaduras armadura) {
        this.armadura = armadura;
    }

    public Armaduras getArmadura() {
        return armadura;
    }

}
