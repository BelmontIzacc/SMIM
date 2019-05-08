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
 * Clase GestorImagenes.
 * Fecha Miercoles 08 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el calculo del histograma de frecuencias de color 
 * De una imagen termografica.
 */


public class HistogramaFrecuencias{
    
    public static double[] calcularHistograma(int color, Image imagen){
         
        double frecuencias[] = new double[256];
        BufferedImage aux = GestorImagenes.toBufferedImage(imagen);

        for(int x=0; x < aux.getWidth(); x++){
            
            for (int y=0; y < aux.getHeight(); y++){
                
                Color pixel = new Color(aux.getRGB(x, y));

                if(color == 0){

                }

                if(color == 1){

                    frecuencias[pixel.getRed()]++;

                }

                if(color == 2){

                    frecuencias[pixel.getGreen()]++;

                }

                if(color == 3){

                    frecuencias[pixel.getBlue()]++;

                }
            }
         }
        
         return frecuencias;    
         
    }
}
