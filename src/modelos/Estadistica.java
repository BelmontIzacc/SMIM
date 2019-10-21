/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import herramientas.Ordenar;
import java.util.ArrayList;

/**
 * Clase Estadistica.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/**
 * Clase para calcular la estadistica segun la coordenada proporsionada,
 * lee las temperaturas en el arreglo para determinar las estadisticas propuestas.
 */


public class Estadistica{
    
    private int idCoordenada;
    private double mediana;
    private double media;
    private double varianza;
    private double moda; //falta este
    private double desviacionEstandar;
    
    public Estadistica(int id){
        
        this.mediana =0;
        this.media = 0;
        this.varianza = 0;
        this.moda = 0;
        this.desviacionEstandar = 0;
        this.idCoordenada = id;
        
    }
    
    public Estadistica(){
        
        this.mediana =0;
        this.media = 0;
        this.varianza = 0;
        this.moda = 0;
        this.desviacionEstandar = 0;
        this.idCoordenada = 0;
        
    }
    
    public void calcularEstadistica(Coordenada puntoInteres){
        
        ArrayList<Temperatura> aux = (ArrayList<Temperatura>) puntoInteres.getTemperatura().clone();
        aux = Ordenar.ordenarBurbujaOpt( aux );
        int tam = ( int )aux.size();
        
        if( tam%2 == 0 ){
            
            int mitad = ( int )aux.size()/2;
            double parteA = aux.get( mitad - 1 ).getTemperaturaCelsius();
            double parteB = aux.get( mitad ).getTemperaturaCelsius();
            this.mediana = ( parteA + parteB ) / 2;
            
        }else{
            
            this.mediana = aux.get( ( int ) aux.size() / 2 ).getTemperaturaCelsius();
        
        }    
        
        double total = 0;
        
        for( int x = 0 ; x < aux.size() ; x++ ){
            
            total += aux.get( x ).getTemperaturaCelsius();
            
        }
       
        this.media = ( total / aux.size() );
        double acumulado = 0;
        
        for( int i = 0 ; i < aux.size() ; i++ ){
            
            double auxiliar = ( aux.get( i ).getTemperaturaCelsius() - this.media );
            acumulado += Math.pow( auxiliar, 2 );
            
        }
        
        int n = puntoInteres.getTemperatura().size();
        int frecTemp, frecModa = 0;
        double moda1 = -1;

        for ( int i = 0; i < n; i++ ) {
            
          frecTemp = 1; 
          Temperatura c1 = puntoInteres.getTemperatura().get(i);
          
          for ( int j = i + 1; j < n; j++ ) {
              
            Temperatura c2 = puntoInteres.getTemperatura().get(j);  
            
            if ( c1.getTemperaturaCelsius() == c2.getTemperaturaCelsius() ){
                
              frecTemp++;
              
            }
            
          }
          
          if ( frecTemp > frecModa ) {
              
            frecModa = frecTemp;
            moda1 = c1.getTemperaturaCelsius();
            
          }
          
        } 
        
        moda = moda1;
        
        this.varianza = ( acumulado / aux.size() );
        this.desviacionEstandar = Math.sqrt( this.varianza );
        
    }
    
   public ArrayList<TemperaturaPromedioPuntos> 
        calcularPromedioPorImagen( ArrayList<Coordenada> puntosInteres ) {
        
        ArrayList<TemperaturaPromedioPuntos> aux;
        aux = new ArrayList<>();
        
        double[] acumulado = new double[ puntosInteres.get( 0 ).getTemperatura().size() ];
        
        for( int y = 0 ; y < puntosInteres.size() ; y++ ){
            
            for( int x = 0 ; x < puntosInteres.get( y ).getTemperatura().size() ; x++ ){
                
                acumulado[ x ] += puntosInteres.get( y ).getTemperatura().get( x ).getTemperaturaCelsius();
                
            }
            
        }
        
        for( int y = 0 ; y < acumulado.length ; y++ ){
            
            String nombreImagen = puntosInteres.get( 0 ).getTemperatura().get( y ).getNombreImagen();
            double promedio = acumulado[ y ] / puntosInteres.size();
            aux.add( new TemperaturaPromedioPuntos( nombreImagen, promedio ) );
        }
        
        return aux;
    }

    public double getMedia(){
        
        return media;
        
    }

    public double getVarianza(){
        
        return varianza;
        
    }

    public double getModa(){
        
        return moda;
        
    }

    public double getDesviacionEstandar(){
        
        return desviacionEstandar;
        
    }
    
    public double getMediana(){
        
        return mediana;
        
    }

    @Override
    public String toString() {
        String es = idCoordenada+","+mediana+","+media+","+varianza+","+moda+","+desviacionEstandar;
        return es;
    }
    
}
