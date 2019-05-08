/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import herramientas.QuickSort;
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
    
    private double mediana;
    private double media;
    private double varianza;
    private double moda; //falta este
    private double desviacionEstandar;
    private Coordenada puntoInteres;
    
    public Estadistica(Coordenada puntoInteres){
        
        this.mediana =0;
        this.media = 0;
        this.varianza = 0;
        this.moda = 0;
        this.desviacionEstandar = 0;
        this.puntoInteres = puntoInteres;
        
    }
    
    public void calcularEstadistica(){
        
        ArrayList<Temperatura> aux = this.puntoInteres.getTemperatura();
        QuickSort.ordenar(aux);
        int tam = (int)aux.size();
        
        if(tam%2==0){
            
            int mitad = (int)aux.size()/2;
            double parteA = aux.get(mitad-1).getTemperatura();
            double parteB = aux.get(mitad).getTemperatura();
            this.mediana = (parteA + parteB)/2;
            
        }else{
            
            this.mediana = aux.get((int)aux.size()/2).getTemperatura();
        
        }    
        
        double total=0;
        
        for(int x = 0; x < aux.size(); x++){
            
            total += aux.get(x).getTemperatura();
            
        }
       
        this.media = (total/aux.size());
        double acumulado = 0;
        
        for(int i = 0; i < aux.size(); i++){
            
            acumulado += Math.pow((aux.get(i).getTemperatura() - this.media), 2);
            
        }
        
        this.varianza = (acumulado/aux.size());
        this.desviacionEstandar = Math.sqrt(this.varianza);
        
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

    public Coordenada getPuntoInteres(){
        
        return puntoInteres;
    }
    

    public double getMediana(){
        
        return mediana;
        
    }
}
