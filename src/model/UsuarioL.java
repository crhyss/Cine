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
public class UsuarioL {
    private String run;
    private String nombre;
    private String apellido;
    private String nombre_u;

    public UsuarioL(String run, String nombre, String apellido, String nombre_u) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_u = nombre_u;
    }

    public UsuarioL() {
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }

    @Override
    public String toString() {
        return "UsuarioL{" + "run=" + run + ", nombre=" + nombre + ", apellido=" + apellido + ", nombre_u=" + nombre_u + '}';
    }
        
}
