/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import modelos.Temperatura;

/**
 * Clase GestorImagenes.
 * Fecha Miercoles 08 de mayo 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase para el ordenamiento de los valores obtenidos de las temperaturas
 * analisadas, para poder calcular mediana y moda.
 */


public class QuickSort{
    
    public static void ordenar(ArrayList<Temperatura> temperaturas){
        
      if(temperaturas != null){
          
         ordenarQuick(temperaturas, 0, temperaturas.size()-1);
         
      }
      
    }
        
    private static void ordenarQuick(ArrayList<Temperatura> tmpArray, int izq, int der){
        
        double pivote = tmpArray.get(izq).getTemperatura();
        int i = izq;
        int j = der;
        double aux;
        
        while(i < j){
            
            while(tmpArray.get(i).getTemperatura() <= pivote && i < j){
                
                i++;
                
            }
            
            while(tmpArray.get(j).getTemperatura() > pivote){
                
                j--;
                
            }
            if(i < j){
                
                aux = tmpArray.get(i).getTemperatura();
                tmpArray.get(i).setTemperatura(tmpArray.get(j).getTemperatura());
                tmpArray.get(j).setTemperatura(aux);
                
            }
        }

        tmpArray.get(izq).setTemperatura(tmpArray.get(j).getTemperatura());
        tmpArray.get(j).setTemperatura(pivote);

        if(izq < j-1){
            
            ordenarQuick(tmpArray, izq, j-1);
            
        }
            
        if(j+1 < der){
            
           ordenarQuick(tmpArray, j+1, der); 
           
        }
    }
}