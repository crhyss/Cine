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
public class Pago {
    private int id_pago;
    private int total;
    private int vuelto;

    public Pago() {
    }
    
    public Pago(int nuevoTotal, int nuevoVuelto){
        
        this.setTotal(nuevoTotal);
        this.setVuelto(nuevoVuelto);
    
    
    
    }

    public Pago(int id_pago, int total, int vuelto) {
        this.id_pago = id_pago;
        this.total = total;
        this.vuelto = vuelto;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getVuelto() {
        return vuelto;
    }

    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }
    
    
    
    @Override
    
    public String toString(){
    
    return String.format("{Pago:\n total = %s\nvuelto: %s\nid_pago: %s\n}",
            
            this.getTotal(),
            this.getVuelto(),
            this.getId_pago()
            );
    
    
    }
    
}
