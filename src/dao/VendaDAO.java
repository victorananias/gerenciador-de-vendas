package dao;

import models.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDAO extends DAO{
    
    public void registrarVenda(Venda venda) {
        String sql = "INSERT INTO vendas(quantidade_total, valor_total, data, hora, usuario_id)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    venda.getQuantidadeTotal(),
                    venda.getValorTotal(),
                    venda.getData(),
                    venda.getHora(),
                    venda.getUsuarioId());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar venda "+e);
        }
    }
    
    public ArrayList<Venda> buscarVendas() {
        try {
            return this.buscar("");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas "+erro);
            return null;
        }
    }
    
    public ArrayList<Venda> buscarVendasUsuario(int usuarioId) {
        ArrayList<Venda> listaVendas = null;
        try {
            listaVendas = this.buscar("where usuario_id="+usuarioId);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas "+erro);
            return null;
        }
        return listaVendas;
    }
    
    public ArrayList<Venda> buscar(String where) throws SQLException {
        ArrayList<Venda> lista = new ArrayList();
        
        String query = "SELECT v.*, "
                + " (SELECT login FROM usuarios AS u WHERE u.id = v.usuario_id LIMIT 1) AS login"
                + " FROM vendas AS v " 
            + where;
        
        PreparedStatement pStmt = getConexao().prepareStatement(query);
        ResultSet resultado = pStmt.executeQuery();

        while (resultado.next()) {
            Venda venda = new Venda();
            venda.setId(resultado.getInt("id"));
            venda.setQuantidadeTotal(resultado.getInt("quantidade_total"));
            venda.setValorTotal(resultado.getDouble("valor_total"));
            venda.setData(resultado.getString("data"));
            venda.setHora(resultado.getString("hora"));
            venda.setLogin(resultado.getString("login"));
            lista.add(venda);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
        
        return lista;
    }

}
