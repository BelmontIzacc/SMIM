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
public class testImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
             
            // esta informacion es la que se proporcionara al momento de estar seleccionando imagenes
            int numeroCoordenadas = 5; //Numero total de coordenadas seleccionadas en el panel
            int numeroImagenes = 2; // numero total de imagenes procesadas
            String tipo = "Fundicion"; // tipo de proceso seleccionado desde los menus
            String nombreProyecto = "Practica_1"; // nombre del proyecto ingresado por el usuario
            String fecha = "02/05/19"; // fecha tomada por el sistema
            String ruta = "C:\\Users\\izacc\\Pictures\\SMIM\\Fundicion"; //ruta donde estan guardadas las imagenes

            ArrayList<Coordenada> puntosInteres = new ArrayList<>(); // creacion de arreglo de puntosInteres
            
            for(int d = 0 ; d<numeroCoordenadas; d++){  //seleccion de puntos de interes aleatorios simulando el panel
                int i = ThreadLocalRandom.current().nextInt(1, 250); //Coordenada X
                int j = ThreadLocalRandom.current().nextInt(1, 250); //Coordenada Y
                Coordenada aux = new Coordenada(d,i,j); //Creacion de Coordenada con los valores enteriores
                puntosInteres.add(aux); //agregado de coordenada en el array de coordenadas
            }
            
            //inicio de preprocesamiento de imagenes
            for(int im = 0 ; im<numeroImagenes ; im++){ // dependiendo del numero de imagenes se aplica los puntos de interes
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".jpg"); // se habre o lee imagen por imagen guardada en la ruta definida
                BufferedImage bi = ImageIO.read(archivo); // se transforma el archivo a Buffered
                ImageJFrame frame = new ImageJFrame(bi); // por prueba se muestran las imagenes en esa carpeta, se quitara esto
                
                for(int x = 0 ; x<puntosInteres.size();x++){ // se aplicara por punto de interes en las imagenes
                    int color = bi.getRGB((int)puntosInteres.get(x).getCoordX(),(int)puntosInteres.get(x).getCoordX()); // se obtiene el color de la coordenada
                    Color c = new Color(color); //se crea el color obtenido de la coordenada
                    Temperatura temp = new Temperatura(puntosInteres.get(x).getId(),c,""+numero); //se guarda el color de la temperatura obtenida
                    puntosInteres.get(x).agregarTemperatura(temp);
                }
                 numero = 0;
            }
            
            //Inicio de procesamiento de imagenes
            Imagen img = new Imagen(tipo,fecha,nombreProyecto,ruta);
            img.agregarPuntosInteres(puntosInteres); //se agrega los puntos de interes a la clase imagen
            img.procesamientoImagenes(); // calculo de temperatura
            img.calcularEstadistica(); //calculo de estadisticass
            System.out.println();
            
        } catch (IOException ex) {
            Logger.getLogger(testImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}