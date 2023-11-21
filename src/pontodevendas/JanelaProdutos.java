/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pontodevendas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Dias
 */
public class JanelaProdutos extends javax.swing.JDialog {

    private static ControladorProduto tabelaProduto;

    
    public JanelaProdutos(java.awt.Frame parent, boolean modal, ControladorProduto tabelaProduto) {
        super(parent, modal);
        initComponents();
        this.tabelaProduto = tabelaProduto;
        tabProduto.setModel(tabelaProduto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new javax.swing.JTable();
        buCadastrar = new javax.swing.JButton();
        buEditar = new javax.swing.JButton();
        buExcluir = new javax.swing.JButton();
        buConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabProduto);

        buCadastrar.setText("Cadastrar");
        buCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCadastrarActionPerformed(evt);
            }
        });

        buEditar.setText("Editar");
        buEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buEditarActionPerformed(evt);
            }
        });

        buExcluir.setText("Excluir");
        buExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExcluirActionPerformed(evt);
            }
        });

        buConsultar.setText("Consultar");
        buConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buConsultarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Produtos");

        buVoltar.setText("Voltar");
        buVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(buEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(buVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(buEditar)
                        .addGap(18, 18, 18)
                        .addComponent(buExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(buConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buVoltar))
                    .addComponent(jScrollPane1))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buEditarActionPerformed
        int indice = tabProduto.getSelectedRow();
        if(indice >= 0){
            Produto produto = tabelaProduto.obterProduto(indice);
            if(JanelaCadastroProduto.executar(OperacaoCadastroProduto.alterar, produto)){
                tabelaProduto.alterarProduto(indice, produto);
            }
        }
    }//GEN-LAST:event_buEditarActionPerformed

    private void buCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCadastrarActionPerformed
          Produto produto = new Produto();
          if(JanelaCadastroProduto.executar(OperacaoCadastroProduto.incluir, produto)){
              tabelaProduto.incluirProduto(produto);
          }
    }//GEN-LAST:event_buCadastrarActionPerformed

    private void buExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExcluirActionPerformed
        int indice = tabProduto.getSelectedRow();
        if(indice >= 0){
            tabelaProduto.removerProduto(indice);
        }
    }//GEN-LAST:event_buExcluirActionPerformed

    private void buConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buConsultarActionPerformed
        int indice = tabProduto.getSelectedRow();
        if(indice >= 0){
              Produto produto = tabelaProduto.obterProduto(indice);
              JanelaCadastroProduto.executar(OperacaoCadastroProduto.consultar, produto);
        }
    }//GEN-LAST:event_buConsultarActionPerformed

    private void buVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_buVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaProdutos dialog = new JanelaProdutos(new javax.swing.JFrame(), true, tabelaProduto);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buCadastrar;
    private javax.swing.JButton buConsultar;
    private javax.swing.JButton buEditar;
    private javax.swing.JButton buExcluir;
    private javax.swing.JButton buVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabProduto;
    // End of variables declaration//GEN-END:variables
}
