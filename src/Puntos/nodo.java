/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puntos;

import GUI_Imagenes.CorreccionPuntosI;
import static GUI_Generales.Editar.colorS;
import static GUI_Generales.Editar.grosorS;
import static GUI_Generales.Editar.tamanioS;
import GUI_Imagenes.Imagenes;
import GUI_Video.CorreccionPuntosV;
import GUI_Video.PuntosVideo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author rebel
 */
public class nodo {
    private int x,y;
    public static int d = 20,ventana;
    public static Image Original;
    public static Graphics2D g2;
    
    public nodo(int x, int y,int v) {
        this.x = x;
        this.y = y;
        ventana = v;
    }
    
    public void pintar(Graphics g){
        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(grosorS));
        d = tamanioS;
        g2.setColor(colorS);
        if(ventana == 1){
            switch (Imagenes.formas.getSelectedIndex()) {
                case 1:
                    g2.drawOval(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                case 2:
                    g2.drawPolygon(new int[] {this.x-(d/2), this.x, this.x+(d/2), this.x}, new int[] {this.y, this.y-(d/2), this.y, this.y+(d/2)}, 4);
                    break;
                case 3:
                    g2.drawRect(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                default:
                    break;
            }
        }else if(ventana == 2){
            switch(CorreccionPuntosI.formas.getSelectedIndex()){
                case 1:
                    g2.drawOval(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                case 2:
                    g2.drawPolygon(new int[] {this.x-(d/2), this.x, this.x+(d/2), this.x}, new int[] {this.y, this.y-(d/2), this.y, this.y+(d/2)}, 4);
                    break;
                case 3:
                    g2.drawRect(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                default:
                    break;
            }
        }else if(ventana ==3){
            switch(PuntosVideo.formas.getSelectedIndex()){
                case 1:
                    g2.drawOval(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                case 2:
                    g2.drawPolygon(new int[] {this.x-(d/2), this.x, this.x+(d/2), this.x}, new int[] {this.y, this.y-(d/2), this.y, this.y+(d/2)}, 4);
                    break;
                case 3:
                    g2.drawRect(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                default:
                    break;
            }
        }else if(ventana ==4){
            switch(CorreccionPuntosV.formas.getSelectedIndex()){
                case 1:
                    g2.drawOval(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                case 2:
                    g2.drawPolygon(new int[] {this.x-(d/2), this.x, this.x+(d/2), this.x}, new int[] {this.y, this.y-(d/2), this.y, this.y+(d/2)}, 4);
                    break;
                case 3:
                    g2.drawRect(this.x-(d/2), this.y-(d/2), d, d);
                    break;
                default:
                    break;
            }
        }
        
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
}
