/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import GUI_Imagenes.Imagenes;
import herramientas.Folio;
import herramientas.GestorImagenes;
import static herramientas.GestorImagenes.crearCarpetas;
import static herramientas.GestorVideo.guardarVideos;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.List;
import procesamiento.Imagen;


/**
 *
 * @author rebel
 */
public class HiloProceso extends Thread{
    public static boolean active;
    public int procesando;
    public Procesando p;
    public List<BufferedImage> listaIm;
    public int tipo;
    public String nProceso;
    public String nombre;
    public String grupo;
    public String nombreProceso;
    public Procesando proceso;
    
    public HiloProceso(Procesando proceso,List<BufferedImage> listaIm,int tipo){
        this.procesando = 1;
        this.p = proceso;
        this.listaIm = listaIm;
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
       
        if(tipo == 1){ ///Tipo 1 --- Ventana Imagenes
            if(procesando == 1){
                proceso.setVisible(true);
                procesando  = 0;
            }

            while(active){
                crearCarpetas(this.listaIm,nProceso,nombre,grupo,nombreProceso);
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
                
                int numeroCoordenadas = Imagenes.vectorNodo.size();
                int numeroImagenes = GestorImagenes.rutas.size();
                String tipoProcesso =  nProceso;
                String nombreProceso = this.nombreProceso;
                Calendar fecha = Calendar.getInstance();
                String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
                String ruta = GestorImagenes.rutaProyecto;
                String usuario = nombre;
                String grupo = this.grupo;
                
                String folio = Folio.generarFolio(nombreProceso);
                
                Imagen img = new Imagen( tipoProcesso, fechaDia, nombreProceso, ruta, numeroImagenes, folio, usuario, grupo );
                
                
                
                active =  false;
                proceso.setVisible(true);
            }
            System.out.println("salio del hilo");
            this.p.muestraResultados();
             
        }else if(tipo == 2){ ////Tipo 2 --- Ventana Video
            if(procesando == 1){
                proceso.setVisible(true);
                procesando = 0;
            }
            
            while(active){
                guardarVideos(nombre,grupo,nombreProceso);
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
                proceso.setVisible(false);
            }
            System.out.println("salio del hilo");
            this.p.muestraResultados();
        }
        
    }

    public void pasarProceso(String nProceso, String nom, String g, String np) {
        this.nProceso = nProceso;
        this.nombre = nom;
        this.grupo = g;
        this.nombreProceso = np;
    }

    public void darProcesando(Procesando proceso) {
        this.proceso = proceso;
    }

}
