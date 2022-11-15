/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.capitulo1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author joaquin.antequera
 */
public class Hilo extends Thread{
    
    JLabel etiqueta;

    public Hilo(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public void run(){
        for (int i = 1; i < 101; i=(i+1)%101) {
            this.etiqueta.setText(String.valueOf(i));
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
