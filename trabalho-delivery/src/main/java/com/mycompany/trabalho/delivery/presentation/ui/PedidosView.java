/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.trabalho.delivery.presentation.ui;

import com.mycompany.trabalho.delivery.presentation.controllers.PedidosController;
import com.mycompany.trabalho.delivery.presentation.Presenter.PedidosPresenter;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erko
 */
public class PedidosView extends javax.swing.JFrame {
    private JFrame parent;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PedidosView.class.getName());
    private PedidosController controller;
    private PedidosPresenter presenter;
    public PedidosView(PedidosController controller, PedidosPresenter presenter) {
        this.parent=null;
        this.controller = controller;
        this.presenter = presenter;
        initComponents();
    }
    
    public PedidosView() {
        this.parent=null;
        initComponents();
    }
    
    public PedidosView(JFrame parent, int cpf) { //CPF usado para recuperar pedidos do cliente
        this();
        this.parent = parent;
        initComponents();
        
        //listener para detectar quando esta janela fechar
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (parent != null) {
                    parent.setEnabled(true); //reativa a ClienteView
                    parent.toFront();        //traz pra frente
                }
            }
        });
        
    }
    
    
    private void addNovoPedidoListener(ActionListener listener) {
        btnNovoPedido.addActionListener(listener);
    }

    private void addVerPedidoListener(ActionListener listener) {
        btnVerPedido.addActionListener(listener);
    }

    private void addCancelarPedidoListener(ActionListener listener) {
        btnCancelarPedido.addActionListener(listener);
    }
//==========================================================================================
    
    public void configurarListenersBotoes(){
            
    }
    
    public void iniciarView(){
        limparTabelas();
        setLocationRelativeTo(null);
        this.setVisible(true);      
    }
    
    public void limparTabelas(){
        DefaultTableModel modelTblPedidos = (DefaultTableModel) tblPedidos.getModel(); //limpa tabela
        modelTblPedidos.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeCliente = new javax.swing.JLabel();
        scrPedidos = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnNovoPedido = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();
        btnVerPedido = new javax.swing.JButton();
        btnAvancarEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeCliente.setText("Pedido do cliente: Fulano");

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPedidos.setViewportView(tblPedidos);

        btnNovoPedido.setText("Novo Pedido");

        btnCancelarPedido.setText("Cancelar Pedido");

        btnVerPedido.setText("Ver Pedido");
        btnVerPedido.addActionListener(this::btnVerPedidoActionPerformed);

        btnAvancarEstado.setText("Avançar Estado");
        btnAvancarEstado.addActionListener(this::btnAvancarEstadoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrPedidos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovoPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVerPedido)
                                .addGap(59, 59, 59)
                                .addComponent(btnAvancarEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarPedido)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarPedido)
                    .addComponent(btnAvancarEstado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovoPedido)
                        .addComponent(btnVerPedido)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvancarEstadoActionPerformed

    private void btnVerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerPedidoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PedidosView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarEstado;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnNovoPedido;
    private javax.swing.JButton btnVerPedido;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JScrollPane scrPedidos;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

}
