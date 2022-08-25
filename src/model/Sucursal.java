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
public class Sucursal {
    private int id_sucursal;
    private String nombre;
    private String acti_sucu;
    private int id_direccion;

    public Sucursal() {
    }
    
    public Sucursal(String nuevoNombre, String nuevoActi_sucu){
    
    this.setNombre(nuevoNombre);
    this.setActi_sucu(nuevoActi_sucu);

    }

    public Sucursal(int id_sucursal, String nombre) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
    }
    
    public Sucursal(String nombre) {
        this.nombre = nombre;
    }
    
    public Sucursal(int id_sucursal, String nombre, String acti_sucu, int id_direccion) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.acti_sucu = acti_sucu;
        this.id_direccion = id_direccion;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActi_sucu() {
        return acti_sucu;
    }

    public void setActi_sucu(String acti_sucu) {
        this.acti_sucu = acti_sucu;
    }
    
    @Override
    
    public String toString(){
    
    return String.format("{Sucursal:\n nombre: %s\n Acti_sucu: %s\n id_sucursal: %s\n }",
            
            this.getNombre(),
            this.getActi_sucu(),
            this.getId_sucursal());
    
    }
}
