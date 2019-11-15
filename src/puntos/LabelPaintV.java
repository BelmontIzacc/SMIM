/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntos;

import GUI_Generales.Instrucciones;
import GUI_Video.PuntosVideo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author rebel
 */
public class LabelPaintV extends JLabel{

    @Override
    public void paintComponent(Graphics g) {
        //Luego, construye un hilo de ese objeto.
//        Thread nuevoh=new Thread(this);
//        if(nuevoh.isAlive()){
//            
//        }else{
//            //Finalmente, comienza la ejecución del hilo.
//             nuevoh.start();
//        }
        
        if(PuntosVideo.im != null){
            Dimension dim = this.getSize();
            ImageIcon im = new ImageIcon(PuntosVideo.im.getScaledInstance(270,
                                270,Image.SCALE_DEFAULT));
            g.drawImage(im.getImage(), 0, 0, (int)dim.getWidth(),(int)dim.getHeight(),null);
        }     
        
        ArrayList<Nodo> vectorNodo = PuntosVideo.vectorNodo;
        
        for(Nodo nodos : vectorNodo){
            nodos.pintar(g);
        }
        
        super.paintComponents(g);
    }

//    @Override
//    public void run() {
//        while(true){
//            if(Instrucciones.ac==true){
//                Point p = GUI_Video.PuntosVideo.Pp.getMousePosition();
//                if(p!= null){
//                    double x1 = p.getX();
//                    double y1 = p.getY();
//                    
//                    GUI_Video.PuntosVideo.coordenadaX.setText(x1+"");
//                    GUI_Video.PuntosVideo.coordenadaY.setText(y1+"");
//                }
//            }
//        }
//    }
    
}
