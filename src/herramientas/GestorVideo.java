/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import static GUI_Generales.Prueba.Procesos;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import GUI_Video.Video;
import static GUI_Video.Video.rutaGeneral;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    
    public static FileNameExtensionFilter filtroLectura;
    public static JFileChooser selectorArchivos;
    public static File video, rutaNueva;
    public static String rutaArchivo;
    
    public static String obtenerRutaFrames( String ruta, int tiempoAnalisis ){
        
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
    
    private static BufferedImage IplImageToBufferedImage( opencv_core.IplImage src ) {
        
        OpenCVFrameConverter.ToIplImage grabberConverter = 
                new OpenCVFrameConverter.ToIplImage();
        
        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
        Frame frame = grabberConverter.convert( src );
        
        return paintConverter.getBufferedImage( frame,1 );
        
    } 
    //////PARTE ALE
    public static boolean abrirVideo(){
        //Filtro de lectura
        filtroLectura = new FileNameExtensionFilter("Video","mp4","3gp","avi");
        //Selector de archivos
        selectorArchivos = new JFileChooser();
        //Se le agrega el filtro al selector de archivos
        selectorArchivos.setAcceptAllFileFilterUsed(false);
        selectorArchivos.setFileFilter(filtroLectura);
        //Se specifica que se puede seleccionar y tambien que puedan ser varios
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selectorArchivos.setMultiSelectionEnabled(false);
        
        //ejecutar selector de video
        if(selectorArchivos.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //Si lo que seleccionaron es un video
            if(selectorArchivos.getSelectedFile().isFile()){
                video = selectorArchivos.getSelectedFile();
                selectorArchivos.cancelSelection();
                System.out.println("Selecciono un video: "+video);
            }
            return true;
        }else{
            GUI_Generales.Prueba.archivos.setEnabled(true);
            GUI_Generales.Prueba.creditos.setEnabled(true);
            return false;
        }
    }
    
    public static List<BufferedImage> obtenerRutaVideo(String ruta, int tiempoAnalisis, int duracionV,double fps){
        int im;
        if(duracionV>GUI_Generales.Prueba.duracionVideo){
            duracionV = GUI_Generales.Prueba.duracionVideo;
            im =  (duracionV/tiempoAnalisis);
        }else{
            im =  (duracionV/tiempoAnalisis);
        }
        
        List<BufferedImage> listaIm = new ArrayList<>();
        String rutaImagenes = null;
        int j,j2;
        try {
            // ruta donde se selecciona el video para tomar los frames
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(ruta);
            frameGrabber.start();
            
            //objeto del cual convertira el frame del video en imagen
            OpenCVFrameConverter.ToIplImage converterToIplImage = new OpenCVFrameConverter.ToIplImage();
            j = (int) fps; //frame numero 30 equivale a 1s
            j2 = j;
            if(j>fps){
                j = j-1;
                j2 = j;
            }
            
            int nombreNum = 1; // utilizado para los nombres de las imagenes
            rutaImagenes = rutaEspecifica();
            
            for(int x = 0 ; x<im ; x++){
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
                    
                    File outputfile = new File(rutaImagenes+"\\"+nombreNum+".png");
                    // se establece y valida el formato de salida
                    ImageIO.write(bi, "png", outputfile);
          /////////////////////agregar los buffer a una lista
                    listaIm.add(bi);
                    // aumenta en 30 los frames para calcular el siguiente segundo
                    j = j+j2;
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
        return listaIm;
    }
        
    public static String rutaEspecifica(){
        int num = 0;
        Calendar fecha = Calendar.getInstance();
        String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
        String rutaUsuario = System.getProperty("user.home");
        rutaArchivo = rutaUsuario+"\\Documents\\SMIM\\"+ 
                Procesos.get(Video.tipoProceso.getSelectedIndex()-1)+"\\"+fechaDia+"_"+
                Video.nombreProceso.getText()+"_"+Video.nombreAlumno.getText()+"_"+
                Video.Grupo.getText()+"\\Imagenes";
        
        rutaNueva = new File(rutaArchivo);
        
        if(!rutaNueva.exists()){
            rutaNueva.mkdirs();
        }else if(rutaNueva.exists()){
            boolean existe = true;
            String aux = rutaArchivo;
            while(existe){
                num++;
                aux = rutaArchivo+"_"+num;
                existe = validarexiste(aux);
            }
        }
        return rutaNueva.getAbsolutePath();
    }

    private static boolean validarexiste(String rutaArchivo) {
        rutaNueva = new File(rutaArchivo);
         if(!rutaNueva.exists()){
             rutaNueva = new File(rutaArchivo);
             rutaNueva.mkdirs();
             return false;
         }
        return true;
    }
    
    public static List<BufferedImage> obtenerRutaNueva(String ruta, int tiempoAnalisis, int duracionV,double fps){
        eliminarArchivo(new File(rutaArchivo));
        int im;
        if(duracionV>GUI_Generales.Prueba.duracionVideo){
            duracionV = GUI_Generales.Prueba.duracionVideo;
            im = (duracionV/tiempoAnalisis);
        }else{
            im = (duracionV/tiempoAnalisis);
        }
        
        List<BufferedImage> listaIm = new ArrayList<>();
        String rutaImagenes = null;
        int j,j2;
        try {
            // ruta donde se selecciona el video para tomar los frames
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(ruta);
            frameGrabber.start();
            Frame i;
            
            //objeto del cual convertira el frame del video en imagen
            OpenCVFrameConverter.ToIplImage converterToIplImage = 
                    new OpenCVFrameConverter.ToIplImage();
            j = (int) fps; //frame numero 30 equivale a 1s
            j2 = j;
            if(j>fps){
                j = j-1;
                j2 = j;
            }
            int nombreNum = 1; // utilizado para los nombres de las imagenes
            rutaImagenes = rutaArchivo;
            
            for(int x = 0 ; x<im ; x++){
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
                            new File(rutaImagenes+"\\"+nombreNum+".png");
                    // se establece y valida el formato de salida
                    ImageIO.write(bi, "png", outputfile);
          /////////////////////agregar los buffer a una lista
                    listaIm.add(bi);
                    // aumenta en 30 los frames para calcular el siguiente segundo
                    j = j+j2;
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
        return listaIm;
    }
    
    public static void eliminarArchivo(File rutaG){
        if(rutaG.isDirectory()){
            if(rutaG.list().length == 0){
            }else{
                for(String temp : rutaG.list()){
                    File file = new File(rutaG,temp);
                    eliminarArchivo(file);
                }
            }
        }
        else{
            rutaG.delete();
        }
    }
    
    public static void guardarVideos(){
        try {
            /////ORIGINAL
            Calendar fecha = Calendar.getInstance();
            String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
            String rutaUsuario = System.getProperty("user.home");
            String rutaOrig = rutaUsuario+"\\Documents\\SMIM\\"+
                    Procesos.get(Video.tipoProceso.getSelectedIndex()-1)+"\\"+fechaDia+"_"+
                    Video.nombreProceso.getText()+"_"+Video.nombreAlumno.getText()+"_"+
                    Video.Grupo.getText()+"\\VideoOriginal.mp4";
            Path origen = Paths.get(video.getAbsolutePath());
            System.out.println(video.getAbsolutePath());
            Path fin = Paths.get(rutaOrig);
            Files.copy(origen,fin);
            /////REDUCIDO
            String rutaOrig2 = rutaUsuario+"\\Documents\\SMIM\\"+
                    Procesos.get(Video.tipoProceso.getSelectedIndex()-1)+"\\"+fechaDia+"_"+
                    Video.nombreProceso.getText()+"_"+Video.nombreAlumno.getText()+"_"+
                    Video.Grupo.getText()+"\\Video.mp4";
            String rut = rutaGeneral.getAbsolutePath()+"\\Video.mp4.bak";
            Path origen2 = Paths.get(rut);
            Path fin2 = Paths.get(rutaOrig2);
            Files.copy(origen2,fin2);
            
        } catch (IOException ex) {
            Logger.getLogger(GestorVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
