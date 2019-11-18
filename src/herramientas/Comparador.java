/*
 */
package herramientas;

import java.util.ArrayList;
import modelos.NodoTemp;

/**
 * Clase Comparador
 * Fecha Lunes 18 de noviembre 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

 /** 
 * Clase que calcula la temperatura apartir de un color
 */
public class Comparador {
    
    public static double Calcular(ArrayList<NodoTemp> PaletaColor, int rgb){ 
        
        NodoTemp resultado = coincidencias(PaletaColor,rgb);
        
        if(resultado != null){
            
            return resultado.getTemperatura();
            
        }
        
        return -1.1;
    }

    /**
     * Funcion para buscar coincidencias respecto a la tonalidad deseada
     * IBelmont
     * Desde 18/11/19
     * params rango de temperatura, tonalidad a buscar, 
     **/ 
    
    public static NodoTemp coincidencias(ArrayList<NodoTemp> temp, int tonalidad){
        
        
        NodoTemp aux = buscar(temp,tonalidad,7,0,0);
        
        if(aux != null){
            
            return aux;
            
        }else{
            
            int i = 1;
            boolean buscar = true;
            
            while( buscar ){
                
                if( i == 13 ){
                    
                    buscar = false;
                    aux = null;
                    
                }else{
                    
                    int valor = reduccion(i);
                    int activo = activoDesactivo(i);
                    int pn = positivoNegativo(i);
                    //-1413002
                    //-14013898
                    aux = buscar(temp,tonalidad,valor,activo,pn);

                    i++;
                    
                    if( aux != null ){
                        
                        buscar = false;
                        
                    }
                    
                }
                
                
            }
        }
        
        return aux;
    }
    
    /**
     * Funcion para dictar el aumento positivo o negativo
     * IBelmont
     * Desde 18/11/19
     * params indice para retornar cantidad cadena
     **/
    
    public static int positivoNegativo( int indice ){
        
        if( indice == 2 || indice == 5 || indice == 8 || indice == 11 ){
            
            return 1;
            
        }else{
            
            return 0;
            
        }
    }
    
    /**
     * Funcion para activar o desactivar el aumento de valores
     * IBelmont
     * Desde 18/11/19
     * params indice para retornar cantidad cadena
     **/
    
    private static int activoDesactivo( int indice ){
        
        if( indice == 1 || indice == 4 || indice == 7 || indice == 10 ){
            
            return 0;
            
        }else{
            
            return 1;
            
        }
        
    }
    
    /**
     * Funcion para regresar valores a tomar por cadena para su busqueda
     * IBelmont
     * Desde 18/11/19
     * params indice para retornar cantidad cadena
     **/ 
    
    private static int reduccion(int indice) {
        
        int cantidad;
        
        if( indice >= 1 && indice <= 3 ){
         
            cantidad = 6;
            
        }else if( indice >= 4 && indice <= 6 ){
         
            cantidad = 5;
            
        }else if( indice >= 7 && indice <= 9 ){
         
            cantidad = 4;
            
        }else {
         
            cantidad = 3;
            
        }
        
        
        return cantidad;
        
    }
    
    /**
     * Funcion para buscar con busqueda binaria
     * IBelmont
     * Desde 18/11/19
     * params rango de temperatura, tonalidad a buscar, cantidad a reducir , habilitar aumento , tipo de aumento 
     **/ 
    
    private static NodoTemp buscar(ArrayList<NodoTemp> temp, int tonalidad, int cant,int opc,int op){
        
        int inicio = 0 ;
        int fin = temp.size() - 1;
        int pos;
        
        String ton = ""+tonalidad;
        String org = ton.substring(0, cant);
        int menos = 0;
        
        if( opc == 1 ){
            menos = Integer.parseInt(org);
            if(op == 1){
                menos = menos + 1 ;
            }else if(op == 0){
                menos = menos - 1 ;
            }
            
            org = ""+menos;
        }
        
        while(inicio <= fin){
            pos = (inicio+fin) / 2;
            
            String t = ""+temp.get(pos).getTonalidad();
            String comp = t.substring(0, cant);
            
            if(comp.equals(org)){
                return temp.get(pos);
            }else if(temp.get(pos).getTonalidad() < tonalidad){
                inicio = pos+1;
            }else{
                fin = pos -1;
            }
        }
        
        return null;
    }

    
}
