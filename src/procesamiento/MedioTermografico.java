/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import herramientas.GestorArchivo;
import herramientas.Grafica;
import herramientas.HistogramaFrecuencias;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelos.Coordenada;
import modelos.Estadistica;
import modelos.TemperaturaPromedioPuntos;

/**
 * Clase Medio Termografico.
 * Fecha Martes 30 de abril 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */

/**
 * La Clase MedioTermografico es abstracta para poder heredar sus metodos y variables a las clases
 * Imagen y Video y poder sobreescribirlos segun se necesite.
 */


public abstract class MedioTermografico{
    
    private String tipProceso;
    private String fecha;
    private String nombreProceso;
    private String rutaImagenes;
    private int numeroImagenes;
    private ArrayList<Coordenada> puntosInteres;
    private ArrayList<Estadistica> estadisticas;
    private ArrayList<TemperaturaPromedioPuntos> temperaturaPromedioPuntos;
    private String folio;
    private String nombreAlumno;
    private String grupoAlumno;
    private ArrayList<Grafica> listaGrafica;
    
    public MedioTermografico( String tipProceso, String fecha, String nombreProceso,
            String rutaImagenes, int numeroImagenes, String folio, String nombreAlumno, String grupoAlumno ){
        
        this.tipProceso = tipProceso;
        this.fecha = fecha;
        this.nombreProceso = nombreProceso;
        this.rutaImagenes = rutaImagenes;
        this.numeroImagenes = numeroImagenes;
        this.puntosInteres = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
        this.temperaturaPromedioPuntos = new ArrayList<>();
        this.folio = folio;
        this.nombreAlumno = nombreAlumno;
        this.grupoAlumno = grupoAlumno;
        this.listaGrafica = new ArrayList<>();
        
    }
    
    abstract public void agregarPuntosInteres(ArrayList<Coordenada> puntosInteres);
    
    abstract public void calcularEstadistica();
    
    abstract public void graficarHistograma();
    
    public ArrayList<ArrayList<double[]>> calcularHistogramaFrecuencias(){

        ArrayList<ArrayList<double[]>> listaTono = new ArrayList<>();

         if( numeroImagenes > 3 ){

             try {

                 int mitad = ( int )Math.floor( numeroImagenes / 2 );
                 int nums[] = { 1, mitad , numeroImagenes };

                 for( int x = 0 ; x < nums.length ; x++ ){
                     
                     ArrayList<double[]> tonos = new ArrayList<>();

                     File archivo = new File( "" + rutaImagenes + "\\" + nums[x] + ".jpg" );
                     BufferedImage bi = ImageIO.read(archivo);

                     double hRojo [] = HistogramaFrecuencias.calcularHistograma( 1, bi );
                     double hVerde [] = HistogramaFrecuencias.calcularHistograma( 2, bi );
                     double hAzul [] = HistogramaFrecuencias.calcularHistograma( 3, bi );

                     tonos.add( hRojo );
                     tonos.add( hVerde );
                     tonos.add( hAzul );
                     
                     listaTono.add( tonos );
                     
                 }
                 
                 return listaTono;

             } catch (IOException ex) {
                 Logger.getLogger(MedioTermografico.class.getName()).log(Level.SEVERE, null, ex);
             }

         }
         return null;
    }
    
    public void generarArchivos(){
        
        GestorArchivo.GenerarTxt(puntosInteres, estadisticas, temperaturaPromedioPuntos);
        
    }
    
    public String getTipProceso(){
        
        return tipProceso;
        
    }

    public String getFecha(){
        
        return fecha;
        
    }

    public String getNombreProceso(){
        
        return nombreProceso;
        
    }

    public String getRutaImagenes(){
        
        return rutaImagenes;
        
    }

    public ArrayList<Coordenada> getPuntosInteres(){
        
        return puntosInteres;
        
    }

    public ArrayList<Estadistica> getEstadisticas(){
        
        return estadisticas;
        
    }

    public void setPuntosInteres(ArrayList<Coordenada> puntosInteres){
        
        this.puntosInteres = puntosInteres;
        
    }

    public ArrayList<TemperaturaPromedioPuntos> getTemperaturaPromedioPuntos() {
        
        return temperaturaPromedioPuntos;
        
    }

    public void setTemperaturaPromedioPuntos( ArrayList<TemperaturaPromedioPuntos> temperaturaPromedioPuntos ) {
        
        this.temperaturaPromedioPuntos = temperaturaPromedioPuntos;
        
    }

    public int getNumeroImagenes() {
        
        return numeroImagenes;
        
    }

    public void setNumeroImagenes( int numeroImagenes ) {
        
        this.numeroImagenes = numeroImagenes;
        
    }

    public String getFolio() {
        
        return folio;
        
    }

    public void setFolio(String folio) {
        
        this.folio = folio;
        
    }

    public String getNombreAlumno() {
        
        return nombreAlumno;
        
    }

    public void setNombreAlumno(String nombreAlumno) {
        
        this.nombreAlumno = nombreAlumno;
        
    }

    public String getGrupoAlumno() {
        
        return grupoAlumno;
        
    }

    public void setGrupoAlumno(String grupoAlumno) {
        
        this.grupoAlumno = grupoAlumno;
        
    }

    public ArrayList<Grafica> getListaGrafica() {
        
        return listaGrafica;
        
    }
    
}