package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    static String bd = "taller";
    static String login = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3305/"+bd+"?serverTimezone=UTC";
    
    Connection con = null;


    public Conexion() { //Constructor
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
    
    public Connection getConnection(){return con;} //Permite retornar la conexión
    public void desconectar(){con = null;}
  
}
