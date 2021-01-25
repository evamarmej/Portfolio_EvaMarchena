package actividad7_runnable;

public class CompartirInfR{

    public static void main(String[] args) {
        Contador cont = new Contador(100);

        Thread a = new Thread(new HiloA(cont));
        Thread b = new Thread(new HiloB(cont));
        Thread c = new Thread(new HiloC(cont));
        Thread d = new Thread(new HiloD(cont));
        Thread e = new Thread(new HiloE(cont));

        a.setName("Hilo A");
        b.setName("Hilo B");
        c.setName("Hilo C");
        d.setName("Hilo D");
        e.setName("Hilo E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();



    }


}
