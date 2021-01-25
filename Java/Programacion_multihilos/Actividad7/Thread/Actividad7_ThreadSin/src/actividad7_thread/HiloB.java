package actividad7_thread;

public class HiloB extends Thread{

    private Contador contador;

    public HiloB (String n, Contador c){
        setName(n);
        contador = c;
    }

    public void run(){
        for (int j = 0; j < 5000; j++){
            contador.incrementa();
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
