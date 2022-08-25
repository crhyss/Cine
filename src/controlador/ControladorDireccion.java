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
import model.Direccion;

/**
 *
 * @author Branco
 */
public class ControladorDireccion {

    private Conexion conexio;

    public ControladorDireccion() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public int RegistrarDirU(Direccion d) {

        int id = 0;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO direccion(calle, numero, id_comuna) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );

            pstm.setString(1, d.getCalle());
            pstm.setInt(2, d.getNumero());
            pstm.setInt(3, d.getCod_comuna());

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

    public void ModificarDirU(Direccion d, int p_id_dir) {
        
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE direccion SET calle = ?, numero = ?, id_comuna = ? WHERE id_direccion = ?"
            );

            pstm.setString(1, d.getCalle());
            pstm.setInt(2, d.getNumero());
            pstm.setInt(3, d.getCod_comuna());
            pstm.setInt(4, p_id_dir);

            pstm.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otro error" + e.getMessage());
        } finally {
            this.getConexion().cerrarConexion();
        }
    }

    public void EliminarDirU(int p_id_dir) {

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "DELETE FROM direccion WHERE id_direccion = ?"
            );
            pstm.setInt(1, p_id_dir);
            pstm.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion" + e.getMessage());
        }
    }

    public Direccion buscarDireccion(int p_id_d) {

        Direccion d = null;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_direccion, calle, numero, id_comuna FROM direccion WHERE id_direccion = ?"
            );
            pstm.setInt(1, p_id_d);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                d = new Direccion(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
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
        return d;
    }
    
    public int obtenerId_direccion (String run){
        int id = 0;
            try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT d.id_direccion FROM  direccion d INNER JOIN persona p USING (id_direccion) WHERE p.run = ?"
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
