package com.Alcancia;



public class Alcancia {

    private int[] monedas;

    public Alcancia(){
        monedas = new int[5];
    }

    public boolean addMonedas(int tipoMoneda){

        switch (tipoMoneda){
            case 0:
                monedas[0] = monedas[0]+1;
                return true;
            case 1:
                monedas[1] = monedas[0]+1;
                return true;
            case 2:
                monedas[2] = monedas[0]+1;
                return true;
            case 3:
                monedas[3] = monedas[0]+1;
                return true;
            case 4:
                monedas[4] = monedas[0]+1;
                return true;
        }

        return false;
    }

    public int getCantidadMonedas(){
        int auxCantidadMonedasGeneral = 0;
        for (int i=0;i<monedas.length;i++){
            auxCantidadMonedasGeneral = auxCantidadMonedasGeneral + monedas[i];
        }
        return  auxCantidadMonedasGeneral;
    }

    public int getCantidadMonedatipo(int tipoMoneda){
        switch (tipoMoneda){
            case 0:
                return monedas[0];
            case 1:
                return monedas[1];
            case 2:
                return monedas[2];
            case 3:
                return monedas[3];
            case 4:
                return monedas[4];
        }
        return -1;

    }

    public int getCantidadDineroTotal(){
        int auxCantidadDineroTotal = 0;
        auxCantidadDineroTotal += monedas[0]*50;
        auxCantidadDineroTotal += monedas[1]*100;
        auxCantidadDineroTotal += monedas[2]*200;
        auxCantidadDineroTotal += monedas[3]*500;
        auxCantidadDineroTotal += monedas[4]*1000;
        return  auxCantidadDineroTotal;
    }

    public int getCantidadDineroMoneda(int tipoMoneda){
        switch (tipoMoneda){
            case 0:
                return monedas[0]*50;
            case 1:
                return monedas[1]*100;
            case 2:
                return monedas[2]*200;
            case 3:
                return monedas[3]*500;
            case 4:
                return monedas[4]*1000;
        }
        return -1;
    }



}
