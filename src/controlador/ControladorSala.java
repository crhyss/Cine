/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import com.mysql.cj.protocol.Resultset;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Sala;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author krizz
 */
public class ControladorSala {
    private Conexion conexio;
    
    public ControladorSala(){
    this.setConexio(Conexion.nuevaInstancia());
    }
    public Conexion getConexio() {
        return conexio;
    }
    public void setConexio(Conexion conexio) {
        this.conexio = conexio;
    }
    
    public List<Sala> listarSala(){
    List<Sala> salas = new ArrayList<Sala>();
        try {
            PreparedStatement pstm = this.getConexio().obtenercConnection().prepareStatement(
                    "Select id_sala,nombre,acti_sala FROM sala");
            ResultSet rs =  pstm.executeQuery();
            if(rs.next()){
            do{ Sala listaTemporal = new Sala(rs.getInt(1), rs.getInt(3));
            salas.add(listaTemporal);
            } while (rs.next());
            return salas;
            }else{return null;}
            
        
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {

            System.out.println(String.format("Error SQL $s : $s", e.getSQLState(), e.getMessage()));

        } catch (Exception e) {

            System.out.println("Otra excepcion " + e.getMessage());
        } finally {

           this.getConexio().cerrarConexion();

        }
    return salas;
    
    }
    
    
}
