package com.Alcancia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * clase que contiene las vistas de la aplicacion de la alcancia
 */
public class View {

    /**
     * es el indicador de que el programa debe seguir ejecutandose
     */
    private boolean bandera;
    /**
     * la alcancia que se esta utilizando
     */
    private Alcancia alcancia;
    /**
     * objeto utilizado para I/0
     */
    private InputStreamReader inputReader = new InputStreamReader(System.in);
    /**
     * objeto utilizado para I/0
     */
    private BufferedReader reader = new BufferedReader(inputReader);

    /**
     * constructor de la clase, toma una alcancia e inicializa la vista de la aplicacion
     *
     * @param alc alcancia que se esta usando
     */
    public View(Alcancia alc) {
        bandera = true;
        while (bandera) {
            init(alc);
        }

    }

    /**
     * vista inicial de la aplicacion, es el menu principal, a partir del cual se
     * accede a las otras funcionalidades de la aplicacion
     *
     * @param alc alcancia que se esta usando
     */
    private void init(Alcancia alc) {
        int entrada;
        alcancia = alc;
        try {
            //while (bandera){}
            System.out.print("Bienvenido a su ALCANCIA, ingrese una de las siguientes opciones:  \n" +
                    "0 para agregar monedas \n" +
                    "1 para saber la cantidad de monedas en la alcancia \n" +
                    "2 para saber la cantidad de dinero en la alcancia \n" +
                    "3 para saber la cantidad de monedas de cierta denominacion \n" +
                    "4 para saber la cantidada de dinero en monedas de cierta denominacion \n" +
                    "5 para salir \n" +
                    "por favor ingrese una opcion :");
            entrada = Integer.parseInt(reader.readLine());
            if ((entrada >= 0) && (entrada < 6)) {
                switch (entrada) {
                    case 0:
                        agregarMonedas();
                    case 1:
                        cantidadMonedasGeneral();
                    case 2:
                        cantidadDineroGeneral();
                    case 3:
                        cantidadMonedasTipo();
                    case 4:
                        cantidadDineroTipo();
                    case 5:
                        bandera = false;
                }
            } else {
                System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                init(alcancia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            init(alcancia);
        }
        alcancia = null;
        System.out.println("Hasta Luego");
        System.exit(0);

    }

    /**
     * la vista de agregar monedas, es el menu que se usa para meter monedas a la alcancia
     */
    private void agregarMonedas() {
        int entrada, tipoMoneda;
        try {
            while (bandera) {
                System.out.print("Que tipo de monedas le gustaria agregar a la alcancia? \n" +
                        "0 para agregar un monedas de 50 \n" +
                        "1 para agregar un monedas de 100 \n" +
                        "2 para agregar un monedas de 200 \n" +
                        "3 para agregar un monedas de 500 \n" +
                        "4 para agregar un monedas de 1000 \n" +
                        "por favor ingrese una opcion :");
                entrada = Integer.parseInt(reader.readLine());
                if ((entrada>=0) && (entrada<5)){
                    tipoMoneda=entrada;
                    System.out.print("Cuantas monedas le gustaria agregar a la alcancia? \n");
                    entrada = Integer.parseInt(reader.readLine());
                    for (int i = 0; i<entrada; i++){
                        alcancia.addMonedas(tipoMoneda);
                    }
                    comprobarSigue(0);
                }else {
                    System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            agregarMonedas();
        }
    }

    /**
     * la vista de consulta general de monedas, es el menu que se usa para consultar
     * la cantidad total de monedas en la alcancia
     */
    private void cantidadMonedasGeneral() {
        int cantidadMonedas;
        cantidadMonedas = alcancia.getCantidadMonedas();
        System.out.print("Hay " + cantidadMonedas + " monedas en la alcancia \n");
        comprobarSigue(1);
    }

    /**
     * la vista de consulta general de dinero, es el menu que se usa para consultar
     * la cantidad total de dinero en la alcancia
     */
    private void cantidadDineroGeneral() {
        int cantidadDinero;
        cantidadDinero = alcancia.getCantidadDineroTotal();
        System.out.print("Hay $" + cantidadDinero + " en la alcancia \n");
        comprobarSigue(2);
    }

    /**
     * la vista de consulta de monedas por tipo, es el menu que se usa para consultar
     * la cantidad de monedas de un cierto tipo en la alcancia
     */
    private void cantidadMonedasTipo() {
        int entrada, cantidadMonedasTipo;
        try {
            while (bandera) {
                System.out.print("Que tipo de monedas le gustaria consultar? \n" +
                        "0 para consultar monedas de 50 \n" +
                        "1 para consultar monedas de 100 \n" +
                        "2 para consultar monedas de 200 \n" +
                        "3 para consultar monedas de 500 \n" +
                        "4 para consultar monedas de 1000 \n" +
                        "por favor ingrese una opcion :");
                entrada = Integer.parseInt(reader.readLine());
                if ((entrada>=0) && (entrada<5)){
                    cantidadMonedasTipo=alcancia.getCantidadMonedatipo(entrada);
                    System.out.print("hay "+cantidadMonedasTipo+" monedas\n");
                    comprobarSigue(3);
                }else {
                    System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            cantidadMonedasTipo();
        }
    }

    /**
     * la vista de consulta de dinero por tipo de moneda, es el menu que se usa para consultar
     * la cantidad de dinero que hay solo en un cierto tipo de moneda en la alcancia
     */
    private void cantidadDineroTipo() {
        int entrada, cantidadDineroTipo;
        try {
            while (bandera) {
                System.out.print("Que tipo de monedas le gustaria consultar? \n" +
                        "0 para consultar monedas de 50 \n" +
                        "1 para consultar monedas de 100 \n" +
                        "2 para consultar monedas de 200 \n" +
                        "3 para consultar monedas de 500 \n" +
                        "4 para consultar monedas de 1000 \n" +
                        "por favor ingrese una opcion :");
                entrada = Integer.parseInt(reader.readLine());
                if ((entrada>=0) && (entrada<5)){
                    cantidadDineroTipo=alcancia.getCantidadDineroMoneda(entrada);
                    System.out.print("hay $"+cantidadDineroTipo+"\n");
                    comprobarSigue(4);
                }else {
                    System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            cantidadDineroTipo();
        }
    }

    /**
     * la vista de pregunta de continuar, es el menu en el cual si se le pregunta al usuario
     * si despues de haber hecho una accion, desea seguir en ese menu, o desea volver al menu
     * principal
     *
     * @param menu vista o menu actual en el que se encuentra siendo las opciones posibles 0, 1, 2, 3, 4
     */
    private void comprobarSigue(int menu) {
        int entrada;
        try {
            System.out.print("desea seguir aqui? \n" +
                    "0 para si\n" +
                    "1 para no \n" +
                    "por favor ingrese una opcion :");
            entrada = Integer.parseInt(reader.readLine());
            if (entrada == 0) {
                switch (menu) {
                    case 0:
                        agregarMonedas();
                    case 1:
                        cantidadMonedasGeneral();
                    case 2:
                        cantidadDineroGeneral();
                    case 3:
                        cantidadMonedasTipo();
                    case 4:
                        cantidadDineroTipo();

                }
            } else if (entrada == 1) {
                init(alcancia);
            } else {
                System.out.print("opcion no valida, ingrese otra opcion\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            comprobarSigue(menu);
        }

    }


}
