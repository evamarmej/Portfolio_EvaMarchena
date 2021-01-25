package controlador;

import modelo.Cuenta;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.Assert.assertEquals;

public class CuentaBaterTest {

    private CuentaBater cuentabater= new CuentaBater();
    private Cuenta cuenta;

    private static String[][] valores() {
        return new String[][] {
            {"13", "Antono García Pérez","2020-12-06", "España","5028.15"},
            {"14", "Agustín Marchena Muñoz","2020-06-21", "España","4444.15"}
        };
    }

    @ParameterizedTest(name = "{index}: Test Insertar datos")
    @MethodSource("valores")
    public void TestInsertar(String numero,String titular,String fecha,String nac, String saldo) {
        cuenta = new Cuenta((Integer.parseInt(numero)),titular,fecha,nac,Double.parseDouble(saldo));
        assertEquals(true, cuentabater.insertar(cuenta));

    }
}
