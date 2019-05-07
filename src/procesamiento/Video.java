/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import java.util.ArrayList;
import modelos.Coordenada;

/**
 * Clase Video.
 * Fecha Martes 01 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el manejo y analisis del video seleccionado por el usuario
 * para su posterior procesamiento y segmentacion de frames.
 */

public class Video extends MedioTermografico{
    
    private int tiempoAnalisis;
    private String rutaVideo;

    public Video(String tipProceso, String fecha, String nombreProceso,
            String rutaImagenes, int tiempoAnalisis, String rutaVideo) {
        super(tipProceso, fecha, nombreProceso, rutaImagenes);
        this.tiempoAnalisis  = tiempoAnalisis;
        this.rutaVideo = rutaVideo;
    }

    @Override
    public void agregarPuntosInteres(ArrayList<Coordenada> puntosInteres){
        
    }

    @Override
    public void calcularEstadistica(){

    }
    
    public int getTiempoAnalisis(){
        return tiempoAnalisis;
    }

    public String getRutaVideo(){
        return rutaVideo;
    }
}