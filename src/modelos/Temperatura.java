/*
 */
package modelos;

import herramientas.Comparador;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Clase Temperatura.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el calculo de la temperaturaCelsius segun el color obtenido de la
 coordenda seleccionada.
 */


public class Temperatura{
    
    private int id;
    private double temperaturaCelsius;
    private double temperaturaKelvin;
    private double temperaturaFarenheit;
    private Color color;
    private String nombreImagen;

    public Temperatura( int id, Color color, String nombreImagen ){
        
        this.id = id;
        this.temperaturaCelsius = 0.0;
        this.temperaturaKelvin = 0.0;
        this.temperaturaFarenheit = 0.0;
        this.color = color;
        this.nombreImagen = nombreImagen;
        
    }
    
    public Temperatura( int id, Color color, String nombreImagen, double temperatura ){
        
        this.id = id;
        this.color = color;
        this.nombreImagen = nombreImagen;
        this.temperaturaCelsius = temperatura;
        this.temperaturaFarenheit = convertirTemp( this.temperaturaCelsius, 1 );
        this.temperaturaKelvin = convertirTemp( this.temperaturaCelsius, 2 );
    }
    
    /**
     * Funcion para calcular temperaturas
     * IBelmont
     * Desde 01/05/19
     * @param Se carga las dos partes de paleta de colores que se tiene
     **/ 
    
    public void calcularTemperatura(ArrayList<NodoTemp> paletaColorAsignadaPartA, 
        ArrayList<NodoTemp> paletaColorAsignadaPartB){
        
        int eleccion = this.color.getRGB()* -1 ;
        
        if( eleccion > 3160048 &&  eleccion < 10441429 ){
            
            double auxTemp = Comparador.Calcular(paletaColorAsignadaPartB, this.color.getRGB());
            this.temperaturaCelsius = auxTemp;
            
            if(auxTemp == -1.1){
                auxTemp = Comparador.Calcular(paletaColorAsignadaPartA, this.color.getRGB());
            }
            
        }else{
            
            double auxTemp = Comparador.Calcular(paletaColorAsignadaPartA, this.color.getRGB());
            this.temperaturaCelsius = auxTemp;
            
            if(auxTemp == -1.1){
                auxTemp = Comparador.Calcular(paletaColorAsignadaPartB, this.color.getRGB());
            }
            
        }
        
        this.temperaturaFarenheit = convertirTemp( this.temperaturaCelsius, 1 );
        this.temperaturaKelvin = convertirTemp( this.temperaturaCelsius, 2 );
        
    }
    
    /**
     * Funcion convertir temperaturas
     * IBelmont
     * Desde 01/05/19
     * params temperatura en celcius , opcion a convertir 1 farenheit 2 kelvin
     **/ 
    
    private double convertirTemp( double tempCelsius, int opc ){
        
        double calculo = 0.0;
        
        if( opc == 1 ){ //Farenheit (0 °C × 9/5) + 32
            
            calculo =  ( tempCelsius * 1.8 ) + 32;
        
        }else if( opc == 2 ){ //Kelvin 0 °C + 273.15 
            
            calculo = tempCelsius + 273.15;
            
        }
        
        return calculo;
        
    }

    public int getId(){
        
        return id;
        
    }

    public double getTemperaturaCelsius(){
        
        return temperaturaCelsius;
        
    }

    public Color getColor(){
        
        return color;
        
    }

    public String getNombreImagen(){
        
        return nombreImagen;
        
    }

    public double getTemperaturaKelvin() {
        
        return temperaturaKelvin;
        
    }

    public double getTemperaturaFarenheit() {
        
        return temperaturaFarenheit;
        
    }    

}