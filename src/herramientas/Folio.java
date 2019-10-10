/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izacc
 */
public class Folio {
    public static String generarFolio(String nombreProyecto){
        try {
            long epoch = System.currentTimeMillis()/1000;
            String exEpoch = Integer.toHexString((int)epoch);
            //ip
            String aip = InetAddress.getLocalHost().getHostAddress();
            String remplazado=aip.replace(".", "");
            int ip = Integer.parseInt(remplazado);
            String exIP = Integer.toHexString((int)ip);
            //ultimas palabras nombre
            String np = ""+nombreProyecto.charAt(nombreProyecto.length()-2);
            np += ""+nombreProyecto.charAt(nombreProyecto.length()-1);
            char a = np.charAt(0);
            String uno = ""+(int)a;
            char b = np.charAt(1);
            String dos = ""+(int)b;
            int nom = Integer.parseInt(uno+""+dos);
            String exNombre = Integer.toHexString(nom);
            //aleatorio
            String p = aleatorio(0,22);
            String s = aleatorio(1,24);
            String ultimo = aleatorio(10,24);
            //String ia = ""+7365;
            int isa = siglas(0);
            int ale = siglas(1);
            
            String aleatorio = p+""+s+""+isa+""+ale+""+ultimo;
            int aux = Integer.parseInt(aleatorio);
            String exAleatorio = Integer.toHexString(aux);
            
            String folio = exEpoch+""+exAleatorio+
                    ""+exNombre+""+exIP;
            
            return folio;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Folio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static int siglas(int opc){
        String[] ale = {"A","L","E","J","A","N","D","R","A","B","E","L","T","R","A","N"};
        String[] isa = {"I","Z","A","C","C","B","E","L","M","O","N","T"};
        
        int nom;
        
        if(opc == 1){ //almeja
           int pos = ThreadLocalRandom.current().nextInt(0, ale.length-1);
           String res = ale[pos];
           char a = res.charAt(0);
           nom = (int)a;
        }else{ //no almeja
           int pos = ThreadLocalRandom.current().nextInt(0, isa.length-1);
           String res = isa[pos];
           char i = res.charAt(0);
           nom = (int)i;
        }
        
        return nom;
    }
    
    private static String aleatorio(int a , int b){
        int uno = ThreadLocalRandom.current().nextInt(a, b);
        return ""+uno;
    }
}
