/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

            }else{
                
                JOptionPane.showMessageDialog(null, "Error inesperado\nPorfavor Intente de nuevo.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                
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
            
            String urlParameters  = "key="+k+"&nombreProyecto="+np+"&tipo="+t+
                    "&fecha="+f+"&tiempoAnalisis="+ta+"&noSerie="+ns+"&alumno="+a+"&grupo="+g+"&linkProyecto="+lk;
            
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
     * params ruta del archivo, carpeta destino dentro del servidor
     **/ 
    
    public String subirArchivo( String archivo, String carpetaDestino ) {
        
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
     
}
