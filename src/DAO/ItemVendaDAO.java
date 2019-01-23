package DAO;

import Models.ItemVenda;
import Models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemVendaDAO extends DAOGenerico{
    
    public void registrarItemVenda(ItemVenda item) {
        String sql = "INSERT INTO itens_venda(valor, quantidade, id_venda, id_produto)"
                +" VALUES(?,?,?,?)";
        
        try {
            insert(
                    sql,
                    item.getValor(),
                    item.getQuantidade(),
                    item.getIdVenda(),
                    item.getIdProduto());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar os itens da venda "+e);
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        ArrayList<ItemVenda> lista = new ArrayList();
        
        String sql = "SELECT p.id AS id_produto, "
                    + "i.id as id_itens_venda, "
                    + "i.id_venda, "
                    + "p.nome as nome_produto, "
                    + "i.quantidade, "
                    + "i.valor "
                    + "FROM itens_venda AS i "
                    + "join produtos AS p on p.id=i.id_produto "
                    + "where i.id_venda=?";
        
        PreparedStatement pStmt;
        try {
            pStmt = getConexao().prepareStatement(sql);
            
            pStmt.setInt(1, idVenda);
        
            ResultSet resultado = pStmt.executeQuery();

            while (resultado.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setId(resultado.getInt("id_venda"));
                itemVenda.setIdProduto(resultado.getInt("id_produto"));
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
        String sql = "UPDATE usuarios set nome = ?, cpf = ?, tipo = ? where id = ?";
        try {
            update(sql, usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getTipo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do usuário "+e);
            
        }
    }
    
    public void alterarSenha(String senha, String id) {
        String sql = "UPDATE usuarios set senha = ? where id = ?";
        try {
            update(sql, id, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha "+e);
            
        }
    }
    
    public void removerUsuario(String id) {
        String sql = "DELETE FROM usuarios where id = ?";
        try {
            delete(sql, id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário "+e);
        }
    }
}
