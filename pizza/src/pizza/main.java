/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

/**
 *
 * @author joaquin.antequera
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pizza p = new Pizza();
        
        Repartidores r1 = new Repartidores(p);
        Repartidores r2 = new Repartidores(p);
        Repartidores r3 = new Repartidores(p);
        Repartidores r4 = new Repartidores(p);
        //Repartidores r5 = new Repartidores(p);
        
        Cocineros c1 = new Cocineros(p);
        Cocineros c2 = new Cocineros(p);
        Cocineros c3 = new Cocineros(p);
        Cocineros c4 = new Cocineros(p);
        Cocineros c5 = new Cocineros(p);
        
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        //r5.start();
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
    
}
