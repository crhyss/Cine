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
public class Empresa {
    
    private int id_empresa;
    private String rut_empresa;
    private String nombre;
    private String correo;
    private String acti_Empr;

    public Empresa() {
    }
    
    public Empresa(String nuevaRutEmpresa, String nuevaNombre, String nuevaCorreo, String nuevaActi_Empr){
    
    this.setRut_empresa(nuevaRutEmpresa);
    this.setNombre(nuevaNombre);
    this.setCorreo(nuevaCorreo);
    this.setActi_Empr(nuevaActi_Empr);
    
    }

    public Empresa(int id_empresa, String rut_empresa, String nombre, String correo, String acti_Empr) {
        this.id_empresa = id_empresa;
        this.rut_empresa = rut_empresa;
        this.nombre = nombre;
        this.correo = correo;
        this.acti_Empr = acti_Empr;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getActi_Empr() {
        return acti_Empr;
    }

    public void setActi_Empr(String acti_Empr) {
        this.acti_Empr = acti_Empr;
    }
    
    @Override
    public String toString(){
    
    return String.format("Empresa:\nrut_empresa = %s\nnombre: %s\ncorreo: %s\nacti_Empr: %s\n",
    
    this.getRut_empresa(),
    this.getNombre(),
    this.getCorreo(),
    this.getActi_Empr()
    );
    
    
    }
    
    
}
