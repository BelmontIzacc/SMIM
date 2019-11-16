/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import herramientas.Grafica;
import java.io.File;
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
            String rutaImagenes, int numeroImagenes, String folio, String nombreAlumno, String grupoAlumno ){
        
        super( tipProceso, fecha, nombreProceso, rutaImagenes,numeroImagenes, folio, nombreAlumno, grupoAlumno );
        
    }
    
    /**
     * Funcion que sobrescribe el metodo agregarPuntosInteres para agregar un arreglo 
     * al objeto de tipo imagen
     * IBelmont
     * Desde 01/05/19
     * params arreglo de coordenadas
     **/ 

    @Override
    public void agregarPuntosInteres( ArrayList<Coordenada> puntosInteres ){
        
        super.setPuntosInteres( puntosInteres );
        
    }

    /**
     * Funcion que sobrescribe el metodo calcular estadistica para calcular la estadistica
     * apartir de los puntos de interes
     * IBelmont
     * Desde 01/05/19
     **/ 
    
    @Override
    public void calcularEstadistica(){
        
        for( int x = 0 ; x < super.getPuntosInteres().size() ; x++ ){
            
            Coordenada c = super.getPuntosInteres().get( x );
            Estadistica e = new Estadistica( c.getId() );
            e.calcularEstadistica( c );
            super.getEstadisticas().add( e );
            
        }
        
        Estadistica temp = new Estadistica();
        super.setTemperaturaPromedioPuntos( temp.calcularPromedioPorImagen( 
                super.getPuntosInteres() ) );
        
    }
    
    /**
     * Funcion Para iniciar el computo en celcius
     * de la temperatura obteniendo el rgb de las imagenes
     * IBelmont
     * Desde 01/05/19
     **/ 
    
    public void procesamientoImagenes(){
        
        for( int x = 0 ; x < super.getPuntosInteres().size() ; x++ ){
            
            int tamTemp = super.getPuntosInteres().get( x ).getTemperatura().size();
            
            for( int y = 0 ; y < tamTemp ; y++ ){
                
                super.getPuntosInteres().get( x ).getTemperatura().get( y ).calcularTemperatura();
                
            }
        }
        
    }
    
    /**
     * Funcion que sobrescribe el metodo para crear el histograma de frecuencias
     * IBelmont
     * Desde 01/05/19
     **/ 
    
    @Override
    public void graficarHistograma() {
        
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
            
            super.getListaGrafica().add(grafica);
            
        }
        
    }
    
    /**
     * Funcion Para generar los archivos apartir del arreglo de puntos de interes
     * IBelmont
     * Desde 01/05/19
     **/ 
    
    public void generarArchivos(){
        
        super.generarArchivos();
        
    }
    
    /**
     * Funcion para guardar el histograma de frecuencias de inicio, medio y final de las imagenes
     * procesadas del medio termografico
     * IBelmont
     * Desde 01/05/19
     **/ 
    
    public void guardarGrafica( int alto, int ancho, String formato ){
        
        String[] nombres = { "inicio", "mitad", "final" }; 
        
        String ruta = super.getRutaImagenes();
        String[] rutaPrincipal = ruta.split("Imagenes");
        String rg = rutaPrincipal[0]+"graficas";
        
        File f = new File(rg);
        
        if(!f.exists()){
            f.mkdirs();
        }
        
        int graficas = super.getListaGrafica().size();
        
        for( int x = 0 ; x < graficas ; x++ ){
            
            Grafica g = super.getListaGrafica().get(x);
            g.guardarGrafica(alto, ancho, rg, nombres[x], formato);
            
        }
        
    }
    
}