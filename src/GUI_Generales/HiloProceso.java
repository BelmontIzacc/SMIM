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
import conexion.EndPoint;
import herramientas.Folio;
import herramientas.GestorImagenes;
import static herramientas.GestorVideo.rutaImagenesFinal;
import static herramientas.GestorVideo.tiempoAnalisisVideo;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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
       
        String aux = nombre.replaceAll("[^\\dA-Za-z]", "");
        nombre = aux;
        
        String aux2 = grupo.replaceAll("[^\\dA-Za-z]", "");
        grupo = aux2;
        
        String aux3 = nombreProceso.replaceAll("[^\\dA-Za-z]", "");
        nombreProceso = aux3;
        
        if(tipo == 1){ ///Tipo 1 --- Ventana Imagenes
            if(procesando == 1){
                proceso.setVisible(true);
                procesando  = 0;
            }
            String rutaProyecto = null;
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
                
                preProseamiento(puntosInteres,numeroImagenes,ruta);
                
                img.agregarPuntosInteres(puntosInteres);
                img.procesamientoImagenes(); // calculo de temperatura
                img.calcularEstadistica(); //calculo de estadisticass
                img.graficarHistograma();
                
                img.generarArchivos();
                img.guardarGrafica(700, 250, "png");
                //Izacc
                active =  false;
                proceso.setVisible(true);
                
                String rutaUsuario = System.getProperty("user.home");
                rutaProyecto = rutaUsuario+"\\Documents\\SMIM\\"+
                    tipoProcesso+"\\"+fechaDia+"_"+
                    nombreProceso+"_"+usuario+"_"+
                    grupo+"";
                
                String tiempo = "0";
                
                envioInformacionArchivos(folio, tipoProcesso, rutaProyecto, tiempo,
                        nombreProceso,fechaDia,"0",usuario,grupo);
                
            }
//            System.out.println("salio del hilo");
            this.p.muestraResultados(rutaProyecto);
            
        }else if(tipo == 2){ ////Tipo 2 --- Ventana Video
            if(procesando == 1){
                proceso.setVisible(true);
                procesando = 0;
            }
            
            String rutaProyecto = null;
            while(active){
                guardarVideos(nombre,grupo,nombreProceso);
                //VIDEO!
                
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
                
                rutaProyecto = rutaUsuario+"\\Documents\\SMIM\\"+
                    tipoProcesoSelect+"\\"+fechaDia+"_"+
                    nombreProceso+"_"+usuario+"_"+
                    grupo+"";
                
                
                envioInformacionArchivos(folio, tipoProcesso, rutaProyecto, ""+tiempoAnalisisVideo,
                        nombreProceso,fechaDia,"0",usuario,grupo);
                
                active = false;
                proceso.setVisible(false);
                
            }
//            System.out.println("salio del hilo");
            this.p.muestraResultados(rutaProyecto);
            
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
        
        int f = forma; //
        int muestra = tamanioS;//diametro 3 = cuadrado //2 rombo
        
        switch(forma){
            case 2:{
                
                for(int im = 0 ; im<numeroImagenes ; im++){

                    rombo(puntosInteres, ruta,muestra,im);

                }
                
                break;
            }
            default:{
                
                for(int im = 0 ; im<numeroImagenes ; im++){

                    cuadrado(puntosInteres, ruta,muestra,im);

                }
                
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
    
    
    private void envioInformacionArchivos(String folio, String tipoProcesso, String rutaProyecto,
            String tiempo, String nombreProceso, String fechaDia, String string, String usuario, String grupo) {
        
        int resp = JOptionPane.showConfirmDialog(null, "Desea registrar el proyecto en SMIM-Web", "SMIM-Web", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        
        int web = JOptionPane.showConfirmDialog(null, "¿Desea visitar el sitio?", "SMIM-Web", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(web == 0){
            
            try {

                Desktop.getDesktop().browse(new URI("http://148.204.142.251/isc/SMIM/public"));

            } catch (URISyntaxException ex) {

//                System.out.println(ex);

            }catch(IOException e){

//                System.out.println(e);

            }
            
        }
        
        if(resp == 0){
            
            //(Espere unos segundos)
            this.p.jLabel3.setText("(Conectando al servidor...)");

            String ruProyecto = enviarEndPoint(folio, tipoProcesso, rutaProyecto);

            if( ruProyecto == null ){

                JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor",
                "Error",JOptionPane.WARNING_MESSAGE);

            }else{

                this.p.jLabel3.setText("(Registrando el proyecto...)");

                registrarDB(nombreProceso,tipoProcesso,fechaDia,tiempo,folio,usuario,grupo,ruProyecto);

            }

            this.p.jLabel3.setText("(Espere unos segundos)");
            
        }else{
            this.p.dispose();
            this.proceso.dispose();
        }
        
    }
    
    private String enviarEndPoint(String folio, String tipoProceso, String rutaProyecto){
        
        String credenciales = EndPoint.endPoint(1);
        String archivo = EndPoint.endPoint(2);
        
        EndPoint ep = new EndPoint( credenciales, archivo );
        
        String key = ep.key(folio);
        
        String link = enviarCredenciales(key,folio,tipoProceso,ep,0);
        
        if( link != null ){
            
            this.p.jLabel3.setText("(Enviando Archivos...)");
            String respuesta = enviarArchivo(link,rutaProyecto,ep);
        
            return respuesta;
            
        }else{
            
            return null;
            
        }
    }
    
    private String enviarArchivo(String link, String rutaProyecto, EndPoint ep) {
        
        String lin = link;
        String directorioServidor="";
        
        if( link != null || !link.equals( "false" ) ){
            
            String rProyecto = rutaProyecto;
        
            String[] contenido =  lin.split("coordenada_");
            directorioServidor = contenido[0];
            
            envioDocumentos(rProyecto, directorioServidor, ep);
        }
        
        return directorioServidor;
    }
    
    private void envioDocumentos( String rProyecto, String directorioServidor, EndPoint ep ){
        
        File proyecto = new File(rProyecto);
        String[] listado = proyecto.list();
        
        for( String index : listado ){
            
//            System.out.println("Contenido : "+index);
            
            if(index.equals("Video.mp4")){
                
//                System.out.println("index : "+index+" | proyecto : "+
//                        rProyecto+" | directorioServidor : "+directorioServidor);
                
                enviarArchivo(index, rProyecto, directorioServidor, ep);
                
            }else if( !index.equals("VideoOriginal.mp4") ){
                
                enviarDirectorio( index, rProyecto, directorioServidor, ep);
                
            }
            
        }
        
//        System.out.println(" : ");
        
    }
    
    private void enviarArchivo(String index, String rProyecto, String directorioServidor, EndPoint ep){
        
        String ruta = rProyecto+"\\"+index;
        int tipo = enteroIndex( index );
        String resultado = ep.subirArchivo( ruta, directorioServidor,tipo );
        
    }
    
    private void enviarDirectorio(String index, String rProyecto, String directorioServidor, EndPoint ep) {
        
        File proyecto = new File(rProyecto+"\\"+index);
        String[] listado = proyecto.list();
        
        String destino = validarIndex( index );
        int tipo = enteroIndex( index );
                
        for( String contenido : listado ){
            
            String archivo = rProyecto+"\\"+index+"\\"+contenido;
            String d = directorioServidor+""+destino+"_";
            String resultado = ep.subirArchivo( archivo, d,tipo );
            
        }
        
    }
    
    private int enteroIndex( String index ){
        
        if( index.equals("coordenada") || index.equals("Estadistica") 
                || index.equals("estadisticaXimagen") || index.equals("txt") ){
            
            return 1;
            
        }else if( index.equals("Imagenes") || index.equals("graficas") ){
            
            return 2;
            
        }else{
            
            return 3;
            
        }
        
    }
    
    private String validarIndex(String index) {
    
        switch(index){
            case "coordenada":{
                
                return "coordenada";
                
            }
            case "Estadistica":{
                
                return "estadistica";
                
            }
            case "estadisticaXimagen":{
                
                return "estadisticaXimagen";
                
            }
            case "graficas":{
                
                return "graficas";
                
            }
            case "Imagenes":{
                
                return "img";
                
            }
            case "txt":{
                
                return "txt";
                
            }
            default:{
                
                return "vid";
                
            }
        }
        
    }
    
    private String enviarCredenciales(String key, String folio, String tipoProceso, EndPoint ep,int pos) {
        
        String formato = formato(pos);
        String carpeta = ""+pos;
        
        String link = ep.enviarCredencialesArchivo(key,folio,tipoProceso,formato,carpeta);
//        System.out.println("Recibir destino : "+link);
        
        return link;
        
    }
    
    private String formato( int pos ){
        
        if( (pos >= 0 && pos <= 2) || pos == 5 ){
            
            return "7";
            
        }else if( pos == 3 || pos == 4 ){
            
            return "8";
            
        }else if( pos == 6 ){
            
            return "9";
            
        }
        
        return "0";
    }

    private void registrarDB(String nombreProceso, String tipoProcesso, 
            String fechaDia, String tiempoAnalisis, String folio, String usuario, String grupo, String ruProyecto) {
        
        //key,nombreProyecto,tipoProceso,fecha,tiempoAnalisis,noSerie,alumno,grupo,linkProyecto
        
        String baseDatos = EndPoint.endPoint(4);
        
        EndPoint ep = new EndPoint( baseDatos );
        
        String key = ep.key(folio);
        
        String registro = ep.enviarRaegistro(key,nombreProceso,tipoProcesso,fechaDia,
                tiempoAnalisis,folio,usuario,grupo,ruProyecto);
//        System.out.println(registro);
        
    }
    
    private void cuadrado(ArrayList<Coordenada> puntosInteres, String ruta, int muestra, int im) {
        
        try {
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".png");
                BufferedImage bi = ImageIO.read(archivo);
                
                for(int x = 0 ; x<puntosInteres.size();x++){
                    
                    int xInicial = (int)puntosInteres.get(x).getCoordX(); 
                    int yInicial = (int) puntosInteres.get(x).getCoordY();
                    
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

                                int color = bi.getRGB(i,j); // se obtiene el color de la coordenada
                                
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

    private void rombo(ArrayList<Coordenada> puntosInteres, String ruta, int muestra, int im) {
    
        try {
                int numero = im+1;
                File archivo = new File(""+ruta+"\\"+numero+".png");
                BufferedImage bi = ImageIO.read(archivo);
                
                for(int x = 0 ; x<puntosInteres.size();x++){
                    
                    int cordX = (int)puntosInteres.get(x).getCoordX(); 
                    int cordY = (int) puntosInteres.get(x).getCoordY();
                    
                    double radio = muestra/2.0;
                    
                    int inicio = (int) (cordX-radio);
                    int fin = (int) (cordX + radio);

                    int iteracion = 0;
                    int rango = 0;
                    
                    int acumuladoRojo = 0;
                    int acumuladoVerde = 0;
                    int acumuladoAzul = 0;
                    int total = 0;
                    
                    for( int i = inicio ; i <= fin ; i++ ){

                       int inicioY = cordY-rango; 
                       int topeY = cordY+rango;

                       for( int j = inicioY ; j <= topeY ; j++){
                           
                           try{
                                
                                int color = bi.getRGB(i,j); // se obtiene el color de la coordenada
                                
                                Color pixel = new Color(color); 
                                acumuladoRojo += pixel.getRed();
                                acumuladoVerde += pixel.getGreen();
                                acumuladoAzul += pixel.getBlue(); 
                                total += 1;   
                                
                            }catch(RuntimeException e){
                                
                            }  
                            
                       }

                       iteracion++;

                       if( iteracion > radio ){

                           rango--;

                       }else{

                           rango++;

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
