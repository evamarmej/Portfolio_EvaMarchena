package HiloTictac;

public class Tac extends Thread{

    //método run
    public void run(){
        while(true){
            System.out.println("Tac");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
