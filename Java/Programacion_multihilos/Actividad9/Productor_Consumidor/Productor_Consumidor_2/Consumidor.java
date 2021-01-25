package Productor_Consumidor_2;
public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        String valor;
        for (int i = 0; i < 10; i++) {
            valor = cola.get(); //recoge el número
            System.out.print(valor + " ");
        }
    }
}
