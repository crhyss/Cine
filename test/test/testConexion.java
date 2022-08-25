/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conexion.Conexion;
import java.sql.SQLException;
import controlador.ControladorAsiento;
import model.Asiento;
import model.Pelicula;
import controlador.ControladorPelicula;
import java.util.List;
import controlador.ControlarFuncion;
import model.FuncionE;

/**
 *
 * @author krizz
 */
public class testConexion {

    private static ControladorPelicula cPelicula = new ControladorPelicula();
    private static ControladorAsiento cAsiento = new ControladorAsiento();
    private static ControlarFuncion cFuncion = new ControlarFuncion();

    public static void main(String... args) {

//        testAgregarAsiento();
        //testBuscarAsiento(2);
//        testmodificarAsiento();
//        testEliminarAsiento(1);
//        
//        testAgregarPelicula();
//    testListarPeliculas();
//        testEliminarPelicula(11);
//        testBuscarPeliculas(1);
//    testAgregarFuncion();
//    testListarPeliculas();
//    testModificarPeliculas();
    }

    
//    public static void testAgregarPelicula() {
//
//        Pelicula nuevaPelicula = new Pelicula("1", 0, "Hola", "Prubea", "la rosalia", "M");
//
//        if (cPelicula.agregarPelicula(nuevaPelicula)) {
//
//            System.out.println(String.format("La pelicula %s ha sido agregada", nuevaPelicula.getNombre()));
//
//        } else {
//
//            System.out.println("No se ha agregado");
//        }
//
//    }

    public static void testListarPeliculas() {

        List<Pelicula> peliculas = cPelicula.listarPeliculas();
        for (Pelicula temp : peliculas) {

            System.out.println(temp.toString());

        }
    }

    public static void testEliminarPelicula(int idPELIMINAR) {

        if (cPelicula.eliminarPelicula(idPELIMINAR)) {

            System.out.println("Eliminado correctamente");
        } else {

            System.out.println("No se elimino");
        }

    }

    public static void testBuscarPeliculas(int idAPeliculas) {

        Pelicula encontrada = cPelicula.buscarPelicula(idAPeliculas);
        if (encontrada != null) {
            System.out.println(encontrada.toString());
        } else {
            System.out.println("Pelicula no encontrada");
        }
    }
    
//    public static void testModificarPeliculas(){
//    Pelicula peli = new Pelicula(4, "Nombre", 1, "DES", "DIR", "REPAR", "CLASI");
//    if (cPelicula.modificarPelicula(peli)){
//        System.out.println("Pelicula modificada");
//    }else{System.out.println("Pelicula no modificada");}
//    }

//    public static void testAgregarFuncion() {
//
//        FuncionE nuevafuncion = new FuncionE("20-06-2020", "21:30", "23:30", "S1");
//        if (cFuncion.agregarFuncion(nuevafuncion)) {
//            System.out.println("La funcion se ha agregado");
//        } else {
//            System.out.println("No se ha agregado");
//        }
//    }
}
