package programa_atlas_hashmap;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PilotAtlas_hash {
    public static void main (String[]args) throws Exception{
        boolean salir = false;
        int opcion;
        String pais;
        String capital;
        String i;
        boolean prueba;
        System.out.println("\t\t\t\t\t\t\tPROGRAMA ATLAS");
        implatlas_hash impla = new implatlas_hash();
        System.out.println("\n\nElige una opción: \n\n1. Añadir una entrada al atlas.\t\t\t2. Mostrar el contenido actual del atlas.\n3. Buscar una entrada del atlas\t\t\t4. Modificar una entrada del atlas.\n5. Eliminar una entrada del atlas.\t\t6. Eiminar el contenido completo del atlas.\n7. Salir.");
        Scanner teclado = new Scanner(System.in);

        while(!salir){
            try {
                System.out.println("\nTeclea una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine(); //fflush

                switch (opcion) {
                    case 1:
                        System.out.println("Teclea un País: ");
                        pais = teclado.nextLine();
                        System.out.println("Teclea su Capital: ");
                        capital = teclado.nextLine();
                        impla.añadir(pais, capital);
                        break;

                    case 2:
                        impla.mostrar();
                        break;

                    case 3:
                        System.out.println("Teclea un País: ");
                        pais = teclado.nextLine();
                        prueba = impla.encuentra(pais);
                        if(prueba == true){ impla.buscar(pais); }
                        break;

                    case 4:
                        System.out.println("Teclea un país: ");
                        pais = teclado.nextLine();
                        prueba = impla.encuentra(pais);
                        if(prueba == true){
                            System.out.println("Teclea modificación de capital: ");
                            capital = teclado.nextLine();
                            impla.modificar(pais, capital);
                        }
                        break;

                    case 5:
                        System.out.println("Teclea un país a eliminar: ");
                        pais = teclado.nextLine();
                        prueba = impla.encuentra(pais);
                        if(prueba == true){ impla.eliminarentrada(pais);}
                        break;

                    case 6:
                        impla.eliminarcontenido();
                        System.out.println("Eliminado el atlas por completo.");
                        break;

                    case 7:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Esta opción no está disponible");
                }

            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                teclado.next();
            }
        }

    }
}
