package programa_atlas_hashmap; //menu no se repite + opc 3 hay x elementos y de este pais no se encuentra la capital

import java.util.HashMap;

public class implatlas_hash {
    HashMap<String, String> paiscapital = new HashMap<String, String>();

    public void añadir(String fpais, String fcapital){
        paiscapital.put(fpais,fcapital);
        System.out.println("\n\tNueva entrada incorporada");
    }

    public void mostrar() {
        int size;
        for (String i : paiscapital.keySet()) {
            System.out.println("País: " + i + "     Capital: " + paiscapital.get(i));
        }
        size=paiscapital.size();
        System.out.println("\nHay "+size+" elementos en el Atlas");
    }

    public void buscar(String fpais){

            System.out.println("Capital: " + paiscapital.get(fpais));
    }

    public void modificar(String fpais, String fcapital){
        paiscapital.replace(fpais, fcapital);
    }

    public void eliminarentrada(String fpais){

        paiscapital.remove(fpais);
        System.out.println(fpais+" eliminada del Atlas");
    }

    public void eliminarcontenido(){
        paiscapital.clear();
    }

    public boolean encuentra(String pais) throws Exception {
        Exception ex;
        boolean fprueba = false;
        for (String i : paiscapital.keySet()) {
            if (pais.equals(i)) {
                fprueba = true;
            }
        }
        if (fprueba == false) {
            System.out.println("De este país no se encuentra capital");
        }

    return fprueba;
    }

}
