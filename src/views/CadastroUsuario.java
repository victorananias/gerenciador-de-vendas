
package views;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import controllers.UsuariosController;

public class CadastroUsuario extends javax.swing.JFrame {
    private static final long serialVersionUID = -675651608089314887L;

    public CadastroUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void verificaUsuario() {
        if (jFormattedTextUsuario.getText().equals("")) {
            jLabelAvisoUsuario.setText("Campo obrigatório");
            return;
        }

        jLabelAvisoUsuario.setText("");
    }

    private void verificaNome() {
        if (jFormattedTextNome.getText().equals("")) {
            jLabelAvisoNome.setText("Campo obrigatório");
            return;
        }

        jLabelAvisoNome.setText("");
    }

    private void verificaCpf() {
        if (jTextCpf.getText().equals("")) {
            jLabelAvisoCpf.setText("Campo obrigatório");
        } else if (jTextCpf.getText().length() != 11) {
            jLabelAvisoCpf.setText("CPF inválido");
        } else {
            jLabelAvisoCpf.setText("");
        }
    }

    private void verificaSenha() {
        if (jPwSenha.getText().equals("")) {
            jLabelAvisoSenha.setText("Campo obrigatório");
        } else if (jPwSenha.getText().length() < 8) {
            jLabelAvisoSenha.setText("Mínimo 8 caracteres");
        } else {
            jLabelAvisoSenha.setText("");
        }
    }

    private void verificaSenhaCoincide() {
        if (jPwSenha.getText().length() >= 8) {
            if (jPwRepete.getText().equals("")) {
                jLabelAvisoSenhaRepete.setText("Campo obrigatório");
            } else if (jPwSenha.getText().equals(jPwRepete.getText())) {
                jLabelAvisoSenhaRepete.setText("");
            } else {
                jLabelAvisoSenhaRepete.setText("Senhas não coincidem");
            }
        } else if (jPwSenha.getText().length() < 8) {
            if (jPwSenha.getText().equals(jPwRepete.getText())) {
                jLabelAvisoSenhaRepete.setText("Campo obrigatório");
            } else if (!jPwRepete.getText().equals("")) {
                jLabelAvisoSenhaRepete.setText("Senhas não coincidem");
            } else {
                jLabelAvisoSenhaRepete.setText("");
            }
        } else {
            jLabelAvisoSenhaRepete.setText("");
        }
    }

    private void limpaAvisos() {
        jLabelAvisoUsuario.setText("");
        jLabelAvisoNome.setText("");
        jLabelAvisoCpf.setText("");
        jLabelAvisoSenha.setText("");
        jLabelAvisoSenhaRepete.setText("");
    }

    private void limparCampos() {
        jFormattedTextNome.setText("");
        jFormattedTextUsuario.setText("");
        jTextCpf.setText("");
        jPwRepete.setText("");
        jPwSenha.setText("");
    }

    private boolean getStatusAvisos() {
        return jLabelAvisoUsuario.getText().equals("") && jLabelAvisoNome.getText().equals("")
                && jLabelAvisoCpf.getText().equals("") && jLabelAvisoSenha.getText().equals("")
                && jLabelAvisoSenhaRepete.getText().equals("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jFormattedTextNome = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPwSenha = new javax.swing.JPasswordField();
        jPwRepete = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabelAvisoUsuario = new javax.swing.JLabel();
        jLabelAvisoNome = new javax.swing.JLabel();
        jLabelAvisoCpf = new javax.swing.JLabel();
        jLabelAvisoSenha = new javax.swing.JLabel();
        jLabelAvisoSenhaRepete = new javax.swing.JLabel();
        jFormattedTextUsuario = new javax.swing.JFormattedTextField();
        jTextCpf = new javax.swing.JTextField();
        jBtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Usuário");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabel1.setText("Nome:");
        jLabel1.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("Usuário:");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabel4.setText("CPF");
        jLabel4.setMinimumSize(new java.awt.Dimension(105, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(105, 30));

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo:");
        jLabel5.setPreferredSize(new java.awt.Dimension(105, 30));

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Admin" }));
        jComboBoxTipo.setMinimumSize(new java.awt.Dimension(85, 30));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(120, 30));

        jFormattedTextNome.setPreferredSize(new java.awt.Dimension(185, 30));
        jFormattedTextNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextNomeFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setText("Cadastrar Usuário");

        jLabel6.setText("Senha:");
        jLabel6.setPreferredSize(new java.awt.Dimension(105, 30));

        jPwSenha.setPreferredSize(new java.awt.Dimension(185, 30));
        jPwSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPwSenhaFocusLost(evt);
            }
        });

        jPwRepete.setPreferredSize(new java.awt.Dimension(185, 30));
        jPwRepete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPwRepeteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPwRepeteFocusLost(evt);
            }
        });

        jLabel7.setText("Confirm Senha:");
        jLabel7.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabelAvisoUsuario.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoUsuario.setForeground(java.awt.Color.red);
        jLabelAvisoUsuario.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoNome.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoNome.setForeground(java.awt.Color.red);
        jLabelAvisoNome.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoCpf.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoCpf.setForeground(java.awt.Color.red);
        jLabelAvisoCpf.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoSenha.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoSenha.setForeground(java.awt.Color.red);
        jLabelAvisoSenha.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoSenhaRepete.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAvisoSenhaRepete.setForeground(java.awt.Color.red);
        jLabelAvisoSenhaRepete.setPreferredSize(new java.awt.Dimension(185, 30));

        jFormattedTextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextUsuarioActionPerformed(evt);
            }
        });
        jFormattedTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextNomeKeyTyped(evt);
            }
        });

        jTextCpf.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCpfKeyTyped(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(
                                                jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                        .createSequentialGroup().addGap(0, 365, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false).addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel7,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        111, Short.MAX_VALUE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPwSenha,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPwRepete,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel4,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jFormattedTextNome,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jTextCpf,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(
                                                                                        jFormattedTextUsuario,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        185,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jComboBoxTipo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(
                                                                                jLabelAvisoCpf,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                jLabelAvisoSenha,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelAvisoSenhaRepete,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelAvisoUsuario,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelAvisoNome,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addGap(212, 212, 212))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(433, 433, 433)))))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(jLabel3)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAvisoUsuario, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelAvisoNome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextNome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelAvisoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPwSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelAvisoSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAvisoSenhaRepete, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPwRepete, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtVoltar).addComponent(jBtSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtSalvarActionPerformed
        this.limpaAvisos();
        this.verificaUsuario();
        this.verificaNome();
        this.verificaCpf();
        this.verificaSenha();
        this.verificaSenhaCoincide();

        if (!this.getStatusAvisos()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
        }

        try {
            new UsuariosController().cadastraUsuario(jFormattedTextUsuario.getText(), jFormattedTextNome.getText(),
                    jTextCpf.getText(), jPwSenha.getText(), jComboBoxTipo.getSelectedItem().toString());
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
        }
        
        JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
        
        this.limparCampos();
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jPwRepeteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPwRepeteFocusGained

    private void jPwSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwSenhaFocusLost
        
    }//GEN-LAST:event_jPwSenhaFocusLost

    private void jPwRepeteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusLost
        
    }//GEN-LAST:event_jPwRepeteFocusLost

    private void jFormattedTextUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextUsuarioFocusLost
        this.verificaUsuario();
    }//GEN-LAST:event_jFormattedTextUsuarioFocusLost

    private void jFormattedTextNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextNomeFocusLost
        
    }//GEN-LAST:event_jFormattedTextNomeFocusLost

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        CadastroUsuario.this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCpfKeyTyped
        if(!String.valueOf(evt.getKeyChar()).matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCpfKeyTyped

    private void jFormattedTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextNomeKeyTyped
        if(!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z ]")){
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextNomeKeyTyped

    private void jFormattedTextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JFormattedTextField jFormattedTextNome;
    private javax.swing.JFormattedTextField jFormattedTextUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAvisoUsuario;
    private javax.swing.JLabel jLabelAvisoNome;
    private javax.swing.JLabel jLabelAvisoCpf;
    private javax.swing.JLabel jLabelAvisoSenha;
    private javax.swing.JLabel jLabelAvisoSenhaRepete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPwRepete;
    private javax.swing.JPasswordField jPwSenha;
    private javax.swing.JTextField jTextCpf;
    // End of variables declaration//GEN-END:variables
}
