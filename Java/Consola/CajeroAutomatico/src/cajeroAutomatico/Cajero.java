package cajeroAutomatico;
import java.util.Scanner;

public class Cajero {

    double saldo;

    public void verificacion () {
        System.out.printf("\n\nSu saldo actual es de: %.1f €.", saldo);
    }

    public void retirar (int tope) {

        double sacar;
        verificacion();
        System.out.print("\n\nTeclee el dinero a retirar: ");
        Scanner teclado = new Scanner(System.in);
        sacar = teclado.nextFloat();

        if (sacar>tope){
            System.out.printf("\nIntenta retirar %.1f €", sacar);
            System.out.printf("\n\nTiene establecido un tope de "+tope+"€");
            verificacion();

        }else{
            saldo = saldo - sacar;
            System.out.printf("\nUsted retiró: %.1f €", sacar);
            verificacion();
        }
    }
    public void ingresar () {

        double ingreso;

        verificacion();
        System.out.print("\n\nTeclee dinero a ingresar: ");
        Scanner teclado = new Scanner(System.in);
        ingreso = teclado.nextDouble();
        saldo = saldo + ingreso;
        System.out.printf("\nUsted ingresó %.2f €", ingreso);
        verificacion();
    }

    public static void main (String[] args){

        int opcion;
        int tope;
        boolean b = false;

        Cajero miCajero1 = new Cajero();
        miCajero1.saldo = Double.parseDouble(args[0]);
        tope = Integer.parseInt(args[1]);
        System.out.println("\t\tPROGRAMA CAJERO AUTOMÁTICO\n\t\t¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");

        while(!b) {
            System.out.print("\n\n\n\n\t\t\tMenú de opciones\n\t\t\t================\n\n\t1) Retirada de dinero\n\t2) Ingreso de dinero\n\t3) Salir\n\n\t\n\nOpción: ");
            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    miCajero1.retirar(tope);
                    break;
                case 2:
                    miCajero1.ingresar();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEsta opción no está disponible");


            }
        }

    }
}

