/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 *
 * @author izacc
 * Esta clase es para obtener los frames de un video.
 * En propiedades del video, puedes ver cuantos frames por segundo son.
 * por ejemplo podemos tomar 30 fps = 30 frames por segundo,
 * Lo que nos da :
 * 30 fps = 30 frames = 1s de video
 * no todos los videos son de 30 fps varia segun la calidad y camara con la que se produjo el video.
 * 
 * Las librerias necesarias para realizar todo esto estaran en el drive junto con el video que utilize
 * para probar todo esto
 */
public class read{
    public static void main(String []args) throws IOException, Exception
    {
        // ruta donde se selecciona el video para tomar los frames
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber("C:\\Users\\izacc\\Downloads\\prueba\\5.mp4");
        // se inicia preparativos para obtener frames
        frameGrabber.start();
        // objeto de tipo frame
        Frame i;
        //objeto del cual convertira el frame del video en imagen
        OpenCVFrameConverter.ToIplImage converterToIplImage = new OpenCVFrameConverter.ToIplImage();
        int j = 30;
        //este for esta preparado para sacar 10 frames por segundo de un video de 30 fps
        for(int x = 0 ; x<10; x++){
            try {
                // seleccionas que frame vas a querer, en este caso el frame de 1s en el video, que es el 
                // numero 30.
                frameGrabber.setFrameNumber(j);//puede ser cualquier frame
                // se obtiene la imagen
                Frame frame = frameGrabber.grabImage();
                //muestras informacion de la imagen obtenida
                System.out.println(frame);
                // se inicia la conversion de frame a imagen
                IplImage image = converterToIplImage.convert(frame);
                // se crea un buffered con el frame obtenido
                BufferedImage bi = IplImageToBufferedImage(image);
                // se guarda el frame en un directorio espesifico con el nombre deseado junto con un formato
                File outputfile = new File("C:\\Users\\izacc\\Downloads\\prueba\\image"+x+".jpg");
                // se establece y valida el formato de salida
                ImageIO.write(bi, "jpg", outputfile);
                // aumenta en 30 los frames para calcular el siguiente segundo 
                j = j+30;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        frameGrabber.stop();
    }
  
    public static BufferedImage IplImageToBufferedImage(IplImage src) {
        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
        Frame frame = grabberConverter.convert(src);
        return paintConverter.getBufferedImage(frame,1);
    }  
  
}
