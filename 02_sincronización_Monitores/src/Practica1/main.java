/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

/**
 *
 * @author joaquin.antequera
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monitor m = new Monitor();
        Productor p1 = new Productor(m);
        Productor p2 = new Productor(m);
        Productor p3 = new Productor(m);
        Consumidor c1 = new Consumidor(m);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
    }
    
}
