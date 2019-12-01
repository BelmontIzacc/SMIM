/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 * Clase Imagen.
 * Fecha Martes 07 de noviembre 2019.
 * @author IBelmont.
 * Copyright IBelmont.
 */ 
 
 /** 
 * Clase para el manejo y conexion a base de datos y servidor
 */
public class EndPoint {
    
    private String rutaBD;
    private String rutaAcceso;
    private String rutaAccesoArchivo;

    public EndPoint( String rutaAcceso, String rutaAccesoArchivo){
        
        this.rutaAcceso = rutaAcceso;
        this.rutaAccesoArchivo = rutaAccesoArchivo;
        
    }
    
    public EndPoint( String rutaBD ){
        
        this.rutaBD = rutaBD;
        
    }
    
    /**
     * Funcion consulta la tabla de configuracion
     * IBelmont
     * Desde 14/11/19
     * params llave de identificacion y folio del proyecto
     **/ 
    
    public String consulta(String key, String ns){
        
        try {
            String urlParameters  = "key="+key+"&noSerie="+ns;
            
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            String request        = rutaBD;
            URL    url            = new URL( request );
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            
            DataOutputStream wr = new DataOutputStream( conn.getOutputStream() );
            wr.write( postData );

            // Responses from the server (code and message)
            int serverResponseCode = conn.getResponseCode();

            if( serverResponseCode == 200 ){

                InputStream is;
                is = conn.getInputStream();

                char buff = 512;
                int len;
                byte[] data = new byte[ buff ];
                
                String respuesta="";

                do {

                    len = is.read( data );

                    if ( len > 0 ) {

                        respuesta = new String( data, 0, len );

                    }

                } while ( len > 0 );
                
                is.close();
                wr.close();
                conn.disconnect();
                
                return respuesta;

            }
            
            return null;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
     /**
     * Funcion que registra la información a base de datos de un proyecto analizado
     * IBelmont
     * Desde 14/11/19
     * params llave de identificacion, nombre de proyecto, tipo de proyecto, fecha del proyecto
     *  tiempo de analisis del proyecto, folio del proyecto, nombre de usuario, 
     *  grupo o cargo del usuario , link de los archivos del proyecto
     **/
    
    public String enviarRaegistro(String key, String nombreProyecto, String tipo,
            String fecha, String tiempoAnalisis, String noSerie, String alumno, String grupo, String linkProyecto ) {
        
        try{
            
            String k = key;
            String np = nombreProyecto;
            String t = tipo;
            String f = fecha;
            String ta = tiempoAnalisis;
            String ns = noSerie;
            String a = alumno;
            String g = grupo;
            String lk = linkProyecto;
            
            String[] urli = lk.split("_var_www_html_isc_SMIM_public_");
            lk = urli[1];

            t = tipo(t);
            
            Calendar fcha = Calendar.getInstance();
            f = fcha.get(Calendar.YEAR)+"-"+fcha.get(Calendar.MONTH)+"-"+fcha.get(Calendar.DAY_OF_MONTH);
            
            String urlParameters  = "key="+k+"&nombreProyecto="+np+"&tipo="+t+
                    "&fecha="+f+"&tiempoAnalisis="+ta+"&noSerie="+ns+"&alumno="+a+"&grupo="+g+"&linkProyecto="+lk;
            
            System.out.println(urlParameters);
            
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            String request        = rutaBD;
            URL    url            = new URL( request );
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );

            DataOutputStream wr = new DataOutputStream( conn.getOutputStream() );
            wr.write( postData );

            // Responses from the server (code and message)
            int serverResponseCode = conn.getResponseCode();

            if( serverResponseCode == 200 ){

                InputStream is;
                is = conn.getInputStream();

                char buff = 512;
                int len;
                byte[] data = new byte[ buff ];
                
                String respuesta="";

                do {

                    len = is.read( data );

                    if ( len > 0 ) {

                        respuesta = new String( data, 0, len );

                    }

                } while ( len > 0 );
                
                is.close();
                wr.close();
                conn.disconnect();
                
                return respuesta;

            }
            
            return null;
                 
            } catch (MalformedURLException ex) {
                
                Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
                
            } catch (ProtocolException ex) {
                
            Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
            
        } catch (IOException ex) {
            
            Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
            
        }
            
       return null;
    }

    /**
     * Funcion para autentificarse con el servidor para antes de subir el archivo
     * IBelmont
     * Desde 14/11/19
     * params llave de identificacion , folio del proyecto, tipo de proceso, formato de archivo
     *  y carpeta a la que va dirigida
     **/ 
    
    public String enviarCredencialesArchivo( String key, String folio, String tipoProceso,
            String formato, String carpeta ) {
        
        try{
            
            String k = key;
            String f = folio;
            String tp = tipoProceso;
            String fo = formato;
            String c = carpeta;
            
            String urlParameters  = "key="+k+"&folio="+f+"&tipoProceso="+tp+
                    "&formato="+fo+"&carpeta="+c;
            
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            String request        = rutaAcceso;
            URL    url            = new URL( request );
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );

            DataOutputStream wr = new DataOutputStream( conn.getOutputStream() );
            wr.write( postData );

            // Responses from the server (code and message)
            int serverResponseCode = conn.getResponseCode();

            if( serverResponseCode == 200 ){

                InputStream is;
                is = conn.getInputStream();

                char buff = 512;
                int len;
                byte[] data = new byte[ buff ];
                
                String respuesta="";

                do {

                    len = is.read( data );

                    if ( len > 0 ) {

                        respuesta = new String( data, 0, len );

                    }

                } while ( len > 0 );
                
                is.close();
                wr.close();
                conn.disconnect();
                
                return respuesta;

            }
            
            return null;
                 
            } catch (MalformedURLException ex) {
                
                Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
                
            } catch (ProtocolException ex) {
                
            Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
            
        } catch (IOException ex) {
            
            Logger.getLogger( EndPoint.class.getName() ).log( Level.SEVERE, null, ex );
            
        }
            
       return null;
    }
    
    
    /**
     * Funcion para subir un archivo al servidor
     * IBelmont
     * Desde 14/11/19
     * params ruta del archivo, carpeta destino dentro del servidor, tipo de archivo
     **/ 
    
    public String subirArchivo( String archivo, String carpetaDestino, int tipo ) {
        
        int serverResponseCode = 0;  
        String upLoadServerUri = rutaAccesoArchivo;

        String fileName = archivo;

        HttpURLConnection conn = null;
        DataOutputStream dos = null;  
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024; 
        File sourceFile = new File( archivo ); 
        
        boolean validarArchivo = pesoArchivo(sourceFile,tipo);
        
        if( validarArchivo == false ){
            
            return null;
            
        }
        
        try { 

            FileInputStream fileInputStream = new FileInputStream( sourceFile );
            URL url = new URL( upLoadServerUri );
            
            conn = ( HttpURLConnection ) url.openConnection(); 
            conn.setDoOutput(true); // Allow Outputs
            conn.setUseCaches(false); // Don't use a Cached Copy
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Connection", "Keep-Alive" );
            conn.setRequestProperty( "ENCTYPE", "multipart/form-data" );
            conn.setRequestProperty( "Content-Type", "multipart/form-data;boundary=" + boundary );
            conn.setRequestProperty( "fileToUpload", fileName );

            dos = new DataOutputStream( conn.getOutputStream() );

            dos.writeBytes( twoHyphens + boundary + lineEnd ); 
            dos.writeBytes( "Content-Disposition: form-data; name=fileToUpload;filename="
                                      + fileName + "|" + carpetaDestino + "" + lineEnd );

            dos.writeBytes( lineEnd );

            bytesAvailable = fileInputStream.available(); 

            bufferSize = Math.min( bytesAvailable, maxBufferSize );
            buffer = new byte[ bufferSize ];

            bytesRead = fileInputStream.read( buffer, 0, bufferSize );  

            while ( bytesRead > 0 ) {

              dos.write( buffer, 0, bufferSize );
              bytesAvailable = fileInputStream.available();
              bufferSize = Math.min( bytesAvailable, maxBufferSize );
              bytesRead = fileInputStream.read( buffer, 0, bufferSize );   

             }

            dos.writeBytes( lineEnd );
            dos.writeBytes( twoHyphens + boundary + twoHyphens + lineEnd );

            serverResponseCode = conn.getResponseCode();

            if( serverResponseCode == 200 ){

                InputStream is;
                is = conn.getInputStream();

                char buff = 512;
                int len;
                byte[] data = new byte[ buff ];
                
                String respuesta="";

                do {

                    len = is.read( data );

                    if (len > 0) {

                        respuesta = new String( data, 0, len );

                    }

                } while ( len > 0 );
                 
                is.close();
                fileInputStream.close();
                dos.flush();
                dos.close();
                conn.disconnect();
                
                return respuesta;
             
            }    
            
            return null;

       } catch (Exception ex) {
          
       }     
                     
        return null; 
        
    } 

    
    /**
     * Funcion que valida el peso del archivo txt img vid
     * IBelmont
     * Desde 17/11/19
     * params File para validar tamaño
     **/
    
    
    public boolean pesoArchivo(File file, int tipo){
        
        long tamBytes = file.length();
        double tamKBytes = (tamBytes / 1024.0);
        
        switch(tipo){
            
            case 1:{
                
                if( tamKBytes <= 6 ){ // 6kB = 200 imagenes procesadas
                    
                    return true;
                    
                }else{
                    
                    return false;
                    
                }
                
            }
            
            case 2:{
                
                double tamMBytes = (tamKBytes/1024.0);
                
                if( tamMBytes <= 4 ){ // 4Mb 
                    
                    return true;
                    
                }else{
                    
                    return false;
                    
                }
                
            }
            
            case 3:{
                
                double tamMBytes = (tamKBytes/1024.0);
                
                if( tamMBytes <= 32 ){ // 32 Mb
                    
                    return true;
                    
                }else{
                    
                    return false;
                    
                }
                
            }
            
            default : {
                
                return false;
                
            }
        }
        
    }
    
    /**
     * Funcion que descarga un archivo del servidor
     * IBelmont
     * Desde 17/11/19
     * params ruta a descargar, nombre paletaDescargada
     **/
    
    public String descargarArchivo( String rutaPaleta, String nombrePaleta) {
        
        try {
            
            String path =  ""+ nombrePaleta;
            File file = new File( path );
            
            URLConnection conn = new URL(rutaPaleta).openConnection();
            conn.connect();
            
            InputStream in = conn.getInputStream();
            OutputStream out = new FileOutputStream(file);
            
            int b = 0;
            
            while ( b != -1 ) {
                
              b = in.read();
              
              if ( b != -1 ){
                  
                out.write(b);
                
              }
              
            }
            
            out.close();
            in.close();
            
            return ""+path;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    /**
     * Funcion para el manejo de direcciones endpoint
     * IBelmont
     * Desde 25/11/19
     * params id de endpoint que se requiere
     **/ 
    
    public static String endPoint( int id ){
        
        String endPoint = null;
        
        switch(id){
            
            case 1:{
                
                endPoint = "http://148.204.142.251/isc/SMIM/SMIM/public/Gestion/credenciales/key.php";
                
                break;
                
            }
            case 2:{
                
                endPoint = "http://148.204.142.251/isc/SMIM/SMIM/public/Gestion/archivos/archivo.php";
                
                break;
                
            }
            case 3:{
                
                endPoint = "http://148.204.142.251/isc/SMIM/SMIM/public/Datos/consulta.php";
                
                break;
                
            }
            case 4:{
                
                endPoint = "http://148.204.142.251/isc/SMIM/SMIM/public/Datos/BaseDatos.php";
                
                break;
                
            }
            default:{
                
                endPoint = null;
                
                break;
                
            }
            
        }
        
        return endPoint;
        
    }
    
    /**
     * Funcion creacion de llave de identificacion con el servidor
     * IBelmont
     * Desde 25/11/19
     * params folio de identificacion
     **/ 
    
    public String key( String folio ){
        
        String f = "A"+folio+"I";
        
        return f;
        
    }
    
    public String tipo( String nombre ){
        
        switch( nombre ){
            case "Soldadura":{
                return "1";
            }
            case "Fundicion":{
                return "3";
            }
            case "Manufactura":{
                return "2";
            }
            default:{
                return "1";
            }
        }
        
    }
}
