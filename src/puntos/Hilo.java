/*
 */
package puntos;

import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author rebel
 */
public class Hilo extends Thread{
    
    public JLabel Pp;
    public JLabel coordenadaX;
    public JLabel coordenadaY;

    public Hilo(JLabel Pp, JLabel coordenadaX, JLabel coordenadaY) {
        this.Pp = Pp;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    @Override
    public void run() {
        while(true){
//            Point punto=MouseInfo.getPointerInfo().getLocation();
//            double x = punto.x;
//            double y = punto.y;

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
