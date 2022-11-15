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
public class Cocineros extends Thread{
    Pizza pizza;
    int i; 
    public Cocineros(Pizza pizza){
        this.pizza = pizza;
    }
    
    public void run(){
        for (;;) {  
            pizza.cocinar(i);
            System.out.println("Se ha cocinado una pizza ");
            try {
                sleep(100);
                        } catch (InterruptedException ex) {
                Logger.getLogger(Cocineros.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }  
    }
}
