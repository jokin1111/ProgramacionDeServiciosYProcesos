package javaapplication1;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Formulario implements ActionListener {

	JButton bt;
        JButton bt2;
        JButton bt3;
        JButton bt4;
        JButton bt5;
        JButton bt6;
        JButton bt7;
        
	JLabel jl;
	JFrame jf = new JFrame("Tragaperras");
        
        Refrescar p;
        Refrescar q;
        Refrescar z;
   
	public Formulario() {
            
		jf.setLayout(null);	
		Dimension d = new Dimension();
                
		bt = new JButton();
                bt2 = new JButton("START1");
                bt3 = new JButton();
                bt4 = new JButton("START2");
                bt5 = new JButton();
                bt6 = new JButton("START3");
                bt7 = new JButton("STOP");
                
		bt.setPreferredSize(new Dimension(150, 150));
                bt.setBounds(50, 50, 150, 150);
                jf.add(bt);
                
		bt2.setPreferredSize(new Dimension (100, 100));
                bt2.setBounds(75, 220, 100, 100);
                bt2.addActionListener(this);
                jf.add(bt2);
                
                bt3.setPreferredSize(new Dimension(150, 150));
                bt3.setBounds(250, 50, 150, 150);
                jf.add(bt3);
                
                bt4.setPreferredSize(new Dimension(100, 100));
                bt4.setBounds(275, 220, 100, 100);
                bt4.addActionListener(this);
                jf.add(bt4);
                
                bt5.setPreferredSize(new Dimension(150, 150));
                bt5.setBounds(450, 50, 150, 150);
                jf.add(bt5);
                
                bt6.setPreferredSize(new Dimension(100, 100));
                bt6.setBounds(475, 220, 100, 100);
                bt6.addActionListener(this);
                jf.add(bt6);
                
                bt7.setPreferredSize(new Dimension(100, 100));
                bt7.setBounds(275, 350, 100, 100);
                bt7.addActionListener(this);
                jf.add(bt7);
                
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocation (620, 340);
		jf.setSize(680, 550);
                jf.setVisible(true);
                
		p = new Refrescar(bt);
                q = new Refrescar(bt3);
		z = new Refrescar(bt5);
                
	}

	public static void main(String[] args) {

		Formulario f = new Formulario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
                if (((JButton)e.getSource()).equals(bt2)){
                    p.start();
                }
                else if (((JButton)e.getSource()).equals(bt4)){
                    q.start();
                }
                else if (((JButton)e.getSource()).equals(bt6)){
                    z.start();
                }
                else if (((JButton)e.getSource()).equals(bt7))
                    p.stop();
                    q.stop();
                    z.stop();
                
                
                /*if (e.getSource().equals(bt7)){
                    p.stop();
                    q.stop();
                    z.stop();
                }else if (e.getSource().equals(bt)) {
                    p.start();
                }else if (e.getSource().equals(bt3)) {
                    q.start();
                }else if (e.getSource().equals(bt5))
                    z.start();
                  */           
    }    
}
