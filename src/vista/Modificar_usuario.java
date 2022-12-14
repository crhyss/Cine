/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import controlador.ControladorComuna;
import controlador.ControladorRegion;
import controlador.ControladorDireccion;
import controlador.ControladorPersona;
import controlador.ControladorEmp;
import controlador.ControladorUsuario;
import controlador.ControladorVista;
import controlador.ControladorCliente;
import model.Direccion;
import model.Empleado;
import model.Persona;
import model.Usuario;

/**
 *
 * @author Branco
 */
public class Modificar_usuario extends javax.swing.JFrame {

    /**
     * Creates new form Agregar_usuario
     */
    String[] pre_CBcomuna = {"Seleccione comuna"};
    String[] e_civil = {"Soltero", "Casado"};
    String[] generos = {"Masculino", "Femenino", "Otro"};
    ControladorRegion cr = new ControladorRegion();
    ControladorComuna cc = new ControladorComuna();
    ControladorDireccion cd = new ControladorDireccion();
    ControladorPersona cp = new ControladorPersona();
    ControladorEmp ce = new ControladorEmp();
    ControladorUsuario cu = new ControladorUsuario();
    ControladorVista cv = new ControladorVista();
    ControladorCliente ccl = new ControladorCliente();
    String[] regiones = cr.llenarRegiones();
    String[] comunas = null;
    String run = "";

    public Modificar_usuario() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cine.in");
        this.setLocationRelativeTo(null);
        lab_comuna.setVisible(false);
        CBcomuna.setVisible(false);
        llenarEstado();
        llenarGenero();
        llenarRegion();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void llenarEstado() {
        for (String es : e_civil) {
            CBestado.addItem(es);
        }
    }

    private void llenarGenero() {
        for (String ge : generos) {
            CBgenero.addItem(ge);
        }
    }

    private void llenarRegion() {
        for (String re : regiones) {
            CBregion.addItem(re);
        }
    }

    private void llenarComunas(String[] comunas) {
        for (String co : comunas) {
            CBcomuna.addItem(co);
        }
    }

    private Direccion crearDireccion() {
        Direccion d = new Direccion(txt_calle.getText(), Integer.parseInt(txt_numero.getText()),
                cc.obtenerIdComuna(CBcomuna.getSelectedItem().toString()));
        return d;
    }

    private Persona crearPersona() {
        Persona p = new Persona(txt_run.getText() + "-" + txt_dv.getText(), txt_nombre.getText(), txt_apellido.getText());

        return p;
    }

    private Empleado crearEmpleado() {
        Empleado emp = new Empleado(Integer.parseInt(txt_edad.getText()), CBestado.getSelectedItem().toString(),
                CBgenero.getSelectedItem().toString());

        return emp;
    }

    private Usuario crearUsuario() {
        Usuario u = new Usuario(cu.crearNombre1(txt_nombre.getText(), txt_apellido.getText()),
                cu.crearContra(txt_nombre.getText(), txt_apellido.getText(), txt_run.getText()));

        return u;
    }

    private void limpiar() {
        txt_run.setText("");
        txt_dv.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_edad.setText("");
        txt_calle.setText("");
        txt_numero.setText("");
        CBestado.setSelectedIndex(0);
        CBgenero.setSelectedIndex(0);
        CBregion.setSelectedIndex(0);
    }

    private void rellenar() {
        Direccion d = null;
        Persona p = null;
        Empleado emp = null;
        Usuario u = null;

        u = cu.buscarUsuario(cu.obtenerId_usuario(txt_run.getText() + "-" + txt_dv.getText()));
        emp = ce.buscarEmpleado(ce.obtenerId_empleado(txt_run.getText() + "-" + txt_dv.getText()));
        p = cp.buscarPersona(cp.obtenerId_persona(txt_run.getText() + "-" + txt_dv.getText()));
        d = cd.buscarDireccion(cd.obtenerId_direccion(txt_run.getText() + "-" + txt_dv.getText()));

        String nom_r = cr.obtenerNombreR(cc.obtenerIdRegion(p.getRun()));
        String nom_c = cc.obtenerNombreC(cc.obtenerIdComunaU(p.getRun()));
        String[] runPart = p.getRun().split("-");
        String runs = runPart[0];
        String dv = runPart[1];

        txt_run.setText(runs);
        txt_dv.setText(dv);
        txt_nombre.setText(p.getNombre());
        txt_apellido.setText(p.getApellido());
        txt_edad.setText(String.valueOf(emp.getEdad()));
        CBestado.setSelectedItem(emp.getEst_civil());
        CBgenero.setSelectedItem(emp.getGenero());
        txt_calle.setText(d.getCalle());
        txt_numero.setText(String.valueOf(d.getNumero()));
        CBregion.setSelectedItem(nom_r);
        CBcomuna.setSelectedItem(nom_c);
    }

    private boolean validarVacios() {
        boolean valido = false;
        if (!txt_run.getText().equals("") && !txt_dv.getText().equals("") && !txt_nombre.getText().equals("")
                && !txt_apellido.getText().equals("")
                && !txt_edad.getText().equals("") && !txt_calle.getText().equals("")
                && !txt_numero.getText().equals("")) {
            valido = true;
        }
        return valido;
    }
    
    private boolean validarVacios2() {
        boolean valido = false;
        if (!txt_run.getText().equals("") && !txt_dv.getText().equals("")) {
            valido = true;
        }
        return valido;
    }

    private boolean validarSeleccionado() {
        boolean valido = true;
        if (CBestado.getSelectedIndex() == 0 || CBgenero.getSelectedIndex() == 0
                || CBregion.getSelectedIndex() == 0) {
            valido = false;
        }
        return valido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lab_comuna = new javax.swing.JLabel();
        txt_calle = new javax.swing.JTextField();
        txt_numero = new javax.swing.JTextField();
        CBregion = new javax.swing.JComboBox<>();
        CBcomuna = new javax.swing.JComboBox<>();
        txt_run = new javax.swing.JTextField();
        txt_dv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_edad = new javax.swing.JTextField();
        CBestado = new javax.swing.JComboBox<>();
        CBgenero = new javax.swing.JComboBox<>();
        ButtonModificar = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        ButtonAtras = new javax.swing.JButton();
        ButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Edad:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Estado civil:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("G??nero:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("RUN:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DIRECCI??N");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Calle:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("N??mero:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Regi??n:");

        lab_comuna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lab_comuna.setText("Comuna:");

        txt_calle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_calleKeyTyped(evt);
            }
        });

        txt_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numeroKeyTyped(evt);
            }
        });

        CBregion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione regi??n" }));
        CBregion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBregionActionPerformed(evt);
            }
        });

        CBcomuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBcomunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(lab_comuna))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_calle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CBcomuna, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CBregion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_numero, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CBregion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_comuna)
                    .addComponent(CBcomuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        txt_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runActionPerformed(evt);
            }
        });
        txt_run.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_runKeyTyped(evt);
            }
        });

        txt_dv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dvActionPerformed(evt);
            }
        });
        txt_dv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dvKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("-");

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });

        txt_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edadActionPerformed(evt);
            }
        });
        txt_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_edadKeyTyped(evt);
            }
        });

        CBestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione estado civil" }));
        CBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBestadoActionPerformed(evt);
            }
        });

        CBgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione g??nero" }));

        ButtonModificar.setText("Modificar");
        ButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModificarActionPerformed(evt);
            }
        });

        ButtonLimpiar.setText("Limpiar");
        ButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpiarActionPerformed(evt);
            }
        });

        ButtonAtras.setText("Atr??s");
        ButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAtrasActionPerformed(evt);
            }
        });

        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_run, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                        .addComponent(ButtonBuscar)
                                        .addGap(135, 135, 135)))
                                .addComponent(ButtonModificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CBgenero, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CBestado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txt_apellido, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(ButtonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonModificar)
                                .addComponent(ButtonBuscar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txt_run, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel13)
                                .addGap(11, 11, 11)
                                .addComponent(ButtonLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonAtras))))
                    .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CBestado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CBgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runActionPerformed
        // TODO add your handling ode here:
    }//GEN-LAST:event_txt_runActionPerformed

    private void txt_dvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dvActionPerformed

    private void txt_edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_edadActionPerformed

    private void CBestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBestadoActionPerformed

    private void CBregionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBregionActionPerformed
        if (CBregion.getSelectedIndex() != 0) {
            CBcomuna.removeAllItems();
            lab_comuna.setVisible(true);
            CBcomuna.setVisible(true);
            comunas = cc.llenarComunas(CBregion.getSelectedItem().toString());
            llenarComunas(comunas);
        }
        if (CBregion.getSelectedIndex() == 0) {
            lab_comuna.setVisible(false);
            CBcomuna.setVisible(false);
            CBcomuna.removeAllItems();

        }
    }//GEN-LAST:event_CBregionActionPerformed

    private void CBcomunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBcomunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBcomunaActionPerformed

    private void ButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModificarActionPerformed
        if (validarVacios()) {
            if (validarSeleccionado()) {
                if (Integer.parseInt(txt_edad.getText()) >= 18 && Integer.parseInt(txt_edad.getText()) <= 70) {
                    cd.ModificarDirU(crearDireccion(), cp.ModificarPerU(crearPersona(), ce.ModificarEmpU(crearEmpleado(),
                            cu.ModificarU(crearUsuario(), cu.obtenerId_usuario(this.run)))));
                    JOptionPane.showMessageDialog(null, "Se ha modificado correctamente la informaci??n del empleado " + this.run);
                } else {
                    JOptionPane.showMessageDialog(null, "Edad inv??lida");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor haga uso de todas las cajas de datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor rellene la informaci??n solicitada");
        }


    }//GEN-LAST:event_ButtonModificarActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        if (validarVacios2()) {
            if (cp.validarRun(txt_run.getText() + "-" + txt_dv.getText()) && !ccl.verificaExistenciaRun(txt_run.getText() + "-" + txt_dv.getText())) {
                this.run = txt_run.getText() + "-" + txt_dv.getText();
                if (cp.obtenerId_persona(this.run) != 0) {
                    rellenar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ning??n empleado con es RUN");
                }
            } else {
                JOptionPane.showMessageDialog(null, "RUN inv??lido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un run para buscar");
        }
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void ButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAtrasActionPerformed
        Menu_admin ma = new Menu_admin();
        dispose();
        ma.setVisible(true);
    }//GEN-LAST:event_ButtonAtrasActionPerformed

    private void txt_runKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarNumero(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_runKeyTyped

    private void txt_dvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (txt_dv.getText().length() < 1) {
            if (cv.validarDv(tecla)) {
                es = true;
            }
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_dvKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarUsuario(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarUsuario(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edadKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarNumero(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_edadKeyTyped

    private void txt_calleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_calleKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarLetra(tecla) || Character.isSpaceChar(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_calleKeyTyped

    private void txt_numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroKeyTyped
        char tecla = evt.getKeyChar();
        boolean es = false;
        if (cv.validarNumero(tecla)) {
            es = true;
        }
        if (!es) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_numeroKeyTyped

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
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAtras;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonModificar;
    private javax.swing.JComboBox<String> CBcomuna;
    private javax.swing.JComboBox<String> CBestado;
    private javax.swing.JComboBox<String> CBgenero;
    private javax.swing.JComboBox<String> CBregion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lab_comuna;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_calle;
    private javax.swing.JTextField txt_dv;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_run;
    // End of variables declaration//GEN-END:variables
}
