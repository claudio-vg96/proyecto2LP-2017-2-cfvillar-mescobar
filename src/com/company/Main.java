package com.company;

import combate.Combate;
import equipamento.Equipamento;
import objetos.Llave;
import personajes.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        System.out.println(" ######## BIENVENIDOOOOS ######## ");
        System.out.println("Ingresa el nombre de tu personaje");
        Scanner name = new Scanner(System.in);
        String nombre = name.nextLine();
        Usuario user = new Usuario();
        user.setNombre(nombre);

    }
}
