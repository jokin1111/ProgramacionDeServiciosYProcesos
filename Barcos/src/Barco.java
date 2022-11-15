
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class Barco extends JFrame implements Runnable{
    JPanel panel1, panel2;
    
    JButton botones[] = new JButton[100];
    JButton botones2[] = new JButton[100];
    public Barco(){
        initPanel();
        initPantalla();
    }
    
    public void initPantalla(){
        setTitle("Barcos");
        setLayout(null);
        setSize(1100,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void initPanel(){
        panel1 = new JPanel();
        panel1.setSize(500,400);
        panel1.setLayout(new GridLayout(10, 10));
        add(panel1);
        panel2 = new JPanel();
        panel2.setBounds(590, 1, 500,400);
        panel2.setLayout(new GridLayout(10, 10));
        add(panel2);
        for (int i = 0; i < botones.length; i++) {
             botones[i] = new JButton(String.valueOf(i));
             panel1.add(botones[i]);
             botones[i].addActionListener(new a);
             botones2[i] = new JButton(String.valueOf(i));
             panel2.add(botones2[i]);
        }
    }
    
    public void initBarcos(){
        poner_barco pb = new poner_barco(this,true);
    }
    
    public static void main(String[] args){
        new Barco();        
    }
    
    @Override
    public void run() {
        while (true){
            
        }
    }
    
}
