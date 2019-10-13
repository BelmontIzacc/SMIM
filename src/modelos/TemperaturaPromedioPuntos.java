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
    private double temperaturaPromedioCelsius;
    private double temperaturaPromedioKelvin;
    private double temperaturaPromedioFarenheit;

    public TemperaturaPromedioPuntos( String nombre, double temperaturaPromedio ) {
        
        this.nombreImagen = nombre;
        this.temperaturaPromedioCelsius = temperaturaPromedio;
        this.temperaturaPromedioKelvin = convertirTemp( temperaturaPromedio, 2 );
        this.temperaturaPromedioFarenheit = convertirTemp( temperaturaPromedio, 1 );
        
    }
    
    private double convertirTemp( double tempCelsius, int opc ){
        
        double calculo = 0.0;
        
        if( opc == 1 ){ //Farenheit (0 °C × 9/5) + 32
            
            calculo =  ( tempCelsius * 1.8 ) + 32;
        
        }else if( opc == 2 ){ //Kelvin 0 °C + 273.15 
            
            calculo = tempCelsius + 273.15;
            
        }
        
        return calculo;
        
    }

    @Override
    public String toString() {
        
        String tem = ""+nombreImagen+","+temperaturaPromedioCelsius+""+temperaturaPromedioKelvin+
                ""+temperaturaPromedioFarenheit;
        return tem;
        
    }

    public String getNombreImagen() {
        
        return nombreImagen;
        
    }

    public double getTemperaturaPromedioCelsius() {
        
        return temperaturaPromedioCelsius;
        
    }

    public double getTemperaturaPromedioKelvin() {
        
        return temperaturaPromedioKelvin;
        
    }

    public double getTemperaturaPromedioFarenheit() {
        
        return temperaturaPromedioFarenheit;
        
    }

}
