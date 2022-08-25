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
import model.Region;

/**
 *
 * @author Branco
 */
public class ControladorRegion {

    private Conexion conexio;

    public ControladorRegion() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public String[] llenarRegiones() {

        String[] regiones = null;
        Region r = null;
        int numero = 0;
        int numeroMax = 0;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "Select nombre FROM region"
            );

            ResultSet rs = pstm.executeQuery();
            if (rs.last()) {
                numeroMax = rs.getRow();
            }
            regiones = new String[numeroMax];
            if (rs.first()) {
                do {
                    r = new Region(
                            rs.getString(1)
                    );
                    regiones[numero] = r.getNombre();
                    numero += 1;
                } while (rs.next());

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
        return regiones;
    }
    
    public String obtenerNombreR(int id){
        
        String nombre = "";
        
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT nombre FROM region WHERE id_region = ?"
            );   
            pstm.setInt(1, id);     
            ResultSet rs = pstm.executeQuery();
            if(rs.first()){
                nombre = rs.getString(1);
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
        return nombre;
    }
}
