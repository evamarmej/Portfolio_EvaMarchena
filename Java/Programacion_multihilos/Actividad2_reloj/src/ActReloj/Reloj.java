package ActReloj;

import java.applet.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reloj extends Applet implements Runnable {
    private Thread hilo = null; //hilo
    private Font fuente; //tipo de letra para la hora
    private String horaActual = "";

    public void init() { //Inicializamos la pantalla
        fuente = new Font("Verdana", Font.BOLD, 26);
        setBackground(Color.pink); //color de fondo
        setFont(fuente); //fuente
    }
    public void start() { //Iniciamos el hilo
        if (hilo == null) {
            hilo = new Thread(this);
            hilo.start();
        }
    }
    public void run() { //Se ejecuta tras el start
        Thread hiloActual = Thread.currentThread();
        while (hilo == hiloActual) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            horaActual = sdf.format(cal.getTime());
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
    public void paint(Graphics g) {
        g.clearRect(1, 1, getSize().width, getSize().height);
        g.drawString(horaActual, 20, 50);//muestra la hora
    }
    public void stop() {
        hilo = null;
    }
}

