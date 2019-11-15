/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntos;

import GUI_Imagenes.Imagenes;
import GUI_Generales.Instrucciones;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
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
    
//    @Override
//    public void run() {
//        while(true){
//            if(Imagenes.bandera==true && Instrucciones.ac==true && Imagenes.retorno==false){
//                //Point p = GUI_Imagenes.Imagenes.Pp.getMousePosition();
//                Point p = MouseInfo.getPointerInfo().getLocation();
//                if(p!= null){
//                    double x1 = p.getX();
//                    double y1 = p.getY();
//                    
//                    GUI_Imagenes.Imagenes.coordenadaX.setText(x1+"");
//                    GUI_Imagenes.Imagenes.coordenadaY.setText(y1+"");
//                }
//            }
//        }
//    }
    
}
