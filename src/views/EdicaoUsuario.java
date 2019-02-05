package views;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import models.Usuario;

public class EdicaoUsuario extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Usuario usuario;

    public EdicaoUsuario(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setUsuario(usuario);
    }

    private void checkJTextNome() {
        if (jTextNome.getText().equals("")) {
            jLabelAvisoNome.setText("Campo obrigatório");
        } else {
            jLabelAvisoNome.setText("");
        }
    }

    private void checkJTextCpf() {
        if (jTextCpf.getText().equals("")) {
            jLabelAvisoCpf.setText("Campo obrigatório");
        } else if (jTextCpf.getText().length() != 11) {
            jLabelAvisoCpf.setText("CPF inválido");
        } else {
            jLabelAvisoCpf.setText("");
        }
    }

    private void setUsuario(Usuario usuario) {
        jTextLogin.setText(usuario.getLogin());
        jTextNome.setText(usuario.getNome());
        jTextCpf.setText(usuario.getCpf());
        jComboBoxTipo.setSelectedIndex(usuario.isAdmin() ? 1 : 0);
    }

    private void limparAvisos() {
        jLabelAvisoNome.setText("");
        jLabelAvisoCpf.setText("");
    }

    private boolean formIsInvalid() {
        return jLabelAvisoNome.getText().equals("") && jLabelAvisoCpf.getText().equals("");
    }

    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jLabelTipo = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelEditarUsuario = new javax.swing.JLabel();
        jLabelAvisoNome = new javax.swing.JLabel();
        jLabelAvisoCpf = new javax.swing.JLabel();
        jTextLogin = new javax.swing.JFormattedTextField();
        jBtVoltar = new javax.swing.JButton();
        jBtRemover = new javax.swing.JButton();
        jTextNome = new javax.swing.JTextField();
        jTextCpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Usuário");

        jPanelPrincipal.setBackground(new java.awt.Color(254, 254, 254));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabelNome.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelNome.setText("Nome:");
        jLabelNome.setPreferredSize(new java.awt.Dimension(55, 30));

        jLabelUsuario.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelUsuario.setText("Usuário:");
        jLabelUsuario.setPreferredSize(new java.awt.Dimension(55, 30));

        jLabelCpf.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelCpf.setText("CPF");
        jLabelCpf.setPreferredSize(new java.awt.Dimension(55, 30));

        jBtSalvar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jLabelTipo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelTipo.setText("Tipo:");
        jLabelTipo.setPreferredSize(new java.awt.Dimension(55, 30));

        jComboBoxTipo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Admin" }));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabelEditarUsuario.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabelEditarUsuario.setText("Editar Usuário");

        jLabelAvisoNome.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoNome.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoCpf.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N

        jTextLogin.setEnabled(false);
        jTextLogin.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextLogin.setRequestFocusEnabled(false);
        jTextLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextLoginFocusLost(evt);
            }
        });
        jTextLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextLoginKeyTyped(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        jBtRemover.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jBtRemover.setText("Remover");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jTextNome.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNomeKeyTyped(evt);
            }
        });

        jTextCpf.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCpfKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup().addContainerGap().addGroup(jPanelPrincipalLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 416, Short.MAX_VALUE)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanelPrincipalLayout.createSequentialGroup().addGroup(jPanelPrincipalLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanelPrincipalLayout.createSequentialGroup()
                                                                        .addComponent(jBtRemover,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                133,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(332, 332, 332))
                                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup().addGap(8, 8, 8)
                                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelCpf,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelUsuario,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelNome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelTipo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBoxTipo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(jTextNome,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jTextCpf,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jTextLogin,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        187,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jBtSalvar,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                105,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelAvisoNome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelAvisoCpf,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                187,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(205, 205, 205))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanelPrincipalLayout.createSequentialGroup().addComponent(jLabelEditarUsuario).addGap(459,
                                                        459, 459)))))));
        jPanelPrincipalLayout.setVerticalGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup().addGap(44, 44, 44).addComponent(jLabelEditarUsuario)
                        .addGap(93, 93, 93)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabelAvisoNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelAvisoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtRemover).addComponent(jBtSalvar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(jBtVoltar).addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtSalvarActionPerformed
        this.limparAvisos();
        this.checkJTextNome();
        this.checkJTextCpf();

        if (!formIsInvalid()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
            return;
        }

        try {
            this.usuario.setNome(jTextNome.getText());
            this.usuario.setCpf(jTextCpf.getText());
            this.usuario.setLogin(jTextLogin.getText());
            char tipo = jComboBoxTipo.getSelectedItem().toString().equals("Usuário") ? 'U' : 'A';
            this.usuario.setTipo(tipo);
            this.usuario.save();
            JOptionPane.showMessageDialog(null, "Informações Alteradas");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do usuário.");
        }

        
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jTextLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextLoginFocusLost
        
    }//GEN-LAST:event_jTextLoginFocusLost

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        EdicaoUsuario.this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLoginKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLoginKeyTyped

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        int removerUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover"
                + " o usuário: "+ usuario.getLogin() +"?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (removerUsuario != 0) {
            return;
        }

        try {
            usuario.delete();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao deletar usuário.");
        }

        JOptionPane.showMessageDialog(null,"Usuário Removido.");
        
        EdicaoUsuario.this.dispose();
        
        new Usuarios().setVisible(true);

    }//GEN-LAST:event_jBtRemoverActionPerformed

    private void jTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNomeKeyTyped
        
    }//GEN-LAST:event_jTextNomeKeyTyped

    private void jTextCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCpfKeyTyped
        if(!(evt.getKeyChar()+"").matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCpfKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtRemover;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelEditarUsuario;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelAvisoNome;
    private javax.swing.JLabel jLabelAvisoCpf;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextCpf;
    private javax.swing.JFormattedTextField jTextLogin;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}
