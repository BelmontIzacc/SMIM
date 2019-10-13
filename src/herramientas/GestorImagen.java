/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import org.jfree.chart.JFreeChart;

/**
 * Clase GestorImagenes.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el manejo de archivos de tipo imagen con formatos ( .jpg, .png, etc )
 * metodo para abrir imagenes multiple y que te regrese la ruta final para su manejo,
 * ruta para convertir de image a buffered para posibles manejos
 */


public class GestorImagen {
    
    public static void guardarImagen( BufferedImage bi, String ruta, String nombreArchivo, String formato){

        try {
            
            File outputfile =
                    new File(ruta+""+nombreArchivo+"."+formato);
            ImageIO.write(bi, formato, outputfile);
            
        } catch (IOException ex) {
            
            Logger.getLogger(GestorImagen.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          
    }
    
    public static void guardarImagen( JFreeChart grafica, int alto, int ancho, 
            String ruta, String nombreArchivo, String formato){

        try {
            
            BufferedImage bi = grafica.createBufferedImage(alto, ancho);
            
            File outputfile =
                    new File(ruta+"\\"+nombreArchivo+"."+formato);
            
            ImageIO.write(bi, formato, outputfile);
            
        } catch (IOException ex) {
            
            Logger.getLogger(GestorImagen.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          
    }
    public static Image AImagen( BufferedImage bi ){
        
        return bi.getScaledInstance( bi.getWidth(), 
                bi.getHeight(), BufferedImage.TYPE_INT_RGB );
        
    }
    
    public static BufferedImage ABuffered( Image imagen ){
        
        if( imagen instanceof BufferedImage ){
            
          return ( BufferedImage )imagen;
        
        }
        
        BufferedImage bi = new BufferedImage( imagen.getWidth( null ), 
                imagen.getHeight( null ), BufferedImage.TYPE_INT_RGB );
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage( imagen, 0, 0, null );
        nueva.dispose();
        
        return bi;
        
    }
}
