/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Pelicula;

public class Lista_peliculas extends JButton implements ActionListener {
    private Pelicula pelicula;

    public Lista_peliculas(Pelicula nuevaPelicula) throws IOException {
        Pelicula p = new Pelicula();
        this.setPelicula(nuevaPelicula);
        this.seticon();
        this.addActionListener(this);
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    private void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    private void seticon() throws IOException {
        ImageIcon image2 = new ImageIcon(new ImageIcon(pelicula.getPortada()).getImage().getScaledInstance(170, 220, Image.SCALE_SMOOTH));
        super.setIcon(image2);
    }
            
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }


}
