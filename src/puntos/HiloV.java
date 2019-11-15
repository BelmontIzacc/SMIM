/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntos;

import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author rebel
 */
public class HiloV extends Thread{
    
    public JLabel Pp;
    public JLabel coordenadaX;
    public JLabel coordenadaY;

    public HiloV(JLabel Pp) {
        this.Pp = Pp;
    }

    public HiloV(JLabel Pp, JLabel coordenadaX, JLabel coordenadaY) {
        this.Pp = Pp;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    @Override
    public void run() {
        while(true){

            Point p = Pp.getMousePosition();
            if(p!= null){
                double x1 = p.getX();
                double y1 = p.getY();
                
                coordenadaX.setText(x1+"");
                coordenadaY.setText(y1+"");
            }

        }
    }
}
