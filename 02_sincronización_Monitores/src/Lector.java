/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Lector extends Thread{
    
    Monitor monitor;

    public Lector(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Número leido " + monitor.leer());
        }
    }
    
}
