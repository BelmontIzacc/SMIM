/*
 */
package modelos;

/**
 * Clase NodoTemp.
 * Fecha Lunes 18 de Noviembre 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/**
 * La Clase NodoTemp se inicializa con la escala generada para usar cada nodo en comparacion a la temperatura a calcular
 */
public class NodoTemp {
    
    private double temperatura;
    private int tonalidad; 
    
    
    public NodoTemp( double temp , int tonalidad){
        
        this.temperatura = temp;
        this.tonalidad = tonalidad;
        
    }
    
    public NodoTemp(String temp){
        
        String[] aux = temp.split(",");
        
        double tempAux = Double.parseDouble(aux[1]);
        int tonAux = Integer.parseInt(aux[0]);
        
        this.temperatura = tempAux;
        this.tonalidad = tonAux;
        
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getTonalidad() {
        return tonalidad;
    }
    
    
    
}
