
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Fibonacci extends Thread{
    public void run(){
       int serie = 10, num1 = 0, num2 = 1, suma = 1;
        System.out.println("Fibonacci: " + num1);      
        for (;;) {
            System.out.println("Fibonacci: " + suma);
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Factorial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
