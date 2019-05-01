/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 * Clase Estadistica.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */
public class Estadistica {
    private double media;
    private double varianza;
    private double moda;
    private double desviacionEstandar;

    public Estadistica(ArrayList<Coordenada> puntosInteres) {
        this.media = 0;
        this.varianza = 0;
        this.moda = 0;
        this.desviacionEstandar = 0;
    }

    public double getMedia() {
        return media;
    }

    public double getVarianza() {
        return varianza;
    }

    public double getModa() {
        return moda;
    }

    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }
    
}
