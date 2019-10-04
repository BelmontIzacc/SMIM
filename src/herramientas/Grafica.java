/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
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
    
    public void agrearSerie( String nombre ){
        
        XYSeries serie = new XYSeries( nombre );
        this.series.addSeries( serie );
     
    }
    
    public void agregarDatoASerie( String nombre, XYDataItem dato ){
        
       this.series.getSeries( nombre ).add( dato );
       
    }
    
    public void agregarSerie( String nombre, double[] datos ){
    
        XYSeries serie = new XYSeries( nombre );

        for ( int x = 0; x < datos.length; x++ ){
            
            serie.add( x, datos[ x ] );
            
        }

        this.series.addSeries( serie );
     
    }
    
    public void crearYmostrarGrafica(){
    
        this.grafica = ChartFactory.createXYLineChart( titulo, ejeX, ejeY, series );
        ChartFrame frame = new ChartFrame( "Histograma de color", grafica );
        frame.setSize( 700, 250 );
        frame.setVisible( true );
         
    }
}
