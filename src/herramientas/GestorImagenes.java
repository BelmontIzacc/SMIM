/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.image.BufferedImage;

/**
 * Clase GestorImagenes.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el manejo de archivos de tipo imagen
 * metodo para abrir imagenes multiple y que te regrese la ruta final para su manejo,
 * ruta para convertir de image a buffered para posibles manejos
 */

public class GestorImagenes {
    public static BufferedImage muestra (int x, int y,int tam,int tam1, BufferedImage bi)
    {
        BufferedImage imagenCopia = new BufferedImage(tam1,tam,BufferedImage.TYPE_INT_RGB);
       
        //int[][] aux = new int [tam][tam];
        int c=0,v=0;
        int finy,finx;
        
        finy = y+tam1;
        finx = x+tam;
        
        for(int j = y ; j < finy ; j++)
        {
            for(int i = x ; i < finx ; i++)
            {
                //aux[c][v] = bi.getRGB(j, i);
                imagenCopia.setRGB(c,v, bi.getRGB(j, i));
                v++;             
            }
            c++;
            v=0;
        }
    
        return imagenCopia;
    }
}
