/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import conexion.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.FuncionE;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author krizz
 */
public class ControlarFuncion {
    private Conexion conexio;
    
    public ControlarFuncion(){
    
        this.setConexion(Conexion.nuevaInstancia());
    
    }
    

    
    private void setConexion(Conexion nuevaConexion){
    this.conexio = nuevaConexion;
    }
    
    private Conexion getConexion(){
    
    return this.conexio;
    
    }
    
    public boolean agregarFuncion(FuncionE nuevaFuncionE){
    boolean salida = false;
    
    
    try{  PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
        
                "INSERT INTO funcion (fecha,horainicio,horafinal,acti_fun,id_sala,id_pelicula) VALUES (?,?,?,?,?,?)"
        );
    
        pstm.setDate(1, (Date) nuevaFuncionE.getFecha());
        pstm.setString(2, nuevaFuncionE.getHorainicio());
        pstm.setString(3, nuevaFuncionE.getHorafinal());
        pstm.setInt(4, nuevaFuncionE.getActi_fun());
        pstm.setInt(5, nuevaFuncionE.getSala());
        pstm.setInt(6, nuevaFuncionE.getId_pelicula());
        
        if(pstm.executeUpdate()== 1){
            
        salida = true;
        
        }
    
    }
    
    catch(ClassNotFoundException e){
    
        System.out.println("Clase no encontrada" +e.getMessage());
    }
    catch(SQLException e){
        
        System.out.println(String.format("Error SQL %s : %s ", e.getSQLState(),e.getMessage()));
    
            
    }
    
    catch(Exception e){
        System.out.println("Otra excepcion" +e.getMessage());
    
    }
    finally{
    
    this.getConexion().cerrarConexion();
    
    }
    return salida;
    
    }
    
    
    
    public boolean modificarFuncion(FuncionE nuevaFuncionE){
     boolean salida = false;
        try{
        PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
        "UPDATE funcion SET fecha = ?,horainicio = ?,acti_fun = ?,id_sala = ?, horafinal = ?, id_pelicula = ? WHERE id_funcion = ?"
        );
        pstm.setDate(1, (Date) nuevaFuncionE.getFecha());
        pstm.setString(2, nuevaFuncionE.getHorainicio());
        pstm.setInt(3, nuevaFuncionE.getActi_fun());
        pstm.setInt(4, nuevaFuncionE.getSala());
        pstm.setString(5, nuevaFuncionE.getHorafinal());
        pstm.setInt(6, nuevaFuncionE.getId_pelicula());
        if(pstm.executeUpdate()==1){
        salida = true;
        }
        }
     
     catch(ClassNotFoundException e){
        
            System.out.println("Clase no encontrada"+e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(String.format("ERROR SQL %s : %s",e.getSQLState(),e.getMessage()));
        }
        
        catch (Exception e){
            System.out.println("Otra excepcion");
        }
        finally{this.getConexion().cerrarConexion();}
    return salida;
      }
    
    
    public boolean eliminarFuncion(int id){
        boolean salida = false;
        try {
            
        PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                "DELETE FROM funcion WHERE id_funcion = ?");
        
        pstm.setInt(1, id);
        if(pstm.executeUpdate()== 1){
        salida = true;
        }
        } catch(ClassNotFoundException e){
        
            System.out.println("Clase no encontrada"+e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(String.format("ERROR SQL %s : %s",e.getSQLState(),e.getMessage()));
        }
        
        catch (Exception e){
            System.out.println("Otra excepcion");
        }
        finally{this.getConexion().cerrarConexion();}
    return salida;
    }
    
    public FuncionE buscarFuncion(int id){
    FuncionE encontrada = null;
        try{
        PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                "SELECT id_funcion,fecha,horainicio,horafinal,acti_fun,id_sala,id_pelicula from funcion where id_funcion ="+id);
        ResultSet rs = pstm.executeQuery();
        if(rs.first()){
        
        encontrada = new FuncionE(
        rs.getInt(1),
        rs.getDate(2),
        rs.getString(3),
        rs.getString(4),
        rs.getInt(5),
        rs.getInt(6),
        rs.getInt(7)
        );
        }
        }
    catch(ClassNotFoundException e){
        
            System.out.println("Clase no encontrada"+e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(String.format("ERROR SQL:" +e.getSQLState()+e.getMessage()));
        }
        
        catch (Exception e){
            System.out.println("Otra excepcion");
        }
        finally{this.getConexion().cerrarConexion();}
        return encontrada;
    
    }
    
    public List<FuncionE> listarFunciones(){
        List<FuncionE> funciones = new ArrayList<FuncionE>();
        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().
                    prepareStatement(
                   "SELECT id_funcion,fecha,horainicio,horafinal,acti_fun,id_sala,id_pelicula FROM funcion ");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
        FuncionE temp = new FuncionE(
        rs.getInt(1),
        rs.getDate(2),
        rs.getString(3),
        rs.getString(4),
        rs.getInt(5),
        rs.getInt(6),
        rs.getInt("id_pelicula")
        );
        funciones.add(temp);
        }
        } 
        
        catch(ClassNotFoundException e){
        
            System.out.println("Clase no encontrada"+e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(String.format("ERROR SQL %s : %s",e.getSQLState(),e.getMessage()));
        }
        
        catch (Exception e){
            System.out.println("Otra excepcion");
        }
        finally{this.getConexion().cerrarConexion();}
    return funciones;
    }
    
        public List<FuncionE> listarFuncion(){
        List<FuncionE> funciones = new ArrayList<FuncionE>();
        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().
                    prepareStatement(
                   "SELECT * FROM basecine.funcion join basecine.pelicula "
                            + "using (id_pelicula) join basecine.sala "
                            + "using(id_sala) join basecine.asi_sala "
                            + "using(id_sala) join basecine.asiento "
                            + "using(id_asiento)");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
        FuncionE temp = new FuncionE(
        rs.getString("horainicio")
        );
        funciones.add(temp);
        }
        } 
        
        catch(ClassNotFoundException e){
        
            System.out.println("Clase no encontrada"+e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(String.format("ERROR SQL %s : %s",e.getSQLState(),e.getMessage()));
        }
        
        catch (Exception e){
            System.out.println("Otra excepcion");
        }
        finally{this.getConexion().cerrarConexion();}
    return funciones;
    }
    
    
    
    
    
    
    }

    
    
