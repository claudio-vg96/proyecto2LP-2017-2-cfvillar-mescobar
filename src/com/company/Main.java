package com.company;

import combate.Combate;
import equipamento.Armas;
import objetos.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import personajes.*;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(" BIENVENIDOS 'A Reptiles y Mujerzuelas'");
        System.out.println("Ingresa el nombre de tu personaje:");
        Scanner name = new Scanner(System.in);
        String nombre = name.nextLine();
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setSalud(800);
        System.out.println("Para poder usar un poder ver el inventario usa 'list [inventory]'");
        System.out.println("Para poder ver las misiones activas, usa 'list [quests]'");
        System.out.println("Para usar un objeto del inventario, utiliza 'use [itemID]'");
        System.out.println("Para poder moverte debes ingresar 'walk [L|R|U|D]'");
        System.out.println("Para ver los enemigos, utiliza 'lookat [enemies]'");
        System.out.println("Para ver los items que hay en la zona actual, escribe 'lookat [items]'");
        System.out.println("Para recoger un item y agregarlo a tu inventario, utiliza 'pickup [item ID]'");
        System.out.println("Para atacar a un enemigo en la zona, usa 'attack [enemyID]'\n");
        //DEFINIMOS MAPA

        Map <String, String> mapa = new HashMap<>();
        mapa.put("L","Alcantarillas");
        mapa.put("R","Ciudad Destruida");
        mapa.put("U","Castillo Destruido");
        mapa.put("D","Sala del Castillo Destruido");

        // DEFINIMOS ZONAS CON SUS ENEMIGOS
        Map<String, List> enemigos = new HashMap<>();
        enemigos.put("Alcantarillas",Arrays.asList("Cocodrilo (ID:L1)","Lagarto Mayor (ID:L2)"));
        enemigos.put("Ciudad Destruida",Arrays.asList("Tortugas ancianas (ID:R1)","Lagarto Mutante (ID:R2)",
                "Perro mutante (ID:R3)"));
        enemigos.put("Castillo Destruido",Arrays.asList("Bandido (ID:U1)","Mujerzuela (ID:U2)"));
        enemigos.put("Sala del Castillo Destruido",Arrays.asList("Jefe rebelde (ID:D1)"));

        // ENEMIGOS CON SUS CARACTERISTICAS
        Map <String, String> enemigos_descripcion = new HashMap<>();
        enemigos_descripcion.put("L1","Cocodrilo radioactivo, tiene 150 de daño");
        enemigos_descripcion.put("L2", "Lagarto Mayor, tiene 180 de daño");
        enemigos_descripcion.put("R1","Tortugas ancianas, tiene 200 de daño");
        enemigos_descripcion.put("R2", "Lagarto mutante, tiene 250 de daño");
        enemigos_descripcion.put("R3","Perro mutante, tiene 300 de daño, dicen que tiene la llave para entrar" +
                " al castillo");
        enemigos_descripcion.put("U1","Bandido tiene 300 de daño");
        enemigos_descripcion.put("U2","Mujerzuela tiene 350 de daño, dicen que tiene la llave rubí");
        enemigos_descripcion.put("D1", "Jefe Rebelde, tiene 400 de daño");

        List<String> lista_enemigos = new ArrayList<>();
        lista_enemigos.add("L1");
        lista_enemigos.add("L2");
        lista_enemigos.add("R1");
        lista_enemigos.add("R2");
        lista_enemigos.add("R3");
        lista_enemigos.add("U1");
        lista_enemigos.add("U2");
        lista_enemigos.add("D1");

        HashMap<String, ArrayList<String>> misiones = new HashMap<>();
        ArrayList<String> misiones_alcantarillas = new ArrayList<>();
        misiones_alcantarillas.add("Derrotar Cocodrilo");
        misiones_alcantarillas.add("Derrotar lagarto mayor");
        misiones.put("Alcantarillas", misiones_alcantarillas);

        ArrayList<String> misiones_ciudad_destruida = new ArrayList<>();
        misiones_ciudad_destruida.add("Derrotar tortugas ancianas");
        misiones_ciudad_destruida.add("Derrotar lagarto mutante");
        misiones_ciudad_destruida.add("Derrotar perro mutante");
        misiones.put("Ciudad Destruida", misiones_ciudad_destruida);

        ArrayList<String> misiones_castillo_destruido = new ArrayList<>();
        misiones_castillo_destruido.add("Derrotar bandido");
        misiones_castillo_destruido.add("Derrotar rebelde");
        misiones_castillo_destruido.add("Derrotar mujerzuela");
        misiones_castillo_destruido.add("Encontrar llave para abrir sala del castillo destruido");
        misiones.put("Castillo Destruido", misiones_castillo_destruido);

        ArrayList<String> misiones_sala_castillo_destruido = new ArrayList<>();
        misiones_sala_castillo_destruido.add("Derrotar jefe rebelde");
        misiones.put("Sala del Castillo Destruido",misiones_sala_castillo_destruido);

        //Nivel 1 -> Alcantarillas
        System.out.println(nombre+" eres la ultima persona en la tierra. Has despertado de un largo sueño y la humanidad"+
                " como la conoces ha llegado a su fin.\n" +
                "Soy el perro de tu ta-tara-abuelo y he venido"+
                " aquí para aconsejarte acerca de tu futuro.\nNo tienes provisiones y tienes que dejar estas" +
                " alcantarillas si quieres sobrevivir.\n Adelante, que comience tu aventura!\n");

        user.setUbicacion(mapa.get("L")); //ubicacion inicial

        Map<String, List> items_por_zona = new HashMap<>();
        items_por_zona.put("Alcantarillas",Arrays.asList("Carne de rata (ID:IL1)","Roca (ID:IL2)"));
        items_por_zona.put("Ciudad Destruida",Arrays.asList("Cañería oxidada (ID:IR1)", "Carton Mojado (ID:IR2"));
        items_por_zona.put("Castillo Destruido", Arrays.asList("Anillo de oro (ID:IU1)", "Gorra cool (ID:IU2)"));
        items_por_zona.put("Sala Castillo Destruido", Arrays.asList("Antorcha (ID:ID1"));

        List<String> lista_items = new ArrayList<>();
        lista_items.add("IL1");
        lista_items.add("IL2");
        lista_items.add("IR1");
        lista_items.add("IR2");
        lista_items.add("IU1");
        lista_items.add("IU2");
        lista_items.add("ID1");
        lista_items.add("ID2");

        Map <String, String> nombres_items = new HashMap<>();
        nombres_items.put("IL1","Carne de rata");
        nombres_items.put("IL2","Roca");
        nombres_items.put("IR1","Cañería Oxidada");
        nombres_items.put("IR2","Carton Mojado");
        nombres_items.put("IU1","Anillo de oro");
        nombres_items.put("IU2","Gorra cool");
        nombres_items.put("ID1","Antorcha");


        Map <String, String> items_descripcion = new HashMap<>();
        items_descripcion.put("IL1","Carne de rata, no es lo más nutritivo, pero te da 50 de salud");
        items_descripcion.put("IL2", "Roca, no sirve para nada, pero es bonita");
        items_descripcion.put("IR1","Cañeria oxidada, te da 20 de daño extra");
        items_descripcion.put("IR2", "Carton mojado, seguramente te servirá algun día");
        items_descripcion.put("IU1","Anillo de oro, te da 30 de salud y 30 de daño");
        items_descripcion.put("IU2","Gorra Cool, te da +1000 de apariencia sexy");
        items_descripcion.put("ID1","Martillo, puedes seleccionarla y cambiar tu arma actual");
        items_descripcion.put("ID2","Antorcha, te sirve para alumbrar");


        List<String> lista_armas = new ArrayList<>();
        lista_armas.add("Espada del viejo mundo");
        lista_armas.add("Hacha del Diablo");
        lista_armas.add("Arco y flechas");
        String arma_random = lista_armas.get(new Random().nextInt(lista_armas.size()));
        Armas arma = new Armas(1);
        arma.setNombre(arma_random);
        arma.setNivel(1);
        arma.setDano(200);
        user.setArma(arma);

        Amuleto_Dano amuleto_dano_user = new Amuleto_Dano(user);
        amuleto_dano_user.setNombre("Amuleto Daño");
        amuleto_dano_user.setDescripcion("Amuleto que aumenta el daño del usuario");
        user.agregarEquipaje(amuleto_dano_user);

        Amuleto_Salud amuleto_salud_user = new Amuleto_Salud(user);
        amuleto_salud_user.setNombre("Amuleto Salud");
        amuleto_salud_user.setDescripcion("Amuleto que aumenta la salud del usuario");
        user.agregarEquipaje(amuleto_salud_user);

        Llave llave1 = new Llave();
        llave1.setNombre("Llave Castillo");
        llave1.setDescripcion("llave para entrar al castillo destruido");

        Llave llave2 = new Llave();
        llave2.setNombre("Llave Rubí");
        llave2.setDescripcion("llave para entrar a la sala del castillo destruido");

        Map <String, String> inventario_descripcion = new HashMap<>();
        inventario_descripcion.put("AD","Amuleto Daño, obtienes 10 de daño extra");
        inventario_descripcion.put("AS", "Amuleto Salud, obtienes 50 de salud extra");
        inventario_descripcion.put("LL1","Llave que abre el castillo destruido");
        inventario_descripcion.put("LL2","Llave que abre la sala del castillo destruido");

        Npc npc1 = new Npc(1);
        npc1.setNombre("Cocodrilo Radioactivo");
        npc1.getArma().setDano(150);
        npc1.setID("L1");

        Npc npc2 = new Npc(1);
        npc2.setNombre("Lagarto Mayor");
        npc2.getArma().setDano(180);
        npc2.setID("L2");

        Npc npc3 = new Npc(2);
        npc3.setNombre("Tortugas Ancianas");
        npc3.getArma().setDano(200);
        npc3.setID("R1");

        Npc npc4 = new Npc(2);
        npc4.setNombre("Lagarto Mutante");
        npc4.getArma().setDano(250);
        npc4.setID("R2");

        Npc npc5 = new Npc(2);
        npc5.setNombre("Perro Mutante");
        npc5.getArma().setDano(300);
        npc5.setID("R3");

        Npc npc6 = new Npc(3);
        npc6.setNombre("Bandido");
        npc6.getArma().setDano(300);
        npc6.setID("U1");

        Npc npc7 = new Npc(3);
        npc7.setNombre("Mujerzuela");
        npc7.getArma().setDano(350);
        npc7.setID("U2");

        Npc boss = new Npc(4);
        boss.setNombre("Jefe Rebelde");
        boss.getArma().setDano(400);
        boss.setID("D1");

        //Llave llave2 = new Llave();
        Varios item1 = new Varios();
        item1.setNombre("Carne de rata");

        Map <String, Items> npc_items = new HashMap<>();
        npc_items.put("R3", llave1);
        npc_items.put("U2",llave2);

        Map <String, Npc> lista_npc = new HashMap<>();
        lista_npc.put("L1", npc1);
        lista_npc.put("L2", npc2);
        lista_npc.put("R1", npc3);
        lista_npc.put("R2", npc4);
        lista_npc.put("R3", npc5);
        lista_npc.put("U1", npc6);
        lista_npc.put("U2", npc7);
        lista_npc.put("D1", boss);

        while (true){
            Scanner comando = new Scanner(System.in);
            //LISTAR COMANDOS
            String opcion1 = comando.nextLine();
            String[] aux = opcion1.split(" ");
            switch (aux[0]){
                case "list":
                    if (aux[1].equals("inventory")){
                        System.out.println("Arma:");
                        System.out.println(user.getArma().getNombre());
                        if (user.getEquipaje().isEmpty()){
                            System.out.println("No tienes nada mas en inventario");
                        }
                        else {
                            System.out.println("Inventario:");
                            contar(user,user.getEquipaje());
                        }
                    }
                    else if (aux[1].equals("quests")){
                        System.out.println("Ubicacion:");
                        System.out.println(user.getUbicacion());
                        System.out.println("Misiones:");
                        System.out.println(misiones.get(user.getUbicacion()));
                    }
                    break;
                case "use":
                    if (lista_items.contains(aux[1])){
                        usar_item(aux[1],user);
                        System.out.println("Item usado correctamente");
                    }
                    break;
                case "walk":
                    if (aux[1].equals("L")){ //alcantarillas
                        user.setUbicacion(mapa.get("L"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);

                    }
                    else if (aux[1].equals("R")){ //ciudad destruida
                        user.setUbicacion(mapa.get("R"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);

                    }
                    else if (aux[1].equals("U")){ //castillo destruido
                        if (user.getEquipaje().contains(llave1)){
                            user.setUbicacion(mapa.get("U"));
                            descripcion_zona(user.getUbicacion(),user,enemigos);
                        }
                        else {
                            System.out.println("Te falta una llave para poder entrar al castillo");
                        }
                    }
                    else if (aux[1].equals("D")){ //sala castillo destruido
                        if (user.getEquipaje().contains(llave1) && user.getEquipaje().contains(llave2)){
                            user.setUbicacion(mapa.get("D"));
                            descripcion_zona(user.getUbicacion(),user,enemigos);
                        }
                        else {
                            System.out.println("Te hace falta la llave rubi para poder entrar a la sala" +
                                    " del castillo destruido");
                        }
                    }
                    break;
                case "lookat":
                    if (aux[1].equals("enemies")){
                        System.out.println("Enemigos:");
                        System.out.println(enemigos.get(user.getUbicacion()));
                    }
                    else if (aux[1].equals("items")){
                        System.out.println("Items:");
                        System.out.println(items_por_zona.get(user.getUbicacion()));
                    }
                    else if (lista_enemigos.contains(aux[1])){
                        System.out.println(enemigos_descripcion.get(aux[1]));
                    }
                    else if (lista_items.contains(aux[1])){
                        System.out.println(items_descripcion.get(aux[1]));
                    }
                    break;
                case "pickup":
                    System.out.println("RECOGER");
                    if (lista_items.contains(aux[1])){
                        recoger(aux[1],user, nombres_items,items_descripcion);
                        System.out.println(nombres_items.get(aux[1]));
                        System.out.println("recogido exitosamente");
                        //contar(user,user.getEquipaje());
                    }
                    break;
                case "attack":
                    if (lista_enemigos.contains(aux[1])){
                        Combate nuevo_combate = new Combate(user,lista_npc.get(aux[1]),npc_items);
                        lista_npc.remove(aux[1]);
                        if (boss.getSalud() <= 0){
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.println("Ingresa un [enemyID] correcto");
                    }
                    break;
                case "help":
                    System.out.println("list [inventory|quests]");
                    System.out.println("Lista el inventario o misiones activas\n");

                    System.out.println("use [itemId]");
                    System.out.println("Usa un objeto del inventario\n");

                    System.out.println("walk [L|R|U|D]");
                    System.out.println("Mueve al jugador en alguna dirección, cambiando de zona\n");

                    System.out.println("lookat [enemies|items]");
                    System.out.println("Lista todos los enemigos o items en la zona actual\n");

                    System.out.println("pickup [itemId]");
                    System.out.println("Recoge un item de la zona\n");

                    System.out.println("attack [enemyId]");
                    System.out.println("Ataca a un enemigo en la zona, entrando en batalla\n");
                    break;
            }
        }
    }

    private static void descripcion_zona(String zona, Usuario user, Map<String, List> hashmap){
        switch (zona) {
            case "Alcantarillas":
                System.out.println("Estas en las alcantarillas, por residuos redioactivos tu salud disminuye en 300");
                System.out.println("Cantidad de enemigos:");
                System.out.println(hashmap.get("Alcantarillas").size());
                user.restarSalud(30);
                break;
            case "Ciudad Destruida":
                System.out.println("Estas en la ciudad destruida, tu daño se ve reducido en 50 por niebla acida");
                System.out.println("Cantidad de enemigos:");
                System.out.println(hashmap.get("Ciudad Destruida").size());

                break;
            case "Castillo Destruido":
                System.out.println("Estas en el Castillo Destruido");
                System.out.println("Cantidad de enemigos:");
                System.out.println(hashmap.get("Castillo Destruido").size());

                break;
            case "Sala del Castillo Destruido":
                System.out.println("Estas en la sala del Castillo Destruido, tus habilidades estan al 100%, a por el " +
                        " jefe final!");
                break;
        }

    }
    private static void contar(Usuario user, ArrayList<Items> equipaje){
        for(int x=0; x<equipaje.size(); x++){
            System.out.println(user.getEquipaje().get(x).getNombre());
        }
    }

    private static void usar_item(String id, Usuario user){
        switch (id){
            case "IL1":
                user.setSalud(user.getSalud()+50);
                //user.getEquipaje().remove();
                break;
            case "IL2":
                System.out.println("Este item no se puede usar :c");
                break;
            case "IR1":
                user.getArma().setDano(user.getArma().getDano()+20);
                break;
            case "IR2":
                System.out.println("Este item no se puede usar :c");
                break;
            case "IU1":
                user.setSalud(user.getSalud()+30);
                user.getArma().setDano(user.getArma().getDano()+30);
                break;
            case "IU2":
                System.out.println("Ya tienes puesta la gorra sexy");
                break;
            case "ID2":
                System.out.println("Ahora llevas mayor luminosidad");
                break;
        }
    }

    private static void recoger(String id, Usuario user, Map<String,String> nombres_items,
                                Map<String,String> items_descripcion){
        Varios nuevo_item = new Varios();
        nuevo_item.setNombre(nombres_items.get(id));
        nuevo_item.setDescripcion(items_descripcion.get(id));
        nuevo_item.setID(id);
        user.agregarEquipaje(nuevo_item);
    }
}