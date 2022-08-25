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
import model.Cliente;
/**
 *
 * @author Branco
 */
public class ControladorCliente {
    private Conexion conexio;

    public ControladorCliente() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }
    
    public void RegistrarCliente(int p_id_persona) {

        int id = 0;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO cliente(id_persona) VALUES (?)"
            );

            pstm.setInt(1, p_id_persona);

            pstm.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s ", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion" + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();
        }
    }
    
    public boolean verificaExistencia(int p_id_persona) {
        boolean existe = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_cliente FROM cliente WHERE id_persona = ?"
            );
            pstm.setInt(1, p_id_persona);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                existe = true;

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

        return existe;
    }
    
    public boolean verificaExistenciaRun(String run) {
        boolean existe = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT c.id_cliente FROM cliente c INNER JOIN persona p USING(id_persona) WHERE p.run = ?;"
            );
            pstm.setString(1, run);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                existe = true;

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

        return existe;
    }
}
