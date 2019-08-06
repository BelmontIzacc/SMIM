/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author izacc
 */
public class TemperaturaPromedioPuntos {
    
    private String nombre;
    private double temperaturaPromedio;

    public TemperaturaPromedioPuntos(String nombre, double temperaturaPromedio) {
        this.nombre = nombre;
        this.temperaturaPromedio = temperaturaPromedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperaturaPromedio() {
        return temperaturaPromedio;
    }
}
