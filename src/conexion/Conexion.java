/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author krizz
 */
public class Conexion {
    private static Conexion conexion;
    private Connection con;
    private Conexion(){}
    
    
    
    public static Conexion nuevaInstancia(){
    
        if(conexion == null){
            return new Conexion();
        }
        return conexion;
    }
    
    private void abrirConexion() throws ClassNotFoundException, SQLException{
    if(this.con== null || this.con.isClosed()){
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    this.con = DriverManager.getConnection("jdbc:mysql://168.138.149.15:3306/basecine","cine_in","CineIn__//1");
    }
    
    }
    
    public Connection obtenercConnection() throws ClassNotFoundException, SQLException{
    
    
        abrirConexion();
        return this.con;
    }
    
    public void cerrarConexion(){
    
    try{
    
        if(!this.con.isClosed()){
    this.con.close();
    }
        
    }
    catch(SQLException e){
        System.out.println("Error de SQL"+e.getMessage()+ "Error de SQL" + e.getSQLState() );}
    }
    
}
