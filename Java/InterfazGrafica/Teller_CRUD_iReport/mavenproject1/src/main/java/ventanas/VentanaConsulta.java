package ventanas;

import conexion.Conexion;
import controles.controles;
import dao.OperarioDAO;
import dao.TallerDAO;
import vo.TallerVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import vo.OperarioVo;

public class VentanaConsulta extends JFrame implements ActionListener {
    TallerVo taller; 
    OperarioVo operario;
    TallerDAO dao = new TallerDAO();
    OperarioDAO opdao = new OperarioDAO();
    controles control = new controles();
    

    public VentanaConsulta() {  //Creación de la ventana y asignación de características
        setSize(800,400); 
        setTitle("Taller"); 
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        textPre.setEnabled(false); // El campo precio aparece desactivado porque se calcula solo
        textFecFin.setEnabled(false); //El campo fecha fin aparece desactivado porque se calcula solo
    }
       
    public String[][] obtenerDatosTaller(){ // Obtener los datos de trabajos
        TallerDAO mitallerDAO = new TallerDAO();
        ArrayList <TallerVo> miLista = mitallerDAO.buscarTrabajos();

        String Datos[][] = new String[miLista.size()][10];

        for (int i = 0; i < miLista.size(); i++) {

            Datos[i][0] = miLista.get(i).getIdtr() + "";
            Datos[i][1] = miLista.get(i).getDescripcion() + "";
            Datos[i][2] = miLista.get(i).getNumhoras() + "";
            Datos[i][3] = miLista.get(i).getPrecio() + "";
            Datos[i][4] = miLista.get(i).getPreciomaterial() + "";
            Datos[i][5] = miLista.get(i).getTipotrabajo() + "";
            Datos[i][6] = miLista.get(i).getEstado() + "";
            Datos[i][7] = miLista.get(i).getFechacomienzo() + "";
            Datos[i][8] = miLista.get(i).getFechafin() + "";
            Datos[i][9] = miLista.get(i).getIdopt() + "";                

        }
        return Datos;
    }
    
    public void construirTablaTaller(){  //Construir la tabla de trabajos
       String titulos[] = {"Id", "Descripción", "Nº Horas", "Precio", "Precio Material", "Tipo trabajo", "Estado", "Fecha Inicio", "Fecha Fin", "Id operario"};
       String informacion [][] = obtenerDatosTaller();
       Tabla = new JTable(informacion, titulos);  
       Barra.setViewportView(Tabla);
    }
    
    public String[][] obtenerDatosOperarios(){  //Obtener los datos de Operarios
        OperarioDAO opdao = new OperarioDAO();
        ArrayList <OperarioVo> miLista = opdao.buscarOperarios();

        String Datos[][] = new String[miLista.size()][6];

        for (int i = 0; i < miLista.size(); i++) {

            Datos[i][0] = miLista.get(i).getIdop() + "";
            Datos[i][1] = miLista.get(i).getDni() + "";
            Datos[i][2] = miLista.get(i).getNombre() + "";
            Datos[i][3] = miLista.get(i).getApellidos() + "";
            Datos[i][4] = miLista.get(i).getDireccion() + "";
            Datos[i][5] = miLista.get(i).getTelefono() + "";           
        }
        return Datos;
    }
    
    public void construirTablaOperarios(){  // Construir la tabla operarios
       String titulos[] = {"Id", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono"};
       String informacion [][] = obtenerDatosOperarios();
       Tabla = new JTable(informacion, titulos);  
       Barra.setViewportView(Tabla);
    }
    
    public void resetVentanaRegistro(){ //Resetea los campos de la pestaña Registro para que aparezcan en blanco
        textIdT.setText(null);
        textDesc.setText(null);
        textHor.setText("0");
        textPre.setText("0.0");
        textPreMat.setText("0.0");
        combTiTr.setSelectedItem(null);
        combEst.setSelectedItem(null);
        textFecIni.setText(null);
        textFecFin.setText("0000-00-00");
        textIdOp.setText(null);        
    }
    
    public void resetVentanaOperarios(){ //Resetea los campos de la pestaña operarios para que aparezcan en blanco
        textDni.setText(null);
        textNom.setText(null);
        textApe.setText(null);
        textDir.setText(null);
        textTel.setText(null);
    }
    
    public void resetVentanaReportes(){ //Resetea los campos de la pestaña reportes para que aparezcan en blanco
        txtRepDNI.setText(null);
        txtRepFI.setText(null);
        txtRepFF.setText(null);
        txtRepIdOp.setText(null);
        combRep.setSelectedItem(null);
    }
    
    public void resetFieldsReportes(){ //Deshabilita los textfield de la pestaña reportes
        txtRepDNI.setEnabled(false);
        txtRepFI.setEnabled(false);
        txtRepFF.setEnabled(false);
        txtRepIdOp.setEnabled(false);  
    }

    //Componentes
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelRegistro = new javax.swing.JPanel();
        labIdT = new javax.swing.JLabel();
        textIdT = new javax.swing.JTextField();
        labDesc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDesc = new javax.swing.JTextArea();
        labTiTr = new javax.swing.JLabel();
        combTiTr = new javax.swing.JComboBox<>();
        labEst = new javax.swing.JLabel();
        combEst = new javax.swing.JComboBox<>();
        labIdOp = new javax.swing.JLabel();
        textIdOp = new javax.swing.JTextField();
        labFecIni = new javax.swing.JLabel();
        textFecIni = new javax.swing.JTextField();
        btnIns = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnCarId = new javax.swing.JButton();
        labPreMat = new javax.swing.JLabel();
        textPreMat = new javax.swing.JTextField();
        labHor = new javax.swing.JLabel();
        textHor = new javax.swing.JTextField();
        labFecFin = new javax.swing.JLabel();
        textFecFin = new javax.swing.JTextField();
        labPre = new javax.swing.JLabel();
        textPre = new javax.swing.JTextField();
        btnCalcula = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        panelOperarios = new javax.swing.JPanel();
        labDni = new javax.swing.JLabel();
        textDni = new javax.swing.JTextField();
        labNom = new javax.swing.JLabel();
        textNom = new javax.swing.JTextField();
        labApe = new javax.swing.JLabel();
        textApe = new javax.swing.JTextField();
        labDir = new javax.swing.JLabel();
        textDir = new javax.swing.JTextField();
        labTel = new javax.swing.JLabel();
        textTel = new javax.swing.JTextField();
        btnInsOp = new javax.swing.JButton();
        panelReportes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combRep = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        txtRepDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRepFI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRepFF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRepIdOp = new javax.swing.JTextField();
        Barra = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegistro.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelRegistroComponentShown(evt);
            }
        });

        labIdT.setText("Id");

        labDesc.setText("Descripción");

        textDesc.setColumns(13);
        textDesc.setRows(3);
        jScrollPane2.setViewportView(textDesc);

        labTiTr.setText("Tipo Trabajo");

        combTiTr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Reparación Mecánica", "Chapa y Pintura", "Revisión" }));

        labEst.setText("Estado");

        combEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "En proceso", "Finalizado" }));

        labIdOp.setText("Id operario");

        labFecIni.setText("Fecha inicio");

        btnIns.setText("Insertar");
        btnIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsActionPerformed(evt);
            }
        });

        btnMod.setText("Modificar");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnCarId.setText("Cargar Id");
        btnCarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarIdActionPerformed(evt);
            }
        });

        labPreMat.setText("Precio Material");

        textPreMat.setText("0.0");

        labHor.setText("Nº Horas");

        textHor.setText("0");

        labFecFin.setText("Fecha fin");

        textFecFin.setText("0000-00-00");

        labPre.setText("Precio total");

        textPre.setText("0.0");

        btnCalcula.setText("Calcular Precio");
        btnCalcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelRegistroLayout.createSequentialGroup()
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labIdT, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegistroLayout.createSequentialGroup()
                                    .addComponent(textIdT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCarId))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labFecIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labEst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labTiTr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labIdOp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labPreMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labHor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labFecFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labPre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combTiTr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combEst, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textIdOp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFecIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRegistroLayout.createSequentialGroup()
                                    .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textPreMat)
                                        .addComponent(textHor)
                                        .addComponent(textFecFin)
                                        .addComponent(textPre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCalcula)))))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnIns, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labIdT)
                    .addComponent(textIdT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labDesc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTiTr)
                    .addComponent(combTiTr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEst)
                    .addComponent(combEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labIdOp)
                    .addComponent(textIdOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labFecIni)
                    .addComponent(textFecIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPreMat)
                    .addComponent(textPreMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labHor)
                    .addComponent(textHor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labFecFin)
                    .addComponent(textFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPre)
                    .addComponent(textPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIns)
                    .addComponent(btnMod)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Registro", panelRegistro);

        panelOperarios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelOperariosComponentShown(evt);
            }
        });

        labDni.setText("DNI");

        labNom.setText("Nombre");

        labApe.setText("Apellidos");

        labDir.setText("Dirección");

        labTel.setText("Teléfono");

        btnInsOp.setText("Insertar");
        btnInsOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsOpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOperariosLayout = new javax.swing.GroupLayout(panelOperarios);
        panelOperarios.setLayout(panelOperariosLayout);
        panelOperariosLayout.setHorizontalGroup(
            panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperariosLayout.createSequentialGroup()
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperariosLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnInsOp))
                    .addGroup(panelOperariosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labDni, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labNom)
                            .addComponent(labApe)
                            .addComponent(labDir)
                            .addComponent(labTel))
                        .addGap(46, 46, 46)
                        .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNom)
                            .addComponent(textApe)
                            .addComponent(textDir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelOperariosLayout.setVerticalGroup(
            panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperariosLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDni)
                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNom)
                    .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labApe)
                    .addComponent(textApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDir)
                    .addComponent(textDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTel)
                    .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnInsOp)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Operarios", panelOperarios);

        panelReportes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelReportesComponentShown(evt);
            }
        });

        jLabel1.setText("Reporte");

        combRep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Reparaciones", "Trabajadores", "Trabajador por DNI", "Reparación por fecha inicial", "Reparación por fecha final", "Reparación por operario" }));
        combRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combRepActionPerformed(evt);
            }
        });

        btnReporte.setText("Crear Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI");

        jLabel3.setText("Fecha Inicio");

        jLabel4.setText("Fecha Fin");

        jLabel5.setText("Id Operario");

        javax.swing.GroupLayout panelReportesLayout = new javax.swing.GroupLayout(panelReportes);
        panelReportes.setLayout(panelReportesLayout);
        panelReportesLayout.setHorizontalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnReporte)
                        .addComponent(txtRepDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(txtRepFI)
                        .addComponent(txtRepFF)
                        .addComponent(txtRepIdOp))
                    .addComponent(combRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        panelReportesLayout.setVerticalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRepFI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRepFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRepIdOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addGap(130, 130, 130))
        );

        jTabbedPane1.addTab("Reportes", panelReportes);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id ", "Descripción", "Nº Horas", "Precio", "Precio Material", "Tipo trabajo", "Estado", "Fecha Inicio", "Fecha Fin", "Id operario"
            }
        ));
        Barra.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Barra, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Acciones cuando se pulsa el botón modificar en la pestaña registro
    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        taller = dao.cargarRegistro(Integer.parseInt(textIdT.getText())); //Carga el registro cuyo Id indicamos en el texfield Id
        
        if(taller.getEstado().equals("Finalizado")){ //Si el estado está finalizado muestra mensaje de error al modificar
            JOptionPane.showMessageDialog(null, "No es posible modificar porque el trabajo está Finalizado", "Error", JOptionPane.ERROR_MESSAGE);                   
        }  
        
        if(taller.getEstado().equals("En proceso")){ //Comprueba que el estado esté en proceso
            if(taller.getIdtr() != null){ //Comprueba que el Id del trabajo no esté en blanco
                if(control.validacionRegistros(textIdOp.getText(), textPreMat.getText(), textHor.getText())){ //Comprueba que sean números
                    if(combEst.getSelectedItem().equals("Finalizado") && textPre.getText().equals("0.0")){ //Si el estado está finalizado y el Precio está a 0 muestra error al modificar
                        JOptionPane.showMessageDialog(null, "Debes calcular el precio antes de finalizar el trabajo", "Error", JOptionPane.ERROR_MESSAGE);                            
                    }else{ // Si el estado no está finalizado y no muestra error al modificar, da a las variables el valor introducido en el textfield
                        taller.setDescripcion(textDesc.getText());
                        taller.setNumhoras(Float.parseFloat(textHor.getText()));
                        taller.setPrecio(Float.parseFloat(textPre.getText()));
                        taller.setPreciomaterial(Float.parseFloat(textPreMat.getText()));
                        taller.setTipotrabajo(String.valueOf(combTiTr.getSelectedItem()));
                        taller.setEstado(String.valueOf(combEst.getSelectedItem()));
                        taller.setFechacomienzo(textFecIni.getText());
                        taller.setFechafin(textFecFin.getText());
                        taller.setIdopt(Integer.parseInt(textIdOp.getText()));
                        taller.setIdtr(Integer.parseInt(textIdT.getText()));

                        if (combEst.getSelectedItem().equals("Finalizado")) { //Si el estado está finalizado actualiza la fecha con la fecha actual
                            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date();
                            taller.setFechafin(formato.format(date));
                        } else { //Si el estado no está finalizado muestra la fecha por defecto 0000-00-00
                            taller.setFechafin(textFecFin.getText());
                        }                
                        dao.modificar(taller); //Modifica el registro en la base de datos
                        construirTablaTaller(); //Refresca la tabla para que aparezca el registro ya modificado
                        resetVentanaRegistro(); //Resetea la pestaña para que los campos vuelvan a aparecer en blanco
                    }
                }
            }            
        }
    }//GEN-LAST:event_btnModActionPerformed

    //Acciones cuando se pulsa el botón insertar en la pestaña registro
    private void btnInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsActionPerformed
        if(control.validacionRegistros(textIdOp.getText(), textPreMat.getText(), textHor.getText())){ //Comprueba que sean números
            taller = new TallerVo(); //Crea un objeto de la clase TallerVo para acceder a las variables y les modifica su valor con los datos insertados en los campos
            taller.setDescripcion(textDesc.getText());
            taller.setNumhoras(Float.parseFloat(textHor.getText()));
            taller.setPrecio(Float.parseFloat(textPre.getText()));
            taller.setPreciomaterial(Float.parseFloat(textPreMat.getText()));
            taller.setTipotrabajo(String.valueOf(combTiTr.getSelectedItem()));
            taller.setEstado(String.valueOf(combEst.getSelectedItem()));
            taller.setFechacomienzo(textFecIni.getText());
            taller.setFechafin(textFecFin.getText());
            taller.setIdopt(Integer.parseInt(textIdOp.getText()));

            dao.insertar(taller); //Inserta el registro en la base de datos
            construirTablaTaller(); //Refresca la tabla para que aparezca el registro ya insertado
            resetVentanaRegistro(); //Resetea la pestaña para que los campos vuelvan a aparecer en blanco
        }

    }//GEN-LAST:event_btnInsActionPerformed

    //Acciones cuando se pulsa el botón Cargar id en la pestaña registro
    private void btnCarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarIdActionPerformed
        if(textIdT.getText().isEmpty()){ //Comprueba que el campo Id no esté vacío, y si lo está muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Debes introducir un ID", "Error", JOptionPane.ERROR_MESSAGE);            
        }else{ //Si el campo no está vacío, toma el valor del campo y lo busca en la base de datos para cargar cada dato en su campo correspondiente
            taller = dao.cargarRegistro(Integer.parseInt(textIdT.getText()));

           if(taller.getIdtr() != null){
               taller.setIdtr(Integer.parseInt(textIdT.getText()));
               textDesc.setText(taller.getDescripcion());
               textHor.setText(String.valueOf(taller.getNumhoras()));
               textPre.setText(String.valueOf(taller.getPrecio()));
               textPreMat.setText(String.valueOf(taller.getPreciomaterial()));
               combTiTr.setSelectedItem(taller.getTipotrabajo());
               combEst.setSelectedItem(taller.getEstado());
               textFecIni.setText(taller.getFechacomienzo());
               textFecFin.setText(taller.getFechafin());
               textIdOp.setText(String.valueOf(taller.getIdopt()));           
            }
        }
    }//GEN-LAST:event_btnCarIdActionPerformed

   //Acciones cuando se pulsa el botón Calcular precio en la pestaña registro    
    private void btnCalculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaActionPerformed
        //Variables
        float horas = Float.valueOf(textHor.getText());
        float material = Float.valueOf(textPreMat.getText());
        float precio = 0;
        
        if(combTiTr.getSelectedItem().equals("Reparación Mecánica")){ //Si el tipo de trabajo es "reparación mecánica"
            precio = (float) ((horas * 30)+ (material * 1.5)); // Calcula el precio
        }
        if(combTiTr.getSelectedItem().equals("Chapa y Pintura")){ //Si el tipo de trabajo es "chapa y pintura"
            precio = (horas * 30) + (material * 2); //Calcula el precio
        }
        if(combTiTr.getSelectedItem().equals("Revisión")){ //Si el tipo de trabajo es "revisión"
            precio = (float)((horas * 30) + 20.0); //Calcula el precio
        }
        
        if(combEst.getSelectedItem().equals("Finalizado")){ //Si el estado es "finalizado"
            textPre.setText(String.valueOf(precio)); //Muestra en el campo "precio" el resultado del cálculo
        }else{ //Sino muestra un error
            JOptionPane.showMessageDialog(null, "Para calcular el precio el Estado debe estar Finalizado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalculaActionPerformed

    //Acciones cuando se pulsa el botón Nuevo en la pestaña registro 
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        resetVentanaRegistro(); //Resetea la pestaña para que los campos vuelvan a aparecer en blanco
        construirTablaTaller(); //Refresca la tabla para que aparezca el registro ya insertado
    }//GEN-LAST:event_btnNuevoActionPerformed

    //Acciones cuando se pulsa el botón Insertar en la pestaña operarios    
    private void btnInsOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsOpActionPerformed
        //Si los campos no están vacíos
        if(!textDni.getText().isEmpty() && !textNom.getText().isEmpty() && !textApe.getText().isEmpty() && !textDir.getText().isEmpty() && !textTel.getText().isEmpty()){
            //Si los datos no son números
            if(control.validacionOperarios(textDni.getText(), textNom.getText(), textApe.getText(), textDir.getText(), textTel.getText())){
                operario = new OperarioVo();
                operario.setDni(textDni.getText());
                operario.setNombre(textNom.getText());
                operario.setApellidos(textApe.getText());
                operario.setDireccion(textDir.getText());
                operario.setTelefono(textTel.getText());

                opdao.insertar(operario); //Inserta el registro en la base de datos con los datos introducidos en los campos
                resetVentanaOperarios(); //Resetea la pestaña para que los campos vuelvan a aparecer en blanco
                construirTablaOperarios(); //Refresca la tabla para que aparezca el registro ya insertado              
            }
        }else{ //Si algún campo está vacío muestra mensaje de error
            JOptionPane.showMessageDialog(null, "Registro NO insertado. Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsOpActionPerformed

    //Acciones cuando se muestra el panel de operarios
    private void panelOperariosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelOperariosComponentShown
        construirTablaOperarios();
    }//GEN-LAST:event_panelOperariosComponentShown

    //Acciones cuando se muestra el panel de registros
    private void panelRegistroComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelRegistroComponentShown
        construirTablaTaller();
    }//GEN-LAST:event_panelRegistroComponentShown
    
    //Acciones cuando se muestra el botón Crear reporte en la pestaña reportes
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        //Si el reporte seleccionado es "reparaciones"
        if(combRep.getSelectedItem().equals("Reparaciones")){  
            try{
                JasperReport archivo = JasperCompileManager.compileReport("Reparaciones.jrxml");
                Map <String, Object> map = new HashMap<>();
                map.put("Logo", "logo.png");
                Conexion con = new Conexion();
                JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                JasperExportManager.exportReportToPdfFile(prin, "reparaciones.pdf");
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "reparaciones.pdf");
                resetVentanaReportes();
            }catch (JRException ex){
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si el reporte seleccionado es "trabajadores"
        if(combRep.getSelectedItem().equals("Trabajadores")){    
            try{
                JasperReport archivo = JasperCompileManager.compileReport("Trabajadores.jrxml");
                Map <String, Object> map = new HashMap<>();
                map.put("Logo", "logo.png");
                Conexion con = new Conexion();
                JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                JasperExportManager.exportReportToPdfFile(prin, "trabajadores.pdf");
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "trabajadores.pdf");
                resetVentanaReportes();
            }catch (JRException ex){
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si el reporte seleccionado es "trabajador por DNI"
        if(combRep.getSelectedItem().equals("Trabajador por DNI")){  
            if(txtRepDNI.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debes insertar un DNI", "Error", JOptionPane.ERROR_MESSAGE);                
            }else{
                try{
                    JasperReport archivo = JasperCompileManager.compileReport("TrabajadorPorDNI.jrxml");
                    Map <String, Object> map = new HashMap<>();
                    map.put("dni", txtRepDNI.getText());
                    map.put("Logo", "logo.png");
                    Conexion con = new Conexion();
                    JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                    JasperExportManager.exportReportToPdfFile(prin, "trabajadorDni.pdf");
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "trabajadorDni.pdf");
                    resetVentanaReportes();
                }catch (JRException ex){
                    ex.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }

        }
        //Si el reporte seleccionado es "reparación por fehca inicial"
        if(combRep.getSelectedItem().equals("Reparación por fecha inicial")){ 
            if(txtRepFI.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debes insertar una fecha de inicio", "Error", JOptionPane.ERROR_MESSAGE);                 
            }else{
                try{
                    JasperReport archivo = JasperCompileManager.compileReport("ReparacionPorFechaIni.jrxml");
                    Map <String, Object> map = new HashMap<>();
                    map.put("fechaini", txtRepFI.getText());
                    map.put("Logo", "logo.png");
                    Conexion con = new Conexion();
                    JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                    JasperExportManager.exportReportToPdfFile(prin, "reparacionfechainicio.pdf");
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "reparacionfechainicio.pdf");
                    resetVentanaReportes();
                }catch (JRException ex){
                    ex.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }

        }  
        //Si el reporte seleccionado es "reparación por fecha final"
        if(combRep.getSelectedItem().equals("Reparación por fecha final")){
            if(txtRepFF.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debes insertar una fecha de finalización", "Error", JOptionPane.ERROR_MESSAGE);                
            }else{
                try{
                    JasperReport archivo = JasperCompileManager.compileReport("ReparacionPorFechaFin.jrxml");
                    Map <String, Object> map = new HashMap<>();
                    map.put("fechafin", txtRepFF.getText());
                    map.put("Logo", "logo.png");
                    Conexion con = new Conexion();
                    JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                    JasperExportManager.exportReportToPdfFile(prin, "reparacionfechafinal.pdf");
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "reparacionfechafinal.pdf");
                    resetVentanaReportes();
                }catch (JRException ex){
                    ex.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }
        //Si el reporte seleccionado es "reparación por operario"
        if(combRep.getSelectedItem().equals("Reparación por operario")){
            if(txtRepIdOp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debes insertar un ID de operario", "Error", JOptionPane.ERROR_MESSAGE);                
            }else{
                try{
                    JasperReport archivo = JasperCompileManager.compileReport("ReparacionPorOperario.jrxml");
                    Map <String, Object> map = new HashMap<>();
                    map.put("operario", txtRepIdOp.getText());
                    map.put("Logo", "logo.png");
                    Conexion con = new Conexion();
                    JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                    JasperExportManager.exportReportToPdfFile(prin, "reparacionporoperario.pdf");
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "reparacionporoperario.pdf");
                    resetVentanaReportes();
                }catch (JRException ex){
                    ex.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }   
    }//GEN-LAST:event_btnReporteActionPerformed

    // Acciones cuando se selecciona una acción de la lista desplegable de la pestaña registros
    private void combRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combRepActionPerformed
        //Si se selecciona el Item en blanco
        if(combRep.getSelectedItem().equals("")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes
        }
        // Si se selecciona el Item "Reparaciones"
        if(combRep.getSelectedItem().equals("Reparaciones")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes
        }
       // Si se selecciona el Item "Trabajadores"
        if(combRep.getSelectedItem().equals("Trabajadores")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes     
        }
       // Si se selecciona el Item "Trabajador por DNI"
        if(combRep.getSelectedItem().equals("Trabajador por DNI")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes               
            txtRepDNI.setEnabled(true); //Habilita el campo DNI
        }
       // Si se selecciona el Item "Reparación por fecha inicial"
        if(combRep.getSelectedItem().equals("Reparación por fecha inicial")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes     
            txtRepFI.setEnabled(true); //Habilita el campo Fecha inicial
        }
       // Si se selecciona el Item "Reparación por fecha final"
        if(combRep.getSelectedItem().equals("Reparación por fecha final")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes     
            txtRepFF.setEnabled(true); //Habilita el campo Fecha final   
        }
       // Si se selecciona el Item "Reparación por operario"
        if(combRep.getSelectedItem().equals("Reparación por operario")){
            resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes     
            txtRepIdOp.setEnabled(true); //Habilita el campo Operario           
        }
    }//GEN-LAST:event_combRepActionPerformed

    //Acciones cuando se muestra la pestaña Reportes
    private void panelReportesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelReportesComponentShown
        resetFieldsReportes(); // Deshabilita todos los campos de la pestaña reportes                   
    }//GEN-LAST:event_panelReportesComponentShown

    public static void main(String args[]) { //Método main
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Barra;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnCalcula;
    private javax.swing.JButton btnCarId;
    private javax.swing.JButton btnIns;
    private javax.swing.JButton btnInsOp;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> combEst;
    private javax.swing.JComboBox<String> combRep;
    private javax.swing.JComboBox<String> combTiTr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labApe;
    private javax.swing.JLabel labDesc;
    private javax.swing.JLabel labDir;
    private javax.swing.JLabel labDni;
    private javax.swing.JLabel labEst;
    private javax.swing.JLabel labFecFin;
    private javax.swing.JLabel labFecIni;
    private javax.swing.JLabel labHor;
    private javax.swing.JLabel labIdOp;
    private javax.swing.JLabel labIdT;
    private javax.swing.JLabel labNom;
    private javax.swing.JLabel labPre;
    private javax.swing.JLabel labPreMat;
    private javax.swing.JLabel labTel;
    private javax.swing.JLabel labTiTr;
    private javax.swing.JPanel panelOperarios;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JTextField textApe;
    private javax.swing.JTextArea textDesc;
    private javax.swing.JTextField textDir;
    private javax.swing.JTextField textDni;
    private javax.swing.JTextField textFecFin;
    private javax.swing.JTextField textFecIni;
    private javax.swing.JTextField textHor;
    private javax.swing.JTextField textIdOp;
    private javax.swing.JTextField textIdT;
    private javax.swing.JTextField textNom;
    private javax.swing.JTextField textPre;
    private javax.swing.JTextField textPreMat;
    private javax.swing.JTextField textTel;
    private javax.swing.JTextField txtRepDNI;
    private javax.swing.JTextField txtRepFF;
    private javax.swing.JTextField txtRepFI;
    private javax.swing.JTextField txtRepIdOp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
