package dao;

import models.ItemVenda;
import models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemVendaDAO extends DAO{
    
    public void registrarItemVenda(ItemVenda item) {
        String sql = "INSERT INTO itens_venda(valor, quantidade, venda_id, produto_id)"
                +" VALUES(?,?,?,?)";
        
        try {
            insert(
                    sql,
                    item.getValor(),
                    item.getQuantidade(),
                    item.getVendaId(),
                    item.getProdutoId());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar os itens da venda "+e);
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        ArrayList<ItemVenda> lista = new ArrayList();
        
        String sql = "SELECT p.id AS produto_id, "
                    + "i.id, "
                    + "i.venda_id, "
                    + "p.nome AS nome_produto, "
                    + "i.quantidade, "
                    + "i.valor "
                    + "FROM itens_venda AS i "
                    + "JOIN produtos AS p ON p.id = i.produto_id "
                    + "WHERE i.venda_id = ?";
        
        PreparedStatement pStmt;
        try {
            pStmt = getConexao().prepareStatement(sql);
            
            pStmt.setInt(1, idVenda);
        
            ResultSet resultado = pStmt.executeQuery();

            while (resultado.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setId(resultado.getInt("venda_id"));
                itemVenda.setProdutoId(resultado.getInt("produto_id"));
                itemVenda.setNomeProduto(resultado.getString("nome_produto"));
                itemVenda.setValor(resultado.getDouble("valor"));
                itemVenda.setQuantidade(resultado.getInt("quantidade"));
            
                lista.add(itemVenda);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens da venda "+erro);
            return null;
        }
        
        return lista;
    }
    
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, cpf = ?, tipo = ? WHERE id = ?";
        try {
            update(sql, usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getTipo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do usuário "+e);
            
        }
    }
    
    public void alterarSenha(String senha, String id) {
        String sql = "UPDATE usuarios SET senha = ? WHERE id = ?";
        try {
            update(sql, id, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha "+e);
            
        }
    }
    
    public void removerUsuario(String id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            this.delete(sql, id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário "+e);
        }
    }
}
