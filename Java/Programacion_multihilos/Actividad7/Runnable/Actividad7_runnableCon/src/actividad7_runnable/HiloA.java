package actividad7_runnable;


public class HiloA implements Runnable{

    private Contador contador;

    public HiloA(Contador c){
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