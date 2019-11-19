/*
 */
package herramientas;

import java.awt.Color;
import java.util.ArrayList;
import modelos.NodoTemp;
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

    /**
     * Funcion para ordenar nodos de paleta de temperatura por tonalidad pra busqueda binaria
     * IBelmont
     * Desde 18/11/19
     * params arreglo de temperatura rango espesificado
     **/ 
    
    public static ArrayList ordenarPorTonalidad(ArrayList<NodoTemp> c){
       
       ArrayList<NodoTemp> colores = c;
       
        for(int i = 0; i < colores.size()- 1; i++)
        {

            for(int j = 0; j < colores.size() - i - 1; j++)
            { 
                  //                           
                if (colores.get(j).getTonalidad() > colores.get(j+1).getTonalidad())
                {
                    NodoTemp tmp = new NodoTemp(colores.get(j+1).getTemperatura(),colores.get(j+1).getTonalidad());

                    colores.set(j+1, new NodoTemp(colores.get(j).getTemperatura(),colores.get(j).getTonalidad()));

                    colores.set(j,new NodoTemp(tmp.getTemperatura(), tmp.getTonalidad()));
                    tmp = null;
                }
            }
        }
       
       return colores;
       
    }
    
}