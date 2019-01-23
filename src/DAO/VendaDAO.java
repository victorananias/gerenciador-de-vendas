package DAO;

import Models.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDAO extends DAOGenerico{
    
    public void registrarVenda(Venda venda) {
        String sql = "INSERT INTO vendas(quantidade_total, valor_total, data, hora, id_usuario)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    venda.getQuantidadeTotal(),
                    venda.getValorTotal(),
                    venda.getData(),
                    venda.getHora(),
                    venda.getIdUsuario());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar venda "+e);
        }
    }
    
    public ArrayList<Venda> buscarVendas() {;;
        try {
            return buscar("");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas "+erro);
            return null;
        }
    }
    
    public ArrayList<Venda> buscarVendasUsuario(int idUsuario) {;
        ArrayList<Venda> listaVendas = null;
        try {
            listaVendas = buscar("where id_usuario="+idUsuario);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas "+erro);
            return null;
        }
        return listaVendas;
    }
    
    public ArrayList<Venda> buscar(String where) throws SQLException {
        ArrayList<Venda> lista = new ArrayList();
        
        String query = "SELECT v.id AS id_venda, "
                + "v.quantidade_total, "
                + "v.valor_total, "
                + "v.data, v.hora, "
                + "u.nome_usuario AS nome_usuario "
                + "FROM vendas AS v "
                + "INNER JOIN usuarios AS u "
                + "ON u.id=v.id_usuario "+where;
        
        PreparedStatement pStmt = getConexao().prepareStatement(query);
        ResultSet resultado = pStmt.executeQuery();

        while (resultado.next()) {
            Venda venda = new Venda();
            venda.setId(resultado.getInt("id_venda"));
            venda.setQuantidadeTotal(resultado.getInt("quantidade_total"));
            venda.setValorTotal(resultado.getDouble("valor_total"));
            venda.setData(resultado.getString("data"));
            venda.setHora(resultado.getString("hora"));
            venda.setNomeUsuario(resultado.getString("nome_usuario"));
            lista.add(venda);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
        
        return lista;
    }

}
