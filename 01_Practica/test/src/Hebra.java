
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Hebra extends Thread{
    
    int array[];
    
    JPanel panel;
    
    Hebra(int array[], JPanel panel) {
        this.array = array;
        this.panel = panel;
    }
    
    public void burbuja(int[] array, JPanel panel) {
        int i, j, aux;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                    ((JButton)(this.panel.getComponent(j))).setText(String.valueOf(array[j]));
                    ((JButton)(this.panel.getComponent(j + 1))).setText(String.valueOf(array[j + 1]));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hebra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ((JButton)(this.panel.getComponent(array.length - i - 1))).setBackground(Color.RED);
        }
        ((JButton)(this.panel.getComponent(0))).setBackground(Color.RED);
    }
    
    public void run() {
        burbuja(array, panel);
    }
}


