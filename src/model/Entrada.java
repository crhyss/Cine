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
public class Entrada {
    
    private int id_entrada;
    private String acti_ent;

    public Entrada() {
    }
    
    public Entrada(String nuevoActi_ent){
    
    this.setActi_ent(nuevoActi_ent);
    
    }

    public Entrada(int id_entrada, String acti_ent) {
        this.id_entrada = id_entrada;
        this.acti_ent = acti_ent;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public String getActi_ent() {
        return acti_ent;
    }

    public void setActi_ent(String acti_ent) {
        this.acti_ent = acti_ent;
    }
    
    
    
    @Override
    
    public String toString(){
    
    
        return String.format("{Entrada:\nacti_ent $s\n id_entrada: %s\n}",
                
                this.getActi_ent(),
                this.getId_entrada());
    
    
    }
}
