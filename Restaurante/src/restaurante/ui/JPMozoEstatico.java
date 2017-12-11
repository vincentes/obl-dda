/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import restaurante.controladores.CMozoMenu;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Sistema;
import restaurante.dominio.Transferencia;
import restaurante.vistas.VMozoMenu;

/**
 *
 * @author vincentes
 */
public class JPMozoEstatico extends javax.swing.JPanel implements VMozoMenu {

    private CMozoMenu controlador;
    private JPMozoMesas jpMesas;
    private Mozo mozo;
    private MozoVentana ventana;
    private Mesa seleccionada;

    @Override
    public void deshabilitarAbrir() {
        toggle.setVisible(false);
    }

    @Override
    public void habilitarToggle() {
        toggle.setVisible(true);
    }

    @Override
    public void textoToggle(boolean abierta) {
        toggle.setText((abierta ? "Cerrar" : "Abrir"));
    }

    @Override
    public void mostrarArticulos(String[] articulos) {
        this.articulos.setListData(articulos);
    }

    @Override
    public void actualizarProcesadores(String[] procesadoras) {
        this.procesadoras.removeAllItems();
        if (procesadoras.length == 0) {
            this.procesadoras.addItem("Ninguna");
        } else {
            for (String procesadora : procesadoras) {
                this.procesadoras.addItem(procesadora);
            }
        }
    }

    @Override
    public String getProcesadoraSeleccionada() {
        Object selectedItem = procesadoras.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        }
        return null;
    }

    @Override
    public void actualizarMozosTransfer(String[] mozos) {
        this.mozosTransfer.removeAllItems();
        if (mozos.length == 0) {
            ocultarTransferir();

        } else {
            if (seleccionada != null) {
                mostrarTransferir();
                for (String mozo : mozos) {
                    this.mozosTransfer.addItem(mozo);
                }
            }

        }
    }

    @Override
    public void actualizarProductos(String[] productos) {
        this.productos.removeAllItems();
        if (productos.length == 0) {
            this.productos.addItem("Ninguna");
        } else {
            for (String procesadora : productos) {
                this.productos.addItem(procesadora);
            }
        }
    }

    private void clear() {
        cantidad.setText("");
        descripcion.setText("");
        procesadoras.setSelectedIndex(0);
        controlador.actualizarProductos();
        productos.setSelectedIndex(0);
    }

    @Override
    public void hideServicio() {
    }

    @Override
    public void mostrarServicio() {
    }
    
    @Override
    public void logOut() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
    }

    @Override
    public void actualizarTransferencia() {
         if(this.mozo.getTransfer()!=null)
        {
            new FrameTransferencia(this.mozo.getTransfer()).setVisible(true);
        }
    }

    @Override
    public void toggleMesaSeleccionada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mesaNoVacia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class MesaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BotonMesa source = (BotonMesa) e.getSource();
            seleccionada = source.getMesa();
            controlador.setSeleccionada(seleccionada);
            controlador.actualizarMesaSeleccionada();
            servicio.setVisible(seleccionada.getAbierta());
            controlador.actualizarArticulos();
            controlador.actualizarProductos();
            controlador.actualizarProcesadores();
            controlador.actualizarMozosTransferencia();
            clear();
        }

    }

    /**
     * Creates new form JPMozoEstatico
     */
    public JPMozoEstatico(JPMozoMesas jpMesas, Mozo mozo) {
        initComponents();
        this.jpMesas = jpMesas;
        this.mozo = mozo;
        mesaSeleccionadaLabel.setVisible(false);
        mesaSeleccionada.setVisible(false);
        ocultarTransferir();

        jpMesas.setListener(new MesaListener());
        controlador = new CMozoMenu(mozo, this);
    }

    public void ocultarTransferir() {
        mozosTransfer.setVisible(false);
        btnTransferir.setVisible(false);
        LblTituloTransfer.setVisible(false);
        LblTituloMozoDestino.setVisible(false);
    }

    public void mostrarTransferir() {
        mozosTransfer.setVisible(true);
        btnTransferir.setVisible(true);
        LblTituloTransfer.setVisible(true);
        LblTituloMozoDestino.setVisible(true);
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
        mesaSeleccionadaLabel = new javax.swing.JLabel();
        mesaSeleccionada = new javax.swing.JLabel();
        toggle = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        servicio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        articulos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        procesadoras = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        productos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        ingresar = new javax.swing.JButton();
        BtnLogout = new javax.swing.JButton();
        LblTituloTransfer = new javax.swing.JLabel();
        LblTituloMozoDestino = new javax.swing.JLabel();
        mozosTransfer = new javax.swing.JComboBox<>();
        btnTransferir = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 800));
        setName(""); // NOI18N
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Tus mesas");
        add(jLabel1);
        jLabel1.setBounds(20, 310, 114, 30);

        mesaSeleccionadaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mesaSeleccionadaLabel.setText("MESA SELECCIONADA");
        add(mesaSeleccionadaLabel);
        mesaSeleccionadaLabel.setBounds(10, 10, 178, 22);

        mesaSeleccionada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mesaSeleccionada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesaSeleccionada.setText("100");
        mesaSeleccionada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(mesaSeleccionada);
        mesaSeleccionada.setBounds(200, 10, 136, 30);

        toggle.setText("Abrir");
        toggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });
        add(toggle);
        toggle.setBounds(340, 10, 136, 34);
        add(filler1);
        filler1.setBounds(190, 240, 0, 0);

        servicio.setLayout(null);

        jLabel2.setText("Servicio");
        servicio.add(jLabel2);
        jLabel2.setBounds(10, 80, 50, 20);

        jScrollPane1.setViewportView(articulos);

        servicio.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 660, 110);

        jLabel3.setText("Procesadora");
        servicio.add(jLabel3);
        jLabel3.setBounds(10, 10, 120, 14);

        procesadoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        procesadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesadorasActionPerformed(evt);
            }
        });
        servicio.add(procesadoras);
        procesadoras.setBounds(10, 30, 130, 20);

        jLabel4.setText("Artículo");
        servicio.add(jLabel4);
        jLabel4.setBounds(150, 10, 90, 14);

        productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        servicio.add(productos);
        productos.setBounds(150, 30, 230, 20);

        jLabel5.setText("Cantidad");
        servicio.add(jLabel5);
        jLabel5.setBounds(400, 10, 70, 14);
        servicio.add(cantidad);
        cantidad.setBounds(400, 30, 50, 20);

        jLabel6.setText("Descripción");
        servicio.add(jLabel6);
        jLabel6.setBounds(470, 10, 110, 14);
        servicio.add(descripcion);
        descripcion.setBounds(470, 30, 190, 20);

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        servicio.add(ingresar);
        ingresar.setBounds(70, 60, 540, 30);

        add(servicio);
        servicio.setBounds(10, 100, 670, 210);
        servicio.setVisible(false);

        BtnLogout.setText("Logout");
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });
        add(BtnLogout);
        BtnLogout.setBounds(570, 0, 110, 23);

        LblTituloTransfer.setText("Transferencia");
        add(LblTituloTransfer);
        LblTituloTransfer.setBounds(10, 40, 120, 14);

        LblTituloMozoDestino.setText("Mozo Destino");
        add(LblTituloMozoDestino);
        LblTituloMozoDestino.setBounds(10, 60, 120, 14);

        mozosTransfer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mozosTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mozosTransferActionPerformed(evt);
            }
        });
        add(mozosTransfer);
        mozosTransfer.setBounds(120, 60, 130, 20);

        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        add(btnTransferir);
        btnTransferir.setBounds(260, 60, 110, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void procesadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesadorasActionPerformed

        controlador.actualizarProductos();
    }//GEN-LAST:event_procesadorasActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        String producto = productos.getSelectedItem().toString();
        final String cantidadStr = cantidad.getText();
        if (cantidadStr.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida");
            return;
        }
        int cant = Integer.valueOf(cantidadStr);
        if (cant <= 0) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida");
            return;
        }
        String descrip = descripcion.getText();
        if (!controlador.ingresar(producto, cant, descrip)) {
            JOptionPane.showMessageDialog(this, "Sin stock");
            return;
        }
        // TODO: ENVIAR A UNIDAD PROCESADORA
    }//GEN-LAST:event_ingresarActionPerformed

    private void toggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleActionPerformed
        if (controlador.toggleMesaSeleccionada()) {
            String toggleText = toggle.getText();
            if (toggleText.equals("Abrir")) {
                toggle.setText("Cerrar");
                servicio.setVisible(true);
            } else {
                toggle.setText("Abrir");
                servicio.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No es posible cerrar la mesa - existen pedidos pendientes en el servicio.");
        }
    }//GEN-LAST:event_toggleActionPerformed

    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
        controlador.logOut();
    }//GEN-LAST:event_BtnLogoutActionPerformed

    private void mozosTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mozosTransferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mozosTransferActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        controlador.transferirMesa(mozosTransfer.getSelectedIndex());
    }//GEN-LAST:event_btnTransferirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogout;
    private javax.swing.JLabel LblTituloMozoDestino;
    private javax.swing.JLabel LblTituloTransfer;
    private javax.swing.JList<String> articulos;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField descripcion;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mesaSeleccionada;
    private javax.swing.JLabel mesaSeleccionadaLabel;
    private javax.swing.JComboBox<String> mozosTransfer;
    private javax.swing.JComboBox<String> procesadoras;
    private javax.swing.JComboBox<String> productos;
    private javax.swing.JPanel servicio;
    private javax.swing.JButton toggle;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMesas(ArrayList<Mesa> mesas) {
        jpMesas.mostrar(mesas, 3);
    }

    // @Override
    // public void mostrarTransferir() {
    //     transferir.setVisible(true);
    // }
    @Override
    public void avisarMesaSeleccionada(Mesa mesa) {
        mesaSeleccionada.setText(String.valueOf(mesa.getNumero()));
        mesaSeleccionadaLabel.setVisible(true);
        mesaSeleccionada.setVisible(true);
        mostrarTransferir();

    }

    @Override
    public void error(String msg) {
        JOptionPane.showMessageDialog(this, msg);

    }
}
