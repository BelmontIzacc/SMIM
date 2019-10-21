/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author izacc
 */
public class GestorArchivo {
    
    private static String linkCoordenada = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\coordenada\\coordenada.txt";
    
    private static String linkEstadistica = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\Estadistica";
    
    private static String linkEstadisticaImagen = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\estadisticaXimagen";
    
    private static String linkTemPorImagen = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema\\txt";
    
    public static void GenerarTxt( ArrayList<Coordenada> puntosInteres,
            ArrayList<Estadistica> estadisticas, ArrayList<TemperaturaPromedioPuntos> temperaturaPromedioPuntos ) {
        
        //coordenada
        generarCoordendas(puntosInteres);
        //estadistica
        generarEstadistica(estadisticas);
        //temperaturaPRomedioPuntos
        generarEstadisticaPorImagen(temperaturaPromedioPuntos);
        //temperatura de los puntos por imagen
        generarTemperaturaPorImagen(puntosInteres);
    }
    
    private static void generarCoordendas( ArrayList<Coordenada> puntosInteres ){
        
        try {
            
            String auxRuta = linkCoordenada;
            
            File file = new File(auxRuta);

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

    private static void generarEstadistica(ArrayList<Estadistica> estadisticas) {
        try {
            
            String auxRuta = linkEstadistica;
            
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

    private static void generarEstadisticaPorImagen(ArrayList<TemperaturaPromedioPuntos>
            temperaturaPromedioPuntos) {
        
        String auxRuta = linkEstadisticaImagen;
        
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

    private static void generarTemperaturaPorImagen(ArrayList<Coordenada> puntosInteres) {
        
        String auxRuta = linkTemPorImagen;
        
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