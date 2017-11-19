package combate;

import personajes.*;
import pocion.Pocion;
import java.util.Iterator;

public class Combate {

    private boolean resultado_pelea;

    public Combate(Usuario usuario, Npc npc){
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
            npc.restarSalud(usuario.getArma().getDaño() - npc.getResistencia());
            System.out.println(usuario.getNombre() + " inflinge " + (usuario.getArma().getDaño()
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

            usuario.restarSalud(npc.getArma().getDaño() - usuario.getArmadura().getResistencia()); //quita vida al usuario
            System.out.println(npc.getNombre() + " inflinge " + (npc.getArma().getDaño() - usuario.getArmadura().getResistencia()) + " de daño");
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

    }
    public boolean getResultado(){
        return resultado_pelea;
    }
    private void setResultado_pelea(boolean resultado_pelea){
        this.resultado_pelea = true;
    }
}
