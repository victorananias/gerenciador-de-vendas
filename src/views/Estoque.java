package views;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.MascaraMonetaria;
import controllers.ProdutosController;
import models.Produto;
import services.AuthService;

public class Estoque extends javax.swing.JFrame {

    private static final long serialVersionUID = -4690580035236381218L;
    ArrayList<Produto> produtos = new ArrayList<>();

    DefaultTableModel modelTbProdutos = new DefaultTableModel(new Object[][] {},
            new String[] { "Código", "Produto", "Em Estoque", "Preço Unidade" }) {
        private static final long serialVersionUID = 148222969011347454L;
        boolean[] canEdit = new boolean[] { false, false, false, false };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public Estoque() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.geraTabelaProdutos();
        this.verificaTipoUsuario();
    }

    private void geraTabelaProdutos() {

        try {
            produtos = new ProdutosController().buscarProdutos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Você nâo selecionou um produto");
        }

        for (int contador = 0; contador < produtos.size(); contador++) {
            modelTbProdutos.addRow(new String[]{
                String.valueOf(produtos.get(contador).getId()),
                String.valueOf(produtos.get(contador).getNome()),
                String.valueOf(produtos.get(contador).getQuantidade()),
                String.valueOf(MascaraMonetaria.add(produtos.get(contador).getValor()))
            });
        }

        jTbProd.setModel(modelTbProdutos);
    }

    private void procuraLinha(String palavra){
        
        for(int contador = 0; contador < jTbProd.getRowCount(); contador++){
            String codProd = jTbProd.getValueAt(contador, 1).toString();
            
            if(codProd.contains(palavra)){
                jTbProd.setRowSelectionInterval(contador,contador);
                break;
            }
            
        }
    }
    
    private void verificaTipoUsuario(){
        if (!AuthService.getUser().isAdmin()){
            jBtEditar.setVisible(false);
        }
    }
    
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProd = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jBtCadastrarProd = new javax.swing.JButton();
        jBtEditar = new javax.swing.JButton();
        jBtMenu = new javax.swing.JButton();
        jBtGerenciar = new javax.swing.JButton();
        jLabelPesquisar = new javax.swing.JLabel();
        jTextPesquisa = new javax.swing.JTextField();
        jBtLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque");

        jPanelPrincipal.setBackground(new java.awt.Color(254, 254, 254));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(1100, 600));

        jTbProd.setModel(this.modelTbProdutos);
        jTbProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTbProd);

        if (jTbProd.getColumnModel().getColumnCount() > 0) {
            jTbProd.getColumnModel().getColumn(0).setResizable(false);
            jTbProd.getColumnModel().getColumn(1).setResizable(false);
            jTbProd.getColumnModel().getColumn(2).setResizable(false);
            jTbProd.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Estoque");

        jBtCadastrarProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCadastrarProd.setText("Cadastrar Produto");
        jBtCadastrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarProdActionPerformed(evt);
            }
        });

        jBtEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtEditar.setText("Editar");
        jBtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEditarActionPerformed(evt);
            }
        });

        jBtMenu.setText("Menu");
        jBtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMenuActionPerformed(evt);
            }
        });

        jBtGerenciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtGerenciar.setText("Gerenciar");
        jBtGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGerenciarActionPerformed(evt);
            }
        });

        jLabelPesquisar.setText("Pesquisar:");

        jTextPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPesquisaKeyTyped(evt);
            }
        });

        jBtLimpar.setText("Limpar");
        jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabelPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtLimpar))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtCadastrarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtGerenciar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelTitle)
                .addGap(51, 51, 51)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtLimpar)))
                .addGap(18, 18, 18)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jBtCadastrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtGerenciar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jBtMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtCadastrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarProdActionPerformed
       new CadastroProduto().setVisible(true);
       Estoque.this.dispose();
    }//GEN-LAST:event_jBtCadastrarProdActionPerformed

    private void jBtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEditarActionPerformed
        if (jTbProd.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Você não selecionou um produto.");
            return;
        }

        new EdicaoProduto(this.produtos.get(jTbProd.getSelectedRow())).setVisible(true);
        Estoque.this.dispose();
    }//GEN-LAST:event_jBtEditarActionPerformed

    private void jBtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMenuActionPerformed
        new Menu().setVisible(true);
        Estoque.this.dispose();
    }//GEN-LAST:event_jBtMenuActionPerformed

    private void jBtGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGerenciarActionPerformed
        new GerenciarProdutos().setVisible(true);
        Estoque.this.dispose();
    }//GEN-LAST:event_jBtGerenciarActionPerformed

    private void jTextPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyTyped
        procuraLinha(jTextPesquisa.getText());
    }//GEN-LAST:event_jTextPesquisaKeyTyped

    private void jBtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparActionPerformed
        jTextPesquisa.setText("");
    }//GEN-LAST:event_jBtLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrarProd;
    private javax.swing.JButton jBtEditar;
    private javax.swing.JButton jBtGerenciar;
    private javax.swing.JButton jBtLimpar;
    private javax.swing.JButton jBtMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbProd;
    private javax.swing.JTextField jTextPesquisa;
    // End of variables declaration//GEN-END:variables
}
