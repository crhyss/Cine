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
public class Direccion {
    private int id_direccion;
    private String calle;
    private int numero;
    private int num_Local;
    private int cod_comuna;

    public Direccion() {
    }
    
    public Direccion(int id_direccion, String nuevoCalle, int nuevoNumero, int cod_comuna){
    
    this.setId_direccion(id_direccion);
    this.setCalle(nuevoCalle);
    this.setNumero(nuevoNumero);
    this.setCod_comuna(cod_comuna);
    
    }

    public Direccion(String calle, int numero, int cod_comuna) {
        this.calle = calle;
        this.numero = numero;
        this.cod_comuna = cod_comuna;
    }

    public Direccion(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }
          
    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNum_Local() {
        return num_Local;
    }

    public void setNum_Local(int num_Local) {
        this.num_Local = num_Local;
    }

    public int getCod_comuna() {
        return cod_comuna;
    }

    public void setCod_comuna(int cod_comuna) {
        this.cod_comuna = cod_comuna;
    }  
    
    @Override
    
    public String toString(){
    
    return String.format("{Direccion:\n Calle: %s\n numero: %s\n numero_local: %s\n codigoPostal: %s\n}",
            
            this.getCalle(),
            this.getNumero(),
            this.getNum_Local(),
            this.getId_direccion()
    );
    
    
    }
    
}
