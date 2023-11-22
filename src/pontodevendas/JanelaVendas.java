/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pontodevendas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Dias
 */
public class JanelaVendas extends javax.swing.JDialog {

    private static ControladorVenda controladorVenda;
//    private static ControladorItemVenda controladorItemVenda;
    private static ControladorProduto tabelaProduto;
    private FormaPagamento formaPagamento;
    
    public JanelaVendas(java.awt.Frame parent, boolean modal, ControladorProduto tabelaProduto) {
        super(parent, modal);
        initComponents();
        this.tabelaProduto = tabelaProduto;
//        this.controladorItemVenda = new ControladorItemVenda();
        this.controladorVenda = new ControladorVenda(tabelaProduto);
        tabVenda.setModel(controladorVenda);
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
        tabVenda = new javax.swing.JTable();
        buConsultar = new javax.swing.JButton();
        buCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabVenda);

        buConsultar.setText("Consultar");
        buConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buConsultarActionPerformed(evt);
            }
        });

        buCadastrar.setText("Cadastrar");
        buCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Vendas");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(buConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(buVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(buConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buVoltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buConsultarActionPerformed
        int indice = tabVenda.getSelectedRow();
        
        if (indice >= 0){
            Venda venda = controladorVenda.obterVenda(indice);
            JOptionPane.showMessageDialog(this,"Data da venda: "+venda.obterDataVenda()+"\n"+
                                                           "Hora da venda: "+venda.obterHoraVenda()+"\n"+
                                                           "Valor da venda: "+venda.obterValorTotalVenda()+"\n"+
                                                           "Forma de pagamento: "+venda.obterFormaPagamento());//+"\n"+
//                                                           "Itens da venda: "+controladorItemVenda.obterItensVenda());
            }
        
        
//        if(indice >= 0){
//            Produto produto = tabelaProduto.obterProduto(indice);
//            JanelaCadastroProduto.executar(OperacaoCadastroProduto.consultar, produto);
//        }
    }//GEN-LAST:event_buConsultarActionPerformed

    private void buCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCadastrarActionPerformed
        JanelaCadastroVenda janelaCadastroVenda = new JanelaCadastroVenda(null, true, tabelaProduto, controladorVenda);
        janelaCadastroVenda.setLocationRelativeTo(null);
        janelaCadastroVenda.setVisible(true);

        Venda venda = new Venda();
//        String dataString = "21/11/2023";
//
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate dataVenda = LocalDate.parse(dataString, formatter);
//            venda.alterarDataVenda(dataVenda);
//        } catch (DateTimeParseException e) {
//            // Lidar com o caso em que a String não pode ser convertida para LocalDate
//            System.out.println("Formato de data inválido: " + dataString);
//        }
//        
//        String horaString = "14:30";
//
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//            LocalTime horaVenda = LocalTime.parse(horaString, formatter);
//            venda.alterarHoraVenda(horaVenda);
//        } catch (DateTimeParseException e) {
//            // Lidar com o caso em que a String não pode ser convertida para LocalTime
//            System.out.println("Formato de hora inválido: " + horaString);
//        }
//        
//        venda.alterarValorTotalVenda(Double.parseDouble("51.99"));
//
//        venda.alterarFormaPagamento(true);
//        
////        if(JanelaCadastroProduto.executar(OperacaoCadastroProduto.incluir, produto)){
////            tabelaProduto.incluirProduto(produto);
////        }
//        controladorVenda.incluirVenda(venda);
////        controladorItemVenda.incluirItemVenda(47, 1234, 3, controladorProduto);
    }//GEN-LAST:event_buCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaVendas dialog = new JanelaVendas(new javax.swing.JFrame(), true, tabelaProduto);
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
    private javax.swing.JButton buVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabVenda;
    // End of variables declaration//GEN-END:variables
}
