/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author krizz
 */
public class FuncionE {
    private int id_funcion;
    private Date fecha;
    private String horainicio;
    private String horafinal;
    private int acti_fun;
    private int sala;
    private int id_pelicula;
    
    public FuncionE(){}
    
    
    public FuncionE(Date nuevaFecha, String nuevaHorainicio, String nuevaHorafinal,int nuevaacti, int nuevaSala, int nuevaid_pelicula){
    
    this.setFecha(nuevaFecha);
    this.setHorainicio(nuevaHorainicio);
    this.setHorafinal(nuevaHorafinal);
    this.setSala(nuevaSala);
    this.setActi_fun(nuevaacti);
    this.setId_pelicula(nuevaid_pelicula);
    }
    
    public FuncionE(int id_funcion, Date fecha, String horainicio,String horafinal,int acti_fun, int sala, int id_pelicula){
    this.setId_funcion(id_funcion);
    this.setFecha(fecha);
    this.setHorainicio(horainicio);
    this.setHorafinal(horafinal);
    this.setSala(sala);
    this.setActi_fun(acti_fun);
    this.setId_pelicula(id_pelicula);
    }
    public FuncionE(int id_funcion,int id_sala){
    this.setId_funcion(id_funcion);
    this.setSala(id_sala);
    }
    public FuncionE(int id_sala){
    this.setSala(id_sala);
    }
    public FuncionE(String horinicio){
    this.setHorainicio(horinicio);
    }

    public int getActi_fun() {
        return acti_fun;
    }

    public void setActi_fun(int acti_fun) {
        this.acti_fun = acti_fun;
    }
    
    
    public void setId_funcion(int id_funcion){
        
    this.id_funcion = id_funcion;
    }
    public void setFecha(Date fecha){
    
    this.fecha = fecha;
    }
    
    public void setHorainicio(String horainicio){
    
    this.horainicio = horainicio;
    }
    
    public void setHorafinal(String horafinal){
    
    this.horafinal = horafinal;
    }
    public void setSala(int sala){
    this.sala = sala;
    }
    
    public int getId_funcion(){
    return this.id_funcion;
    }
    
    public Date getFecha(){
    return this.fecha;
    }
    
    public String getHorainicio(){
    return this.horainicio;
    }
    public String getHorafinal(){
    return this.horafinal;
    }
    public int getSala(){
    return this.sala;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    
    public String [] datosTabla(){
    String[] datos = {
    String.valueOf(this.getId_funcion()),
    String.valueOf(getFecha()),
    this.getHorainicio(),
    this.getHorafinal(),
    String.valueOf(this.getActi_fun()),
    String.valueOf(this.getSala()),
    String.valueOf(this.getId_pelicula())
    };
    return datos;
    }
    
}
