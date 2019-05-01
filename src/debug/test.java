/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import java.awt.Color;
import java.util.ArrayList;
import modelos.Coordenada;
import modelos.Temperatura;
import procesamiento.Imagen;

/**
 *
 * @author izacc
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Coordenada cor1 = new Coordenada(1,50.0,124.2);
        Coordenada cor2 = new Coordenada(2,20.0,184.2);
        
        Color c1 = new Color(24,9,51);
        Color c2 = new Color(23,212,52);
        Color c3 = new Color(20,1,6);
        Color c4 = new Color(105,23,4);
        Color c5 = new Color(158,17,186);
        
        Temperatura t1 = new Temperatura(1,c1,"A");
        Temperatura t2 = new Temperatura(2,c2,"B");
        Temperatura t3 = new Temperatura(3,c3,"C");
        Temperatura t4 = new Temperatura(4,c4,"D");
        Temperatura t5 = new Temperatura(5,c5,"E");
        
        cor1.agregarTemperatura(t1);
        cor1.agregarTemperatura(t2);
        cor1.agregarTemperatura(t3);
        cor1.agregarTemperatura(t4);
        cor1.agregarTemperatura(t5);
        
        cor2.agregarTemperatura(t1);
        cor2.agregarTemperatura(t2);
        cor2.agregarTemperatura(t3);
        cor2.agregarTemperatura(t4);
        cor2.agregarTemperatura(t5);
        
        ArrayList<Coordenada> puntosInteres = new ArrayList<>();
        puntosInteres.add(cor1);
        puntosInteres.add(cor2);

        Imagen img = new Imagen("Fundicion","01-05-19","Practica","C:\\Documentos\\SMIM\\Fundicion");
        img.agregarPuntosInteres(puntosInteres);
        img.procesamientoImagenes();
        System.out.println();
    }
    
}
