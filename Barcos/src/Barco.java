import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Barco extends JFrame implements Runnable{
    JPanel panel1, panel2;
    JButton botones[] = new JButton[100];
    JButton botones2[] = new JButton[100];
    int v1;
    int v2[],v3[],v4[];
    JRadioButton [] radios = new JRadioButton[4];
    JRadioButton [] radios1 = new JRadioButton[2];
    ButtonGroup grupo;
    ButtonGroup grupo1;
    boolean b1,b2,b3,b4, xd;
    int puertoRecibe, puertoEnvia;
    JButton start;
    public Barco(int puertoRecibe, int puertoEnvia, String jugador){
        this.puertoRecibe = puertoRecibe;
        this.puertoEnvia = puertoEnvia;
        new Thread(this).start();
        initVs();
        initRadios();
        initLabel(jugador);
        initPanel();
        initBotones();
        initPantalla();
        initStart();
    }

    public void initPantalla(){
        setTitle("Barcos");
        setLayout(null);
        setSize(1100,900);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void initVs(){
        v1 = 0;
        v2 = new int[2];
        v3 = new int[3];
        v4 = new int[4];
    }

    public void initPanel(){
        panel1 = new JPanel();
        panel1.setBounds(1,60,500,500);
        panel1.setLayout(new GridLayout(10, 10));
        add(panel1);
        panel2 = new JPanel();
        panel2.setBounds(590, 60, 500,500);
        panel2.setLayout(new GridLayout(10, 10));
        panel2.setVisible(false);
        add(panel2);
    }
    public void initBotones(){
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton(String.valueOf(i));
            panel1.add(botones[i]);
            int finalI = i;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(radios[0].isSelected()){
                        botones[finalI].setBackground(Color.RED);
                        radios[0].setEnabled(false);
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b1 = true;
                        v1=finalI;
                        System.out.println(v1);
                    }if(radios[1].isSelected()){
                        for (int j = 0; j < 2; j++) {
                            if(radios1[0].isSelected() & finalI<90){
                                botones[finalI+(j*10)].setBackground(Color.RED);
                                radios[1].setEnabled(false);
                                v2[j] = finalI+ (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<9) {
                                botones[finalI+j].setBackground(Color.RED);
                                radios[1].setEnabled(false);
                                v2[j] = finalI + j;
                            }
                        }
                        for (int i = 0; i < 2; i++) {
                            System.out.print(v2[i] + ",");
                        }
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b2 = true;
                    }if(radios[2].isSelected()){
                        for (int j = 0; j < 3; j++) {
                            if(radios1[0].isSelected() & finalI<80){
                                botones[finalI+(j*10)].setBackground(Color.RED);
                                radios[2].setEnabled(false);
                                v3[j] = finalI + (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<8) {
                                botones[finalI+j].setBackground(Color.RED);
                                radios[2].setEnabled(false);
                                v3[j] = finalI + j;
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.print(v3[i] + ",");
                        }
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b3 = true;
                    }if(radios[3].isSelected()){
                        for (int j = 0; j < 4; j++) {
                            if(radios1[0].isSelected() & finalI<70){
                                botones[finalI+(j*10)].setBackground(Color.RED);
                                radios[3].setEnabled(false);
                                v4[j] = finalI + (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<7) {
                                botones[finalI+j].setBackground(Color.RED);
                                radios[3].setEnabled(false);
                                v4[j] = finalI + j;
                            }
                        }
                        for (int i = 0; i < 4; i++) {
                            System.out.print(v4[i] + ",");
                        }
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b4 = true;
                    }
                    xd = (b1&b2&b3&b4);
                    if (xd){
                        start.setEnabled(true);
                    }
                }
            });

            botones2[i] = new JButton(String.valueOf(i));
            botones2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            panel2.add(botones2[i]);
        }
    }
    public void initStart(){
        start = new JButton("START");
        start.setBounds(200, 600, 100, 30);
        start.setEnabled(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(start)){
                    for (int i = 0; i < botones.length; i++) {
                        botones[i].setEnabled(false);
                    }
                    panel2.setVisible(true);
                    panel2.setEnabled(true);
                    start.setEnabled(false);
                }
            }
        });
        add(start);
    }

    public void initRadios(){
        grupo = new ButtonGroup();
        String [] nombres = {"1", "2", "3", "4"};
        int iy = 1;

        for (int i = 0; i < radios.length; i++) {
            radios[i] = new JRadioButton(nombres[i]);
            radios[i].setBounds(iy, 30, 40, 20);
            add(radios[i]);
            grupo.add(radios[i]);
            iy+=50;
        }
        grupo1 = new ButtonGroup();
        String [] nombres1 = {"Vertical", "Horizontal"};
        int iy1 = 200;
        for (int i = 0; i < radios1.length; i++) {
            radios1[i] = new JRadioButton(nombres1[i]);
            radios1[i].setBounds(iy1, 30, 100, 20);
            add(radios1[i]);
            grupo1.add(radios1[i]);
            iy1+=95;
        }
    }

    public void initLabel(String jugador){
       JLabel p1 = new JLabel(jugador);
       p1.setBounds(1, 1, 100, 30);
       add(p1);
       JLabel p2 = new JLabel();
       p2.setBounds(590, 1, 100, 30);
       if (jugador == "jugador 2"){
           p2.setText("jugador 1");
       }
       else
           p2.setText("jugador 2");
       add(p2);
   }

   public void initLog(){

   }

   public void HitOrNot(){

   }
    public static void main(String[] args){
        new Barco(5000, 6500, "jugador 2");
        new Barco(6500, 5000, "jugador 1");
    }
    @Override
    public void run() {
        while (true){
            int i = (int) RecibeObjetos.recibe(puertoRecibe);

            EnviaObjetos.Envia(, "localhost", puertoEnvia);
        }
    }
}
