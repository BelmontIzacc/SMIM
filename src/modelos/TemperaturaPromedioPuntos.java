/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * Clase GestorVideo.
 * Fecha Martes 05 de Agosto 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/*
* Clase que guardara la temperatura promedio de los puntos de interes por imagen
*/

public class TemperaturaPromedioPuntos {
    
    private String nombreImagen;
    private double temperaturaPromedio;

    public TemperaturaPromedioPuntos( String nombre, double temperaturaPromedio ) {
        
        this.nombreImagen = nombre;
        this.temperaturaPromedio = temperaturaPromedio;
        
    }

    public String getNombreImagen() {
        
        return nombreImagen;
        
    }

    public double getTemperaturaPromedio() {
        
        return temperaturaPromedio;
        
    }
}
