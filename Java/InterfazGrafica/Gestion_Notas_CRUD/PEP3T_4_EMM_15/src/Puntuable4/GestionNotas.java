package Puntuable4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class GestionNotas {
    public static void main(String[] args) {

        JFrame marco = new JFrame("Ejercicio PEP3T_4 JAVA");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new FlowLayout());

        JPanel cabecera = new JPanel();
        cabecera.setLayout(new GridLayout(2,1));
        JLabel titulo = new JLabel("GESTIÓN DE LA TABLA NOTAS ");
        titulo.setBorder(new EmptyBorder(5,10,5,10));

        JPanel matricula = new JPanel();
        matricula.setLayout(new GridLayout(1,2));
        JLabel codigo = new JLabel("Código Matrícula: ");
        codigo.setBorder(new EmptyBorder(5,10,5,10));
        JTextField text1 = new JTextField();
        text1.setPreferredSize(new Dimension(200,25));

        JPanel asignatura = new JPanel();
        asignatura.setLayout(new GridLayout(1,2));
        JLabel nombre = new JLabel("Nombre Asignatura: ");
        nombre.setBorder(new EmptyBorder(5,10,5,10));
        JTextField text2 = new JTextField();
        text2.setPreferredSize(new Dimension(200,25));

        JPanel notas = new JPanel();
        notas.setLayout(new GridLayout(1,4));
        JLabel nota1 = new JLabel(" Nota 1");
        JTextField text3 = new JTextField();
        nota1.setBorder(new EmptyBorder(5,10,5,10));
        JLabel nota2 = new JLabel("    Nota 2");
        JTextField text4 = new JTextField();
        nota2.setBorder(new EmptyBorder(5,10,5,10));

        JPanel botones = new JPanel();
        JButton boton1 = new JButton("Insertar");
        JButton boton2 = new JButton("Modificar");
        JButton boton3 = new JButton("Borrar");
        JButton boton4 = new JButton("Consultar");

        JPanel label = new JPanel();
        JLabel mensaje = new JLabel();

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(e.getSource() == boton1){
                        Connection conexBd = conexionBD();

                        PreparedStatement encapsulaPsCons = conexBd.prepareStatement("INSERT INTO notas (codmat, nomas, nota1, nota2) VALUES (?,?,?,?)");

                        encapsulaPsCons.setInt(1, Integer.valueOf(text1.getText()));
                        encapsulaPsCons.setString(2, text2.getText());
                        encapsulaPsCons.setFloat(3, Float.valueOf(text3.getText()));
                        encapsulaPsCons.setFloat(4, Float.valueOf(text4.getText()));

                        int filActualizadas = encapsulaPsCons.executeUpdate();
                        System.out.println(filActualizadas+" registros actualizados");

                        if(filActualizadas >= 1){
                            text1.setText(null);
                            text2.setText(null);
                            text3.setText(null);
                            text4.setText(null);

                            mensaje.setText("Registro insertado");
                        }else {
                            text1.setText(null);
                            text2.setText(null);
                            text3.setText(null);
                            text4.setText(null);

                            mensaje.setText("El código introducido ya existe");
                        }

                        cerrar(conexBd, encapsulaPsCons);
                    }else if (e.getSource() == boton2){
                        Connection conexBd = conexionBD();

                        PreparedStatement encapsulaPsCons = conexBd.prepareStatement("UPDATE notas SET nomas = ?, nota1 = ?, nota2 = ? WHERE codmat = ?");

                        encapsulaPsCons.setString(1, text2.getText());
                        encapsulaPsCons.setFloat(2, Float.valueOf(text3.getText()));
                        encapsulaPsCons.setFloat(3, Float.valueOf(text4.getText()));
                        encapsulaPsCons.setInt(4, Integer.valueOf(text1.getText()));

                        int filActualizadas = encapsulaPsCons.executeUpdate();
                        System.out.println(filActualizadas+" registros actualizados");

                        if(filActualizadas >= 1){
                            text1.setText(null);
                            text2.setText(null);
                            text3.setText(null);
                            text4.setText(null);

                            mensaje.setText("Registro modificado");
                        }else {
                            text1.setText(null);
                            text2.setText(null);
                            text3.setText(null);
                            text4.setText(null);

                            mensaje.setText("No se encuentra el código introducido");
                        }
                        cerrar(conexBd, encapsulaPsCons);

                    }else if (e.getSource() == boton3){
                        Connection conexBd = conexionBD();

                        PreparedStatement encapsulaPsCons = conexBd.prepareStatement("DELETE FROM notas WHERE codmat = ? ");

                        encapsulaPsCons.setInt(1, Integer.valueOf(text1.getText()));

                        int filActualizadas = encapsulaPsCons.executeUpdate();
                        System.out.println(filActualizadas+" registros actualizados");

                        if(filActualizadas >= 1){
                            text1.setText(null);
                            text2.setText(null);
                            text3.setText(null);
                            text4.setText(null);

                            mensaje.setText("Registro eliminado");
                        }else{
                            mensaje.setText("Registro no encontrado");
                        }

                        cerrar(conexBd, encapsulaPsCons);

                    }else if (e.getSource() == boton4){
                        Connection conexBd = conexionBD();

                        text2.setText(null);
                        text3.setText(null);
                        text4.setText(null);

                        String query = ("SELECT nomas,nota1,nota2 FROM notas WHERE codmat = ?");
                        PreparedStatement encapsulaPsCons = conexBd.prepareStatement(query);

                        encapsulaPsCons.setInt(1, Integer.valueOf(text1.getText()));

                        ResultSet rs = encapsulaPsCons.executeQuery();

                        while(rs.next()) {
                            text2.setText(rs.getString("nomas"));
                            text3.setText(String.valueOf(rs.getFloat("nota1")));
                            text4.setText(String.valueOf(rs.getFloat("nota2")));
                        }

                        if(text1.getText().length()==0) {
                            mensaje.setText("Registro no encontrado");
                        }else{
                            mensaje.setText("Registro encontrado");
                        }

                        cerrar(conexBd, encapsulaPsCons);
                    }
                } catch(SQLException sqle) {
                    System.out.println("La consulta no ha podido ejecutarse correctamente");
                    mensaje.setText("El código introducido ya existe");

                } catch (ClassNotFoundException cnfe) {
                    System.out.println(cnfe.getMessage());
                }
            }
        };

        boton1.addActionListener(actionListener);
        boton2.addActionListener(actionListener);
        boton3.addActionListener(actionListener);
        boton4.addActionListener(actionListener);

        marco.setSize(440, 300);

        cabecera.add(titulo);

        matricula.add(codigo);
        matricula.add(text1);

        asignatura.add(nombre);
        asignatura.add(text2);

        botones.add(boton1);
        botones.add(boton2);
        botones.add(boton3);
        botones.add(boton4);

        notas.add(nota1);
        notas.add(text3);
        notas.add(nota2);
        notas.add(text4);

        label.add(mensaje);

        marco.add(cabecera, BorderLayout.NORTH);
        marco.add(matricula, BorderLayout.NORTH);
        marco.add(asignatura, BorderLayout.CENTER);
        marco.add(notas, BorderLayout.CENTER);
        marco.add(botones, BorderLayout.CENTER);
        marco.add(label, BorderLayout.SOUTH);
        marco.setVisible(true);
        marco.setResizable(false);
    }
    private static Connection conexionBD() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String urlCon = "jdbc:mariadb://localhost:3306/puntu4";
        Connection conexBd = DriverManager.getConnection(urlCon, "root", "root");
        System.out.println("Tenemos conexión...");
        return conexBd;
    }
    private static void cerrar(Connection conexBd, PreparedStatement encapsulaPsCons) throws SQLException {
        encapsulaPsCons.close();
        conexBd.close();
    }
}

