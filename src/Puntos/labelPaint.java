/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;

import GUI_Imagenes.CorreccionPuntosI;
import static GUI_Imagenes.CorreccionPuntosI.ventana;
import GUI_Imagenes.Imagenes;
import static GUI_Imagenes.Imagenes.Pp;
import GUI_Generales.Instrucciones;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author rebel
 */
public class labelPaint extends JLabel implements Runnable{
    
    @Override
    public void paintComponent(Graphics g){
        
        //Luego, construye un hilo de ese objeto.
        Thread nuevoh=new Thread(this);
        if(nuevoh.isAlive()){
            
        }else{
            //Finalmente, comienza la ejecución del hilo.
             nuevoh.start();
        }
        
        if(Imagenes.btn != null){
            Dimension dim = this.getSize();
            ImageIcon im = new ImageIcon(Imagenes.btn.getScaledInstance(Pp.getWidth(),
                                Pp.getHeight(),Image.SCALE_DEFAULT));
            //this.setIcon(im);
            g.drawImage(im.getImage(), 0, 0, (int)dim.getWidth(),(int)dim.getHeight(),null);
        }     
        
        Vector<nodo> vectorNodo = Imagenes.vN;
        
        for(nodo nodos : vectorNodo){
            nodos.pintar(g);
        }
        
        super.paintComponents(g);
    }

    @Override
    public void run() {
        while(true){
            if(Imagenes.bandera==true && Instrucciones.ac==true && Imagenes.retorno==false){
                Point p = GUI_Imagenes.Imagenes.Pp.getMousePosition();
                if(p!= null){
                    double x1 = p.getX();
                    double y1 = p.getY();
                    
                    GUI_Imagenes.Imagenes.coordenadaX.setText(x1+"");
                    GUI_Imagenes.Imagenes.coordenadaY.setText(y1+"");
                }
            }
        }
    }
    
}
