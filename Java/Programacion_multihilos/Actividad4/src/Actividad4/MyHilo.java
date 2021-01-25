package Actividad4;

import java.util.Scanner;

public class MyHilo extends Thread{

    private SolicitaSuspender suspender = new SolicitaSuspender();
    private boolean stopHilo = false;
    private int contador = 0;

    public void Suspende(){suspender.set(true);}
    public void Reanuda(){suspender.set(false);}

    public int getContador() {
        return contador;
    }

    public void pararHilo(){
        stopHilo = true;
    }

    public void run(){
        try{
            while(!stopHilo){
                suspender.esperandoParaReanudar(); //comprobar
                contador++;
                System.out.println(getContador());
                Thread.sleep(2000);
            }
        }catch(InterruptedException exception){

        }
    }

    public static void main(String[] args) {
        MyHilo hilo = new MyHilo();
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        hilo.start();

        while(true){
            cadena = sc.nextLine();
            if(cadena.equals("S")){
                hilo.Suspende();
            }else if(cadena.equals("R")){
                hilo.Reanuda();
            }else if(cadena.equals("*")){
                hilo.pararHilo();
            }
        }
    }
}
