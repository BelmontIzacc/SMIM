/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.util.ArrayList;
import modelos.Temperatura;

/**
 * Clase QuickSort.
 * Fecha Miercoles 08 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el ordenamiento de los valores obtenidos de las temperaturas
 * analisadas, para poder calcular mediana y moda.
 */


public class Ordenar{
    
    /**
     * Funcion para ordenar toda una coleccion de temperatura para calculos estadisticos
     * IBelmont
     * Desde 08/05/19
     * params arreglo de temperatura
     **/ 
    
    public static ArrayList ordenarBurbujaOpt( ArrayList<Temperatura> t ){
        
        ArrayList<Temperatura> listaTemperatura = t;
        
        for( int i = 0 ; i < listaTemperatura.size() - 1 ; i++ ){
            
            for( int j = 0 ; j < listaTemperatura.size() - i - 1 ; j++ ){
                
                if( listaTemperatura.get( j ).getTemperaturaCelsius() > listaTemperatura.get( j+1 ).getTemperaturaCelsius() ){
                    
                    int idSiguiente = listaTemperatura.get( j + 1 ).getId();
                    Color colorSiguiente = listaTemperatura.get( j + 1 ).getColor();
                    String nombreSiguiente = listaTemperatura.get( j + 1 ).getNombreImagen();
                    double temperaturaSiguiente = listaTemperatura.get( j + 1 ).getTemperaturaCelsius();
                    
                    Temperatura nuevaTemperatura = new Temperatura( idSiguiente, colorSiguiente, 
                            nombreSiguiente, temperaturaSiguiente );
                    
                    int idAnterior = listaTemperatura.get( j ).getId();
                    Color colorAnterior = listaTemperatura.get( j ).getColor();
                    String nombreAnterior = listaTemperatura.get( j ).getNombreImagen();
                    double temperaturaAnterior = listaTemperatura.get( j ).getTemperaturaCelsius();
                    
                    Temperatura remplazarTemperatura = new Temperatura( idAnterior, colorAnterior, 
                            nombreAnterior, temperaturaAnterior );
                    
                    listaTemperatura.set( j + 1 , remplazarTemperatura );
                    
                    listaTemperatura.set( j, nuevaTemperatura );
                    
                }
                
            }
            
        }
        
        return listaTemperatura;
        
    }
    
}