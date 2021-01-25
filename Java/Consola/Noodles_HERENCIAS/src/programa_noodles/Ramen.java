package programa_noodles;
//clase hija
public class Ramen extends Noodles {
    //Constructor
    public Ramen(){
        super("harina de trigo");
    }
    @Override // método con datos que nos llevaremos a la clase principal
    public void preparanoodle (){
        System.out.println("\nCueza el ramen 5 minutos en caldo, añada la carne, los champiñones, e huevo y las verduras.");
    }

    @Override // método con datos que nos llevaremos a la clase principal
    public void tipoharina (){
        System.out.println("Básicamente hecho de " + harinabase);
    }
}
