/*
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
    
    /**
     * Funcion agregar un arreglo de temperaturas a la coordenada
     * IBelmont
     * Desde 01/05/19
     * params arreglo de temperatura
     **/ 
    
    public void agregarTemperatura( ArrayList<Temperatura> temperatura ){
        
        this.temperatura = temperatura;
        
    }
    
    /**
     * Funcion agregar temperatura al arreglo de temepratura
     * IBelmont
     * Desde 01/05/19
     * params objeto de tipo temperatura
     **/ 
    
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