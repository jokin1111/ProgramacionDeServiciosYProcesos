
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author joaquin.antequera
 */
public class Monitor {
    
    int valor;
    
    boolean libre= true;
    
    synchronized void escribir(int valor){
        
        while(!libre){
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        this.valor = valor;
        this.libre = false;
        notifyAll();
    }
    
    synchronized int leer(){
       
        while(libre){
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        int n;
        n = valor;
        libre = true;
        notifyAll();
        return n;
        }
}
