/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bilheteria.bilheteria;

import com.bilheteria.bilheteria.classes.Usuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author raul_
 */
public class FormDeletarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormDeletarUsuario
     */
    
    
        
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jButton2.setText("Deletar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2OnclickSalvar(evt);
            }
        });

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1OnclickFechar(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnclickDeletar(evt);
            }
        });

        jButton4.setText("Fechar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnclickFechar(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Id");

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        labelId.setText("00000");

        textNome.setEditable(false);
        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnclickNome(evt);
            }
        });

        textEmail.setEditable(false);
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnclickCPF(evt);
            }
        });

        textCPF.setEditable(false);
        textCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnclickEmail(evt);
            }
        });

        jLabel4.setText("CPF");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(textNome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 157, Short.MAX_VALUE))
                    .addComponent(textCPF))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelId))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FormDeletarUsuario(int id, String nome, String email, String cpf) {
        initComponents();
        labelId.setText(String.valueOf(id));
        textNome.setText(nome);
        textEmail.setText(email);
        textCPF.setText(cpf);
        
       
        
        System.out.println("id: " + id + " nome: " + nome + " email: " + email + ", cpf: " + cpf);
    }
    
    
    private void jButton2OnclickSalvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2OnclickSalvar
        int id = Integer.parseInt(labelId.getText()); // Recuperando o ID do estado

        // Exibir caixa de diálogo para confirmar a exclusão
        int option = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este estado?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // Se o usuário confirmou a exclusão, proceder com a exclusão do estado
            Usuarios estado = new Usuarios();
            String response = estado.deletarUsuarioDELETE(id);

            // Exibir mensagem de sucesso ou tratamento de erro
            if (response.equals("sucesso")) {
                System.out.println("Estado deletado com sucesso.");
            } else {
                System.out.println("Erro ao deletar estado: " + response);
            }

            // Fechar este formulário e abrir o formulário de listagem de estados
            FormListaEstados form = new FormListaEstados();
            form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            form.setVisible(true);

            this.dispose(); // Fechar
        }
        // Se o usuário escolher não excluir, não fazemos nada
    }//GEN-LAST:event_jButton2OnclickSalvar

    private void jButton1OnclickFechar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1OnclickFechar
        // TODO add your handling code here:

        var form = new FormListarUsuario();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);

        System.out.println("OnclickFechar");

        this.dispose(); // Fechar
    }//GEN-LAST:event_jButton1OnclickFechar

    private void OnclickDeletar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnclickDeletar
   int id = Integer.parseInt(labelId.getText()); // Recuperando o ID do estado
   
        // Exibir caixa de diálogo para confirmar a exclusão
        int option = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este estado?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // Se o usuário confirmou a exclusão, proceder com a exclusão do estado
            Usuarios estado = new Usuarios();
            String response = estado.deletarUsuarioDELETE(id);

            // Exibir mensagem de sucesso ou tratamento de erro
            if (response.equals("sucesso")) {
                System.out.println("Estado deletado com sucesso.");
            } else {
                System.out.println("Erro ao deletar estado: " + response);
            }

            // Fechar este formulário e abrir o formulário de listagem de estados
            FormListaEstados form = new FormListaEstados();
            form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            form.setVisible(true);

            this.dispose(); // Fechar
        }
        // Se o usuário escolher não excluir, não fazemos nada
    }//GEN-LAST:event_OnclickDeletar

    private void OnclickFechar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnclickFechar
        // TODO add your handling code here:

        var form = new FormListarUsuario();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);

        System.out.println("OnclickFechar");

        this.dispose(); // Fechar
    }//GEN-LAST:event_OnclickFechar

    private void OnclickNome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnclickNome
        // TODO add your handling code here:
    }//GEN-LAST:event_OnclickNome

    private void OnclickCPF(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnclickCPF
        // TODO add your handling code here:
    }//GEN-LAST:event_OnclickCPF

    private void OnclickEmail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnclickEmail
        // TODO add your handling code here:
    }//GEN-LAST:event_OnclickEmail

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
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FormDeletarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Exemplo de valores para id, nome, email e cpf
            int id = 1;
            String nome = "Fulano";
            String email = "fulano@example.com";
            String cpf = "123.456.789-00";

            // Chamando o construtor com os parâmetros necessários
            new FormDeletarUsuario(id, nome, email, cpf).setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelId;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
