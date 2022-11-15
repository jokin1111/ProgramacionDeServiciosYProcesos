/**
 *
 * @author joaquin.antequera
 */
public class Escritor extends Thread{
    Monitor monitor;

    public Escritor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){
        
        for (int i = 0; i < 10; i++) {
            monitor.escribir(i);
            System.out.println("Se ha escrito un " + i);
        }
    }
}
