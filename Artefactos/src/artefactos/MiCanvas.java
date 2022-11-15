/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class MiCanvas extends Canvas{

    
    int xAzul = 0;
    int xRojo = 360;
    int z = 0;
    
    MiCanvas() {
        
        setBounds(0, 0, 400, 400);
        setBackground(Color.BLACK);
        
    }
    
    public void paint(Graphics g){
        
        g.setColor(Color.GREEN);
        
        g.fillRect(190, 0, 50, 400);
        
        g.setColor(Color.blue);
        
        g.fillOval(xAzul, 100, 40, 40);
        
        g.setColor(Color.red);
        
        g.fillOval(xRojo, 200, 40, 40);
        
        
    }
    
    synchronized void moverIzq(){
        while(xRojo >= 150 && xRojo <= 240 && xAzul > 140 && xAzul < 150)
                try {
                    wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MiCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (xAzul > 400){
            xAzul = 0;
        }
        else
            xAzul++;
            
        notifyAll();
        repaint();
    }
    
    synchronized void moverDer(){
         while(xAzul >= 150 && xAzul <= 240 && xRojo > 240 && xRojo < 250)
                try {
                    wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MiCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (xRojo < -40){
            xRojo = 400;
        }
        else
            xRojo--;
           
        notifyAll();
        repaint();
    }
    
}
