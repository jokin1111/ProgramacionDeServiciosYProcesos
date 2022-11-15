/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamonitorespila;

/**
 *
 * @author joaquin.antequera
 */
public class PracticaMonitoresPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila pa = new Pila();
        Consumidor c = new Consumidor(pa);
        Productor p = new Productor(pa);
        Productor p2 = new Productor(pa);
        
        c.start();
        p.start();
        p2.start();
        
    }
    
}
