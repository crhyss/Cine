/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Empleado;

/**
 *
 * @author Branco
 */
public class ControladorEmp {
    
    private Conexion conexio;

    public ControladorEmp() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }
    
    public int RegistrarEmpU(Empleado emp, int p_id_persona) {

        int id = 0;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO emp(edad, estado_civil, genero, id_persona) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );

            pstm.setInt(1, emp.getEdad());
            pstm.setString(2, emp.getEst_civil());
            pstm.setString(3, emp.getGenero());
            pstm.setInt(4, p_id_persona);

            if (pstm.executeUpdate() == 1) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s ", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion" + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();
        }
        return id;
    }
    
    public int ModificarEmpU(Empleado emp, int p_id_emp){
        int id = 0;
            
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE emp SET edad = ?, estado_civil = ?, genero = ? WHERE id_empleado = ?"
            );
            
            pstm.setInt(1, emp.getEdad());
            pstm.setString(2, emp.getEst_civil());
            pstm.setString(3, emp.getGenero());    
            pstm.setInt(4, p_id_emp);
            
            if (pstm.executeUpdate() == 1) {

                id = buscarEmpleado(p_id_emp).getId_persona();

            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otro error" + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();

        }
        return id;
    }
    
    public int EliminarEmpU(int p_id_emp) {
        int id = 0;
        int t_id = buscarEmpleado(p_id_emp).getId_persona();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "DELETE FROM emp WHERE id_empleado = ?"
            );
            
            pstm.setInt(1, p_id_emp);
            if(pstm.executeUpdate() == 1){
                id = t_id;
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion" + e.getMessage());
        }
        return id;
    }
    
    public Empleado buscarEmpleado(int p_id_emp) {

        Empleado emp = null;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_empleado, edad, estado_civil, genero, id_persona FROM emp WHERE id_empleado = ?"
            );
            pstm.setInt(1, p_id_emp);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                emp = new Empleado(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );

            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion " + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();
        }
        return emp;
    }
    
    public int obtenerId_empleado(String run){
        int id = 0;
            try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT e.id_empleado FROM emp e INNER JOIN persona p USING (id_persona) "
                    + "INNER JOIN direccion d USING (id_direccion) WHERE p.run = ?"
            );
            pstm.setString(1, run);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                id = rs.getInt(1);

            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion " + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();
        }
        return id;
    }
}
