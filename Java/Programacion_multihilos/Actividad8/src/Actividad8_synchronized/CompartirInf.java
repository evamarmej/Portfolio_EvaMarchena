package Actividad8_synchronized;

public class CompartirInf {
    public static void main(String[] args) {
        saldo saldo = new saldo (100);
        SacarDinero h1 = new SacarDinero ("Hilo1", saldo);

        h1.start();
    }
}
