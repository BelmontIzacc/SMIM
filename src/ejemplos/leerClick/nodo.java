/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.leerClick;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author izacc
 */
public class nodo {
    private int x,y;
    public static final int d = 20;
    public static Image Original;
    
    public nodo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void pintar(Graphics g){
        g.drawOval(this.x+(d/3), this.y+d+(d/3), d, d);
        //g.drawOval(this.x - d/2, this.y - d/2, d, d);
        //g.setColor (Color.red);
        //g.fillOval(this.x, this.y , d, d);
    }
    
    public void borrar(Graphics g){
        //g.clearRect(this.x - d/2, this.y - d/2, d+1, d+1);
        //g.clearRect(this.x+(d/3), this.y+d+(d/3), d+1, d+1);
        //g.clearRect(this.x, this.y+d, d+1, d+1);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage){
          return (BufferedImage)imagen;
        }
        BufferedImage bi = 
        new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
    
}
