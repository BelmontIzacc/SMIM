/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
        try {
            // TODO code application logic here

            int numeroCoordenadas = 5;
            int numeroImagenes = 6;
            String tipo = "Fundicion";
            String nombreProyecto = "Practica_1";
            String fecha = "02/05/19";
            String ruta = "C:\\Users\\izacc\\Pictures\\SMIM\\Fundicion";

            ArrayList<Coordenada> puntosInteres = new ArrayList<>();
            
            for(int d = 0 ; d<numeroCoordenadas; d++){
                int i = ThreadLocalRandom.current().nextInt(1, 250);
                int j = ThreadLocalRandom.current().nextInt(1, 250);    
                Coordenada aux = new Coordenada(d,i,j);
                puntosInteres.add(aux);
            }
            
            for(int im = 0 ; im<numeroImagenes ; im++){
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".jpg");
                BufferedImage bi = ImageIO.read(archivo);
                ImageJFrame frame = new ImageJFrame(bi);
                
                for(int x = 0 ; x<puntosInteres.size();x++){
                    int color = bi.getRGB((int)puntosInteres.get(x).getCoordX(),(int)puntosInteres.get(x).getCoordX());
                    Color c = new Color(color);
                    Temperatura temp = new Temperatura(puntosInteres.get(x).getId(),c,""+numero);
                    puntosInteres.get(x).agregarTemperatura(temp);
                }
                 numero = 0;
            }

            Imagen img = new Imagen(tipo,fecha,nombreProyecto,ruta);
            img.agregarPuntosInteres(puntosInteres);
            img.procesamientoImagenes();
            img.calcularEstadistica();
            System.out.println();
            
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}