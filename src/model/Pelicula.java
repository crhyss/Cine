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
public class Pelicula {

    private int id_pelicula;
    private String nombre;
    private int acti_peli;
    private String descripcion;
    private String director;
    private String reparto;
    private String clasificacion;
    private byte[] portada;
    private int sala;
    public String Funcion;
    

    public Pelicula() {
    }

    public Pelicula(int id_pelicula, String nombre, int acti_peli, String descripcion, String director, String reparto, String clasificacion,byte[] portada) {

        this.setId_pelicula(id_pelicula);
        this.setNombre(nombre);
        this.setActi_peli(acti_peli);
        this.setDescripcion(descripcion);
        this.setDirector(director);
        this.setReparto(reparto);
        this.setClasificacion(clasificacion);
        this.setPortada(portada);
        
    
    }


    public Pelicula(String nuevoNombre, int nuevoActi_peli, String nuevoDescrip, String nuevoDirector, String nuevoreparto, String nuevoclasifi,byte[] nuevaPorta) {

        this.setNombre(nuevoNombre);
        this.setActi_peli(nuevoActi_peli);
        this.setDescripcion(nuevoDescrip);
        this.setDirector(nuevoDirector);
        this.setReparto(nuevoreparto);
        this.setClasificacion(nuevoclasifi);
        this.setPortada(nuevaPorta);
    }
        public Pelicula(int nuevaid, String nuevoNombre, int nuevoActi_peli, String nuevoDescrip, String nuevoDirector, String nuevoreparto, String nuevoclasifi,byte[] nuevaPorta, int nuevasala, String nuevaFuncion) {
        this.setId_pelicula(nuevaid);
        this.setNombre(nuevoNombre);
        this.setActi_peli(nuevoActi_peli);
        this.setDescripcion(nuevoDescrip);
        this.setDirector(nuevoDirector);
        this.setReparto(nuevoreparto);
        this.setClasificacion(nuevoclasifi);
        this.setPortada(nuevaPorta);
        this.setSala(nuevasala);
        this.setFuncion(nuevaFuncion);
    }

    public Pelicula(int id_peli,byte[] nuevaportada) {
        this.setId_pelicula(id_peli);
        this.setPortada(nuevaportada);
    }

    public Pelicula(int id_peli, String nombre) {
        this.setId_pelicula(id_peli);
        this.setNombre(nombre);
    }
    public  Pelicula (int activo){
    this.setActi_peli(activo);
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    
    
    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActi_peli() {
        return acti_peli;
    }

    public void setActi_peli(int acti_peli) {
        this.acti_peli = acti_peli;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getFuncion() {
        return Funcion;
    }

    public void setFuncion(String Funcion) {
        this.Funcion = Funcion;
    }

    public String[] datosTabla() {

        String[] datos = {
            String.valueOf(this.getId_pelicula()),
            this.getNombre(),
            String.valueOf(this.getActi_peli()),
            this.getDescripcion(),
            this.getDirector(),
            this.getReparto(),
            this.getClasificacion()

        };
        return datos;
    }

    @Override

    public String toString() {

        return String.format("{Pelicula:\n Nombre = %s\n acti_peli: =s\n descripcion: =\n%s director: =\n reparto: =\n clasificacion: \n id_pelicula}",
                this.getNombre(),
                this.getActi_peli(),
                this.getDescripcion(),
                this.getDirector(),
                this.getReparto(),
                this.getClasificacion(),
                this.getId_pelicula());

    }

}
