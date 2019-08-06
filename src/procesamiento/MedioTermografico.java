/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import java.util.ArrayList;
import modelos.Coordenada;
import modelos.Estadistica;
import modelos.TemperaturaPromedioPuntos;

/**
 * Clase Medio Termografico.
 * Fecha Martes 30 de abril 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/**
 * La Clase MedioTermografico es abstracta para poder heredar sus metodos y variables a las clases
 * Imagen y Video y poder sobreescribirlos segun se necesite.
 */


public abstract class MedioTermografico{
    
    private String tipProceso;
    private String fecha;
    private String nombreProceso;
    private String rutaImagenes;
    private ArrayList<Coordenada> puntosInteres;
    private ArrayList<Estadistica> estadisticas;
    private ArrayList<TemperaturaPromedioPuntos> temperaturaPorImagen;

    public MedioTermografico(String tipProceso, String fecha, String nombreProceso,
            String rutaImagenes){
        
        this.tipProceso = tipProceso;
        this.fecha = fecha;
        this.nombreProceso = nombreProceso;
        this.rutaImagenes = rutaImagenes;
        this.puntosInteres = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
        this.temperaturaPorImagen = new ArrayList<>();
        
    }
    
    abstract public void agregarPuntosInteres(ArrayList<Coordenada> puntosInteres);
    
    abstract public void calcularEstadistica();

    public String getTipProceso(){
        
        return tipProceso;
        
    }

    public String getFecha(){
        
        return fecha;
        
    }

    public String getNombreProceso(){
        
        return nombreProceso;
        
    }

    public String getRutaImagenes(){
        
        return rutaImagenes;
        
    }

    public ArrayList<Coordenada> getPuntosInteres(){
        
        return puntosInteres;
        
    }

    public ArrayList<Estadistica> getEstadisticas(){
        
        return estadisticas;
        
    }

    public void setPuntosInteres(ArrayList<Coordenada> puntosInteres){
        
        this.puntosInteres = puntosInteres;
        
    }

    public ArrayList<TemperaturaPromedioPuntos> getTemperaturaPorImagen() {
        return temperaturaPorImagen;
    }

    public void setTemperaturaPorImagen(ArrayList<TemperaturaPromedioPuntos> temperaturaPorImagen) {
        this.temperaturaPorImagen = temperaturaPorImagen;
    }
    
}