/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.leitorexpressoes;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LeitorJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AutomatoJFrame
     */
    public LeitorJFrame() {
        initComponents();
    }
    
    private void btnProcessarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        ExpressaoSimp.setText("uysauyduy");
    }                                            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelExpMat = new javax.swing.JLabel();
        PainelExpMat = new javax.swing.JScrollPane();
        ExpressaoMat = new javax.swing.JTextArea();
        PainelExpSimp = new javax.swing.JScrollPane();
        ExpressaoSimp = new javax.swing.JTextArea();
        LabelExpSimp = new javax.swing.JLabel();
        btnSimplificar = new javax.swing.JButton();
        btnReconhecer = new javax.swing.JButton();
        PainelReconhecimento = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        LabelRec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelExpMat.setText("Expressão Matematica");

        ExpressaoMat.setColumns(20);
        ExpressaoMat.setRows(5);
        PainelExpMat.setViewportView(ExpressaoMat);

        ExpressaoSimp.setColumns(20);
        ExpressaoSimp.setRows(5);
        PainelExpSimp.setViewportView(ExpressaoSimp);

        LabelExpSimp.setText("Expressão Simplificada");

        btnSimplificar.setText("Simplificar");
        btnSimplificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimplificarActionPerformed(evt);
            }
        });

        btnReconhecer.setText("Reconhecer");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        PainelReconhecimento.setViewportView(jTextArea3);

        LabelRec.setText("Expressão Reconhecida ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelExpMat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PainelExpSimp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelExpMat)
                            .addComponent(LabelExpSimp))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btnSimplificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(btnReconhecer)
                .addGap(236, 236, 236))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelRec)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PainelReconhecimento))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LabelExpMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelExpMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(LabelExpSimp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelExpSimp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(LabelRec)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PainelReconhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimplificar)
                            .addComponent(btnReconhecer))
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimplificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimplificarActionPerformed
        String expressaoMat,expressaoSimp; 
        ExpressaoSimplificada expressaoSimplificada = new ExpressaoSimplificada();
        
        expressaoMat = ExpressaoMat.getText().trim();
        try{
            if(expressaoMat.length()==0){
            throw new Exception("Expressão vazia, escreva uma expressão matematica para continuar");
            }
            expressaoSimp = expressaoSimplificada.converterExpressao(expressaoMat);
            ExpressaoSimp.setText(expressaoSimp);
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSimplificarActionPerformed

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
            java.util.logging.Logger.getLogger(LeitorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeitorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeitorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeitorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeitorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ExpressaoMat;
    private javax.swing.JTextArea ExpressaoSimp;
    private javax.swing.JLabel LabelExpMat;
    private javax.swing.JLabel LabelExpSimp;
    private javax.swing.JLabel LabelRec;
    private javax.swing.JScrollPane PainelExpMat;
    private javax.swing.JScrollPane PainelExpSimp;
    private javax.swing.JScrollPane PainelReconhecimento;
    private javax.swing.JButton btnReconhecer;
    private javax.swing.JButton btnSimplificar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}