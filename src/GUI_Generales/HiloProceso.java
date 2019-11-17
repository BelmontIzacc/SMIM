/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import static GUI_Generales.Editar.tamanioS;
import static herramientas.GestorImagenes.crearCarpetas;
import static herramientas.GestorVideo.guardarVideos;

import GUI_Imagenes.Imagenes;
import GUI_Video.PuntosVideo;
import static GUI_Video.Video.tipoProcesoSelect;
import herramientas.Folio;
import herramientas.GestorImagenes;
import static herramientas.GestorVideo.rutaImagenesFinal;
import static herramientas.GestorVideo.tiempoAnalisisVideo;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelos.Coordenada;
import modelos.Temperatura;
import procesamiento.Imagen;
import procesamiento.Video;
import puntos.Nodo;


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
    public int forma;
    
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
                
                Imagen img = new Imagen( tipoProcesso, fechaDia, nombreProceso, ruta,
                        numeroImagenes, folio,usuario, grupo );
                
                ArrayList<Coordenada> puntosInteres = iniciarPuntos(Imagenes.vectorNodo);
                
                int tam = tamanioS;
                int f = forma;
                
                preProseamiento(puntosInteres,numeroImagenes,ruta);
                
                img.agregarPuntosInteres(puntosInteres);
                img.procesamientoImagenes(); // calculo de temperatura
                img.calcularEstadistica(); //calculo de estadisticass
                img.graficarHistograma();
                
                img.generarArchivos();
                img.guardarGrafica(700, 250, "png");
                
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
                
                int numeroCoordenadas = PuntosVideo.vectorNodo.size();
                String tipoProcesso =  nProceso;
                String nombreProceso = this.nombreProceso;
                Calendar fecha = Calendar.getInstance();
                String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
                String usuario = nombre;
                String grupo = this.grupo;
                
                String rutaUsuario = System.getProperty("user.home");
                String rutaVideoOriginal = rutaUsuario+"\\Documents\\SMIM\\"+
                    tipoProcesoSelect+"\\"+fechaDia+"_"+
                    nombreProceso+"_"+usuario+"_"+
                    grupo+"\\VideoOriginal.mp4";
                
                String rutaVideoReducido = rutaUsuario+"\\Documents\\SMIM\\"+
                    tipoProcesoSelect+"\\"+fechaDia+"_"+
                    nombreProceso+"_"+usuario+"_"+
                    grupo+"\\Video.mp4";
                
                String rutaImagenes = rutaImagenesFinal;
                
                String folio = Folio.generarFolio(nombreProceso);
                
                int tiempo= tiempoAnalisisVideo;
                
                ArrayList<Coordenada> puntosInteres = iniciarPuntos(PuntosVideo.vectorNodo);
                
                int numeroImagenes = 0;
                
                File fImagenes = new File(rutaImagenes);
                numeroImagenes = fImagenes.listFiles().length;
                
                Video vid = new Video(tipoProcesso, fechaDia, nombreProceso,
                        rutaImagenes, tiempo, rutaVideoReducido, numeroImagenes, folio, usuario, grupo );
                
                preProseamiento(puntosInteres,numeroImagenes,rutaImagenes);
                
                vid.agregarPuntosInteres(puntosInteres);
                vid.procesamientoVideo();
                vid.calcularEstadistica();
                vid.graficarHistograma();
                vid.generarArchivos();
                
                vid.guardarGrafica(700, 250, "png");
                
                
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

    public void forma(int forma) {
        this.forma = forma;
    }

    private void preProseamiento(ArrayList<Coordenada> puntosInteres, int numeroImagenes, String ruta) {
        
        int f = forma;
        int muestra = tamanioS;
        
        for(int im = 0 ; im<numeroImagenes ; im++){

            try {
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".png");
                BufferedImage bi = ImageIO.read(archivo);
                
                for(int x = 0 ; x<puntosInteres.size();x++){
                    
                    int xInicial = (int)puntosInteres.get(x).getCoordX(); 
                    int yInicial = (int) puntosInteres.get(x).getCoordY();
                    //int muestra = (tamanioS/2); //tamaño final = 2*muestra + 1
                    
                    int xNuevoInicio = xInicial-muestra; 
                    int xNuevoFin = xInicial+muestra;
                    int yNuevoInicio = yInicial-muestra;
                    int yNuevoFin = yInicial+muestra;
                    
                    int acumuladoRojo = 0;
                    int acumuladoVerde = 0;
                    int acumuladoAzul = 0;
                    int total = 0;
                    
                    for(int i = xNuevoInicio ; i <= xNuevoFin ; i++){
                        for(int j = yNuevoInicio ; j <= yNuevoFin ; j++){
                            
                            try{
                                
                                int color = bi.getRGB((int)puntosInteres.get(x).getCoordX(),(int)puntosInteres.get(x).getCoordX()); // se obtiene el color de la coordenada
                                Color pixel = new Color(color); 
                                acumuladoRojo += pixel.getRed();
                                acumuladoVerde += pixel.getGreen();
                                acumuladoAzul += pixel.getBlue(); 
                                total += 1;   
                                
                            }catch(RuntimeException e){
                                
                            }
                            
                        }
                    }
                    
                    int r;
                    int g;
                    int b;
                    
                    try{ r = acumuladoRojo/total; }catch(ArithmeticException e){ r = 0; }
                    
                    try{ g = acumuladoVerde/total; }catch(ArithmeticException e){ g = 0; }
                                        
                    try{ b = acumuladoAzul/total; }catch(ArithmeticException e){ b = 0; }
                   
                    
                    if( r > 255 ){ r = 255; }else if( r < 0 ){ r = 0; }
                    if( g > 255 ){ g = 255; }else if( g < 0 ){ g = 0; }
                    if( b > 255 ){ b = 255; }else if( b < 0 ){ b = 0; }
                    
                    Color colorPromedio = new Color(r,g,b);
                    
                    Temperatura temp = new Temperatura(puntosInteres.get(x).getId(),colorPromedio,""+numero);
                    puntosInteres.get(x).agregarTemperatura(temp);
                    
                }
                numero = 0;
            } catch (IOException ex) {
                Logger.getLogger(HiloProceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private ArrayList<Coordenada> iniciarPuntos(ArrayList<Nodo> lista) {
        
        ArrayList<Coordenada> puntosInteres = new ArrayList<>();
        
        int i = 0;
        for( Nodo n : lista){

            int x = n.getX();
            int y = n.getY();
            Coordenada e = new Coordenada(i,x,y);
            puntosInteres.add(e);
            i++;
        }
        return puntosInteres;  
    }

}
