package Actividad8_synchronized;

public class SacarDinero extends Thread{

    private saldo s;

    public SacarDinero(String n, saldo s) {
        setName(n);
        this.s = s;
    }

    public void run(){
        s.AnadirSaldo(10, "Celia");
        s.AnadirSaldo(20, "Marta");
        s.AnadirSaldo(30, "Paula");
    }
}
