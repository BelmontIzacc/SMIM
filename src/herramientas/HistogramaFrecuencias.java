/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Clase HistogramaFrecuencias.
 * Fecha Martes 15 de abril 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el calculo del histograma de frecuencias de color 
 * De una imagen termografica.
 */


public class HistogramaFrecuencias{
    
    /**
     * Funcion calcular el histograma de color de una imagen
     * IBelmont
     * Desde 15/04/19
     * params identificacion del color , imagen a calcular histograma
     **/ 
    
    public static double[] calcularHistograma( int color, Image imagen ){
         
        double frecuencias[] = new double[ 256 ];
        BufferedImage aux = GestorImagen.ABuffered( imagen );

        for( int x = 0; x < aux.getWidth(); x++ ){
            
            for ( int y = 0; y < aux.getHeight(); y++ ){
                
                Color pixel = new Color( aux.getRGB( x, y ) );

                if( color == 0 ){

                }

                if( color == 1 ){

                    frecuencias[ pixel.getRed() ]++;

                }

                if(color == 2){

                    frecuencias[ pixel.getGreen() ]++;

                }

                if(color == 3){

                    frecuencias[ pixel.getBlue() ]++;

                }
            }
         }
        
         return frecuencias;    
         
    }
}
