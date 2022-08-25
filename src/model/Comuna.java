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
public class Comuna {
    
    private int id_comuna;
    private String nombre;
    private int id_region;

    public Comuna() {
    }

    public Comuna(String nombre) {
        this.nombre = nombre;
    }
       
    public Comuna(String nuevoNombre, int nuevaId_r){
    
    this.setNombre(nuevoNombre);
    this.setId_region(nuevaId_r);
    
    }
    
    public Comuna(int id_comuna, String nombre, int id_region) {
        this.id_comuna = id_comuna;
        this.nombre = nombre;
        this.id_region = id_region;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    @Override
    public String toString() {
        return "Comuna{" + "id_comuna=" + id_comuna + ", nombre=" + nombre + ", id_region=" + id_region + '}';
    }
    
    
}
