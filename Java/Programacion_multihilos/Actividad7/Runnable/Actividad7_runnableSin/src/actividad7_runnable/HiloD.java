package actividad7_runnable;


public class HiloD implements Runnable{

    private Contador contador;

    public HiloD (Contador c){
        contador = c;
    }

    public void run(){
        for (int j = 0; j < 5000; j++){
            contador.incrementa();
        }
        System.out.println(Thread.currentThread().getName() + " contador vale " + contador.getValor());
    }
}