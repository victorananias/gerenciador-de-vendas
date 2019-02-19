package views;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.MascaraMonetaria;
import models.ItemVenda;
import models.Venda;

public class HistoricoVendasProdutos extends javax.swing.JFrame {
    private static final long serialVersionUID = -4804893350212309060L;
    private ArrayList<ItemVenda> itensVenda = new ArrayList<>();
    private Venda venda;

    DefaultTableModel modelTbHistorico = new DefaultTableModel(new Object[][] {},
            new String[] { "Código Venda", "Código Produto", "Nome Produto", "Valor", "Quantidade" }) {
        private static final long serialVersionUID = -4619459734196977870L;
        boolean[] canEdit = new boolean[] { false, false, false, false, false };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public HistoricoVendasProdutos(Venda venda) {
        this.venda = venda;
        this.initComponents();
        this.updateTb();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProds = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jBtMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Produtos da Venda");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jTbProds.setModel(this.modelTbHistorico);

        jTbProds.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTbProds);
        
        if (jTbProds.getColumnModel().getColumnCount() > 0) {
            jTbProds.getColumnModel().getColumn(0).setResizable(false);
            jTbProds.getColumnModel().getColumn(1).setResizable(false);
            jTbProds.getColumnModel().getColumn(2).setResizable(false);
            jTbProds.getColumnModel().getColumn(3).setResizable(false);
            jTbProds.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Produtos da Venda");

        jBtMenu.setText("Voltar");
        jBtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jBtMenu,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(408, 408, 408).addComponent(jLabelTitle)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup().addGap(0, 32, Short.MAX_VALUE).addComponent(jScrollPane1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(jLabelTitle).addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28).addComponent(jBtMenu).addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtMenuActionPerformed
        HistoricoVendasProdutos.this.dispose();
        new HistoricoVendas().setVisible(true);
    }// GEN-LAST:event_jBtMenuActionPerformed

    private void updateTb() {
        try {
            this.itensVenda = venda.getItens();

            for (int i = 0; i < this.itensVenda.size(); i++) {
                this.modelTbHistorico.addRow(new String[]{
                    String.valueOf(this.itensVenda.get(i).getVendaId()),
                    String.valueOf(this.itensVenda.get(i).getProdutoId()),
                    String.valueOf(this.itensVenda.get(i).getProduto().getNome()),
                    String.valueOf(MascaraMonetaria.add(this.itensVenda.get(i).getValor())),
                    String.valueOf(this.itensVenda.get(i).getQuantidade())});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens da venda.");
        }
        
        
        jTbProds.setModel(this.modelTbHistorico);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbProds;
    // End of variables declaration//GEN-END:variables
}
