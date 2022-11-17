
import javax.swing.JDialog;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class poner_barco extends JDialog{
    JLabel bb;
    public poner_barco(Barco parent, boolean modal){
        super(parent, modal);
        setLayout(null);
        setBounds(10,10,300,100);
        bb = new JLabel("Coloca tus barcos");
        bb.setBounds(115,60,200,30);
        add(bb);    
    }
}
