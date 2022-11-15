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
public class Consumidor extends Thread{
    
    Monitor monitor;

    public Consumidor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){
        for (;;) {
            System.out.println("Número leido " + monitor.Consumir());
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
}
