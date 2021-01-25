package PROG2T.PEP2T_2;
import java.util.Scanner;
public class PilotDigits {

    public static void main (String [] args){
        boolean salir = false;
        int opcion;
        String banco;
        String sucursal;
        String cuenta;
        String digitocontrol;
        String digitovalidar;
        String digban;
        String iban;
        //  2098 0008 64 1207383832
        while (!salir){
            System.out.println("\nIndica qué quieres hacer: \n1. Generar dígitos de control.\n2. Validar dígitos de control.\n3. Generar IBAN.\n4. Validar IBAN.\n5. Salir\nOpción: ");
            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
            teclado.nextLine(); //fflush
            DigiControl dc = new DigiControl();
            DigiIban ib = new DigiIban();

            switch (opcion){
                case 1: System.out.print("\n\tIntroduce los cuatro dígitos del banco: ");
                    banco = teclado.nextLine();
                    System.out.print("\tIntroduce los cuatro dígitos de la sucursal: ");
                    sucursal = teclado.nextLine();
                    System.out.print("\tIntroduce los diez dígitos de la cuenta: ");
                    cuenta = teclado.nextLine();

                    digitocontrol = dc.generar(banco, sucursal, cuenta);
                    System.out.println("\n\t" +banco + " " + sucursal + " DC1DC2 " + cuenta + " --> " + banco + " " + sucursal + " " + digitocontrol + " " + cuenta);
                    break;

                case 2: System.out.print("\n\tIntroduce los cuatro dígitos del banco: ");
                    banco = teclado.nextLine();
                    System.out.print("\tIntroduce los cuatro dígitos de la sucursal: ");
                    sucursal = teclado.nextLine();
                    System.out.print("\tIntroduce el dígitos de control: ");
                    digitovalidar = teclado.nextLine();
                    System.out.print("\tIntroduce los diez dígitos de la cuenta: ");
                    cuenta = teclado.nextLine();
                    System.out.println("\tNúmero de cuenta a validar: " +banco+" "+sucursal+" "+digitovalidar+" "+cuenta);

                    digitocontrol = dc.generar(banco, sucursal, cuenta);
                    dc.validar(digitovalidar, digitocontrol);
                    break;

                case 3: System.out.print("\n\tIntroduce los cuatro dígitos del banco: ");
                    banco = teclado.nextLine();
                    System.out.print("\tIntroduce los cuatro dígitos de la sucursal: ");
                    sucursal = teclado.nextLine();
                    System.out.print("\tIntroduce el dígitos de control: ");
                    digitocontrol = teclado.nextLine();
                    System.out.print("\tIntroduce los diez dígitos de la cuenta: ");
                    cuenta = teclado.nextLine();

                    digban = ib.generariban(banco, sucursal, digitocontrol, cuenta);
                    System.out.println("\n\t" +digban+" "+ banco+" "+ sucursal+" "+ digitocontrol+" "+ cuenta);
                    break;

                case 4: System.out.print("\n\tIntroduce los cuatro dígitos del IBAN: ");
                    iban = teclado.nextLine();
                    System.out.print("\tIntroduce los cuatro dígitos del banco: ");
                    banco = teclado.nextLine();
                    System.out.print("\tIntroduce los cuatro dígitos de la sucursal: ");
                    sucursal = teclado.nextLine();
                    System.out.print("\tIntroduce el dígito de control: ");
                    digitocontrol = teclado.nextLine();
                    System.out.print("\tIntroduce los diez dígitos de la cuenta: ");
                    cuenta = teclado.nextLine();
                    System.out.println("\tNúmero de cuenta a validar: "+iban+ " " +banco+ " " +sucursal+ " " +digitocontrol+ " " +cuenta);

                    digban = ib.generariban(banco, sucursal, digitocontrol, cuenta);
                    ib.validariban(iban, digban);
                    break;
                case 5: System.exit(0);
                    break;
                default: System.out.print("Esta opción no está disponible");
            }
        }


    }
}
