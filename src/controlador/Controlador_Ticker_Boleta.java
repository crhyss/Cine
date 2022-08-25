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
import model.Persona;

/**
 *
 * @author cris_
 */
public class Controlador_Ticker_Boleta {
    

    private Conexion conexio;

    public Controlador_Ticker_Boleta() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public int Registrarticker(Persona p, int p_id_direccion) {

        int id = 0;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO persona(run, nombre, apellido, id_direccion ) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );

            pstm.setString(1, p.getRun());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido());
            pstm.setInt(4, p_id_direccion);

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

    public int ModificarPerU(Persona p, int p_id_per) {
        int id = 0;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE persona SET run = ?, nombre = ?, apellido = ? WHERE id_persona = ?"
            );

            pstm.setString(1, p.getRun());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido());
            pstm.setInt(4, p_id_per);

            if (pstm.executeUpdate() == 1) {

                id = buscarPersona(p_id_per).getId_direccion();

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

    public int EliminarPerU(int p_id_per) {
        int id = 0;
        int t_id = buscarPersona(p_id_per).getId_direccion();

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "DELETE FROM persona WHERE id_persona = ?"
            );

            pstm.setInt(1, p_id_per);
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

    public Persona buscarPersona(int p_id_p) {

        Persona p = null;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_persona, run, nombre, apellido, id_direccion FROM persona WHERE id_persona = ?"
            );
            pstm.setInt(1, p_id_p);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                p = new Persona(
                        rs.getInt(1),
                        rs.getString(2),
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
        return p;
    }

    public int obtenerId_persona(String run) {
        int id = 0;
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_persona FROM persona WHERE run = ?"
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
