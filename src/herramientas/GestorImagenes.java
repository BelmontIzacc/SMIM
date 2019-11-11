/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import GUI_Imagenes.Imagenes;
import static GUI_Generales.Prueba.Procesos;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rebel
 */
public class GestorImagenes {
    public static FileNameExtensionFilter filtroLectura;
    public static JFileChooser selectorArchivos;
    public static File[] listaImagenes;
    public static ArrayList<String> rutas;
    public static String rutaUsuario;
    public static File rutaNueva,rutaCarpeta;
    
    public static boolean abrirImagenes(){
        int i=0;
        //Filtro de lectura
        filtroLectura = new FileNameExtensionFilter("Imagenes o Directorio","jpg","jpeg","png");
        //Selector de archivos
        selectorArchivos = new JFileChooser();
        //Se le agrega el filtro al selector de archivos
        selectorArchivos.setAcceptAllFileFilterUsed(false);
        selectorArchivos.setFileFilter(filtroLectura);
        //Se specifica que se puede seleccionar y tambien que puedan ser varios
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        selectorArchivos.setMultiSelectionEnabled(true);
        //ejecutar selector de imagenes        
        if(selectorArchivos.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
//*********************************************************************************
            //Si lo que seleccionaron es un directorio
            if(selectorArchivos.getSelectedFile().isDirectory()){
                listaImagenes = selectorArchivos.getSelectedFile().listFiles();                
                System.out.println("Selecciono un directorio");
                                
                //cambiar de un arreglo simple a un lista
                rutas = new ArrayList<>();
                
                //Este for es para verificar que lo que existe en la carpeta sean solo imagenes
                for(i=0;i < listaImagenes.length; i++){
                    String pat = listaImagenes[i].getPath();
                    String ref = pat.substring(pat.lastIndexOf(".")+1,pat.length());
                    System.out.println(ref);
                    if(ref.equals("jpg") || ref.equals("jpeg") || ref.equals("png")){
                        System.out.println("Archivo "+listaImagenes[i]+" --- Nombre: "+listaImagenes[i].getName());
                        System.out.println("---------------------------------------------------------------------");
                        rutas.add(pat);
                    }else{
                        System.out.println("Se remueve de la lista"+listaImagenes[i].getName()+"\n");
                    }
                }
//*********************************************************************************
            }else if(selectorArchivos.getSelectedFile().isFile()){
                listaImagenes = selectorArchivos.getSelectedFiles();
                System.out.println("Se selecciono una imagen");
                
                rutas = new ArrayList<>();
                
                for(i=0;i < listaImagenes.length; i++){
                    String pat = listaImagenes[i].getPath();
                    rutas.add(pat);
                    System.out.println("Imagen "+listaImagenes[i]+" ---- Nombre: "+ listaImagenes[i].getName());
                }
            }
            return true;
        } else{
            GUI_Generales.Prueba.archivos.setEnabled(true);
            GUI_Generales.Prueba.creditos.setEnabled(true);
            return false;
        }
    }
    
    public static BufferedImage muestra(int x, int y, int tam, int tam1, BufferedImage bi){
        
        BufferedImage imagenCopia = new BufferedImage(tam1, tam, BufferedImage.TYPE_INT_RGB);
        int c=0;
        int v=0;
        int finy;
        int finx;
        finy = y+tam1;
        finx = x+tam;
        
        for(int j = y; j < finy; j++){
            
            for(int i = x; i < finx; i++){
                
                imagenCopia.setRGB(c, v, bi.getRGB(j, i));
                v++;      
                
            }
            
            c++;
            v=0;
            
        }
        
        return imagenCopia;
        
    }
    
    public static Image toImage(BufferedImage bi){
        
        return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        
    }
    
    public static BufferedImage toBufferedImage(Image imagen){
        
        if(imagen instanceof BufferedImage){
            
          return(BufferedImage)imagen;
        
        }
        
        BufferedImage bi = new BufferedImage(imagen.getWidth(null), 
                imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0, null);
        nueva.dispose();
        return bi;
        
    }
    
    public static void crearCarpetas(List<BufferedImage> listaIm){
        int num = 0;
        Calendar fecha = Calendar.getInstance();
        String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
        rutaUsuario = System.getProperty("user.home");
        String rutaArchivo = rutaUsuario+"\\Documents\\SMIM\\"+ 
                Procesos.get(Imagenes.nomProceso.getSelectedIndex()-1)+"\\"+fechaDia+"_"+
                Imagenes.nombreProceso.getText()+"_"+Imagenes.nombre.getText()+"_"+
                Imagenes.grupo.getText();
        
        rutaNueva = new File(rutaArchivo);
        
        if(!rutaNueva.exists()){
            rutaNueva.mkdirs();
        }else if(rutaNueva.exists()){
            
            boolean existe = true;
            String aux = rutaArchivo;
            while(existe){
                num++;
                aux = rutaArchivo+"_"+num;
                existe = validarexiste(aux);
            }
        }
        
        for(int x=0; x<rutas.size(); x++){
            rutaCarpeta = new File(rutaNueva.getAbsolutePath() + "\\"+(x+1)+".png");
            try {
                ImageIO.write(listaIm.get(x),"png", rutaCarpeta);
            } catch (IOException ex) {
                Logger.getLogger(GestorImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static boolean validarexiste(String rutaArchivo) {
        rutaNueva = new File(rutaArchivo);
         if(!rutaNueva.exists()){
             rutaNueva = new File(rutaArchivo);
             rutaNueva.mkdirs();
             return false;
         }
        return true;
    }
}
