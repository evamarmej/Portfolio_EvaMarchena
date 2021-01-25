package programa_atlas_arraylist;
import java.util.ArrayList;

public class implatlas_array {
    ArrayList<String> paiscapital = new ArrayList<String>();

    public void añadir(String fpais, String fcapital) {
        paiscapital.add(fpais);
        paiscapital.add(fcapital);
        System.out.println("\nNueva entrada incorporada");
    }

    public void mostrar() {
        int size;
        size = paiscapital.size();
        for (int i = 0; i < paiscapital.size(); i++) {
            if ((i + 1) != size) {
                System.out.println("País: " + paiscapital.get(i) + "     Capital: " + paiscapital.get(i + 1));
                i++;
            }
        }

        System.out.println("\nHay " + (size/2) + " elementos en el Atlas");
    }

    public void buscar(String fpais) {
        for (int i = 0; i < paiscapital.size(); i++) {
            if (paiscapital.get(i).equals(fpais)) {
                System.out.println("Capital: " + paiscapital.get(i+1));
            }
        }
    }

    public void modificar(String fpais, String fcapital) {
        for (int i = 0; i < paiscapital.size(); i++) {
            if (paiscapital.get(i).equals(fpais)) {
                paiscapital.set(i+1, fcapital);
            }
        }
    }

    public void eliminarentrada(String fpais) {

        paiscapital.remove(fpais);
        System.out.println(fpais + " eliminado del Atlas");
    }

    public void eliminarcontenido() {
        paiscapital.clear();
    }

    public boolean encuentra(String pais) throws Exception {
        Exception ex;
        boolean fprueba = false;
        for (int i = 0; i < paiscapital.size(); i++) {
            if (paiscapital.get(i).equals(pais)) {
                fprueba = true;
                break;
            }
        }
            if (fprueba == false) {
                System.out.println("De este país no se encuentra capital");
            }

        return fprueba;
    }
}
