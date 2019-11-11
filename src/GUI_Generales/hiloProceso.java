/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import static GUI_Generales.Prueba.Procesos;
import static GUI_Generales.Prueba.Tiempo;
import GUI_Imagenes.Imagenes;
import GUI_Video.PuntosVideo;
import GUI_Video.Video;
import herramientas.GestorImagenes;
import static herramientas.GestorImagenes.crearCarpetas;
import herramientas.GestorVideo;
import static herramientas.GestorVideo.guardarVideos;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rebel
 */
public class hiloProceso extends Thread{
    public static boolean active;
    public int procesando;
    public Procesando p;
    public List<BufferedImage> listaIm;
    public int tipo;
    
    public hiloProceso(Procesando proceso,List<BufferedImage> listaIm,int tipo){
        this.procesando = 1;
        this.p = proceso;
        this.listaIm = listaIm;
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
       
        if(tipo == 1){ ///Tipo 1 --- Ventana Imagenes
            if(procesando == 1){
                GUI_Imagenes.CorreccionImagenes.proceso.setVisible(true);
                procesando  = 0;
            }

            while(active){
                crearCarpetas(this.listaIm);
                ///IMAGENES!
                // numeroCoordenadas = 5; //Numero total de coordenadas seleccionadas en el panel
                //-----------Imagenes.vN.size();
                //numeroImagenes = 8; // numero total de imagenes procesadas
                //-----------GestorImagenes.rutas.size();
                //tipo = "Fundicion"; // tipo de proceso seleccionado desde los menus {soldadura, fundicion,manufactura)
                //------------Procesos.get(Imagenes.nomProceso.getSelectedIndex()-1);
                //nombreProyecto = "Practica_1"; // nombre del proyecto ingresado por el usuario
                //------------Imagenes.nombreProceso.getText();
                //fecha = "02/05/19"; // fecha tomada por el sistema
                //------------Calendar fecha = Calendar.getInstance();
                //------------String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
                //ruta = "C:\\Users\\izacc\\Pictures\\SMIM\\Fundicion"; //ruta donde estan guardadas las imagenes
                //------------GestorImagenes.rutaNueva;
                //nombreAlumno = "Izacc Belmont Belmont";
                //------------Imagenes.nombre.getText();
                //grupoAlumno = "5CM1";
                //------------Imagenes.grupo.getText();
                active =  false;
                GUI_Imagenes.CorreccionImagenes.proceso.setVisible(true);
            }
            System.out.println("salio del hilo");
            this.p.muestraResultados();
             
        }else if(tipo == 2){ ////Tipo 2 --- Ventana Video
            if(procesando == 1){
                GUI_Video.CorreccionVideo.proceso.setVisible(true);
                procesando = 0;
            }
            
            while(active){
                guardarVideos();
                //VIDEO!
                //numeroCoordenadas = 2; //Numero total de coordenadas seleccionadas en el panel
                //------------PuntosVideo.vN.size();
                //numeroImagenes = 4; // numero total de imagenes procesadas obtenidas del video
                //------------
                //tipo = "Fundicion"; // tipo de proceso seleccionado desde los menus
                //------------Procesos.get(Video.tipoProceso.getSelectedIndex()-1);
                //nombreProyecto = "Manufactura_1"; // nombre del proyecto ingresado por el usuario
                //------------Video.nombreProceso.getText();
                //fecha = "05/08/19"; // fecha tomada por el sistema
                //------------Calendar fecha = Calendar.getInstance();
                //------------String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
                //rutaVideo = "C:\\Users\\izacc\\Pictures\\SMIM\\Manufactura\\profe.mp4"; //ruta donde estan guardado el video
                //------------
                //rutaVideo = "C:\\Users\\izacc\\Pictures\\SMIM\\Manufactura\\profe.mp4"; //ruta donde estan guardado el video Convertido
                //------------
                //rutaImagenes = /ruta donde se guarda las imagenes
                //------------GestorVideo.rutaNueva;
                //tiempoAnalisis = 10;
                //------------Tiempo.get(Video.tiempoImagenes.getSelectedIndex()-1);
                //nombreAlumno = "Alejandra Beltran Silva";
                //------------Video.nombreAlumno.getText();
                //grupoAlumno = "5CM1";
                //------------Video.Grupo.getText();
                active = false;
                GUI_Video.CorreccionVideo.proceso.setVisible(false);
            }
            System.out.println("salio del hilo");
            this.p.muestraResultados();
        }
        
    }
}
