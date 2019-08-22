/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;


/**
 * Clase GestorVideo.
 * Fecha Martes 15 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/**
 * Clase para el manejo de los archivos de video
 * son funciones estaticas, se puede obtener la ruta final de donde se guardo el video
 * y meter metodo para abrir un video
 */
public class GestorVideo {
    
    public static String obtenerRutaFrames(String ruta, int tiempoAnalisis){
        
        String rutaImagenes = "C:\\Users\\izacc\\Pictures\\SMIM\\Manufactura\\img\\"; //ruta que se espera que regrese el metodo
        
        try {
            // ruta donde se selecciona el video para tomar los frames
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(ruta);
            // se inicia preparativos para obtener frames
            frameGrabber.start();
            // objeto de tipo frame
            Frame i;
            //objeto del cual convertira el frame del video en imagen
            OpenCVFrameConverter.ToIplImage converterToIplImage = 
                    new OpenCVFrameConverter.ToIplImage();
            int j = 30; //frame numero 30 equivale a 1s
            int nombreNum = 1; // utilizado para los nombres de las imagenes
            //este for esta preparado para sacar 10 frames por segundo de un video de 30 fps
            // el 10 simboliza que el video dura 10segundos
            for(int x = 0 ; x<10 ; x++){
                
                try {
                    // seleccionas que frame vas a querer, en este caso el frame de 1s en el video, que es el
                    // numero 30.
                    frameGrabber.setFrameNumber(j);//puede ser cualquier frame
                    // se obtiene la imagen
                    Frame frame = frameGrabber.grabImage();
                    //muestras informacion de la imagen obtenida
                    System.out.println(frame.toString());
                    // se inicia la conversion de frame a imagen
                    opencv_core.IplImage image = converterToIplImage.convert(frame);
                    // se crea un buffered con el frame obtenido
                    BufferedImage bi = IplImageToBufferedImage(image);
                    // se guarda el frame en un directorio espesifico con el nombre deseado junto con un formato
                    File outputfile = 
                            new File("C:\\Users\\izacc\\Pictures\\SMIM\\Manufactura\\img\\"+nombreNum+".jpg");
                    // se establece y valida el formato de salida
                    ImageIO.write(bi, "jpg", outputfile);
                    // aumenta en 30 los frames para calcular el siguiente segundo
                    j = j+30;
                    nombreNum++;
                    
                } catch (FrameGrabber.Exception e) {
                    
                    e.printStackTrace();
                    
                } catch (IOException ex) {
                    
                    Logger.getLogger(GestorVideo.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
            frameGrabber.stop();
            
        } catch (FrameGrabber.Exception ex) {
            
            Logger.getLogger(GestorVideo.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return rutaImagenes;
    }
    
    private static BufferedImage IplImageToBufferedImage(opencv_core.IplImage src) {
        
        OpenCVFrameConverter.ToIplImage grabberConverter = 
                new OpenCVFrameConverter.ToIplImage();
        
        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
        Frame frame = grabberConverter.convert(src);
        
        return paintConverter.getBufferedImage(frame,1);
        
    } 
}
