package com.company;

import combate.Combate;
import equipamento.Armas;
import objetos.Llave;
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
        user.setSalud(1000);

        //DEFINIMOS MAPA

        Map <String, String> mapa = new HashMap<String, String>();
        mapa.put("L","Alcantarillas");
        mapa.put("R","Ciudad Destruida");
        mapa.put("U","Castillo Destruido");
        mapa.put("D","Sala del Castillo Destruido");

        // DEFINIMOS ZONAS CON SUS ENEMIGOS
        Map<String, List> enemigos = new HashMap<String, List>();
        enemigos.put("Alcantarillas",Arrays.asList("Cocodrilo (ID:L1)","Lagarto Mayor (ID:L2)"));
        enemigos.put("Ciudad Destruida",Arrays.asList("Tortugas ancianas (ID:R1)","Lagarto Mutante (ID:R2)",
                "Perro mutante (ID:R3)"));
        enemigos.put("Castillo Destruido",Arrays.asList("Bandido (ID:U1)","Rebelde (ID:U2)",
                "Mujerzuela (ID:U3)"));
        enemigos.put("Sala del Castillo Destruido",Arrays.asList("Jefe rebelde (ID:D1)"));

        // DEFINIMOS ZONAS CON SUS MISIONES
        /*
        Map <String,List> misiones = new HashMap<String, List>();

        misiones.put("Alcantarillas", Arrays.asList("Encontrar un arma","Derrotar al Lagarto mayor"+
                "Encontrar chaleco de kevlar"));
        misiones.put("Ciudad Destruida", Arrays.asList("Derrotar tortugas ancianas", "Derrotar lagarto mutante\n",
                " Derrotar perro mutante"));
        misiones.put("Castillo Destruido", Arrays.asList("Derrotar bandido","Derrotar rebelde",
                "Derrotar mujerzuela", "Encontrar llave para abrir sala del castillo destruido"));
        misiones.put("Sala del Castillo Destruido", Arrays.asList("Derrotar jefe rebelde"));
        */

        HashMap<String, ArrayList<String>> misiones = new HashMap<String, ArrayList<String>>();
        ArrayList<String> misiones_alcantarillas = new ArrayList<String>();
        misiones_alcantarillas.add("Encontrar un arma");
        misiones_alcantarillas.add("Derrotar lagarto mayor");
        misiones_alcantarillas.add("Encontrar chaleco de kevlar");
        misiones.put("Alcantarillas", misiones_alcantarillas);

        ArrayList<String> misiones_ciudad_destruida = new ArrayList<String>();
        misiones_ciudad_destruida.add("Derrotar tortugas ancianas");
        misiones_ciudad_destruida.add("Derrotar lagarto mutante");
        misiones_ciudad_destruida.add("Derrotar perro mutante");
        misiones.put("Ciudad Destruida", misiones_ciudad_destruida);

        ArrayList<String> misiones_castillo_destruido = new ArrayList<String>();
        misiones_castillo_destruido.add("Derrotar bandido");
        misiones_castillo_destruido.add("Derrotar rebelde");
        misiones_castillo_destruido.add("Derrotar mujerzuela");
        misiones_castillo_destruido.add("Encontrar llave para abrir sala del castillo destruido");
        misiones.put("Castillo Destruido", misiones_castillo_destruido);

        ArrayList<String> misiones_sala_castillo_destruido = new ArrayList<String>();
        misiones_sala_castillo_destruido.add("Derrotar jefe rebelde");
        misiones.put("Sala del Castillo Destruido",misiones_sala_castillo_destruido);


        //Nivel 1 -> Alcantarillas
        System.out.println(nombre+" eres la ultima persona en la tierra. Has despertado de un largo sueño y la humanidad"+
                " como la conoces ha llegado a su fin.\n" +
                "Soy el perro de tu ta-tara-abuelo y he venido"+
                " aquí para aconsejarte acerca de tu futuro.\nNo tienes provisiones y tienes que dejar estas" +
                " alcantarillas si quieres sobrevivir.\n Adelante, que comience tu aventura!\n");
        /*
        System.out.println("1: Espada del viejo mundo"); // 200 de daño
        System.out.println("2: Hacha del destino final"); //150 de daño y 100 de armadura
        System.out.println("3: Arco y flechas"); //100 de daño y 500 de salud
        int opcion = arma.nextInt();
        if(opcion == 1){
            Armas espada = new Armas();
            espada.setNombre("Espada del viejo mundo");
            espada.setDano(200);
            espada.setNivel(1);
        }
        else if (opcion == 2){
            Armas hacha = new Armas();
            hacha.setNombre("Hacha del destino final");
            hacha.setDano(150);
            hacha.setNivel(1);
        }
        else if (opcion == 3){
            Armas arco = new Armas();
            arco.setNombre("Arco y flechas");
            arco.setDano(100);
            arco.setNivel(1);
        }
        System.out.println("Ahora que has seleccionado tu arma estas listo para comenzar la lucha," +
                " recuerda que te encontraras con diversos objetos\n que te ayudaran a sobrevivir." +
                " Nada mas me queda desearte buena suerte, estare cuidando tu espalda si necesitas algun consejo ");
        System.out.println("");
        */
        while (true){
            Scanner comando = new Scanner(System.in);
            //LISTAR COMANDOS
            String opcion1 = comando.nextLine();
            String[] aux = opcion1.split(" ");
            switch (aux[0]){
                case "list":
                    if (aux[1].equals("[inventory]")){
                        if (user.getEquipaje().isEmpty()){
                            System.out.println("No tienes nada en inventario");
                        }
                        else {
                            System.out.println("LISTAR INVENTARIO");
                        }
                    }
                    else if (aux[1].equals("[quests]")){
                        user.setUbicacion("L");
                        System.out.println(misiones.get("Alcantarillas"));
                    }
                    break;
                case "use":
                    System.out.println("USAR OBJETO DEL INVENTARIO");
                    break;
                case "walk":
                    if (aux[1].equals("[L]")){ //alcantarillas
                        user.setUbicacion(mapa.get("L"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);

                    }
                    else if (aux[1].equals("[R]")){ //ciudad destruida
                        user.setUbicacion(mapa.get("R"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);

                    }
                    else if (aux[1].equals("[U]")){ //castillo destruido
                        user.setUbicacion(mapa.get("U"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);
                    }
                    else if (aux[1].equals("[D]")){ //sala castillo destruido
                        // if user.getEquipaje().contains(llave para entrar al castillo)
                        user.setUbicacion(mapa.get("D"));
                        descripcion_zona(user.getUbicacion(),user,enemigos);
                    }
                    break;
                case "lookat":
                    System.out.println("LISTA ENEMIGOS");
                    break;
                case "pickup":
                    System.out.println("RECOGER");
                    break;
                case "attack":
                    System.out.println("ATACAR");
                    break;
                case "help":
                    System.out.println("list [inventory|quests]\n");
                    System.out.println("use [itemId]\n");
                    System.out.println("walk [L|R|U|D]\n");
                    System.out.println("pickup [itemId]\n");
                    System.out.println("attack [enemyId]");
                    break;
            }
        }
    }

    private static void descripcion_zona(String zona, Usuario user, Map<String, List> hashmap){
        if (zona.equals("Alcantarillas")){
            System.out.println("Estas en las alcantarillas, por residuos redioactivos tu salud disminuye en 300");
            System.out.println("Cantidad de enemigos:");
            System.out.println(hashmap.get("Alcantarillas").size());
            user.restarSalud(30);
        }
        else if (zona.equals("Ciudad Destruida")){
            System.out.println("Estas en la ciudad destruida, tu daño se ve reducido en 50 por niebla acida");
            System.out.println("Cantidad de enemigos:");
            System.out.println(hashmap.get("Ciudad Destruida").size());

        }
        else if (zona.equals("Castillo Destruido")){
            System.out.println("Estas en el Castillo Destruido");
            System.out.println("Cantidad de enemigos:");
            System.out.println(hashmap.get("Castillo Destruido").size());

        }
        else if (zona.equals("Sala del Castillo Destruido")){
            System.out.println("Estas en la sala del Castillo Destruido, tus habilidades estan al 100%, a por el " +
                    " jefe final!");
        }

    }
    private static void contar(Map aux){
        Iterator it = aux.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
        }
    }


        //Se le entregan la espada, el chaleco y las botas. Se le preguntara al jugador que quiere hacer con ellas
        //Si recogerlas, o no recogerlas. Si no las recoge el jugador no podra dar cara a los enemigos y su muerte sera
        //inevitable.

        //Perro: Durante tu lucha te encontraras con diversos objetos que te ayudaran a sobrevivir. Como por ejemplo
        //agua, cerveza, pan, pizza,etc. Es recomendable que ocupes estos objetos consumibles.
        //Bueno y nada mas me queda desearte buena suerte, estare cuidando tu espalda si quieres algun consejo.

        //Transcurre el nivel..
        //Se creara un arreglo, enemigos=[5,6,7,8,9,10], en donde al principio del nivel se aplicara la funcion random
        //al arreglo para saber a cuantos enemigos se tendra que enfrentar (eso no lo sabe el jugador, es para darle
        //variedad al juego). Y cada enemigo tendra otro arreglo items_a_dropear=[0,1,2] y tambien se le aplicara
        //random para saber si es que dropea o no items.

        //Perro: Cuidado adelante, se encuentra el Lagarto mayor, que custodia la escalera a la superficie.
        //Es tu eleccion si te enfrentas a el o no,pero te advierto, es muy poderoso. Se le da a elegir al jugador.

        //Al matar al Lagarto mayor, este dropea la mascara de gas y se le pregunta al jugador si quiere tomarla o no,
        //si la toma puede salir y si es que no este morira al principio del nivel 2. Esta mascara le da 10 defensa
        //y 20 de armadura al personaje.

        //Nivel 2 -> Ciudad destruida
        //Caracteristicas: Ataque*0.9, Defensa*0.9, Armadura*0.9
        //Perro: Ves lo que hizo la humanidad a este hermoso planeta?
        //Se le da a elegir al jugador, SI->(Perro Responde: Entonces si sabes no seas igual a ellos y cuida tu hogar)
        //NO ->(Entonces eres un estupido)..continua el dialogo del perro...
        //Aqui la radiacion afectara en tus habilidades, por lo que atacaras y te defenderas menos.
        //La unica posibilidad de supervivencia es abrirte paso entre las criaturas para asi llegar al castillo
        //destruido.

        //Transcurre el nivel...

        //Al llegar a la puerta del castillo se hara un arreglo, tortugas=[4,5,6] y al matar a la ultima tortuga
        //se dropeara la llave del castillo.

        //Nivel 3 -> Castillo Destruido
        //Caracteristicas: Ataque*1, Defensa*1, ganar experiencia*0.8, Armadura*1.05
        //Perro: Para serte franco nunca pense que llegarias tan lejos.. Se le da a elegir al jugador
        //LLORAR->(Perro: Que marica que eres, deberias atacar menos(se multplica tu ataque por 0.9)) o REIR->(Perro:
        //Interesante reaccio, me caes bien (se multplica el ataque por 1.1 ))
        //continua el dialogo... Este castillo esta lleno de seres como tu, no hace falta decirte mas, tu los conoces
        //mejor que yo.

        //Una llave color rubi se dropea al matar la "unica" mujerzuela del castillo.Llave escondida en sus bragas.

        //Transcurre el nivel...

        //Perro: Hemos llegado casi al final de tu viaje, en esta sala se encuentra el jefe de toda esta tribu de
        //supervivientes, jefe que codicia y poca vez comparte todos los recursos recuadados por su gente.
        //Es tu mision entrar para derrocarlo y rescatar a las mujerzuelas atrapadas en el calabozo de la sala
        //principal.


        //Nivel 4 -> Sala del castillo destruido
        //Caracteristicas: Ataque*1.1 y Defensa*1.1

        //Jefe de le Tribu de supervivientes: Quien hoza entrar en mis aposentos?!
        //Se le da a elegir al jugador una serie de opciones...

        //Falta desarrollar.

        //FIN.
    }