/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.cmdReproducir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author izacc
 */
public class cmd {
    
//    private String cmd = "ffmpeg -i flir.mp4 -preset superfast -s 540x720 -ab 98k f.mp4";
    
    public static String cmd(){
        
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[]{"cmd.exe","/c","start","c"});
            System.out.println("Pause 1");
            Thread.sleep(10*1000);
            System.out.println("Pasa Pause 1");
            
            return "f.mp4";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "f.mp4";
    }
    
}
