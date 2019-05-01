/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Temperatura.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */
public class Temperatura {
    private int id;
    private double temperatura;
    private Color color;
    private String nombreImagen;

    public Temperatura(int id, Color color, String nombreImagen) {
        this.id = id;
        this.temperatura = 0.0;
        this.color = color;
        this.nombreImagen = nombreImagen;
    }
    
    public void calcularTemperatura(){
        this.temperatura = ThreadLocalRandom.current().nextInt(1, 400);
    }

    public int getId() {
        return id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public Color getColor() {
        return color;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }
}
