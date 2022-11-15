/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class Monitor {

    LinkedList ll = new LinkedList();
    
    synchronized void producir(int valor){
        while(ll.size() > 0 && (int)ll.getLast() == valor){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //this.valor = valor;
        ll.addLast(valor);
        notifyAll();
    }
    
    synchronized int Consumir(){
        while(ll.isEmpty()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int n;
        n = (int) ll.getFirst(); 
        ll.removeFirst();
        return n;
    }
    
}
