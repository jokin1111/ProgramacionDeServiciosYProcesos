/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamonitorespila;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class Pila {
    
    private Nodo raiz;
    
    public Pila () {
        raiz = null;
    }
    class Nodo {
        int info;
        Nodo sig;
    }
    synchronized void push(int x) {
        while(x<siguienteEnPila()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        System.out.println("Apilado "+x);
        nuevo.sig = raiz;
        raiz = nuevo;
    }
    synchronized int pop() {
        while (pilaVacia()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int informacion = raiz.info;
        raiz = raiz.sig;
        return informacion;
    }

    public void imprimir() {
        Nodo reco=raiz;
        System.out.println("Listado de todos los elementos de la pila");
        while (reco!=null) {
            System.out.print(reco.info+"-");
            reco=reco.sig;
        }
        System.out.println();
    }
    
    public boolean pilaVacia(){
        if (raiz==null) {
            return true;
        } else {
    	    return false; 
        }
    }
    
    public int pilaCount(){
        int cant=0;
        Nodo reco=raiz;
        while (reco!=null) {
            cant++;
            reco=reco.sig;
        }
        return cant;
    }
    
    public int siguienteEnPila(){
        while (pilaVacia()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        int informacion = raiz.info;
        return informacion;          
    }
}