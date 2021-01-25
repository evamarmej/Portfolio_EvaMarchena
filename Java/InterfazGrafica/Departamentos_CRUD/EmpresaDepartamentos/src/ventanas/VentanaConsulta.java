
package ventanas;

import conexion.Conexion;
import dao.DepartamentoDAO;
import vo.DepartamentoVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class VentanaConsulta extends JFrame implements ActionListener {
    DepartamentoDAO dao = new DepartamentoDAO();

    public VentanaConsulta() {
        setSize(680,310);
        setTitle("Departamentos");
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
    }
    
    public void construirTabla(){
           String titulos[] = {"Id", "Nombre", "Número", "Jefe", "Servicios"};
           String informacion [][] = dao.obtenerDatos();
           Tabla = new JTable(informacion, titulos);  
           Barra.setViewportView(Tabla);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPpal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextFId = new javax.swing.JTextField();
        TextFNom = new javax.swing.JTextField();
        TextFNum = new javax.swing.JTextField();
        TextFJefe = new javax.swing.JTextField();
        TextFServ = new javax.swing.JTextField();
        BtnInsertar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnBorrar = new javax.swing.JButton();
        Barra = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnMostrar = new javax.swing.JButton();
        BtnCargar = new javax.swing.JButton();

        jLabel1.setText("Datos del departamento:");

        jLabel2.setText("Id");

        jLabel3.setText("Nombre");

        jLabel4.setText("Nº Emp");

        jLabel5.setText("Jefe");

        jLabel6.setText("Servicio");

        TextFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFIdActionPerformed(evt);
            }
        });

        TextFServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFServActionPerformed(evt);
            }
        });

        BtnInsertar.setText("Insertar");
        BtnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnBorrar.setText("Borrar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Nº Emp", "Jefe", "Servicio"
            }
        ));
        Barra.setViewportView(Tabla);

        BtnMostrar.setText("Mostrar");
        BtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarActionPerformed(evt);
            }
        });

        BtnCargar.setText("Cargar Registro");
        BtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPpalLayout = new javax.swing.GroupLayout(PanelPpal);
        PanelPpal.setLayout(PanelPpalLayout);
        PanelPpalLayout.setHorizontalGroup(
            PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPpalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPpalLayout.createSequentialGroup()
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPpalLayout.createSequentialGroup()
                                .addComponent(BtnInsertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBorrar))
                            .addComponent(jLabel1))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(PanelPpalLayout.createSequentialGroup()
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFServ)
                            .addComponent(TextFNom)
                            .addComponent(TextFNum)
                            .addComponent(TextFJefe)
                            .addGroup(PanelPpalLayout.createSequentialGroup()
                                .addComponent(TextFId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(BtnCargar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPpalLayout.createSequentialGroup()
                        .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPpalLayout.createSequentialGroup()
                        .addComponent(BtnMostrar)
                        .addGap(134, 134, 134))))
        );
        PanelPpalLayout.setVerticalGroup(
            PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPpalLayout.createSequentialGroup()
                .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPpalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(PanelPpalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCargar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TextFNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TextFNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TextFJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TextFServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(PanelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInsertar)
                    .addComponent(BtnModificar)
                    .addComponent(BtnBorrar)
                    .addComponent(BtnMostrar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFIdActionPerformed

    private void TextFServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFServActionPerformed

    private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed
        Conexion conex = new Conexion();
        try{
            if(!TextFNom.getText().isEmpty() && !TextFNum.getText().isEmpty() && !TextFJefe.getText().isEmpty() && !TextFServ.getText().isEmpty()){
                DepartamentoVo dep = new DepartamentoVo();

                PreparedStatement ps = conex.getConnection().prepareStatement("INSERT INTO DEPARTAMENTO (nombre_dpto, num_emp_dpto, jefe_dpto, servicios) VALUES (?,?,?,?)");
                ps.setString(1,TextFNom.getText());
                ps.setInt(2,Integer.parseInt(TextFNum.getText()));
                ps.setString(3,TextFJefe.getText());
                ps.setString(4,TextFServ.getText());

                int insertado = ps.executeUpdate();
                if (insertado >=1) {
                    System.out.println("Registro insertado");
                } else {
                    System.out.println("No se ha podido realizar la inserción");
                }
                construirTabla();
                TextFId.setText(null);
                TextFNom.setText(null);
                TextFNum.setText(null);
                TextFJefe.setText(null);
                TextFServ.setText(null);
                
                JOptionPane.showMessageDialog(null, "Registro insertado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.desconectar();
        }
    }//GEN-LAST:event_BtnInsertarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        Conexion conex = new Conexion();
        try{
            if(!TextFId.getText().isEmpty() && !TextFNom.getText().isEmpty() && !TextFNum.getText().isEmpty() && !TextFJefe.getText().isEmpty() && !TextFServ.getText().isEmpty()){
                PreparedStatement ps = conex.getConnection().prepareStatement("UPDATE departamento SET nombre_dpto = ?, num_emp_dpto = ?, jefe_dpto = ?, servicios = ? WHERE id_dpto = ?");

                ps.setString(1, TextFNom.getText());
                ps.setInt(2, Integer.valueOf(TextFNum.getText()));
                ps.setString(3, TextFJefe.getText());
                ps.setString(4, TextFServ.getText());
                ps.setInt(5, Integer.valueOf(TextFId.getText()));

                ps.executeUpdate();

                construirTabla();
                TextFId.setText(null);
                TextFNom.setText(null);
                TextFNum.setText(null);
                TextFJefe.setText(null);
                TextFServ.setText(null);
                
                JOptionPane.showMessageDialog(null, "Registro modificado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Escribe en 'Id' el Id del departamento a modificar y carga los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.desconectar();
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
        Conexion conex = new Conexion();
        try{
            if(!TextFId.getText().isEmpty()){
               String[] botones = {"Sí", "No"};
               int opcion = JOptionPane.showOptionDialog(this, "¿Estás seguro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, null);
               if(opcion == 0){
                   PreparedStatement ps = conex.getConnection().prepareStatement("DELETE FROM DEPARTAMENTO WHERE id_dpto = ?");
                   ps.setInt(1, Integer.parseInt(TextFId.getText()));

                   int filActualizadas = ps.executeUpdate();

                   if(filActualizadas >= 1){
                       TextFId.setText(null);
                       TextFNom.setText(null);
                       TextFNum.setText(null);
                       TextFJefe.setText(null);
                       TextFServ.setText(null);

                       JOptionPane.showMessageDialog(this, "Departamento eliminado", "Completado", JOptionPane.PLAIN_MESSAGE);
                   }
               construirTabla();
               }else{
                       TextFId.setText(null);
                       TextFNom.setText(null);
                       TextFNum.setText(null);
                       TextFJefe.setText(null);
                       TextFServ.setText(null);                
               }  
            }else{
                JOptionPane.showMessageDialog(null, "Escribe en 'Id' el Id del departamento a borrar y carga los datos", "Error", JOptionPane.ERROR_MESSAGE);                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            conex.desconectar();
        }
    }//GEN-LAST:event_BtnBorrarActionPerformed

    private void BtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarActionPerformed
            construirTabla();
            JOptionPane.showMessageDialog(null, "Datos cargados en la tabla", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnMostrarActionPerformed

    private void BtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarActionPerformed
        Conexion conex = new Conexion();       
        try {
            if(!TextFId.getText().isEmpty()){
                PreparedStatement ps = conex.getConnection().prepareStatement("SELECT nombre_dpto, num_emp_dpto, jefe_dpto, servicios FROM departamento WHERE id_dpto = ?");
                ps.setInt(1, Integer.valueOf(TextFId.getText()));

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    TextFNom.setText(rs.getString("nombre_dpto"));
                    TextFNum.setText(String.valueOf(rs.getInt("num_emp_dpto")));
                    TextFJefe.setText(rs.getString("jefe_dpto"));
                    TextFServ.setText(rs.getString("servicios"));
                }           
            }else{
                JOptionPane.showMessageDialog(null, "Introduce un Id", "Error", JOptionPane.ERROR_MESSAGE);                
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(VentanaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            conex.desconectar();
        }
    }//GEN-LAST:event_BtnCargarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Barra;
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnCargar;
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnMostrar;
    private javax.swing.JPanel PanelPpal;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField TextFId;
    private javax.swing.JTextField TextFJefe;
    private javax.swing.JTextField TextFNom;
    private javax.swing.JTextField TextFNum;
    private javax.swing.JTextField TextFServ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
