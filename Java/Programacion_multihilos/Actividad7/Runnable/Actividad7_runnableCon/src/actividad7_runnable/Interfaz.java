package actividad7_runnable;

public class Interfaz implements Runnable{

    private Contador contador;

    public Interfaz (Contador c){
        this.contador = contador;
    }

    @Override
    public void run() {
        synchronized (contador){
            for (int i = 0; i < 5000; i++){
                contador.incrementa();
            }
            System.out.println(Thread.currentThread().getName() + ": " + contador);
        }

    }
}
