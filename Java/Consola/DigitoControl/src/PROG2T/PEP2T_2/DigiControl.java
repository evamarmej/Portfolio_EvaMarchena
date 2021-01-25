package PROG2T.PEP2T_2;
import java.util.Scanner;

public class DigiControl {

    public  String generar(String fbanco, String fsucursal, String fcuenta){
        int x = 0;
        int y = 0;
        int resulbanco = 0;
        int resulsucursal = 0;
        int resulcuenta = 0;
        int resul;
        int DigCon1;
        int DigCon2 = 0;
        String digitocontrol;
        int[] homologo = {1,2,4,8,5,10,9,7,3,6};


        //  2098 0008 64 1207383832
        //Calcular dígito de control 1

        // Entidad
        for (x = 2; x <= 5; x++){
            resulbanco = resulbanco + (homologo[x] * (Integer.parseInt(String.valueOf(fbanco.charAt(y)))));
            y = y+1;
        }
        y = 0;


        //Sucursal
        for(x = 6; x < homologo.length; x++){
            resulsucursal = resulsucursal + (homologo[x] * (Integer.parseInt(String.valueOf(fsucursal.charAt(y)))));
            y++;
        }
        y = 0;

        DigCon1 = 11 - ((resulbanco + resulsucursal) % 11);

        if(DigCon1 == 10){
            DigCon1 = 1;
        } else if(DigCon1 == 11) {
            DigCon1 = 0;
        }


        // Calcular digito de control 2
        // Cuenta
        for (x = 0; x < homologo.length ; x++){
            resulcuenta = resulcuenta + (homologo[x] * (Integer.parseInt(String.valueOf(fcuenta.charAt(y)))));
            y = y+1;
        }
        y = 0;

        DigCon2 = 11 - (resulcuenta%11);

        if(DigCon2 == 10){
            DigCon2 = 1;
        } else if(DigCon2 == 11) {
            DigCon2 = 0;
        }

        // Paso de int a string
        digitocontrol = String.valueOf(DigCon1) + String.valueOf(DigCon2);

        return digitocontrol;

    }


    public void validar(String fdigitovalidar, String fdigitocontrol){

        if (fdigitocontrol.equals(fdigitovalidar)){
            System.out.println("\n\tDígitos calculados: " + fdigitovalidar + "\t\tVerificación: correcta");
        } else {
            System.out.println("\n\tDígitos calculados: " + fdigitovalidar + "\t\tVerificación: incorrecta");
        }
        //  2098 0008 64 1207383832
    }
}

