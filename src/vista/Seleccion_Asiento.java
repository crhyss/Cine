/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Confi_Asiento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Asiento;
import controlador.ControladorAsiento;

/**
 *
 * @author cris_
 */
public final class Seleccion_Asiento extends javax.swing.JFrame {

    /**
     * Creates new form asis
     */
    private List<Confi_Asiento> botones = new ArrayList<Confi_Asiento>();

    public Seleccion_Asiento() {
        initComponents();
        setTitle("Cine.in");
        this.setLocationRelativeTo(null);
        crearAsientos();
        pasardatos();
    }
    int contadorasi = 1;
    ControladorAsiento ca = new ControladorAsiento();
    List<Asiento> asientos = new ArrayList();
    int posicionColumna = 10;
    int posicionFila = 1;
    int cantFilas = 4;
    int contador = 1;

    private void crearAsientos() {

        if (Entradas.sala.getText().length() == 8) {
            String numero = Entradas.sala.getText().charAt(7) + "";
            int numero2 = Integer.parseInt(numero);
            asientos = new ControladorAsiento().buscarAsiento(numero2);

        }

        try {
            for (Asiento temp : asientos) {
                Confi_Asiento nuevoAsiento = new Confi_Asiento(temp);
                nuevoAsiento.setSize(30, 35);
                nuevoAsiento.setLocation(posicionColumna, posicionFila);
                posicionFila = posicionFila + 35;
                contadorasi++;

                nuevoAsiento.setOpaque(false);
                if (contador % cantFilas == 0) {
                    posicionColumna = posicionColumna + 38;
                    posicionFila = 1;
                }
                //Añadimos el nuevo elemento al Jlambel
                panel_asientos.add(nuevoAsiento);
                this.botones.add(nuevoAsiento);
                contador++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
private void pasardatos(){


}
//    public void lista() {
//        Boleta.ppelicula.setText(Entradas.jnombre.getText());
//        System.out.println(Entradas.jnombre.getText());
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        comprar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ocu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        libre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panel_asientos = new javax.swing.JPanel();
        cantA = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        s = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        funcion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        salass = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });
        getContentPane().add(comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 327, -1, -1));

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 327, -1, -1));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rojo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jLabel2, gridBagConstraints);

        ocu.setText("ocupados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel1.add(ocu, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blanco.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jLabel1, gridBagConstraints);

        libre.setText("libres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(libre, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verde.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel3.setText("seleccionado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jLabel3, gridBagConstraints);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 120, -1, 150));

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel4.setText("A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 10, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel7.setText("B");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 12, 0, 2);
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setText("C");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        jLabel9.setText("D");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 10, 11, 0);
        jPanel2.add(jLabel9, gridBagConstraints);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, -1, -1));

        jLabel10.setText("    1");

        jLabel11.setText("    2");

        jLabel12.setText("    3");

        jLabel13.setText("   4");

        jLabel14.setText("    5");

        jLabel15.setText("     6");

        jLabel16.setText("  7");

        jLabel17.setText("    8");

        jLabel18.setText("   9");

        jLabel19.setText(" 10 ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(28, 28, 28)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addComponent(jLabel12)
                .addComponent(jLabel13)
                .addComponent(jLabel14)
                .addComponent(jLabel15)
                .addComponent(jLabel16)
                .addComponent(jLabel17)
                .addComponent(jLabel18)
                .addComponent(jLabel19))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 290, -1, -1));

        javax.swing.GroupLayout panel_asientosLayout = new javax.swing.GroupLayout(panel_asientos);
        panel_asientos.setLayout(panel_asientosLayout);
        panel_asientosLayout.setHorizontalGroup(
            panel_asientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        panel_asientosLayout.setVerticalGroup(
            panel_asientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        getContentPane().add(panel_asientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 129, 395, -1));

        cantA.setText("0");
        getContentPane().add(cantA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 27, -1));

        jLabel20.setText("Asientos Por Reservar:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        a.setText("jLabel21");
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        s.setText("jLabel22");
        getContentPane().add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        d.setText("jLabel23");
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        funcion.setText("jLabel24");
        getContentPane().add(funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pantalla.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 78));

        salass.setText("jLabel21");
        getContentPane().add(salass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jButton1.setText("Ver Mapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        List<Asiento> asientosSeleccionados = new ArrayList<Asiento>();
        ControladorAsiento ca = new ControladorAsiento();
        for (Confi_Asiento boton : botones) {
            if (boton.isSelected()) {
                asientosSeleccionados.add(boton.getAsiento());
            }
        }
        StringBuffer string = new StringBuffer();
        string.append("Cantidad de asientos selecionados %s\n");
        for (Asiento temp : asientosSeleccionados) {
            if (String.format(String.valueOf(asientosSeleccionados.size())).equals(cantA.getText())) {
                ca.modificarAsiento(temp.getN_asiento());
            }
        }
        if (String.format(String.valueOf(asientosSeleccionados.size())).equals(cantA.getText())) {
            Boleta bol = new Boleta();
            bol.setVisible(true);
            dispose();}
            else{
            JOptionPane.showMessageDialog(null, "Seleccione la Cantidad de asientos Comprados");}
        
    }//GEN-LAST:event_comprarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Mapa_cine mc = new Mapa_cine();
    mc.setVisible(true);
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Seleccion_Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion_Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion_Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion_Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccion_Asiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel a;
    public static javax.swing.JLabel cantA;
    private javax.swing.JButton comprar;
    public static javax.swing.JLabel d;
    public static javax.swing.JLabel funcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel libre;
    private javax.swing.JLabel ocu;
    private javax.swing.JPanel panel_asientos;
    public static javax.swing.JLabel s;
    public static javax.swing.JLabel salass;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

}
