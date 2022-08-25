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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.Sucursal;

/**
 *
 * @author cris_
 */
public class ControladorSucursal {

    private Conexion conexio;

    public ControladorSucursal() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;
    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public List<Sucursal> listarSucursal() {
        List<Sucursal> sucursal = new ArrayList<Sucursal>();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "Select id_sucursal,nombre FROM sucursal"
            );

            ResultSet rs = pstm.executeQuery();
            String nombre;
            if (rs.next()) {
                do {
                    Sucursal ListaTemporal = new Sucursal(rs.getInt(1), rs.getString(2).toString());
                    sucursal.add(ListaTemporal);
                    nombre = rs.getString(2);
                } while (rs.next());
                return sucursal;
            } else {
                return null;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {

            System.out.println(String.format("Error SQL $s : $s", e.getSQLState(), e.getMessage()));

        } catch (Exception e) {

            System.out.println("Otra excepcion " + e.getMessage());
        } finally {

            this.getConexion().cerrarConexion();

        }

        return sucursal;

    }

}
