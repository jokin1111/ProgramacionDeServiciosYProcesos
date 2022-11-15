/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class Repartidores extends Thread{
    Pizza pizza;
    
    public Repartidores(Pizza pizza){
        this.pizza = pizza;
    }
    
    public void run(){
        for (;;) {
            System.out.println("Pizza repartida " + pizza.repartir());
            try {
                sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Repartidores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
