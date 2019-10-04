/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 * Clase Coordenada.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el manejo de las coordenadas de los puntos de interes elegidas por el usuario,
 * poder calcular la temperatura de estos puntos.
 * Estas coordendas se aplicaran en todas las imagenes obtenidas del medio termografico.
 */


public class Coordenada{
    
    private int id;
    private double coordX;
    private double coordY;
    private ArrayList<Temperatura> temperatura;

    public Coordenada( int id, double coordX, double coordY ){
        
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.temperatura = new ArrayList<>();
        
    }
    
    public void agregarTemperatura( ArrayList<Temperatura> temperatura ){
        
        this.temperatura = temperatura;
        
    }
    
    public void agregarTemperatura( Temperatura temperatura ){
        
        this.temperatura.add( temperatura );
        
    }

    public int getId(){
        
        return id;
        
    }

    public double getCoordX(){
        
        return coordX;
        
    }

    public double getCoordY(){
        
        return coordY;
        
    }

    public ArrayList<Temperatura> getTemperatura(){
        
        return temperatura;
        
    }
}