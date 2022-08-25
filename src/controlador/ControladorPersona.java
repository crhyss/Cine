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
 * @author Branco
 */
public class ControladorPersona {

    private Conexion conexio;

    public ControladorPersona() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public int RegistrarPerU(Persona p, int p_id_direccion) {

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
            if (pstm.executeUpdate() == 1) {
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

    public boolean validarRun(String p_run) {
        boolean valido = false;

        if (p_run.length() == 9 || p_run.length() == 10) {
            if (p_run.charAt(7) == '-' || p_run.charAt(8) == '-') {

                String[] runPart = p_run.split("-");
                String run = runPart[0];
                String dv = runPart[1];

                String inv_run = "";
                int part_run = run.length() - 1;
                int suma = 0;
                int multi_n = 2;
                for (int i = 0; i < run.length(); i++) {
                    inv_run += Character.toString(run.charAt(part_run));
                    part_run--;
                }
                for (int i = 0; i < inv_run.length(); i++) {
                    int d = Integer.parseInt(Character.toString(inv_run.charAt(i)));
                    suma += d * multi_n;
                    if (multi_n == 7) {
                        multi_n = 2;
                    } else {
                        multi_n++;
                    }
                }
                int mod = suma % 11;
                int dv_v = 11 - mod;
                if (dv_v < 10) {
                    String val = Integer.toString(dv_v);
                    if (val.equals(dv)) {
                        valido = true;
                    }

                } else if (dv_v == 10) {
                    String val = "K";
                    if (val.equals(dv.toUpperCase())) {
                        valido = true;
                    }
                } else if (dv_v == 11) {
                    String val = Integer.toString(0);
                    if (val.equals(dv)) {
                        valido = true;
                    }
                } else {
                    valido = false;
                }
            }
        }
        return valido;
    }
    
     public boolean verificaRun(String run) {
        boolean existe = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT run FROM persona WHERE run = ?"
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
