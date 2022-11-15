
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Factorial extends Thread{ 
     long x = 1, y = 1;
    String texto1 = "Factorial: "+String.valueOf(x);
    public void run(){
        System.out.println(texto1);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Factorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            x += 1;
            for (long i=x; i>1 ;i--) {
                y=y*i;
            }
            String texto = "Factorial: "+String.valueOf(y);
            System.out.println(texto);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Factorial.class.getName()).log(Level.SEVERE, null, ex);
            }
            y=1;
        }
    }
}
