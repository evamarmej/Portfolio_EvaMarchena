package Ejemplo1;

public class EjemploHiloPrioridad1 {
    public static void main(String args[]){
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo3");

        //Asignamos prioridad
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MAX_PRIORITY);

        //Ejecutamos los hilos
        h2.start();
        h1.start();
        h3.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();

        System.out.println("h2 (Prioridad Máxima): " + h2.getContador());
        System.out.println("h1 (Prioridad Normal): " + h1.getContador());
        System.out.println("h3 (Prioridad Mínima): " + h3.getContador());

    }
}
