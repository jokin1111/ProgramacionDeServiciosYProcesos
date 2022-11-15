package javaapplication1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Refrescar extends Thread {
	
	JButton bt;

	public Refrescar(JButton bt){
		this.bt = bt;
	}
	
	public void run() {
		int i = 0;
                while(i < 3) {
                    try {
                        ImageIcon icono = new ImageIcon(i + ".jpg");
                        ImageIcon iconoEscalado = new ImageIcon (icono.getImage().getScaledInstance(150, 150, 0));
                        this.bt.setIcon(iconoEscalado);
                        Thread.sleep(200);
                        i++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Refrescar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (i == 3)
                    i = 0;
		}
	}
}
