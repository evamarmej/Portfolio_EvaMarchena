package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    static String bd = "empresa";
    static String login = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3305/"+bd+"?serverTimezone=UTC";
    
    Connection con = null;

    //Constructor
    public Conexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, password);
            
            if(con != null){
                System.out.println("Conexión a base de datos" + bd + " OK");
            }
        }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
    }
    
    //Permite retornar la conexión
    public Connection getConnection(){return con;}
    public void desconectar(){con = null;}
  
}
