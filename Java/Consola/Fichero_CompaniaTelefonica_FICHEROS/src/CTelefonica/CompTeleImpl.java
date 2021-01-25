package CTelefonica;

import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;



public class CompTeleImpl {
    Scanner teclado = new Scanner(System.in);


    public static void main(String[] args) {
        int opcion;
        boolean salir = false;
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        CompTeleClases ctc = new CompTeleClases();

            while (!salir) {
                ctc.MenuOpciones();
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();
                teclado.nextLine(); //fflush

                switch (opcion) {
                    case 1:
                        ctc.altaNuevasFacturas();
                        break;
                    case 2:
                        ctc.modificacionValorFactura();
                        break;
                    case 3:
                        ctc.datoFacturacionAbonado();
                        break;
                    case 4:
                        ctc.datoFacturacionTotal();
                        break;
                    case 5:
                        ctc.eliminarFichero();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Esta opción no está disponible.");
                }
            }
    }
}
