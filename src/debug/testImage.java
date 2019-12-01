/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import herramientas.Folio;
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
            int numeroCoordenadas = 3; //Numero total de coordenadas seleccionadas en el panel
            int numeroImagenes = 4; // numero total de imagenes procesadas
            String tipo = "Fundicion"; // tipo de proceso seleccionado desde los menus
            String nombreProyecto = "Practica_1"; // nombre del proyecto ingresado por el usuario
            String fecha = "02/05/19"; // fecha tomada por el sistema
            String ruta = "C:\\Users\\izacc\\Pictures\\SMIM\\Fundicion"; //ruta donde estan guardadas las imagenes
            String nombreAlumno = "Izacc Belmont Belmont";
            String grupoAlumno = "5CM1";
            String folio;
            
            ArrayList<Coordenada> puntosInteres = new ArrayList<>(); // creacion de arreglo de puntosInteres
//            int cord1 = 121;//Coordenada X
//            int cord2 = 103; //Coordenada Y
//            Coordenada a = new Coordenada(0,cord1,cord2); //Creacion de Coordenada con los valores enteriores
//            puntosInteres.add(a); //agregado de coordenada en el array de coordenadas
                
            for(int d = 0 ; d<numeroCoordenadas; d++){  //seleccion de puntos de interes aleatorios simulando el panel
                int i = ThreadLocalRandom.current().nextInt(1, 200); //Coordenada X
                int j = ThreadLocalRandom.current().nextInt(1, 200); //Coordenada Y
                Coordenada aux = new Coordenada(d,i,j); //Creacion de Coordenada con los valores enteriores
                puntosInteres.add(aux); //agregado de coordenada en el array de coordenadas
            }
            
            //inicio de preprocesamiento de imagenes
            for(int im = 0 ; im<numeroImagenes ; im++){ // dependiendo del numero de imagenes se aplica los puntos de interes
                
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".jpg"); // se habre o lee imagen por imagen guardada en la ruta definida
                BufferedImage bi = ImageIO.read(archivo); // se transforma el archivo a Buffered
                ImageJFrame frame = new ImageJFrame(bi); // por prueba se muestran las imagenes en esa carpeta, se quitara esto
                
                BufferedImage imagenConstruida = new BufferedImage(frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
                
                for(int x = 0 ; x<puntosInteres.size();x++){ // se aplicara por punto de interes en las imagenes
                    
                    int xInicial = (int)puntosInteres.get(x).getCoordX(); //Cordenada seleccionada por el usuario X
                    int yInicial = (int) puntosInteres.get(x).getCoordY(); //Coordenada seleccionada por el usuario Y
                    int muestra = 50; //tamaño final = 2*muestra + 1
                    int xNuevoInicio = xInicial-muestra; //Nuevo inicio X para iniciar el recorrido matriz
                    int xNuevoFin = xInicial+muestra; //Nuevo tope X para finalizar el recorrido en matriz
                    int yNuevoInicio = yInicial-muestra; //Nuevo inicio Y para iniciar el recorrido matriz
                    int yNuevoFin = yInicial+muestra; //Nuevo tope Y para finalizar el recorrido en matriz

                    int acumuladoRojo = 0; //variable para acumular la tonalidad roja del reccorido
                    int acumuladoVerde = 0; //variable para acumular la tonalidad verde del reccorido
                    int acumuladoAzul = 0; //variable para acumular la tonalidad azul del reccorido
                    int total = 0; //total de tonalidades recorridas
            
                    //for para recorrer por matriz las tonalidades al rededor de la coordenada seleccionada por el usuario
                    for(int i = xNuevoInicio ; i <= xNuevoFin ; i++){
                        for(int j = yNuevoInicio ; j <= yNuevoFin ; j++){
                            
                            int color = bi.getRGB(i,j); // se obtiene el color de la coordenada                            
                            Color pixel = new Color(color); //se crea el color obtenido de la coordenada
                            //System.out.println(""+c.getRed()+","+c.getGreen()+","+c.getBlue());
                            acumuladoRojo += pixel.getRed(); //acumula la tonalidad roja de los pixeles
                            acumuladoVerde += pixel.getGreen(); //acumula la tonalidad verde de los pixeles
                            acumuladoAzul += pixel.getBlue(); //acumula la tonalidad zul de los pixeles
                            total += 1; //acumula cada pixel recorrido
                            
                            imagenConstruida.setRGB(i, j, color);
                            
                        }
                    }
                    
                    int r = acumuladoRojo/total; //calculo del promedio de las tonalidades rojas
                    int g = acumuladoVerde/total; //calculo del promedio de las tonalides verdes
                    int b = acumuladoAzul/total; //calculo del promedio de las tonalidades azules
                    
                    if( r > 255 ){ r = 255; }else if( r < 0 ){ r = 0; }
                    if( g > 255 ){ g = 255; }else if( g < 0 ){ g = 0; }
                    if( b > 255 ){ b = 255; }else if( b < 0 ){ b = 0; }
                    
                    Color colorPromedio = new Color(r,g,b); //creado del color calculado del promedio anterior
                    
                    Temperatura temp = new Temperatura(puntosInteres.get(x).getId(),colorPromedio,""+numero); //se guarda el color de la temperatura obtenida
                    puntosInteres.get(x).agregarTemperatura(temp);
                    
                    ImageJFrame fram = new ImageJFrame(imagenConstruida);
                    System.out.println();
                }
                numero = 0;
            }
            
            //Inicio de procesamiento de imagenes
            folio = Folio.generarFolio(nombreProyecto);
            Imagen img = new Imagen( tipo, fecha, nombreProyecto, ruta, numeroImagenes, folio, nombreAlumno, grupoAlumno );
            img.agregarPuntosInteres(puntosInteres); //se agrega los puntos de interes a la clase imagen
            img.procesamientoImagenes(); // calculo de temperatura
            img.calcularEstadistica(); //calculo de estadisticass
//            img.graficarHistograma();
            img.generarArchivos();
            
//            img.guardarGrafica(700, 250, "png");
            
            System.out.println();
            
        } catch (IOException ex) {
            Logger.getLogger(testImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}