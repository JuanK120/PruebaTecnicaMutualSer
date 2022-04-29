package com.Alcancia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    private boolean bandera;
    private Alcancia alcancia;
    private InputStreamReader inputReader = new InputStreamReader(System.in);
    private BufferedReader reader = new BufferedReader (inputReader);

    public View(Alcancia alc){
        bandera = true;
        init(alc);
    }

    private void init(Alcancia alc){
        int entrada;
        alcancia = alc;
        try {
            while (bandera){
                System.out.print("Bienvenido a su ALCANCIA, ingrese una de las siguientes opciones:  \n" +
                        "0 para agregar monedas \n" +
                        "1 para saber la cantidad de monedas en la alcancia \n" +
                        "2 para saber la cantidad de dinero en la alcancia \n" +
                        "3 para saber la cantidad de monedas de cierta denominacion \n" +
                        "4 para saber la cantidada de dinero en monedas de cierta denominacion \n" +
                        "5 para salir \n" +
                        "por favor ingrese una opcion :");
                entrada = Integer.parseInt(reader.readLine());
                if ((entrada>=0) && (entrada<6)){
                    switch (entrada){
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
                }else {
                    System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            init(alcancia);
        }
        alcancia = null;
        System.out.println("Hasta Luego");

    }

    private void agregarMonedas(){
        int entrada,tipoMoneda;
        try {
            while (bandera){
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
                    for (int i=0;i<entrada;i++){
                        alcancia.addMonedas(tipoMoneda);
                    }
                    comprobarSigue(0);
                }else {
                    System.out.println("Opcion No Valida, por favor ingrese otra opcion");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            agregarMonedas();
        }
    }

    private void cantidadMonedasGeneral(){
        int cantidadMonedas;
        cantidadMonedas=alcancia.getCantidadMonedas();
        System.out.print("Hay "+cantidadMonedas+" monedas en la alcancia \n");
        comprobarSigue(1);
    }

    private void cantidadDineroGeneral(){
        int cantidadDinero;
        cantidadDinero=alcancia.getCantidadDineroTotal();
        System.out.print("Hay $"+cantidadDinero+" en la alcancia \n");
        comprobarSigue(2);
    }

    private void cantidadMonedasTipo(){
        int entrada,cantidadMonedasTipo;
        try {
            while (bandera){
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
        } catch (NumberFormatException e){
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            cantidadMonedasTipo();
        }
    }

    private void cantidadDineroTipo(){
        int entrada,cantidadDineroTipo;
        try {
            while (bandera){
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
        } catch (NumberFormatException e){
            System.out.println("Opcion No Valida, por favor ingrese otra opcion");
            cantidadDineroTipo();
        }
    }

    private void comprobarSigue(int menu){
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
