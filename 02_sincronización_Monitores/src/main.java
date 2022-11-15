
/**
 *
 * @author joaquin.antequera
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monitor m = new Monitor();
        Escritor e1 = new Escritor(m);
        Escritor e2 = new Escritor(m);
        Lector l1 = new Lector(m);
        Lector l2 = new Lector(m);
        e1.start();
        e2.start();
        l1.start();
        l2.start();
    }
    
}
