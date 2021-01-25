package programa_noodles;
//clase madre
public class Noodles {
    //atributos
    float longitud;
    float anchura;
    String textura;
    String harinabase;

    public Noodles(String harinabase){this.harinabase = harinabase;}

    public void preparanoodle (){ //este método traerá el mismo dato de todas sus clases hijas
    }

    public void tipoharina (){ //este método traerá el mismo dato de todas sus clases hijas.
    }

    public static void main (String [] args){
        // Creación de objetos
        Spaghettis sp = new Spaghettis();
        Ramen ra = new Ramen();
        Pho ph = new Pho();
        //tabla
        Noodles[] pasta = {sp, ra, ph};
        int x = 0;


        for (x = 0; x < pasta.length; x++){
            pasta[x].preparanoodle();
            pasta[x].tipoharina();
        }


    }
}
