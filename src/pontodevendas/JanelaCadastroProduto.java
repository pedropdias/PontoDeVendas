/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pontodevendas;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pedro Dias
 */
public class JanelaCadastroProduto extends javax.swing.JDialog {

    private OperacaoCadastroProduto operacaoCadastroProduto;
    private Produto produto;
    private boolean confirmado;
    
    public boolean operacaoConfirmada(){
        return confirmado;
    }
    
    public static boolean executar(OperacaoCadastroProduto operacaoCadastroProduto,
                                    Produto produto){
        JanelaCadastroProduto cadastroProduto = new JanelaCadastroProduto(null, operacaoCadastroProduto, produto);
        cadastroProduto.setLocationRelativeTo(null);
        cadastroProduto.setVisible(true);
        return cadastroProduto.operacaoConfirmada();
    }

    
    
    public JanelaCadastroProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JanelaCadastroProduto(java.awt.Frame parent, 
            OperacaoCadastroProduto operacaoCadastroProduto, 
            Produto produto){
        super(parent, true);
        
        confirmado = false;
        this.operacaoCadastroProduto = operacaoCadastroProduto;
        this.produto = produto;
        
        initComponents();
        
        if(operacaoCadastroProduto == OperacaoCadastroProduto.alterar ||
           operacaoCadastroProduto == OperacaoCadastroProduto.consultar){
            edNome.setText(produto.obterNome());
            edCodigo.setText(Integer.toString(produto.obterCodigo()));
            edUnidade.setText(produto.obterUnidade());
            edPreco.setText(Double.toString(produto.obterPreco()));
            edQntEstoque.setText(Integer.toString(produto.obterQntEstoque()));
            if (produto.obterDataUltimaVenda() instanceof Date) {
                Date dataUltimaVenda = (Date) produto.obterDataUltimaVenda();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataUltimaVendaString = dateFormat.format(dataUltimaVenda);

                edDataUltimaVenda.setText(dataUltimaVendaString);
            }  
        }
        buCancelar.setVisible(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edNome.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edCodigo.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edUnidade.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edPreco.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edQntEstoque.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        edDataUltimaVenda.setEnabled(operacaoCadastroProduto != OperacaoCadastroProduto.consultar);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edNome = new javax.swing.JTextField();
        edCodigo = new javax.swing.JTextField();
        edUnidade = new javax.swing.JTextField();
        edPreco = new javax.swing.JTextField();
        edQntEstoque = new javax.swing.JTextField();
        edDataUltimaVenda = new javax.swing.JTextField();
        buOk = new javax.swing.JButton();
        buCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Código:");

        jLabel3.setText("Unidade:");

        jLabel4.setText("Preço:");

        jLabel5.setText("Quantidade em estoque:");

        jLabel6.setText("Última venda (dd/mm/yyyy):");

        edNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edNomeActionPerformed(evt);
            }
        });

        edCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCodigoActionPerformed(evt);
            }
        });

        edUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edUnidadeActionPerformed(evt);
            }
        });

        edPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edPrecoActionPerformed(evt);
            }
        });

        edQntEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edQntEstoqueActionPerformed(evt);
            }
        });

        edDataUltimaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edDataUltimaVendaActionPerformed(evt);
            }
        });

        buOk.setText("Ok");
        buOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buOkActionPerformed(evt);
            }
        });

        buCancelar.setText("Cancelar");
        buCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Cadastro de Produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(edDataUltimaVenda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(edQntEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edUnidade)
                                    .addComponent(edPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edNome)
                            .addComponent(edCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel7)
                .addGap(0, 169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buOk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(edCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(edUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edQntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edDataUltimaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edUnidadeActionPerformed

    private void edNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edNomeActionPerformed

    private void edCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCodigoActionPerformed

    private void edPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edPrecoActionPerformed

    private void edQntEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edQntEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edQntEstoqueActionPerformed

    private void edDataUltimaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edDataUltimaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edDataUltimaVendaActionPerformed

    private void buOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buOkActionPerformed
        if(operacaoCadastroProduto != OperacaoCadastroProduto.consultar){
            produto.alterarNome(edNome.getText());
            produto.alterarCodigo(Integer.parseInt(edCodigo.getText()));
            produto.alterarUnidade(edUnidade.getText());
            produto.alterarPreco(Double.parseDouble(edPreco.getText()));
            produto.alterarQntEstoque(Integer.parseInt(edQntEstoque.getText()));
            String dataUltimaVendaString = edDataUltimaVenda.getText();
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dataUltimaVenda = dateFormat.parse(dataUltimaVendaString);
                produto.alterarDataUltimaVenda(dataUltimaVenda);
            } catch(ParseException e){
                
            }
            confirmado = true;
        }
        dispose();
    }//GEN-LAST:event_buOkActionPerformed

    private void buCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaCadastroProduto dialog = new JanelaCadastroProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buCancelar;
    private javax.swing.JButton buOk;
    private javax.swing.JTextField edCodigo;
    private javax.swing.JTextField edDataUltimaVenda;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edPreco;
    private javax.swing.JTextField edQntEstoque;
    private javax.swing.JTextField edUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
