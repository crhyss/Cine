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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Asiento;
import vista.Estado_asiento;

/**
 *
 * @author krizz
 */
public class ControladorAsiento {

    Asiento as = new Asiento();
    private Conexion conexio;

    public ControladorAsiento() {
        this.setConexion(Conexion.nuevaInstancia());
    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;
    }

    private Conexion getConexion() {
        return this.conexio;
    }

    public boolean modificarAsiento(int nuevoAsiento) {
        boolean salida = false;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE asiento SET disponible = 'no' where id_asiento =" + nuevoAsiento);
            pstm.executeUpdate();
            salida = true;
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

    public boolean quitarmodificarAsiento(int nuevoAsiento) {
        boolean salida = false;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE basecine.asiento join basecine.asi_sala "
                    + "using(id_asiento) SET `disponible` = 'si' WHERE id_sala =" + nuevoAsiento);

            int mensaje = pstm.executeUpdate();
            if (mensaje > 0) {
                JOptionPane.showMessageDialog(null, "los Asientos ya no se encuentras reservados");
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo quitar la reservacion");
            }

            salida = true;

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

    public boolean quitarmodificarAsiento2(int nuevoAsiento) {
        boolean salida = false;

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE basecine.asiento join basecine.asi_sala "
                    + "using(id_asiento) SET `disponible` = 'si' WHERE id_asiento =" + nuevoAsiento);

            int mensaje = pstm.executeUpdate();
            if (mensaje > 0) {
                JOptionPane.showMessageDialog(null, "El asiento se encuentra disponible nuevamente");
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo quitar la reservacion");
            }

            salida = true;

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

    public List<Asiento> buscarAsiento(int id) {
        List<Asiento> asie = new ArrayList<Asiento>();
        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().
                    prepareStatement(
                            "SELECT * FROM basecine.funcion join basecine.pelicula "
                            + "using (id_pelicula) join basecine.sala "
                            + "using(id_sala) join basecine.asi_sala "
                            + "using(id_sala) join basecine.asiento "
                            + "using(id_asiento)where id_sala =" + id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Asiento temporal = new Asiento(rs.getInt("id_asiento"), rs.getString("disponible"));

                asie.add(temporal);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());

        } catch (SQLException e) {
            System.out.println(String.format("Error SQL %s : %s", e.getSQLState(), e.getMessage()));
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Otra excepcion " + e.getMessage());
        } finally {

            this.getConexion().cerrarConexion();
        }
        return asie;
    }

    public void listarAsiento() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement pstm = this.getConexion().obtenercConnection().
                    prepareStatement(
                            "select* from basecine.asiento join basecine.asi_sala using(id_asiento)");
            ResultSet rs = pstm.executeQuery();
            modelo.setColumnIdentifiers(new Object[]{"id_asiento", "disponible", "id_asi_sala", "id_sala"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_asiento"), rs.getString("disponible"), rs.getInt("id_asi_sala"), rs.getInt("id_sala")});
            }
            Estado_asiento.tabla_asi_sala.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "se debe modificar desde la barra de id");
        }
    }
}
