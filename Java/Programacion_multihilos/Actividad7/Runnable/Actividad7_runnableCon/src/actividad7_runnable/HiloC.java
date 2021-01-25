package actividad7_runnable;


public class HiloC implements Runnable{

    private Contador contador;

    public HiloC(Contador c){
        contador = c;
    }

    public void run(){
        synchronized (contador){
            for (int j = 0; j < 5000; j++){
                contador.incrementa();
            }
            System.out.println(Thread.currentThread().getName() + " contador vale " + contador.getValor());
        }
    }
}