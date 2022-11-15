/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author joaquin.antequera
 */
public class Productor extends Thread{
    
    Monitor monitor;
    
    public Productor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){  
        for (;;) {
            int i = (int)(Math.random()*10 + 1);
            monitor.producir(i);
            System.out.println("Se ha escrito un " + i);
            try {
                sleep(100);
                        } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
}
