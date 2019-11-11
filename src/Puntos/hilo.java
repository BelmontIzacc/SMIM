/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;

import java.awt.Point;

/**
 *
 * @author rebel
 */
public class hilo extends Thread{
    public hilo(){
        
    }

    @Override
    public void run() {
        while(true){
//            Point punto=MouseInfo.getPointerInfo().getLocation();
//            double x = punto.x;
//            double y = punto.y;
            
            Point p = GUI_Imagenes.Imagenes.Pp.getMousePosition();
            if(p!= null){
                double x1 = p.getX();
                double y1 = p.getY();
                
                GUI_Imagenes.Imagenes.coordenadaX.setText("   X: "+x1+", Y: "+y1);
            }
            //GUI.cord.setText("X: "+x+", Y: "+y);
        }
    }
}
