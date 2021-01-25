package Actividad8_synchronized;

public class saldo {
    private int saldo;

    public saldo(int saldo) { this.saldo = saldo; }


    public float getSaldo() {
        try{
            Thread.sleep(1511);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    public void setSaldo(int saldo) {
        try{
            Thread.sleep(1511);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.saldo = saldo;
    }

    synchronized void AnadirSaldo(int cant, String nom){
        if(getSaldo() >= cant){
            System.out.println(("\n" + nom + " va a añadir saldo."));
            System.out.println("El saldo que se va a añadir es: " + cant);
            System.out.println("El estado inicial del saldo es: " + saldo);
            saldo = saldo + cant;
            System.out.println("El estado final del saldo es: " + saldo);

        }else{
            System.out.println(nom + " no puede añadir saldo");
        }
    }


}
