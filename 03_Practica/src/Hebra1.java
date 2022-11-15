
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Hebra1 extends Thread{
    JProgressBar barra;
    JLabel etiqueta;
    String str = new String();
    int x, y= 0;
    public Hebra1(JProgressBar barra, JLabel etiqueta, String str) {
        this.barra = barra;
        this.etiqueta = etiqueta;
    }
    
    public void run(){
        while (x < 100){
            y = (int)(Math.random()*14 + 1);
            x += y;
            barra.setValue(x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hebra1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (str.equals("Inicio")){
            String str = new String("Fin");
            this.etiqueta.setText(this.etiqueta.getText());
        }
            
            
    }
    
}
