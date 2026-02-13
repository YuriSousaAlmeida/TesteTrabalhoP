/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.ui;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.presentation.controllers.ClienteController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erko
 */
public class ClienteView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteView.class.getName());

//    private ClientePresenter presenter;
    private ClienteController controller;
    
    

//    public void setPresenter(ClientePresenter presenter) {
//        this.presenter = presenter;
//    }
    /**
     * Creates new form ClienteView
     */
    public ClienteView() {
        
        initComponents();
        setLocationRelativeTo(null);

    }


     public void inicializar() {
        setTitle("Gestão de Clientes - Sistema Delivery");
       
        limparCampos();
        this.configurarListeners();
        atualizarTabela();
        this.setVisible(true);
    }
    
    //setters que enviaram para presenter
//    @Override
    public String getNome() {
        return txtNome.getText();
    }

//    @Override
    public String getEmail() {
        return txtEMail.getText();
    }

//    @Override
    public String getCidade() {
        return txtCidade.getText();
    }

//    @Override
    public String getBairro() {
        return txtBairro.getText();
    }

//    @Override
    public String getRua() {
        return txtRua.getText();
    }

//    @Override
    public String getNumero() {
        return txtNumero.getText();
    }

    public String getCpf() {
        return txtCPF.getText();
    }

//    @Override
    public int getLinhaSelecionada() {
        return tblClientes.getSelectedRow();
    }

//    @Override
    public void mostrarMensagem(String msg) {
        //mostra um optionpane com a mensagem
        javax.swing.JOptionPane.showMessageDialog(this, msg);
    }

   

    public void setController(ClienteController controller) {
        this.controller = controller;
    }

    public void adicionarClienteNaTabela(String cpf, String nome, String endereco, String email) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

        model.addRow(new Object[]{cpf, nome, endereco, email});
    }
    // Dentro de ClienteView.java

    //=========metodos para adicionar lsiteners aos botoes=======================================================
    private void addSalvarListener(ActionListener listener) {
        btnSalvar.addActionListener(listener);
    }

    private void addPesquisarListener(ActionListener listener) {
        btnPesquisar.addActionListener(listener);
    }

    private void addLimparListener(ActionListener listener) {
        btnLimpar.addActionListener(listener);
    }

    private void addExcluirListener(ActionListener listener) {
        btnExcluir.addActionListener(listener);
    }

    private void addPedidosClienteListener(ActionListener listener) {
        btnPedidosDoCliente.addActionListener(listener);
    }
    //=====================================//=====================================//===================================== 
    
    private void configurarListeners() {
        // Ação do Botão Salvar
        btnSalvar.addActionListener((ActionEvent e) -> {
//            executarFluxoSalvar();
              salvarCliente();
              this.mostrarMensagem("Salvando");
        });

        // Ação do Botão Limpar
        btnLimpar.addActionListener(e -> {
            limparCampos();
            this.mostrarMensagem("Limpando campos de entrada");
        });
        
        //Ação botao pesquisar
        btnPesquisar.addActionListener((ActionEvent e) -> {
//            executarFluxoPesquisa();
              this.mostrarMensagem("Pesquisar ainda não implementado"); //TODO
        });
        
        
        //ação Botão Pedidos cliente
        btnPedidosDoCliente.addActionListener((ActionEvent e) -> {
//            executarFluxoPedidoCliente();

            //parent como parametro para poder desabilitar esta tela
            PedidosView pedidosView = new PedidosView(this, 0);   //TODO passando qualquer CPF como parametro por enquanto, até ser implementado
            
            
            //desativa essa janela 
            this.setEnabled(false);
            
            //mstra a nova janela PEDIDOS
            pedidosView.iniciarView();
            
            System.out.println("[Navegação] PedidosView aberta. ClienteView temporariamente inativa.");

           
        });
        
        
        
        // Ação do Botão Excluir
        btnExcluir.addActionListener(e -> {
            int row = tblClientes.getSelectedRow();
            if (row != -1) {
//                cacheVisual.remove(row); //remove linha (row) da tabela 
//                atualizarTabela();
                mostrarMensagem("Removido da visualização.");
            } else {
                mostrarMensagem("Selecione um cliente na tabela primeiro.");
            }
        });
    }

    private void salvarCliente(/*java.awt.event.ActionEvent evt*/) {
        CreateClienteInputDTO dto = new CreateClienteInputDTO();

        dto.nome = txtNome.getText();
        dto.email = txtEMail.getText();
        dto.cpf = txtCPF.getText();

        dto.cidade = txtCidade.getText();
        dto.bairro = txtBairro.getText();
        dto.rua = txtRua.getText();
        dto.numero = txtNumero.getText();

        if (controller != null) {
            Optional<CreateClienteOutputDTO> retorno = controller.salvar(dto);
            if (retorno.isPresent()) {
                CreateClienteOutputDTO output = retorno.get();
                String enderecoCompleto = dto.rua + ", " + dto.numero + " - " + dto.bairro + " - " + dto.cidade;

                adicionarClienteNaTabela(output.cpf, output.nome, enderecoCompleto, output.email);

                System.out.println("DTO Enviado: " + dto.nome + " - CPF: " + dto.cpf);

//                limparCampos();
            } else {
                mostrarMensagem("Erro ao salvar cliente.");
            }

        } else {
            System.err.println("Erro: Controller não foi inicializado!");
        }

    }

    
    
    
//       @Override
    public void atualizarTabela(/*List<CreateClienteOutputDTO> clientes*/) { //limpa tabela e preenche com clientes 
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel(); 
        model.setRowCount(0);//limpa tabela
        List<CreateClienteOutputDTO> clientes = controller.listarTodos();
        for (CreateClienteOutputDTO c : clientes) { //preenche com os dados da lista de clientes
            model.addRow(new Object[]{ c.cpf, c.nome, c.getEnderecoFormatado(), c.email});
    
        }
    }
    
    public void limparCampos() {
        txtNome.setText("");
        txtEMail.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtCPF.setText("");
    }

    
    public void limparTabela(){
          DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.setRowCount(0);
    }
//====================================================================
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEMail = new javax.swing.JLabel();
        txtEMail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        scrClientes = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnPedidosDoCliente = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome");

        lblEMail.setText("E-mail");

        lblEndereco.setText("Endereco: ");

        btnSalvar.setText("Salvar");

        btnLimpar.setText("Limpar");

        btnExcluir.setText("Excluir");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Endereço", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setColumnSelectionAllowed(true);
        scrClientes.setViewportView(tblClientes);
        tblClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblCidade.setText("Cidade");

        lblBairro.setText("Bairro");

        lblRua.setText("Rua");

        lblNumero.setText("Número");

        btnPedidosDoCliente.setText("Pedidos do Cliente");
        btnPedidosDoCliente.addActionListener(this::btnPedidosDoClienteActionPerformed);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(this::btnPesquisarActionPerformed);

        lblCPF.setText("CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEMail)
                                    .addComponent(txtEMail, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addComponent(lblRua)
                            .addComponent(lblNumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRua)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(scrClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPedidosDoCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblEMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRua)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPedidosDoCliente)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPedidosDoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosDoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPedidosDoClienteActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ClienteView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPedidosDoCliente;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEMail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRua;
    private javax.swing.JScrollPane scrClientes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEMail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
