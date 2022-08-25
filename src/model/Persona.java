/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author krizz
 */
public class Persona {

    private int id_persona;
    private String run;
    private String nombre;
    private String apellido;
    private int id_direccion;

    public Persona() {
    }

    public Persona(String run, String nombre, String apellido, int id_direccion) {
        setRun(run);
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_direccion = id_direccion;
    }

    public Persona(int id_persona, String run, String nombre, String apellido, int id_direccion) {
        this.id_persona = id_persona;
        setRun(run);
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_direccion = id_direccion;
    }

    public Persona(String run, String nombre, String apellido) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
}
