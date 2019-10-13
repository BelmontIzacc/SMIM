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
import modelos.TemperaturaPromedioPuntos;

/**
 *
 * @author izacc
 */
public class GestorArchivo {

    public static void GenerarTxt( ArrayList<Coordenada> puntosInteres,
            ArrayList<Estadistica> estadisticas, ArrayList<TemperaturaPromedioPuntos> temperaturaPromedioPuntos ) {
        
        //puntosInteres
        generarCoordendas(puntosInteres);
        //estadistica
        generarEstadistica(estadisticas);
        //temperaturaPRomedioPuntos
        generarEstadisticaPorImagen(temperaturaPromedioPuntos);
    }
    
    private static void generarCoordendas( ArrayList<Coordenada> puntosInteres ){
        
        try {
            
            String auxRuta = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\coordenada\\coordenada.txt";
            
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
                
                double coordx = c.getCoordX();
                double coordy = c.getCoordY();
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
            
            String auxRuta = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\Estadistica";
            
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
                
                s.println("id,idCoordenada,mediana,media,varianza,moda,desviacionEstandar");
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
        
        String auxRuta = "C:\\Users\\izacc\\Documents\\Termicas\\archivosSistema"
                    + "\\estadisticaXimagen";
        
        for(int x = 0 ; x < temperaturaPromedioPuntos.size() ; x++ ){
            
            try {
                
                TemperaturaPromedioPuntos temperaturaPorImagen = temperaturaPromedioPuntos.get(x);
                int num = x+1;
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
    
}