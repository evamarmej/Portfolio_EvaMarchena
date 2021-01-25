package programa_noodles;
//clase hija
public class Spaghettis extends Noodles {
        //constructor
        public Spaghettis(){
                super("harina de sémola");
        }
        @Override
        public void preparanoodle (){
                System.out.println("\nCueza los spaghettis de 8 a 10 minutos y añada la salsa al gusto, queso o aceite y ajo.");
        }
        @Override
        public void tipoharina (){
                System.out.println("Básicamente hecho de " + harinabase);
        }
}
