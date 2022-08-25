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
public class Cliente {

    private int id_cliente;
    private int id_persona;

    public Cliente() {
    }

    public Cliente(int id_persona) {
        this.id_persona = id_persona;
    }

    public Cliente(int id_cliente, int id_persona) {
        this.id_cliente = id_cliente;
        this.id_persona = id_persona;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", id_persona=" + id_persona + '}';
    }

}
