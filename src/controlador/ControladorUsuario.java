package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.UsuarioL;

public class ControladorUsuario {

    private Conexion conexio;

    public ControladorUsuario() {

        this.setConexion(Conexion.nuevaInstancia());

    }

    private void setConexion(Conexion nuevaConexion) {

        this.conexio = nuevaConexion;

    }

    private Conexion getConexion() {

        return this.conexio;

    }

    public void RegistrarUsu(Usuario u, int p_id_emp) {

        try {
            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "INSERT INTO usuario(nom_u, contrasena, id_empleado) VALUES (?, ?, ?)"
            );

            pstm.setString(1, u.getNombre());
            pstm.setString(2, u.getPass());
            pstm.setInt(3, p_id_emp);

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

    public int ModificarU(Usuario u, int p_id_usu) {
        int id = 0;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "UPDATE usuario SET nom_u = ?, contrasena = ? WHERE id_usuario = ?"
            );

            pstm.setString(1, u.getNombre());
            pstm.setString(2, u.getPass());
            pstm.setInt(3, p_id_usu);

            if (pstm.executeUpdate() == 1) {

                id = buscarUsuario(p_id_usu).getId_empleado();

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

    public int EliminarU(int p_id_u) {
        int id = 0;
        int t_id = buscarUsuario(p_id_u).getId_empleado();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "DELETE FROM usuario WHERE id_usuario = ?"
            );

            pstm.setInt(1, p_id_u);
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

    public Usuario buscarUsuario(int p_id_u) {

        Usuario u = null;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT id_usuario,nom_u,contrasena,id_empleado FROM usuario WHERE id_usuario = ?"
            );
            pstm.setInt(1, p_id_u);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {

                u = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
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
        return u;
    }

    public int obtenerId_usuario(String run) {
        int id = 0;
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT u.id_usuario FROM usuario u INNER JOIN emp e USING (id_empleado) "
                    + "INNER JOIN persona p USING (id_persona) INNER JOIN direccion d USING (id_direccion) WHERE p.run = ?"
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

    public List<UsuarioL> listarUsuarios() {
        List<UsuarioL> usuarios = new ArrayList<UsuarioL>();
        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "Select run, nombre, apellido, u.nombre FROM usuario u "
                    + "INNER JOIN empleado e USING(id_empleado) "
                    + "INNER JOIN persona p USING(id_persona)"
            );

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioL temp = new UsuarioL(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                usuarios.add(temp);

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

        return usuarios;

    }

    public String crearNombre1(String nombre, String apellido) {
        String v_nombre = nombre;
        String v_apellido = apellido;
        String nomb_u = "";

        if (v_nombre.length() >= 2 && v_nombre.length() <= 4) {
            nomb_u = v_nombre + "." + v_apellido;
        } else if (v_nombre.length() > 4) {
            nomb_u = v_nombre.substring(0, 3) + "." + v_apellido;
        }

        return nomb_u;
    }

    public String crearNombre2(String nombre, String apellido) {
        String v_nombre = nombre;
        String v_apellido = apellido;
        String nomb_u = "";

        if (v_nombre.length() >= 2 && v_nombre.length() <= 4) {
            nomb_u = v_nombre.substring(0) + "." + v_apellido;
        } else if (v_nombre.length() > 4) {
            nomb_u = v_nombre.substring(0, 1) + "." + v_apellido;
        }

        return nomb_u;
    }

    public String crearNombre3(String nombre, String apellido) {
        String v_nombre = nombre;
        String v_apellido = apellido;
        String nomb_u = "";

        if (v_apellido.length() >= 2 && v_apellido.length() <= 4) {
            nomb_u = v_nombre + "." + v_apellido.substring(0);
        } else if (v_apellido.length() > 4) {
            nomb_u = v_nombre + "." + v_apellido.substring(0, 3);
        }

        return nomb_u;
    }

    public String crearNombre4(String nombre, String apellido) {
        String v_nombre = nombre;
        String v_apellido = apellido;
        String nomb_u = "";

        if (v_apellido.length() >= 2 && v_apellido.length() <= 4) {
            nomb_u = v_nombre + "." + v_apellido.substring(0, 1);
        } else if (v_apellido.length() > 4) {
            nomb_u = v_nombre + "." + v_apellido.substring(0, 4);
        }

        return nomb_u;
    }

    public String crearContra(String nombre, String apellido, String run) {
        String pass = "";

        pass = nombre.substring(0, 2) + "." + apellido.substring(0, 2) + run.substring(0, 4);

        return pass;
    }
    
    public boolean verificaExistencia(String nom, String pass) {
        boolean existe = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT nom_u FROM usuario WHERE nom_u = ? and contrasena = ?"
            );
            pstm.setString(1, nom);
            pstm.setString(2, pass);
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
    
    public boolean verificaNomU(String nom) {
        boolean existe = false;

        try {

            PreparedStatement pstm = this.getConexion().obtenercConnection().prepareStatement(
                    "SELECT nom_u FROM usuario WHERE nom_u = ?"
            );
            pstm.setString(1, nom);
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
