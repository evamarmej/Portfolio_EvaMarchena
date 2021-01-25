package Productor_Consumidor_2;
public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i%2 == 0){
                cola.put("PING"); //pone el número
                try {
                    sleep(100);
                } catch (InterruptedException e) { }
            }else{
                cola.put("PONG");
                try {
                    sleep(100);
                } catch (InterruptedException e) { }
            }
        }
        System.out.println("Fin productor");
    }
}


