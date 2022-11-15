/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class HiloRojo extends Thread{
    
    MiCanvas c = new MiCanvas();

    int i = (int)(Math.random() * 5 + 1);
    
    public HiloRojo(MiCanvas c) {
        
        this.c = c;
        
    }
    
    public void run(){
        while(true){
            c.moverDer();
            try {
                sleep(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloAzul.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
