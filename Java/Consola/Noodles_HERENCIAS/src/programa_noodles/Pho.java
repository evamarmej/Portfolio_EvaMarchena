package programa_noodles;
//clase hija
public class Pho extends Noodles {
    //Constructor
    public Pho(){
        super("harina de arroz");
    }
    @Override //método con datos que nos llevaremos a la clase principal
    public void preparanoodle (){
        System.out.println("\nHidrate los pho durante 1 hora, para luego cocerlos 1 minuto en el caldo. Finalmente sazónelos con cilantro y jalapeños");
    }

    @Override //método con datos que nos llevaremos a la clase principal
    public void tipoharina (){
        System.out.println("Básicamente hecho de " + harinabase);
    }
}
