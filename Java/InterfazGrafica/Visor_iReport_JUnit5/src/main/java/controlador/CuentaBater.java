package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelo.Cuenta;
import net.sf.jasperreports.engine.*;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CuentaBater extends Conexion implements Initializable {


    // Componentes de javaFX
    public Label labelTitulo;
    public Label labelNom;
    public Label labelTit;
    public Label labelFecAp;
    public Label labelSald;
    public TextField fieldNum;
    public TextField fieldTit;
    public TextField fieldFecAp;
    public TextField fieldSald;
    public Button botonCancela;
    public Button botonAcepta;
    public Button botonBack;
    public Button botonNext;
    public Button botonPdf;
    public Button botonHtml;
    public Label labelTitulo1;
    public Button botonNuevo;
    public Pane panelPrincipal;
    public Label labelNac;
    public TextField fieldNac;


    //Variables
    //ArrayList<Cuenta> inicializacion = new ArrayList();
    int i=0;
    Boolean error1=false;
    Boolean error2=false;
    Boolean error3=false;
    Integer numero;
    String titulo;
    String fecha;
    Double salar;
    String nac;

    ArrayList<Cuenta> inicializacion= new ArrayList();

    ModificaCuentas mod= new ModificaCuentas();   //Llama a la clase ModificaCuentas

    public ArrayList<Cuenta> obtenerTodos() {
        this.conectarBBDD();
        String sql = "SELECT * FROM cuentas";
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        try {
            Statement statement = this.conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Cuenta c = new Cuenta();
                c.setNumero(resultSet.getInt("id"));
                c.setTitular(resultSet.getString("titular"));
                c.setFecha(resultSet.getString("fecha"));
                c.setNacionalidad(resultSet.getString("nacionalidad"));
                c.setSaldo(resultSet.getDouble("saldo"));

                cuentas.add(c);
            }
            resultSet.close();
            statement.close();


        } catch (SQLException ex) {
            System.out.println("Excepción Sql");
        } finally{

            this.cerrarConexion();
        }

        return cuentas;
    }

    public boolean insertar(Cuenta c){
        boolean insertadoOk = true;
        try{
            this.conectarBBDD();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO cuentas (id, titular, fecha, nacionalidad, saldo) VALUES (?,?,?,?,?)");

            st.setInt(1, c.getNumero());
            st.setString(2, c.getTitular());
            st.setString(3, c.getFecha());
            st.setString(4, c.getNacionalidad());
            st.setDouble(5, c.getSaldo());

            st.executeUpdate();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            insertadoOk=false;
        }finally{
            this.cerrarConexion();
        }
        return insertadoOk;
    }


    public void initialize(URL url, ResourceBundle resourceBundle) { //Inicializa el programa
        inicializacion = obtenerTodos();
        fieldNum.setEditable(false);
        fieldFecAp.setEditable(false);
        fieldNac.setEditable(false);
        fieldSald.setEditable(false);
        fieldTit.setEditable(false);
        fieldNum.setText(String.valueOf(inicializacion.get(0).getNumero()));
        fieldTit.setText(inicializacion.get(i).getTitular());
        fieldFecAp.setText(String.valueOf(inicializacion.get(0).getFecha()));
        fieldNac.setText(String.valueOf(inicializacion.get(0).getNacionalidad()));
        fieldSald.setText(String.valueOf(inicializacion.get(0).getSaldo()));
        botonBack.setVisible(false);
        botonAcepta.setVisible(false);
    }

    public void accionback() { //acción cuando pulsamos el botón volver "<<"

        fieldNum.getStylesheets().clear();
        fieldSald.getStylesheets().clear();
        botonAcepta.setVisible(false);
        botonNuevo.setVisible(false);
        botonNext.setVisible(true);
        i--;
        if (i==0||i<0){ //Cuando está en el primero de la tabla desactiva el botón volver
            i = 0;
            botonBack.setVisible(false);
            botonNext.setVisible(true);
            fieldNum.setText(String.valueOf(inicializacion.get(i).getNumero()));
            fieldTit.setText(inicializacion.get(i).getTitular());
            fieldFecAp.setText(inicializacion.get(i).getFecha());
            fieldNac.setText(inicializacion.get(i).getNacionalidad());
            fieldSald.setText(String.valueOf(inicializacion.get(i).getSaldo()));

        }else{ //Vuelve uno atrás y aparece el botón volver
            fieldNum.setText(String.valueOf(inicializacion.get(i).getNumero()));
            fieldTit.setText(inicializacion.get(i).getTitular());
            fieldFecAp.setText(String.valueOf(inicializacion.get(i).getFecha()));
            fieldNac.setText(String.valueOf(inicializacion.get(i).getNacionalidad()));
            fieldSald.setText(String.valueOf(inicializacion.get(i).getSaldo()));
        }
    }

    public void accionnext() { //Acción cuando pulsamos el botón siguiente ">>"

        botonBack.setVisible(true);

        if (i < inicializacion.size() - 1) { //Coge le tamaño y al ser más pequeño que el tamaño total entra
            i++; //avanza uno
            fieldNum.setText(String.valueOf(inicializacion.get(i).getNumero()));
            fieldTit.setText(inicializacion.get(i).getTitular());
            fieldFecAp.setText(String.valueOf(inicializacion.get(i).getFecha()));
            fieldNac.setText(inicializacion.get(i).getNacionalidad());
            fieldSald.setText(String.valueOf(inicializacion.get(i).getSaldo()));
            
            if(i == inicializacion.size() - 1){
                botonNuevo.setVisible(true);
                botonNext.setVisible(false);
            }
        }
    }

    public void accionC() { //Acción cuando pulsamos el botón cancelar
        labelTitulo1.setVisible(false);
        labelTitulo.setVisible(true);
        botonCancela.setVisible(false);
        botonAcepta.setVisible(false);
        botonNext.setVisible(true);
        botonBack.setVisible(true);

        fieldNum.getStylesheets().clear(); //Limpia los datos de los textfield para que aparezcan en blanco
        fieldSald.getStylesheets().clear();
        fieldFecAp.getStylesheets().clear();
        fieldNum.setText(String.valueOf(inicializacion.get(i).getNumero())); //Recupera los datos de lo último que haya en el arraylist
        fieldTit.setText(inicializacion.get(i).getTitular());
        fieldFecAp.setText(String.valueOf(inicializacion.get(i).getFecha()));
        fieldNac.setText(String.valueOf(inicializacion.get(i).getNacionalidad()));
        fieldSald.setText(String.valueOf(inicializacion.get(i).getSaldo()));

        botonNext.setVisible(false);
        botonNuevo.setVisible(true);
    }

    public void accionA() { //Acción cuando pulsamos el botón aceptar
        String estilo = "miestilo.css";

        error1 = false;
        error2 = false;
        error3 = false;

        botonCancela.setVisible(false);
        botonNext.setVisible(false);
        botonBack.setVisible(true);
        botonNuevo.setVisible(true);

        try {
            numero = Integer.parseInt(fieldNum.getText()); //Acepta los números introducidos
            fieldNum.getStylesheets().clear();
        } catch (NumberFormatException e) { //Si no es un número
            error1 = true; //control del campo número
            fieldNum.getStylesheets().add(estilo); //Aparecerán los campos textfield en rojo
            botonAcepta.setVisible(true);
            botonNuevo.setVisible(false);
            botonCancela.setVisible(true);
            botonBack.setVisible(false);
            botonNext.setVisible(false);
        }

        try {
            fecha = fieldFecAp.getText(); //Recoge los datos de fecha introducidos
            String[] v = fecha.split("-"); //los separa en un arrray de string y los separa por "-"

            error2=mod.fecha(v); //Devuelve el booleano que confirma si los campos son correctos (viene de la clase ModificaCuentas)

            fieldFecAp.getStylesheets().clear(); //Si reinserta datos correctos deja de aparecer el fondo rojo

            if (error2) { //Control del campo fecha. Si no es correcto
                fieldFecAp.getStylesheets().add(estilo); //Muestra texfield en rojo
                botonAcepta.setVisible(true);
                botonNuevo.setVisible(false);
                botonCancela.setVisible(true);
                botonBack.setVisible(false);
                botonNext.setVisible(false);
            }
        } catch (NumberFormatException e) { //Si no es un número
            fieldFecAp.getStylesheets().add(estilo); //Muestra textfield en rojo
            error2 = true;
            botonAcepta.setVisible(true);
            botonNuevo.setVisible(false);
            botonCancela.setVisible(true);
            botonBack.setVisible(false);
            botonNext.setVisible(false);
        }

        try {
            titulo = fieldTit.getText();
            fecha = fieldFecAp.getText();
            nac = fieldNac.getText();
            salar = Double.parseDouble(fieldSald.getText());
            fieldSald.getStylesheets().clear();
        } catch (NumberFormatException e) {
            error3 = true; //Controla el saldo
            fieldSald.getStylesheets().add(estilo);
            botonAcepta.setVisible(true);
            botonNuevo.setVisible(false);
            botonCancela.setVisible(true);
            botonBack.setVisible(false);
            botonNext.setVisible(false);
        }

        if (!error1 && !error2 && !error3) { //Si no hay error
            Cuenta c = new Cuenta();
            c.setNumero(Integer.parseInt(String.valueOf(numero)));
            c.setTitular(titulo);
            c.setFecha(fecha);
            c.setNacionalidad(nac);
            c.setSaldo(Double.parseDouble(String.valueOf(salar)));
            insertar(c);
            inicializacion = obtenerTodos();
            botonAcepta.setVisible(false);
            labelTitulo1.setVisible(false);
            labelTitulo.setVisible(true);
            fieldTit.setEditable(false);
            fieldFecAp.setEditable(false);
            fieldNac.setEditable(false);
            fieldSald.setEditable(false);
            fieldNum.setEditable(false);
            inicializacion = obtenerTodos();
            i++;
        }
    }



    public void accionNuevo() { //Acción si pulsamos sobre botón Nuevo
        labelTitulo.setVisible(false);
        labelTitulo1.setVisible(true);
        botonNext.setVisible(false);
        fieldNum.setText("");
        fieldTit.setText("");
        fieldFecAp.setText("");
        fieldNac.setText("");
        fieldSald.setText("");
        botonBack.setVisible(false);
        botonNext.setVisible(false);
        botonNuevo.setVisible(false);
        botonAcepta.setVisible(true);
        botonCancela.setVisible(true);
        fieldNum.setEditable(true);
        fieldSald.setEditable(true);
        fieldFecAp.setEditable(true);
        fieldNac.setEditable(true);
        fieldTit.setEditable(true);
    }

    public void accionPdf(ActionEvent actionEvent) {
        try{
            JasperReport archivo = JasperCompileManager.compileReport("CuentasFecha.jrxml");
            Map<String,Object> map = new HashMap<>();
            map.put("logo", "logotipo.png");
            Conexion con = new Conexion();
            JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
            JasperExportManager.exportReportToPdfFile(prin, "reportePDF.pdf");
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "reportePDF.pdf");
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }

    public void accionHtml(ActionEvent actionEvent) {
        try{
            JasperReport archivo = JasperCompileManager.compileReport("CuentasSubtotalesGrafico_parametro.jrxml");
            Map<String,Object> map = new HashMap<>();
            map.put("logo", "logotipo.png");
            Conexion con = new Conexion();
            JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
            JasperExportManager.exportReportToHtmlFile(prin, "reporteHTML.html");
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "reporteHTML.html");
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}
