/*
 */
package puntos;

import GUI_Imagenes.Imagenes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author rebel
 */
public class LabelPaint extends JLabel{
    
    @Override
    public void paintComponent(Graphics g){
        
//        //Luego, construye un hilo de ese objeto.
//        Thread nuevoh=new Thread(this);
//        if(nuevoh.isAlive()){
//            
//        }else{
//            //Finalmente, comienza la ejecución del hilo.
//             nuevoh.start();
//        }
        
        if(Imagenes.btn != null){
            Dimension dim = this.getSize();
//            ImageIcon im = new ImageIcon(Imagenes.btn.getScaledInstance(Pp.getWidth(),
//                                Pp.getHeight(),Image.SCALE_DEFAULT));
            ImageIcon im = new ImageIcon(Imagenes.btn.getScaledInstance(294,
                                249,Image.SCALE_DEFAULT));
            //this.setIcon(im);
            g.drawImage(im.getImage(), 0, 0, (int)dim.getWidth(),(int)dim.getHeight(),null);
        }     
        
        ArrayList<Nodo> vectorNodo = Imagenes.vectorNodo;
        
        for(Nodo nodos : vectorNodo){
            nodos.pintar(g);
        }
    

        super.paintComponents(g);
    }
    
}
