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
public class Asiento {
    
    private int id_asiento;
    private int n_asiento;
    private String disponible;
    private String nombre;
    public Asiento(){
    }
    
    public Asiento(int n_asiento, String disponible){      
        this.n_asiento = n_asiento;
        this.disponible = disponible;
    }
        public Asiento(int id_asiento, int n_asiento){      
        this.id_asiento = id_asiento;
        this.n_asiento = n_asiento;
    }

    public Asiento(int id_asiento, String disponible, String nombre) {
        this.id_asiento = id_asiento;
        this.disponible = disponible;
        this.nombre = nombre;
    }
        

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public int getN_asiento() {
        return n_asiento;
    }

    public void setN_asiento(int n_asiento) {
        this.n_asiento = n_asiento;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}