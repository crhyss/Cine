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
import model.FuncionE;
import model.Pelicula;

/**
 *
 * @author krizz
 */
public class ControladorPelicula {

    private Conexion conexio;

    public ControladorPelicula() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public boolean agregarPelicula(Pelicula nuevaPelicula) {

        boolean salida = false;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO pelicula (nombre,acti_peli,descripcion,director,reparto,clasificacion,portada) VALUES (?,?,?,?,?,?,?)"
            );

            pstm.setString(1, nuevaPelicula.getNombre());
            pstm.setInt(2, nuevaPelicula.getActi_peli());
            pstm.setString(3, nuevaPelicula.getDescripcion());
            pstm.setString(4, nuevaPelicula.getDirector());
            pstm.setString(5, nuevaPelicula.getReparto());
            pstm.setString(6, nuevaPelicula.getClasificacion());
            pstm.setBytes(7, nuevaPelicula.getPortada());

            if (pstm.executeUpdate() == 1) {

                salida = true;

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
        return salida;

    }

    public boolean modificarPelicula(Pelicula nuevaPelicula) {

        boolean salida = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE pelicula SET nombre = ? , acti_peli = ?, descripcion = ?, director = ?, reparto = ?, clasificacion = ?, portada = ? WHERE id_pelicula = ?"
            );

            pstm.setString(1, nuevaPelicula.getNombre());
            pstm.setInt(2, nuevaPelicula.getActi_peli());
            pstm.setString(3, nuevaPelicula.getDescripcion());
            pstm.setString(4, nuevaPelicula.getDirector());
            pstm.setString(5, nuevaPelicula.getReparto());
            pstm.setString(6, nuevaPelicula.getClasificacion());
            pstm.setBytes(7, nuevaPelicula.getPortada());
            pstm.setInt(8, nuevaPelicula.getId_pelicula());
            if (pstm.executeUpdate() == 1) {

                salida = true;

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
        return salida;

    }

    public boolean eliminarPelicula(int id) {

        boolean salida = false;
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "DELETE FROM pelicula WHERE id_pelicula = ?"
            );
            pstm.setInt(1, id);
            if (pstm.executeUpdate() == 1) {

                salida = true;

            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {

            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println("Otra excepcion" + e.getMessage());

        } finally {

            this.getConexion().cerrarConexion();

        }

        return salida;

    }

    public Pelicula buscarPelicula(int id) {

        Pelicula encontrada = null;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_pelicula,nombre,acti_peli,descripcion,director,reparto,clasificacion,portada FROM pelicula WHERE id_pelicula = ?"
            );
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                encontrada = new Pelicula(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBytes(8));
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
        return encontrada;
    }

    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "Select * FROM pelicula;"
            );
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Pelicula temp = new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("nombre"),
                        rs.getInt("acti_peli"),
                        rs.getString("descripcion"),
                        rs.getString("director"),
                        rs.getString("reparto"),
                        rs.getString("clasificacion"),
                        rs.getBytes("portada")
                        );
                peliculas.add(temp);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {

            System.out.println(String.format("Error SQL "+ e.getSQLState()+ e.getMessage()));

        } catch (Exception e) {

            System.out.println("Otra excepcion " + e.getMessage());
        } finally {

            this.getConexion().cerrarConexion();

        }

        return peliculas;

    }

    public ArrayList<Pelicula> listaPortada() {
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT * FROM basecine.funcion join basecine.pelicula using (id_pelicula);"
            );
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Pelicula temp = new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("nombre"),
                        rs.getInt("acti_peli"),
                        rs.getString("descripcion"),
                        rs.getString("director"),
                        rs.getString("reparto"),
                        rs.getString("clasificacion"),
                        rs.getBytes("portada"),
                        rs.getInt("id_sala"),
                        rs.getString("horainicio"));
                peliculas.add(temp);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {

            System.out.println(String.format("Error SQL" + e.getSQLState() + e.getMessage()));

        } catch (Exception e) {

            System.out.println("Otra excepcion " + e.getMessage());
        } finally {

            this.getConexion().cerrarConexion();

        }

        return peliculas;

    }

}
