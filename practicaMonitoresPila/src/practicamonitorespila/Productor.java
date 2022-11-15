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
public class Productor extends Thread{
    Pila p = new Pila();
    
    public Productor(Pila p){
        this.p = p;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++){
            int y = 10;
            int x = (int)(Math.random()*y+1);
            y+=10;
            System.out.println("Se quiere insertar un " + x);
            p.push(x);
        }
    }
}
