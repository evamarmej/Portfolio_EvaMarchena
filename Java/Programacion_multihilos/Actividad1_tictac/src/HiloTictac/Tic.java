package HiloTictac;

public class Tic extends Thread{

    //método run
    public void run(){
        while(true){
            System.out.println("Tic");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
