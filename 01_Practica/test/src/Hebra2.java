
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
public class Hebra2 extends Thread{
    
    int array[];
    
    JPanel panel;
    
    public Hebra2(int array[], JPanel panel) {
        this.array = array;
        this.panel = panel;
    }
    
    public void seleccion(int[] array,  JPanel panel){
          int i, j, menor = 0, pos, tmp;
          for (i = 0; i < array.length - 1; i++){
                menor = array[i];                       
                pos = i;                            
                for (j = i + 1; j < array.length; j++){ 
                      if (array[j] < menor) {           
                          menor = array[j];             
                          pos = j;
                          ((JButton)(this.panel.getComponent(j))).setText(String.valueOf(array[j]));
                      }
                }
                if (pos != i){                                           
                    tmp = array[i];
                    array[i] = array[pos];
                     ((JButton)(this.panel.getComponent(i))).setText(String.valueOf(array[pos]));  
                    array[pos] = tmp;
                     ((JButton)(this.panel.getComponent(pos))).setText(String.valueOf(tmp)); 
                     
                }
                ((JButton)(this.panel.getComponent(i))).setBackground(Color.GREEN);
                try {
                  Thread.sleep(50);
                  //((JButton)(this.panel.getComponent(array[j]))).setBackground(Color.RED);   
              } catch (InterruptedException ex) {
                  Logger.getLogger(Hebra2.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          ((JButton)(this.panel.getComponent(19))).setBackground(Color.GREEN);
                   
    }
    
    public void run(){
        seleccion(array, panel);
    }
   
}
