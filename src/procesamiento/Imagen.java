/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

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

    public Imagen(String tipProceso, String fecha, String nombreProceso,String rutaImagenes){
        super(tipProceso, fecha, nombreProceso, rutaImagenes);
    }

    @Override
    public void agregarPuntosInteres(ArrayList<Coordenada> puntosInteres){
        super.setPuntosInteres(puntosInteres);
    }

    @Override
    public void calcularEstadistica(){
        Estadistica e = new Estadistica(super.getPuntosInteres());
        super.setEstadistica(super.getEstadistica());
    }
    
    public void procesamientoImagenes(){
        for(int x = 0 ; x<super.getPuntosInteres().size(); x++){
            int tamTemp = super.getPuntosInteres().get(x).getTemperatura().size();
            for(int y = 0 ; y<tamTemp; y++){
                super.getPuntosInteres().get(x).getTemperatura().get(y).calcularTemperatura();
            }
        }
    }
}