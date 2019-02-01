package views;

import models.Usuario;
import services.AuthService;

public class Menu extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;

    public Menu() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.verificaTipoUsuario();
        this.setLogin();
        
    }
    
    private void setLogin(){
        jLabelNomeUsuaro.setText(AuthService.getUser().getNome());
    }
    
    private void verificaTipoUsuario(){
        if (!AuthService.getUser().isAdmin()){
            jBtUsuarios.setVisible(false);
        }
    }
    
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jBtVenda = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jBtHistorico = new javax.swing.JButton();
        jBtUsuarios = new javax.swing.JButton();
        jBtEstoque = new javax.swing.JButton();
        jLabelNomeUsuaro = new javax.swing.JLabel();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jPanelPrincipal.setBackground(new java.awt.Color(254, 254, 254));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(1100, 600));

        jBtVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtVenda.setText("Vendas");
        jBtVenda.setPreferredSize(new java.awt.Dimension(200, 100));
        jBtVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVendaActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setText("Menu");

        jBtHistorico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtHistorico.setText("Histórico");
        jBtHistorico.setPreferredSize(new java.awt.Dimension(200, 100));
        jBtHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtHistoricoActionPerformed(evt);
            }
        });

        jBtUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtUsuarios.setText("Usuários");
        jBtUsuarios.setPreferredSize(new java.awt.Dimension(200, 100));
        jBtUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtUsuariosActionPerformed(evt);
            }
        });

        jBtEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtEstoque.setText("Estoque");
        jBtEstoque.setPreferredSize(new java.awt.Dimension(200, 100));
        jBtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEstoqueActionPerformed(evt);
            }
        });

        jLabelNomeUsuaro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(0, 153, 204));
        jBtSair.setText("Sair");
        jBtSair.setBorderPainted(false);
        jBtSair.setContentAreaFilled(false);
        jBtSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtSairMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtSairMouseEntered(evt);
            }
        });
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(jLabelTitle))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelNomeUsuaro, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jBtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jBtHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jBtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(193, 193, 193))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomeUsuaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabelTitle)))
                .addGap(146, 146, 146)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addComponent(jBtUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVendaActionPerformed
        Vendas v = new Vendas();
        v.setVisible(true);
        Menu.this.dispose();
    }//GEN-LAST:event_jBtVendaActionPerformed

    private void jBtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEstoqueActionPerformed
        Estoque e = new Estoque();
        e.setVisible(true);
        Menu.this.dispose();
    }//GEN-LAST:event_jBtEstoqueActionPerformed

    private void jBtUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtUsuariosActionPerformed
        Usuarios u = new Usuarios();
        u.setVisible(true);
        Menu.this.dispose();
    }//GEN-LAST:event_jBtUsuariosActionPerformed

    private void jBtHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtHistoricoActionPerformed
        HistoricoVendas h = new HistoricoVendas();
        h.setVisible(true);
        Menu.this.dispose();
    }//GEN-LAST:event_jBtHistoricoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        new Login().setVisible(true);
        Menu.this.dispose();
        AuthService.setUser(new Usuario());
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtSairMouseEntered
        jBtSair.setForeground(java.awt.Color.red);
    }//GEN-LAST:event_jBtSairMouseEntered

    private void jBtSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtSairMouseExited
        jBtSair.setForeground(new java.awt.Color(0, 153, 204));
    }//GEN-LAST:event_jBtSairMouseExited
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEstoque;
    private javax.swing.JButton jBtHistorico;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtUsuarios;
    private javax.swing.JButton jBtVenda;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelNomeUsuaro;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
