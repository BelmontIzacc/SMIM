/*
 */
package herramientas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Coordenada;
import modelos.Estadistica;
import modelos.Temperatura;
import modelos.TemperaturaPromedioPuntos;

/**
 * Clase GestorArchivo.
 * Fecha Martes 20 de octubre 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase que ayuda a la creacion de los archivos necesarios resultantes del 
 * procesamiento del medio termografico en rutas espesificadas
 */
public class GestorArchivo {
    
    /**
     * Funcion principal para generar los archivos en formato txt
     * IBelmont
     * Desde 20/10/19
     * params arreglo de puntos de interes
     **/ 
    
    public static void GenerarTxt( ArrayList<Coordenada> puntosInteres,
            ArrayList<Estadistica> estadisticas, ArrayList<TemperaturaPromedioPuntos> temperaturaPromedioPuntos,
            String ruta) {
        
        String[] rutaPrincipal = ruta.split("Imagenes");
        
        //coordenada
        generarCoordendas(puntosInteres,rutaPrincipal[0]);
        //estadistica
        generarEstadistica(estadisticas,rutaPrincipal[0]);
        //temperaturaPRomedioPuntos
        generarEstadisticaPorImagen(temperaturaPromedioPuntos,rutaPrincipal[0]);
        //temperatura de los puntos por imagen
        generarTemperaturaPorImagen(puntosInteres,rutaPrincipal[0]);
    }
    
    /**
     * Funcion para generar el archivo de txt correspondiente a las coordenadas
     * IBelmont
     * Desde 20/10/19
     * params arrelo de coordenadas
     **/ 
    
    private static void generarCoordendas( ArrayList<Coordenada> puntosInteres, String ruta ){
        
        try {
            
            String auxRuta = ruta + "coordenada";
            File file = new File(auxRuta);

            if( !file.exists() ){
                
                file.mkdirs();
            }
            
            auxRuta = ruta + "coordenada\\coordenada.txt";
            file = new File(auxRuta);
            
            if( !file.exists() ){
                
                file.createNewFile();
                
            }
            
            FileWriter fw = new FileWriter(file);
            
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter s = new PrintWriter(fw);
            
            s.println("id,coordX,coordY");
            
            for( int x = 0 ; x < puntosInteres.size() ; x++ ){
                
                Coordenada c = puntosInteres.get(x);
                
                int coordx = (int)c.getCoordX();
                int coordy = (int)c.getCoordY();
                int id = c.getId();
                
                if(x == puntosInteres.size()-1){
                    
                    s.print(""+id+","+coordx+","+coordy);
                    
                }else{
                    
                    s.println(""+id+","+coordx+","+coordy);
                    
                }
                
            }
            
            
            s.close();
            bw.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(GestorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    /**
     * Funcion para generar los archivos txt correspondiente a la estadistica
     * IBelmont
     * Desde 20/10/19
     * params arreglo de estadisticas
     **/ 
    
    private static void generarEstadistica(ArrayList<Estadistica> estadisticas, String ruta) {
        try {
            
            String auxRuta = ruta + "Estadistica";
            File f = new File(auxRuta);
            
            if( !f.exists() ){
                
                f.mkdirs();
            }
            
            for( int x = 0 ; x < estadisticas.size() ; x++ ){
                
                Estadistica e = estadisticas.get(x);
                int num = x+1;
                String r = auxRuta+"\\"+num+".txt";
                
                File file = new File(r);
                
                if( !file.exists() ){
                
                    file.createNewFile();
                
                }
                
                
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter s = new PrintWriter(fw);
                
                s.println("idCoordenada,mediana,media,varianza,moda,desviacionEstandar");
                s.print(e.toString());
                
                s.close();
                bw.close();
                
            }

        } catch (IOException ex) {
            
            Logger.getLogger(GestorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    /**
     * Funcion para generar archivos txt correspondientes al promedio de temperatura por imagen
     * IBelmont
     * Desde 20/10/19
     * params arreglo de temperatura en promedio de los puntos por imagen
     **/ 
    
    private static void generarEstadisticaPorImagen(ArrayList<TemperaturaPromedioPuntos>
            temperaturaPromedioPuntos , String ruta) {
        
        String auxRuta = ruta + "estadisticaXimagen";
        File f = new File(auxRuta);
        
        if( !f.exists() ){
                
            f.mkdirs();
        }
        
        for(int x = 0 ; x < temperaturaPromedioPuntos.size() ; x++ ){
            
            try {
                
                TemperaturaPromedioPuntos temperaturaPorImagen = temperaturaPromedioPuntos.get(x);
                String num = temperaturaPorImagen.getNombreImagen();
                String r = auxRuta+"\\"+num+".txt";
                File file = new File(r);
                
                if( !file.exists() ){
                    
                    file.createNewFile();
                    
                }   
                
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter s = new PrintWriter(fw);
                
                s.println("nombreImagen,celsius,kelvin,farenheit");
                s.print(temperaturaPorImagen.toString());
                
                s.close();
                bw.close();
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(GestorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Funcion para generar los txt correspondientes al calculo de temperaturas por punto de interes 
     * IBelmont
     * Desde 20/10/19
     * params arreglo de coordenadas
     **/ 
    
    private static void generarTemperaturaPorImagen(ArrayList<Coordenada> puntosInteres, String ruta) {
        
        String auxRuta = ruta + "txt";
        
        File f = new File(auxRuta);
        
        if( !f.exists() ){
                
            f.mkdirs();
        }
        
        for(int x = 0 ; x < puntosInteres.size() ; x++){
            
            try {
                Coordenada c = puntosInteres.get(x);
                ArrayList<Temperatura> t = c.getTemperatura();
                ArrayList<String[]> documento = new ArrayList<>();
                
                for( int i = 0 ; i < t.size() ; i++ ){
                    
                    String nombre = t.get(i).getNombreImagen();
                    String tempCelsius = ""+t.get(i).getTemperaturaCelsius();
                    String tempFar = ""+t.get(i).getTemperaturaFarenheit();
                    String tempKelvin = ""+t.get(i).getTemperaturaKelvin();
                    
                    String[] valor = new String[4];
                    valor[0] = nombre;
                    valor[1] = tempCelsius;
                    valor[2] = tempFar;
                    valor[3] = tempKelvin;
                    
                    documento.add(valor);
                }
                
                String Idcoord = ""+c.getId();
                
                String r = auxRuta+"\\"+Idcoord+".txt";
                File file = new File(r);
                
                if( !file.exists() ){
                    
                    file.createNewFile();
                    
                }
                
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter s = new PrintWriter(fw);
                
                s.println("nombreImagen,celsius,farenheit,kelvin");
                for( int j = 0 ; j < documento.size() ; j++ ){

                    String nombreImagen = documento.get(j)[0];
                    String tempCelsius = documento.get(j)[1];
                    String tempFar = documento.get(j)[2];
                    String tempKelvin = documento.get(j)[3];
                    
                    if( j == documento.size()-1 ){

                        s.print(nombreImagen+","+tempCelsius+","+tempFar+","+tempKelvin);

                    }else{

                        s.println(nombreImagen+","+tempCelsius+","+tempFar+","+tempKelvin);

                    }

                }
                
                s.close();
                bw.close();
                fw.close();
                System.out.println();
            } catch (IOException ex) {
                Logger.getLogger(GestorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}