package controlador;

import modelo.Cuenta;
import controlador.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificaCuentas extends Conexion {

    private PreparedStatement preparedStatement;


    public Boolean fecha(String[] v) { //Control de errores para el campo fecha

        Boolean error2 = false;

        if (v.length != 3) {
            error2 = true;
        } else {
            if (Integer.parseInt(v[2]) > 31 && Integer.parseInt(v[0]) > 1) { //Controla que el día no sea menor que 1 ni mayor que 31
                error2 = true;
            }
            if (Integer.parseInt(v[1]) > 12 && Integer.parseInt(v[1]) > 1) { //Controla que el mes no sea menor que 1 ni mayor que 12
                error2 = true;
            }
            if (v[0].length() != 4) { //Controla que el año no sea distinto de 4 dígitos.
                error2 = true;
            }
        }


        return error2;

    }



}
