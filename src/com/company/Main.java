package com.company;

import combate.Combate;
import equipamento.Equipamento;
import objetos.Llave;
import personajes.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        System.out.println(" BIENVENIDOS 'A Reptiles y Mujerzuelas'");
        System.out.println("Ingresa el nombre de tu personaje:");
        Scanner name = new Scanner(System.in);
        String nombre = name.nextLine();
        Usuario user = new Usuario();
        user.setNombre(nombre);

        //Nivel 1 -> Alcantarillas
        System.out.println(nombre+" eres la ultima persona en la tierra. Has despertado de un largo sueño y la humanidad"+
                " como la conoces ha llegado a su fin.\n" +
                "Soy el perro de tu ta-tara-abuelo y he venido"+
                " aquí para aconsejarte acerca de tu futuro.\nNo tienes provisiones y tienes que dejar estas" +
                " alcantarillas si quieres sobrevivir.\nMas adelante te encontraras con diversos enemigos de origen" +
                " desconocido, por lo cual te entrego estas herramientas que te ayudaran a vencerlos.");

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
}