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
public class Sala {
    
    private int id_sala;
    private int acti_sala;

    public Sala() {
    }
    public Sala( int nuevoid_sala){

    this.setId_sala(nuevoid_sala);
    
    
    }

    public Sala(int id_sala, int acti_sala) {
        this.id_sala = id_sala;
        this.acti_sala = acti_sala;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }


    public int getActi_sala() {
        return acti_sala;
    }

    public void setActi_sala(int acti_sala) {
        this.acti_sala = acti_sala;
    }
    
    
    @Override
    
    public String toString(){
    
    return String.format("{Acti_sala: %s\n id_sala: %s\n}",
            this.getActi_sala(),
            this.getId_sala()
            
            );
    
    }
    
    
}
