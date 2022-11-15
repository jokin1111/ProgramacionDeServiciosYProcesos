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
public class Consumidor extends Thread{
    
    Pila p = new Pila();
    
    public Consumidor(Pila p){
        this.p = p;
    }
    
    public void run(){
        for (int i = 0; i < 20; i++){
            System.out.println("Se ha eliminado el valor" + p.pop());
        }
    }
}
