import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import static java.awt.Font.MONOSPACED;

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
    boolean b1,b2,b3,b4, xd, empieza;
    int puertoRecibe, puertoEnvia;
    JButton start, ultimoBoton;
    Semaphore s1;
    int barcos = 10;
    JLabel Etlog;
    JTextArea log;
    public Barco(int puertoRecibe, int puertoEnvia, String jugador, Boolean empieza){
        this.puertoRecibe = puertoRecibe;
        this.puertoEnvia = puertoEnvia;
        this.empieza = empieza;
        s1 =  new Semaphore(empieza ? 1 : 0);
        new Thread(this).start();
        initVs();
        initRadios();
        initLabel(jugador);
        initPanel();
        initBotones();
        initPantalla();
        initLog();
        initStart();
    }

    public void initPantalla(){
        setTitle("Barcos");
        setLayout(null);
        getContentPane().setBackground(Color.magenta);
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
        panel1.setBounds(1,60,400,400);
        panel1.setLayout(new GridLayout(10, 10));
        add(panel1);
        panel2 = new JPanel();
        panel2.setBounds(590, 60, 400,400);
        panel2.setLayout(new GridLayout(10, 10));
        panel2.setVisible(false);
        add(panel2);
    }
    public void initBotones(){
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton();
            botones[i].setBackground(Color.BLACK);
            panel1.add(botones[i]);
            int finalI = i;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(radios[0].isSelected()){
                        botones[finalI].setBackground(Color.GREEN);
                        botones[finalI].setEnabled(false);
                        radios[0].setEnabled(false);
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b1 = true;
                        v1=finalI;
                    }if(radios[1].isSelected()){
                        for (int j = 0; j < 2; j++) {
                            if(radios1[0].isSelected() & finalI<90){
                                botones[finalI+(j*10)].setBackground(Color.GREEN);
                                botones[finalI+(j*10)].setEnabled(false);
                                radios[1].setEnabled(false);
                                v2[j] = finalI+ (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<9) {
                                botones[finalI+j].setBackground(Color.GREEN);
                                botones[finalI+j].setEnabled(false);
                                radios[1].setEnabled(false);
                                v2[j] = finalI + j;
                            }
                        }
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b2 = true;
                    }if(radios[2].isSelected()){
                        for (int j = 0; j < 3; j++) {
                            if(radios1[0].isSelected() & finalI<80){
                                botones[finalI+(j*10)].setBackground(Color.GREEN);
                                botones[finalI+(j*10)].setEnabled(false);
                                radios[2].setEnabled(false);
                                v3[j] = finalI + (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<8) {
                                botones[finalI+j].setBackground(Color.GREEN);
                                botones[finalI+j].setEnabled(false);
                                radios[2].setEnabled(false);
                                v3[j] = finalI + j;
                            }
                        }
                        grupo.clearSelection();
                        grupo1.clearSelection();
                        b3 = true;
                    }if(radios[3].isSelected()){
                        for (int j = 0; j < 4; j++) {
                            if(radios1[0].isSelected() & finalI<70){
                                botones[finalI+(j*10)].setBackground(Color.GREEN);
                                botones[finalI+(j*10)].setEnabled(false);
                                radios[3].setEnabled(false);
                                v4[j] = finalI + (j*10);
                            }
                            else if (radios1[1].isSelected()& finalI%10<7) {
                                botones[finalI+j].setBackground(Color.GREEN);
                                botones[finalI+j].setEnabled(false);
                                radios[3].setEnabled(false);
                                v4[j] = finalI + j;
                            }
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

            botones2[i] = new JButton();
            botones2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (s1.tryAcquire()){
                        ultimoBoton = ((JButton)e.getSource());
                        EnviaObjetos.Envia(finalI, "localhost", puertoEnvia);
                        ((JButton)e.getSource()).setEnabled(false);
                    }
                }
            });
            panel2.add(botones2[i]);
        }
    }
    public void initStart(){
        start = new JButton("START");
        start.setBounds(440, 460, 100, 30);
        start.setForeground(Color.BLUE);
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
    public void initLog(){
        log = new JTextArea();
        log.setBounds(50, 540, 900, 300);
        log.setLineWrap(true);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.GREEN);
        log.setFont(Font.getFont(MONOSPACED));
        add(log);
    }

    public void initRadios(){
        grupo = new ButtonGroup();
        String [] nombres = {"1", "2", "3", "4"};
        int iy = 1;

        for (int i = 0; i < radios.length; i++) {
            radios[i] = new JRadioButton(nombres[i]);
            radios[i].setBounds(iy, 30, 40, 20);
            radios[i].setBackground(Color.MAGENTA);
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
            radios1[i].setBackground(Color.MAGENTA);
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
       Etlog = new JLabel("Registro de Actividades");
       Etlog.setBounds(420, 500, 300, 30 );
       add(Etlog);
   }
    public static void main(String[] args){
        new Barco(5000, 6500, "jugador 2",true);
        new Barco(6500, 5000, "jugador 1",false);
    }
    @Override
    public void run() {
        while (barcos >0){
            Object ob = RecibeObjetos.recibe(puertoRecibe);
            if (ob instanceof Integer){
                s1.release();
                if (botones[(int)ob].getBackground().equals(Color.GREEN)){
                    EnviaObjetos.Envia("Tocado", "localhost", puertoEnvia);
                    barcos--;
                    botones[(int)(ob)].setBackground(Color.RED);
                }
                else {
                    EnviaObjetos.Envia("Agua", "localhost", puertoEnvia);
                    botones[(int)(ob)].setBackground(Color.BLUE);
                }

            } else if (ob instanceof String) {
                if (ob.equals("Tocado")){
                    ultimoBoton.setBackground(Color.red);
                    log.append("Tocado¡" + "\n");
                }
                else if (ob.equals("Agua")){
                    ultimoBoton.setBackground(Color.blue);
                    log.append("Agua" + "\n");
                }
                else if (ob.equals("Win")) {
                    for (int i = 0; i < botones.length; i++) {
                        botones[i].setEnabled(false);
                        botones2[i].setEnabled(false);
                    }
                    log.append("has ganado");
                }
            }
        }
        EnviaObjetos.Envia("Win", "localhost", puertoEnvia);
        log.append("Has perdido");
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
            botones2[i].setEnabled(false);
        }
    }
}
