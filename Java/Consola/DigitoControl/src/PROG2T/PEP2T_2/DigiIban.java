package PROG2T.PEP2T_2;

public class DigiIban {

    public String generariban(String fbanco, String fsucursal, String fdigitocontrol,String fcuenta){
        String cuentaiban;
        int i;
        int m = 0;
        int calculo;

        cuentaiban = fbanco + fsucursal + fdigitocontrol + fcuenta;
        cuentaiban = (cuentaiban + "142800");

        for (i = 0; i < cuentaiban.length(); i++){
            m = ((m * 10 + (Integer.parseInt(String.valueOf(cuentaiban.charAt(i))))) % 97);
        }
        calculo = 98 - m;

        if (calculo <= 9){
            cuentaiban = "ES0" + String.valueOf(calculo);
        } else {
            cuentaiban = "ES" + String.valueOf(calculo);
        }

        return cuentaiban;
    }

    public void validariban(String fiban, String fdigban){

        if (fiban.equals(fdigban)){
            System.out.println("\n\tIBAN calculado: "+fiban+"\t\tVerificación: correcta");
        }else{
            System.out.println("\n\tIBAN calculado: "+fiban+"\t\tVerificación: incorrecta");
        }
    }
}
