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
import model.Comuna;
/**
 *
 * @author Branco
 */
public class ControladorComuna {
    
    private Conexion conexio;

    public ControladorComuna() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }
    
    public String[] llenarComunas(String nm_region) {

        String[] comunas = null;
        Comuna c = null;
        int numero = 0;
        int numeroMax = 0;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT c.nombre FROM comuna c INNER JOIN region r USING (id_Region) WHERE r.nombre = ?"
            );   
            pstm.setString(1, nm_region);     
            ResultSet rs = pstm.executeQuery();
            if (rs.last()) {
                numeroMax = rs.getRow();
            }
            comunas = new String[numeroMax];
            if (rs.first()) {
                do {
                    c = new Comuna(
                            rs.getString(1)
                    );
                    comunas[numero] = c.getNombre();
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
        return comunas;
    }
    
    public int obtenerIdComuna(String nombre){
        
        int id_comuna = 0;
        
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_comuna FROM comuna WHERE nombre = ?"
            );   
            pstm.setString(1, nombre);     
            ResultSet rs = pstm.executeQuery();
            if(rs.first()){
                id_comuna = rs.getInt(1);
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
        return id_comuna;
    }
    
    public int obtenerIdComunaU(String run){
        int id = 0;
            try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT c.id_comuna FROM comuna c INNER join direccion d "
                    + "USING (id_comuna) INNER JOIN persona p USING (id_direccion) WHERE p.run = ?"
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
    
    public int obtenerIdRegion(String run){
        int id = 0;
            try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT c.id_region FROM comuna c INNER join direccion d "
                    + "USING (id_comuna) INNER JOIN persona p USING (id_direccion) WHERE p.run = ?"
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
    
    public String obtenerNombreC(int id){
        
        String nombre = "";
        
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT nombre FROM comuna WHERE id_comuna = ?"
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
