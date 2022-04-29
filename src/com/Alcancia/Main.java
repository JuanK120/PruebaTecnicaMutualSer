package com.Alcancia;

public class Main {

    /**
     * clase main de la aplicacion, crea los objetos y corre el programa
     *
     * @param args
     */
    public static void main(String[] args) {
        Alcancia alcancia = new Alcancia();
        View vista = new View(alcancia);
    }
}
