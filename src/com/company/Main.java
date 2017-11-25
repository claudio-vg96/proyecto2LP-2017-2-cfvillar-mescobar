package com.company;

import combate.Combate;
import equipamento.Armas;
import objetos.Llave;
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
        //List<String> mapa = new ArrayList<>();
        //Map<String, List<String>> mapa = new LinkedHashMap<String, List<String>>();


        // DEFINIMOS ZONAS CON SUS ENEMIGOS
        Map<String, List> enemigos = new HashMap<String, List>();
        enemigos.put("Alcantarillas",Arrays.asList("Cocodrilo","Lagarto Mayor","Serpiente"));
        enemigos.put("Ciudad Destruida",Arrays.asList("Elementos","Ciudad","Destruida"));
        enemigos.put("Castillo Destruido",Arrays.asList("Elementos","Castillo","Destruido"));
        enemigos.put("Sala del Castillo Destruido",Arrays.asList("Elementos","Sala","Castillo","Destruido"));

        // DEFINIMOS ZONAS CON SUS MISIONES

        Map <String,List> misiones = new HashMap<String, List>();
        misiones.put("Alcantarillas", Arrays.asList("Encontrar un arma","Derrotar al Lagarto Anciano"+
                "Encontrar chaleco de kevlar"));

        //Nivel 1 -> Alcantarillas
        System.out.println(nombre+" eres la ultima persona en la tierra. Has despertado de un largo sueño y la humanidad"+
                " como la conoces ha llegado a su fin.\n" +
                "Soy el perro de tu ta-tara-abuelo y he venido"+
                " aquí para aconsejarte acerca de tu futuro.\nNo tienes provisiones y tienes que dejar estas" +
                " alcantarillas si quieres sobrevivir.\n Adelante, que comience tu aventura!");
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

        /*
        Iterator it = zona.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        */
        System.out.println("CAPITULO 1: ALCANTARILLAS");
        TimeUnit.SECONDS.sleep(3);
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
                        mostrar(misiones);
                        //System.out.println("LISTAR MISIONES");
                    }
                    break;
                case "use":
                    System.out.println("USAR OBJETO DEL INVENTARIO");
                    break;
                case "walk":
                    if (aux[1].equals("[L]")){
                        System.out.println("MOVERSE IZQUIERDA");
                    }
                    else if (aux[1].equals("[R]")){
                        System.out.println("MOVERSE DERECHA");
                    }
                    else if (aux[1].equals("[U]")){
                        System.out.println("MOVERSE ARRIBA");
                    }
                    else if (aux[1].equals("[D]")){
                        System.out.println("MOVERSE ABAJO");
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
                    System.out.println("HELP");
                    break;
            }
        }
    }

    private static void mostrar(Map aux){
        Iterator it = aux.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();

            System.out.println(e.getKey() + " " + e.getValue());
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