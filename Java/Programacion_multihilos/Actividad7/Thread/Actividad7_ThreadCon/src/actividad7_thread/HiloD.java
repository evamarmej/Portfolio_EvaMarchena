package actividad7_thread;

public class HiloD extends Thread{

    private Contador contador;

    public HiloD (String n, Contador c){
        setName(n);
        contador = c;
    }

    public void run(){
        synchronized (contador){
            for (int j = 0; j < 5000; j++){
                contador.incrementa();
            }
            System.out.println(getName() + " contador vale " + contador.getValor());
        }
    }
}
