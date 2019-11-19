/*
 */
package puntos;

import GUI_Imagenes.CorreccionPuntosI;
import static GUI_Generales.Editar.colorS;
import static GUI_Generales.Editar.grosorS;
import static GUI_Generales.Editar.tamanioS;
import GUI_Imagenes.Imagenes;
import GUI_Video.CorreccionPuntosV;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author rebel
 */
public class Nodo {
    private int x,y;
    public int d = 20,ventana;
    public Image Original;
    public Graphics2D g2;
    
    public Nodo(int x, int y,int v) {
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
            switch (Imagenes.forma) {
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
            switch(CorreccionPuntosI.forma){
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
            switch(GUI_Video.PuntosVideo.forma){
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
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
