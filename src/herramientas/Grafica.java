/*
 */
package herramientas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * Clase Grafica.
 * Fecha Martes 15 de abril 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */ 

/*
* Clase para contruir y mostrar graficas
* Esta clase se llenara de informacion estadistica, para poder graficar el comportamiento
*/

public class Grafica {
    
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX; 
    private String ejeY;
    private String titulo;

    public Grafica( String ejeX, String ejeY, String titulo ) {
        
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
        
    }
    
    /**
     * Funcion para generar una nueva coleccion para su visualizacion en la grafica
     * IBelmont
     * Desde 15/04/19
     * params nombre de la coleccion
     **/ 
    
    public void agrearSerie( String nombre ){
        
        XYSeries serie = new XYSeries( nombre );
        this.series.addSeries( serie );
     
    }
    
    /**
     * Funcion para agregar datos a la coleccion
     * IBelmont
     * Desde 15/04/19
     * params nombre de la coleccion y dato del punto para agregar a la coleccion
     **/ 
    
    public void agregarDatoASerie( String nombre, XYDataItem dato ){
        
       this.series.getSeries( nombre ).add( dato );
       
    }
    
    /**
     * Funcion para agregar a una coleccion un conjunto de datos
     * IBelmont
     * Desde 15/04/19
     * params nombre de la coleccion y arreglo de datos a agregar
     **/ 
    
    public void agregarSerie( String nombre, double[] datos ){
    
        XYSeries serie = new XYSeries( nombre );

        for ( int x = 0; x < datos.length; x++ ){
            
            serie.add( x, datos[ x ] );
            
        }

        this.series.addSeries( serie );
     
    }
    
    /**
     * Funcion para guardar grafica
     * IBelmont
     * Desde 15/04/19
     * params alto de la imagen, ancho de la imagen, ruta donde se guardara y nombre del archivo
     **/ 
    
    public void guardarGrafica(int alto, int ancho, String ruta, String nombreArchivo,
            String formato){
        
        GestorImagen.guardarImagen(grafica, alto, ancho, ruta, nombreArchivo, formato);
        
    }
    
    /**
     * Funcion para crear y mostrar la grafica
     * IBelmont
     * Desde 15/04/19
     **/ 
    
    public void crearYmostrarGrafica(){
    
        this.grafica = ChartFactory.createXYLineChart( titulo, ejeX, ejeY, series );
         
    }
}
