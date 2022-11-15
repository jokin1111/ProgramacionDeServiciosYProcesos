/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class Pizza {
    
    LinkedList linked = new LinkedList();
    
    int max = (int)(Math.random()*(15-10+1)+10);
    synchronized void cocinar(int i){
        while(this.linked.size() >= max){
            try {
                System.out.println("bandeja llena");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.linked.add(i);
        notifyAll();
    }
    
    synchronized int repartir(){
        while(linked.isEmpty()){
            try {
                System.out.println("La bandeja está vacia");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int n;
        n = (int) linked.getFirst(); 
        linked.removeFirst();
        notifyAll();
        return n;
    }
 }
    

