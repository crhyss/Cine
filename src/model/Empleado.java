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
public class Empleado {
    
    private int id_empleado;
    private int edad;
    private String est_civil;
    private String genero;
    private int id_persona;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public Empleado(int id_empleado, int edad, String est_civil, String genero, int id_persona) {
        this.id_empleado = id_empleado;
        this.edad = edad;
        this.est_civil = est_civil;
        this.genero = genero;
        this.id_persona = id_persona;
    }

    public Empleado(int edad, String est_civil, String genero, int id_persona) {
        this.edad = edad;
        this.est_civil = est_civil;
        this.genero = genero;
        this.id_persona = id_persona;
    }

    public Empleado(int edad, String est_civil, String genero) {
        this.edad = edad;
        this.est_civil = est_civil;
        this.genero = genero;
    }
        
    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", edad=" + edad + ", est_civil=" + est_civil + ", genero=" + genero + ", id_persona=" + id_persona + '}';
    }

}
