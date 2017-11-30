package combate;

import objetos.Items;
import personajes.*;
import pocion.Pocion;

import java.util.Iterator;
import java.util.Map;

public class Combate {

    private boolean resultado_pelea;

    public Combate(Usuario usuario, Npc npc, Map<String, Items> npc_items) {
        int potencia_pocion_npc = npc.getPociones().get(0).getPotencia();
        Iterator <Pocion> iterador = npc.getPociones().iterator();
        System.out.println("Empieza el combate entre " + usuario.getNombre()+ " y " + npc.getNombre());

        while (true){
            if((npc.getSalud() <= 40) && (npc.getLargoPociones() != 0)){
                while (iterador.hasNext()){
                    if(60 < npc.getSalud() || npc.getLargoPociones() == 0) break;
                    npc.sanarNpc();
                    System.out.println(npc.getNombre() + " usa una pocion, curandose por " + potencia_pocion_npc);
                }
            }
            npc.restarSalud(usuario.getArma().getDano() - npc.getResistencia());
            System.out.println(usuario.getNombre() + " inflinge " + (usuario.getArma().getDano()
                    - npc.getResistencia()) + " de daño");

            if (usuario.getSalud() <= 0) {
                System.out.println("Escape fallido " + usuario.getNombre() + " a muerto");
                break;
            }

            if (npc.getSalud() <= 0){
                System.out.println("Exito! " + npc.getNombre() + " a muerto");
                usuario.subirNivel();
                break;
            }

            System.out.println("La vida actual de " + npc.getNombre() + " es " + (npc.getSalud()));

            usuario.restarSalud(npc.getArma().getDano() - usuario.getArmadura().getResistencia()); //quita vida al usuario
            System.out.println(npc.getNombre() + " inflinge " + (npc.getArma().getDano() - usuario.getArmadura().getResistencia()) + " de daño");
            if (usuario.getSalud() <= 0) {
                System.out.println("Escape fallido " + usuario.getNombre() + " a muerto");
                resultado_pelea = false;
                break;
            }
            if (npc.getSalud() <= 0) {
                System.out.println("Exito! " + npc.getNombre() + " a muerto");
                usuario.subirNivel();
                this.setResultado_pelea(resultado_pelea);
                break;
            }
            System.out.println("La vida actual de " + usuario.getNombre() + " es " + (usuario.getSalud()));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }

        }

        if (npc.getSalud()<= 0){
            if (npc.getNombre().equals("Perro Mutante")){
                System.out.println("Enhorabuena! has recibido la llave para entrar al castillo");
                usuario.agregarEquipaje(npc_items.get(npc.getID()));
            }
            else if (npc.getNombre().equals("Mujerzuela")){
                System.out.println("Enhorabuena! has recibido la llave para entrar a la sala del castillo");
                usuario.agregarEquipaje(npc_items.get(npc.getID()));
            }
            else if (npc.getNombre().equals("Jefe Rebelde")){
                System.out.println("Derrotaste al Jefe Rebelde, has ganado la beta de nuestro juego" +
                        " felicidades! y gracias por probar nuestro juego");
            }

        }


    }
    public boolean getResultado(){
        return resultado_pelea;
    }
    private void setResultado_pelea(boolean resultado_pelea){
        this.resultado_pelea = true;
    }
}
