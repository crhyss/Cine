/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import model.Asiento;

/**
 *
 * @author cris_
 */
public class Confi_Asiento extends JToggleButton {

    private Conexion conexio;
    private Asiento asiento;
    private final ImageIcon Ocupado;
    private final ImageIcon Disponible;
    private final ImageIcon Seleccionado;
    ControladorAsiento ca = new ControladorAsiento();

    public Confi_Asiento(Asiento nuevoAsiento) throws IOException {
        this.setAsiento(nuevoAsiento);
        this.Ocupado = new ImageIcon(ImageIO.read(this.getClass().getResource("/imagenes/rojo.png")));
        this.Disponible = new ImageIcon(ImageIO.read(this.getClass().getResource("/imagenes/blanco.png")));
        this.Seleccionado = new ImageIcon(ImageIO.read(this.getClass().getResource("/imagenes/verde.png")));
        this.setIconDefault();
    }

    private Conexion getConexion() {
        return this.conexio;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    private void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public void reiniciar() {
        super.setSelected(false);
    }

    private void setIconDefault() {

        if ("si".equals(getAsiento().getDisponible())) {
            super.setIcon(this.Disponible);
        } else if ("no".equals(getAsiento().getDisponible())) {
            super.setDisabledIcon(Ocupado);
            this.setEnabled(false);
        }
        if (this.isEnabled()) {
            this.setSelectedIcon(Seleccionado);
        }
    }

}
