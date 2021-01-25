package actividad7_thread;

public class Contador {

    private int c = 0;

    public Contador(int c) {
        this.c = c;
    }

    public void incrementa(){
        c = c + 1;
    }

    public int getValor() {
        return c;
    }
}
