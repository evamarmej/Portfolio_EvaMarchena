package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.TallerVo;


public class TallerDAO { //Clase que contiene los métodos de los trabajos 
    public TallerVo taller;
    
    
    public ArrayList<TallerVo> buscarTrabajos(){ // Método para seleccionar todos los trabajos de la tabla y añadirlos a una lista
        Conexion conex = new Conexion();
        
        ArrayList<TallerVo> miLista = new ArrayList<>();

        
        try{
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trabajos");
            
            while(rs.next()){
                taller = new TallerVo();
                taller.setIdtr(Integer.parseInt(rs.getString("idtr")));
                taller.setDescripcion(rs.getString("descripcion"));
                taller.setNumhoras(Float.parseFloat(rs.getString("numhoras")));
                taller.setPrecio(Float.parseFloat(rs.getString("precio")));
                taller.setPreciomaterial(Float.parseFloat(rs.getString("preciomaterial")));
                taller.setTipotrabajo(rs.getString("tipotrabajo"));
                taller.setEstado(rs.getString("estado"));
                taller.setFechacomienzo(rs.getString("fechacomienzo"));
                taller.setFechafin(rs.getString("fechafin"));
                taller.setIdopt(Integer.parseInt(rs.getString("idopt")));    
                miLista.add(taller);
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
    
    public TallerVo cargarRegistro (int idtr){ //Método para cargar un operario de la tabla, filtrando por id de trabajo
        Conexion conex = new Conexion();
        taller = new TallerVo();
        
        try{
            PreparedStatement ps = conex.getConnection().prepareStatement("SELECT * FROM trabajos WHERE idtr = ?");
            ps.setInt(1, idtr);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                taller.setIdtr(idtr);
                taller.setDescripcion(rs.getString("descripcion"));
                taller.setNumhoras(rs.getFloat("numhoras"));
                taller.setPrecio(rs.getFloat("precio"));
                taller.setPreciomaterial(rs.getFloat("preciomaterial"));
                taller.setTipotrabajo(rs.getString("tipotrabajo"));
                taller.setEstado(rs.getString("estado"));
                taller.setFechacomienzo(rs.getString("fechacomienzo"));
                taller.setFechafin(rs.getString("fechafin"));
                taller.setIdopt(rs.getInt("idopt"));
            }
            ps.close();
            rs.close();
            conex.desconectar();          
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Introduce un Id", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        return taller;
    }
    
    public void insertar(TallerVo taller){ // Método para insertar un trabajo en la bbdd
    Conexion conex = new Conexion();
    //taller = new TallerVo();
    
    try{
        PreparedStatement ps = conex.getConnection().prepareStatement("INSERT INTO trabajos (descripcion, numhoras, precio, preciomaterial, tipotrabajo, estado, fechacomienzo, fechafin, idopt) VALUES (?,?,?,?,?,?,?,?,?)");
        
        ps.setString(1, taller.getDescripcion());
        ps.setFloat(2, taller.getNumhoras());
        ps.setFloat(3, taller.getPrecio());
        ps.setFloat(4, taller.getPreciomaterial());
        ps.setString(5, taller.getTipotrabajo());
        ps.setString(6, taller.getEstado());
        ps.setString(7, taller.getFechacomienzo());
        ps.setString(8, taller.getFechafin());
        ps.setInt(9, taller.getIdopt());
        
        
        ps.executeUpdate();
        ps.close();
        conex.desconectar(); 
        
    }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }       
            
            
    public void modificar(TallerVo taller){ // Método para modificar un trabajo en la bbdd
        Conexion conex = new Conexion();
        
        try{
            PreparedStatement ps = conex.getConnection().prepareStatement("UPDATE trabajos SET descripcion = ?, numhoras = ?, precio = ?, preciomaterial = ?, tipotrabajo = ?, estado = ?, fechacomienzo = ?, fechafin = ?, idopt = ? WHERE idtr = ?");

            ps.setString(1, taller.getDescripcion());
            ps.setFloat(2, taller.getNumhoras());
            ps.setFloat(3, taller.getPrecio());
            ps.setFloat(4, taller.getPreciomaterial());
            ps.setString(5, taller.getTipotrabajo());
            ps.setString(6, taller.getEstado());
            ps.setString(7, taller.getFechacomienzo());
            ps.setString(8, taller.getFechafin());
            ps.setInt(9, taller.getIdopt());
            ps.setInt(10, taller.getIdtr());
            
            ps.executeUpdate();
            ps.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    

}


