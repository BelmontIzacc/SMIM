/*
 */
package procesamiento;

import herramientas.GestorArchivo;
import herramientas.Grafica;
import herramientas.HistogramaFrecuencias;
import herramientas.Ordenar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelos.Coordenada;
import modelos.Estadistica;
import modelos.NodoTemp;
import modelos.PaletaColor;
import modelos.Temperatura;
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
    private ArrayList<Grafica> graficasPromedio;
    private ArrayList<NodoTemp> paletaColorAsignadaPartA;
    private ArrayList<NodoTemp> paletaColorAsignadaPartB;
    
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
        this.graficasPromedio = new ArrayList<>();
        this.paletaColorAsignadaPartA = new ArrayList<>();
        this.paletaColorAsignadaPartB = new ArrayList<>();
        
    }
    
    /**
     * Funcion para agregar los puntos de interes
     * IBelmont
     * Desde 30/04/19
     * params arreglo de coordenadas
     **/ 
    
    abstract public void agregarPuntosInteres(ArrayList<Coordenada> puntosInteres);
    
    /**
     * Funcion calcular la estadistica
     * IBelmont
     * Desde 30/04/19
     **/ 
    
    abstract public void calcularEstadistica();
    
    /**
     * Funcion para graficar el histograma
     * IBelmont
     * Desde 30/04/19
     **/ 
    
    abstract public void graficarHistograma();
    
     /**
     * Funcion para calcular Histograma de frecuencias
     * IBelmont
     * Desde 30/04/19
     **/ 
    
    public ArrayList<ArrayList<double[]>> calcularHistogramaFrecuencias(){

        ArrayList<ArrayList<double[]>> listaTono = new ArrayList<>();

         if( numeroImagenes > 3 ){

             try {

                 int mitad = ( int )Math.floor( numeroImagenes / 2 );
                 int nums[] = { 1, mitad , numeroImagenes };

                 for( int x = 0 ; x < nums.length ; x++ ){
                     
                     ArrayList<double[]> tonos = new ArrayList<>();

                     File archivo = new File( "" + rutaImagenes + "\\" + nums[x] + ".png" );
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
    
    /**
     * Funcion para generar las graficas de estadistica
     * IBelmont
     * Desde 1/12/19
     **/
    
    public void generarGraficaEstadisticas(String rg){
        
        int alto = 950;
        int ancho = 550;
        
        double[] eDesviacion = new double[estadisticas.size()];
        double[] eMedia = new double[estadisticas.size()];
        double[] eMediana = new double[estadisticas.size()];
        double[] eModa = new double[estadisticas.size()];
        double[] eVarianza = new double[estadisticas.size()];
        
        for(int x = 0 ; x < estadisticas.size() ; x++){
            
            eDesviacion[x] = estadisticas.get(x).getDesviacionEstandar();
            eMedia[x] = estadisticas.get(x).getMedia();
            eMediana[x] = estadisticas.get(x).getMediana();
            eModa[x] = estadisticas.get(x).getModa();
            eVarianza[x] = estadisticas.get(x).getVarianza();
            
        }
        
        Grafica grafica = new Grafica( "Punto de Interes", " ",
                "Desviacion estandar de temperatura por punto de interes Celsius" );
        
        grafica.agregarSerie( "DesviacionEstandar", eDesviacion );
        grafica.crearYmostrarGrafica();
        
        grafica.guardarGrafica(alto, ancho, rg, "Desviacion estandar", "png");
        
        Grafica grafica2 = new Grafica( "Punto de Interes", " Temperatura",
                "Media de temperatura por punto de interes Celsius" );
        
        grafica2.agregarSerie( "Media", eMedia );
        grafica2.crearYmostrarGrafica();
        
        grafica2.guardarGrafica(alto, ancho, rg, "Media", "png");
        
        Grafica grafica3 = new Grafica( "Punto de Interes", " Temperatura",
                "Mediana de temperatura por punto de interes Celsius" );
        
        grafica3.agregarSerie( "Mediana", eMediana );
        grafica3.crearYmostrarGrafica();
        
        grafica3.guardarGrafica(alto, ancho, rg, "Mediana", "png");
        
        Grafica grafica4 = new Grafica( "Punto de Interes", " Temperatura",
                "Moda de temperatura por punto de interes Celsius" );
        
        grafica4.agregarSerie( "Moda", eModa );
        grafica4.crearYmostrarGrafica();
        
        grafica4.guardarGrafica(alto, ancho, rg, "Moda", "png");
        
        Grafica grafica5 = new Grafica( "Punto de Interes", " ",
                "Varianza de temperatura por punto de interes Celsius" );
        
        grafica5.agregarSerie( "Varianza", eVarianza );
        grafica5.crearYmostrarGrafica();
        
        grafica5.guardarGrafica(alto, ancho, rg, "Varianza", "png");
    }
    
    /**
     * Funcion para generar las graficas por punto de interes
     * IBelmont
     * Desde 15/11/19
     **/ 
    
    public void generarGraficaPorPunto(String rg){
        
        int alto = 950;
        int ancho = 550;
        
//        ArrayList<Grafica> comportamiento = new ArrayList<>();
        ArrayList<double[]> comportamientoC = new ArrayList<>();
        ArrayList<double[]> comportamientoF = new ArrayList<>();
        ArrayList<double[]> comportamientoK = new ArrayList<>();
        
        for(int x = 0 ; x < puntosInteres.size() ; x++){
            
            Coordenada c = puntosInteres.get(x);
            ArrayList<Temperatura> t = c.getTemperatura();
            
            int tamTemp = t.size();
            
            double[] datosC = new double[tamTemp];
            double[] datosF = new double[tamTemp];
            double[] datosK = new double[tamTemp];
            
            for( int i = 0 ; i < t.size() ; i++ ){

                String nombre = t.get(i).getNombreImagen();
                double tempCelsius = t.get(i).getTemperaturaCelsius();
                double tempFar = t.get(i).getTemperaturaFarenheit();
                double tempKelvin = t.get(i).getTemperaturaKelvin();

                datosC[i] = tempCelsius;
                datosF[i] = tempFar;
                datosK[i] = tempKelvin;
            }
            
            comportamientoC.add(datosC);
            comportamientoK.add(datosF);
            comportamientoF.add(datosK);
            
        }
        
        Grafica grafica = new Grafica( "Punto de Interes", "Temperatura","Comportamiento de temperatura por punto de interes Celsius" );
        
        for( int i = 0 ; i < comportamientoC.size() ; i++ ){
            
            grafica.agregarSerie( ""+i, comportamientoC.get(i) );
            grafica.crearYmostrarGrafica();
            
        }
        
        grafica.guardarGrafica(alto, ancho, rg, "Punto Interes Celsius", "png");
        
        Grafica grafica1 = new Grafica( "Punto de Interes", "Temperatura","Comportamiento de temperatura por punto de interes Farenheit" );
        
        for( int i = 0 ; i < comportamientoF.size() ; i++ ){
            
            grafica1.agregarSerie( ""+i, comportamientoF.get(i) );
            grafica1.crearYmostrarGrafica();
            
        }
        
        grafica1.guardarGrafica(alto, ancho, rg, "Punto Interes Farenheit", "png");
        
        Grafica grafica2 = new Grafica( "Punto de Interes", "Temperatura","Comportamiento de temperatura por punto de interes Kelvin" );
        
        for( int i = 0 ; i < comportamientoK.size() ; i++ ){
            
            grafica2.agregarSerie( ""+i, comportamientoK.get(i) );
            grafica2.crearYmostrarGrafica();
            
        }
        
        grafica2.guardarGrafica(alto, ancho, rg, "Punto Interes Kelvin", "png");
        
        generarGraficaEstadisticas(rg);
    }
    
    /**
     * Funcion para generar las graficas de promedio por temperatura
     * IBelmont
     * Desde 15/11/19
     **/ 
    
    public void generarGraficaPromedioPunto(){
        
        double[] datosC = new double[temperaturaPromedioPuntos.size()];
        double[] datosF = new double[temperaturaPromedioPuntos.size()];
        double[] datosK = new double[temperaturaPromedioPuntos.size()];
        
        for( int x = 0 ; x < datosC.length ; x++ ){
            
            datosC[x] = temperaturaPromedioPuntos.get(x).getTemperaturaPromedioCelsius();
            datosF[x] = temperaturaPromedioPuntos.get(x).getTemperaturaPromedioFarenheit();
            datosK[x] = temperaturaPromedioPuntos.get(x).getTemperaturaPromedioKelvin();
            
        }
        
        Grafica grafica1 = new Grafica( "Imagen", "Temperatura","Nivel de temperatura promedio por imagen Celsius" );
            
        grafica1.agregarSerie( "Celsius", datosC );
        grafica1.crearYmostrarGrafica();
        
        Grafica grafica2 = new Grafica( "Imagen", "Temperatura","Nivel de temperatura promedio por imagen Farenheit" );
            
        grafica2.agregarSerie( "Farenheit", datosF );
        grafica2.crearYmostrarGrafica();
        
        Grafica grafica3 = new Grafica( "Imagen", "Temperatura","Nivel de temperatura promedio por imagen Kelvin" );
            
        grafica3.agregarSerie( "Kelvin", datosK );
        grafica3.crearYmostrarGrafica();
        
        this.graficasPromedio.add(grafica1);
        this.graficasPromedio.add(grafica2);
        this.graficasPromedio.add(grafica3);
        
    }
    
    public void cargarPaleta(){
        
        PaletaColor pc = new PaletaColor();
        
        ArrayList<String> tempMax = 
            new ArrayList<>(Arrays.asList(pc.arcoirisMax())); 
        
        ArrayList<String> tempMin = 
            new ArrayList<>(Arrays.asList(pc.arcoirisMin())); 
        
        ArrayList<NodoTemp> nt = new ArrayList<>();
        
        for( int x = 0 ; x < tempMax.size() ; x++ ){
            
            NodoTemp n = new NodoTemp(tempMax.get(x));
            nt.add(n);
        }
        
        ArrayList<NodoTemp> ntm = new ArrayList<>();
        
        for( int x = 0 ; x < tempMin.size() ; x++ ){
            
            NodoTemp n = new NodoTemp(tempMin.get(x));
            ntm.add(n);
        }
        
        this.paletaColorAsignadaPartA = Ordenar.ordenarPorTonalidad(nt);
        this.paletaColorAsignadaPartB = Ordenar.ordenarPorTonalidad(ntm);
        
    }
    
    /**
     * Funcion para generar los archivos .txt del proyecto procesado
     * IBelmont
     * Desde 30/04/19
     **/ 
    
    public void generarArchivos(){
        
        String r = this.rutaImagenes;
        GestorArchivo.GenerarTxt(puntosInteres, estadisticas, temperaturaPromedioPuntos,r);
        
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

    public ArrayList<Grafica> getGraficasPromedio() {
        return graficasPromedio;
    }

    public ArrayList<NodoTemp> getPaletaColorAsignadaPartA() {
        return paletaColorAsignadaPartA;
    }

    public ArrayList<NodoTemp> getPaletaColorAsignadaPartB() {
        return paletaColorAsignadaPartB;
    }
    
}