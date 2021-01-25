package dao;

import conexion.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vo.DepartamentoVo;

public class DepartamentoDAO {
    
    public ArrayList<DepartamentoVo> buscarUsuarios(){
        
        Conexion conex = new Conexion();
        
        ArrayList<DepartamentoVo> miLista = new ArrayList<>();
        DepartamentoVo departamento;
        
        try{
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM departamento");
            
            while (rs.next()){
                departamento = new DepartamentoVo();
                departamento.setId_dpto(Integer.parseInt(rs.getString("id_dpto")));
                departamento.setNombre_dpto(rs.getString("nombre_dpto"));
                departamento.setNum_emp_dpto(Integer.parseInt(rs.getString("num_emp_dpto")));
                departamento.setJefe_dpto(rs.getString("jefe_dpto"));
                departamento.setServicios(rs.getString("servicios"));
                miLista.add(departamento);
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
    
    public String[][] obtenerDatos() {
        try{
            DepartamentoDAO miDepartamentoDao=new DepartamentoDAO();
            ArrayList <DepartamentoVo> miLista = miDepartamentoDao.buscarUsuarios();

            String Datos[][]=new String[miLista.size()][5];

            for (int i = 0; i < miLista.size(); i++) {
                    Datos[i][0]=miLista.get(i).getId_dpto()+"";
                    Datos[i][1]=miLista.get(i).getNombre_dpto()+"";
                    Datos[i][2]=miLista.get(i).getNum_emp_dpto()+"";
                    Datos[i][3]=miLista.get(i).getJefe_dpto()+"";
                    Datos[i][4]=miLista.get(i).getServicios()+"";
            }
            return Datos;
        }catch (ArrayIndexOutOfBoundsException excep) {
                System.out.println("Accesando a una posición fuera del vector");
        }
        return null;
    }  
   
}
