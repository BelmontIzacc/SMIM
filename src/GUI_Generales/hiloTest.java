/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import GUI_Video.Video;
/**
 *
 * @author rebel
 */
public class hiloTest extends Thread {

    public static boolean active;
    public int cargando;
    public Cargando c;
    
    public hiloTest(Cargando cargando) { 
        
        this.cargando = 1;
        this.c = cargando;
        
    }

    @Override
    public void run() {
       
        if(cargando == 1){
           
             System.out.println("-------Cargando-----");
            GUI_Generales.Prueba.cargando.setVisible(true);
            cargando  = 0;
        }
        
        while(active){
            Video.ruta = Video.cmd();
             active =  false;
             GUI_Generales.Prueba.cargando.setVisible(false);
        }
        
        System.out.println("salio del hilo");
        this.c.mostrarVideo();    
       
    }
}
