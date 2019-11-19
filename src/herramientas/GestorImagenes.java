/*
 */
package herramientas;

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
    
    public static ArrayList<String> rutas;
    public static String rutaProyecto;
    
    public static boolean abrirImagenes(){
        int i=0;
        File[] listaImagenes;
        //Filtro de lectura
        FileNameExtensionFilter filtroLectura 
                = new FileNameExtensionFilter("Imagenes o Directorio","jpg","jpeg","png");
        //Selector de archivos
        JFileChooser selectorArchivos;
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
    
    public static void crearCarpetas(List<BufferedImage> listaIm, 
            String nProceso,String nombreAlumno, String grupo, String nombreProceso){
        
        int num = 0;
        File rutaCarpeta;
        File rutaNueva;
        String rutaUsuario;
        
        Calendar fecha = Calendar.getInstance();
        String fechaDia = fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
        rutaUsuario = System.getProperty("user.home");
        String rutaArchivo = rutaUsuario+"\\Documents\\SMIM\\"+ 
                nProceso+"\\"+fechaDia+"_"+
                nombreProceso+"_"+nombreAlumno+"_"+
                grupo+"\\Imagenes";
        
        rutaNueva = new File(rutaArchivo);
        
        rutaProyecto = rutaArchivo;
        
        if(!rutaNueva.exists()){
            rutaNueva.mkdirs();
        }else if(rutaNueva.exists()){
            
            boolean existe = true;
            String aux = rutaArchivo;
            while(existe){
                num++;
                aux = rutaArchivo+"_"+num;
                existe = validarexiste(aux, rutaNueva);
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

    private static boolean validarexiste(String rutaArchivo, File rutaNueva) {
        rutaNueva = new File(rutaArchivo);
         if(!rutaNueva.exists()){
             rutaNueva = new File(rutaArchivo);
             rutaNueva.mkdirs();
             return false;
         }
        return true;
    }
}
