/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import herramientas.Grafica;
import java.util.ArrayList;
import modelos.Coordenada;
import modelos.Estadistica;

/**
 * Clase Imagen.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */ 
 
 /** 
 * Clase para el manejo y analisis de las imagenes seleccionadas por el usuario
 * para su posterior procesamiento.
 */


public class Imagen extends MedioTermografico{

    public Imagen( String tipProceso, String fecha, String nombreProceso, 
            String rutaImagenes, int numeroImagenes ){
        
        super( tipProceso, fecha, nombreProceso, rutaImagenes,numeroImagenes );
        
    }

    @Override
    public void agregarPuntosInteres( ArrayList<Coordenada> puntosInteres ){
        
        super.setPuntosInteres( puntosInteres );
        
    }

    @Override
    public void calcularEstadistica(){
        
        for( int x = 0 ; x < super.getPuntosInteres().size() ; x++ ){
            
            Estadistica e = new Estadistica();
            e.calcularEstadistica(super.getPuntosInteres().get( x ));
            super.getEstadisticas().add( e );
            
        }
        
        Estadistica temp = new Estadistica();
        super.setTemperaturaPromedioPuntos( temp.calcularPromedioPorImagen( 
                super.getPuntosInteres() ) );
        
    }
    
    public void procesamientoImagenes(){
        
        for( int x = 0 ; x < super.getPuntosInteres().size() ; x++ ){
            
            int tamTemp = super.getPuntosInteres().get( x ).getTemperatura().size();
            
            for( int y = 0 ; y < tamTemp ; y++ ){
                
                super.getPuntosInteres().get( x ).getTemperatura().get( y ).calcularTemperatura();
                
            }
        }
        
    }

    @Override
    public void graficar() {
        
        ArrayList<ArrayList<double[]>> histograma = super.calcularHistogramaFrecuencias();
        
        for( int x = 0 ; x < histograma.size() ; x++ ){
            
            ArrayList<double[]> auxHistograma = histograma.get( x );
            double[] rojo = auxHistograma.get( 0 );
            double[] verde = auxHistograma.get( 1 );
            double[] azul = auxHistograma.get( 2 );
            String[] nombres = { "al inicio", " a la mitad", "al final" }; 
            
            Grafica grafica = new Grafica( "Tono", "Frecuencia","Nivel de Temperatura " + nombres[ x ] );
            
            grafica.agregarSerie( "Rojo", rojo );
            grafica.agregarSerie( "Azul", verde );
            grafica.agregarSerie( "Verde", azul );
            grafica.crearYmostrarGrafica();
            
        }
        
    }
    
}