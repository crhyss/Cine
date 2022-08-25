/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Branco
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String pass;
    private int id_empleado;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }
    

    public Usuario(String nombre, String pass, int id_empleado) {
        this.nombre = nombre;
        this.pass = pass;
        this.id_empleado = id_empleado;
    }

    public Usuario(int id_usuario, String nombre, String pass, int id_empleado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.pass = pass;
        this.id_empleado = id_empleado;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", pass=" + pass + ", id_empleado=" + id_empleado + '}';
    }
    
    
}
