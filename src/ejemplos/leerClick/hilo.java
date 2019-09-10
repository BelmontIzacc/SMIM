/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.leerClick;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;

/**
 *
 * @author izacc
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
            
            Point p = GUI.jLabel1.getMousePosition();
            if(p!= null){
                double x1 = p.getX();
                double y1 = p.getY();
                
                GUI.cord2.setText("X: "+x1+", Y: "+y1);
            }
            //GUI.cord.setText("X: "+x+", Y: "+y);
        }
    }
  
}
