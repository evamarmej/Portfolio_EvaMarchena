package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.OperarioVo;


public class OperarioDAO { //Clase que contiene los métodos de los operarios
    public OperarioVo operario;
    
    public ArrayList<OperarioVo> buscarOperarios(){ // Método para seleccionar todos los operarios de la tabla y añadirlos a una lista
    Conexion conex = new Conexion();

    ArrayList<OperarioVo> miLista = new ArrayList<>();


    try{
        Statement st = conex.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM operarios");

        while(rs.next()){
            operario = new OperarioVo();
            operario.setIdop(Integer.parseInt(rs.getString("idop")));
            operario.setDni(rs.getString("dni"));
            operario.setNombre(rs.getString("nombre"));
            operario.setApellidos(rs.getString("apellidos"));
            operario.setDireccion(rs.getString("direccion"));  
            operario.setTelefono(rs.getString("telefono"));
            miLista.add(operario);
        }
        rs.close();
        st.close();
        conex.desconectar();        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
        JOptionPane.ERROR_MESSAGE);
    }
    return miLista;
    }
    
    public void insertar(OperarioVo operario){  // Método para insertar un operario en la bbdd
        Conexion conex = new Conexion();
        //taller = new TallerVo();

        try{
            PreparedStatement ps = conex.getConnection().prepareStatement("INSERT INTO operarios (dni, nombre, apellidos, direccion, telefono) VALUES (?,?,?,?,?)");

            ps.setString(1, operario.getDni());
            ps.setString(2, operario.getNombre());
            ps.setString(3, operario.getApellidos());
            ps.setString(4, operario.getDireccion());
            ps.setString(5, operario.getTelefono());


            ps.executeUpdate();
            ps.close();
            conex.desconectar(); 

        }catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al insertar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }  
    
    public OperarioVo cargarRegistro (int idop){ //Método para cargar un registro de la tabla, filtrando por id de operario
    Conexion conex = new Conexion();
    operario = new OperarioVo();

    try{
        PreparedStatement ps = conex.getConnection().prepareStatement("SELECT * FROM operarios WHERE idop = ?");
        ps.setInt(1, idop);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            operario.setIdop(idop);
            operario.setDni(rs.getString("dni"));
            operario.setNombre(rs.getString("nombre"));
            operario.setApellidos(rs.getString("apellidos"));
            operario.setDireccion(rs.getString("direccion"));
            operario.setTelefono(rs.getString("telefono"));
        }
        ps.close();
        rs.close();
        conex.desconectar();          

    }catch (SQLException ex) {
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Introduce un Id", "Error",
        JOptionPane.ERROR_MESSAGE);
    }
    return operario;
    }
}
