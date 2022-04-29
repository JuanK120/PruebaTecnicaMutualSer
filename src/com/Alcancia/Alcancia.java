package com.Alcancia;

/**
 * clase que describe la alcancia con sus respectivas funciones
 */
public class Alcancia {

    /**
     * array que contiene de manera ordenada las monedas que contiene la alcancia
     * segun su tipo, siendo de la siguiente manera :
     * [50, 100, 200, 500, 1000]
     */
    private int[] monedas;

    /**
     * constructor de la clase, inicializa el array monedas
     */
    public Alcancia() {
        monedas = new int[5];
    }

    /**
     * añade una moneda a la alcancia, segun el tipo de moneda que se indica
     *
     * @param tipoMoneda el tipo de moneda a añadir, puede tomar los valores 0, 1, 2, 3, 4
     * @return true si se pudo añadir la moneda de forma exitosa, false en caso contrario
     */
    public boolean addMonedas(int tipoMoneda) {

        switch (tipoMoneda) {
            case 0:
                monedas[0] = monedas[0] + 1;
                return true;
            case 1:
                monedas[1] = monedas[1] + 1;
                return true;
            case 2:
                monedas[2] = monedas[2] + 1;
                return true;
            case 3:
                monedas[3] = monedas[3] + 1;
                return true;
            case 4:
                monedas[4] = monedas[4] + 1;
                return true;
        }

        return false;
    }

    /**
     * retorna la sumatoria de la cantidad de monedas que hay de cada tipo en la alcancia
     *
     * @return cantidad total de monedas
     */
    public int getCantidadMonedas() {
        int auxCantidadMonedasGeneral = 0;
        for (int i = 0; i < monedas.length; i++) {
            auxCantidadMonedasGeneral = auxCantidadMonedasGeneral + monedas[i];
        }
        return auxCantidadMonedasGeneral;
    }

    /**
     * retorna la cantidad de monedas de un tipo especifico que hay en la alcancia
     *
     * @param tipoMoneda el tipo de moneda a consultar, puede tomar los valores 0, 1, 2, 3, 4
     * @return cantidad de monedas del tipo escogido
     */
    public int getCantidadMonedatipo(int tipoMoneda) {
        switch (tipoMoneda) {
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

    /**
     * retorna la cantidad de Dinero de un tipo especifico que hay en la alcancia
     *
     * @return cantidad total de dinero
     */
    public int getCantidadDineroTotal() {
        int auxCantidadDineroTotal = 0;
        auxCantidadDineroTotal += monedas[0] * 50;
        auxCantidadDineroTotal += monedas[1] * 100;
        auxCantidadDineroTotal += monedas[2] * 200;
        auxCantidadDineroTotal += monedas[3] * 500;
        auxCantidadDineroTotal += monedas[4] * 1000;
        return auxCantidadDineroTotal;
    }

    /**
     * retorna la cantidad de dinero de un tipo de moneda especifico que hay en la alcancia
     *
     * @param tipoMoneda el tipo de moneda a consultar, puede tomar los valores 0, 1, 2, 3, 4
     * @return cantidad de dinero del tipo de moneda escogido
     */
    public int getCantidadDineroMoneda(int tipoMoneda) {
        switch (tipoMoneda) {
            case 0:
                return monedas[0] * 50;
            case 1:
                return monedas[1] * 100;
            case 2:
                return monedas[2] * 200;
            case 3:
                return monedas[3] * 500;
            case 4:
                return monedas[4] * 1000;
        }
        return -1;
    }


}
