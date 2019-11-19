/*
 */
package puntos;

import GUI_Video.PuntosVideo;
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
public class LabelPaintV extends JLabel{

    @Override
    public void paintComponent(Graphics g) {
        
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
    
}
