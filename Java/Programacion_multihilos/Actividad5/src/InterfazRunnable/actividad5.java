package InterfazRunnable;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class actividad5 extends Applet implements ActionListener {

    class HiloContador extends Thread{
        long contador = 0;

        public HiloContador (long contador){
            this.contador = contador;
        }

        public void run() { //Se ejecuta tras el start
            try {
                while (!isInterrupted()) {

                    Thread.sleep(500);
                    repaint();
                    contador++;
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }

        public long getContador() {
            return contador;
        }
    }

    //private Thread h;
    private Font fuente;
    private Button b1, b2;
    HiloContador hilo1;
    HiloContador hilo2;

    public void start() {
        hilo1 = new HiloContador(0);
        hilo2 = new HiloContador(5);
        hilo1.start();
        hilo2.start();
    }

    public void init() { //Inicializamos la pantalla
        setBackground(Color.pink);

        add(b1 = new Button("Parar contador 1"));
        b1.addActionListener(this);

        add(b2 = new Button("Parar contador 2"));
        b2.addActionListener(this);

        fuente = new Font("Calibri", Font.PLAIN, 26);
    }

    public void paint(Graphics g) { //pinta la pantalla
        g.clearRect(0, 0, 400, 400);
        g.setFont(fuente); // fuente
        g.drawString("Contador 1: ", 110, 130);
        g.drawString("Contador 2: ", 110, 180);
        g.drawString(Long.toString((long) hilo1.getContador()), 260, 130);
        g.drawString(Long.toString((long) hilo2.getContador()), 260, 180);
    }

    public void actionPerformed(ActionEvent e) { //controla los botones
        if (e.getSource() == b1){ // Pulso boton 1
            System.out.println("Finalizado hilo 1");
            hilo1.interrupt();

        } else if (e.getSource() == b2){ // Pulso boton 2
            System.out.println("Finalizado hilo 2");
            hilo2.interrupt();
        }
    }

    public void stop() {
        hilo1 = null;
        hilo2 = null;
    }
}