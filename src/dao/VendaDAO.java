package dao;

import models.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDAO extends DAO{
    
    public void insert(Venda venda) {
        String sql = "INSERT INTO vendas(quantidade_total, valor_total, usuario_id)  VALUES(?,?,?)";
        
        try {
            insert(
                sql,
                venda.getQuantidadeTotal(),
                venda.getValorTotal(),
                venda.getUsuarioId()
            );
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar venda "+e);
        }
    }
    
    public ArrayList<Venda> getAll() {
        ArrayList<Venda> lista = new ArrayList();

        String sql = "SELECT v.*, "
                + " (SELECT login FROM usuarios AS u WHERE u.id = v.usuario_id LIMIT 1) AS login"
                + " FROM vendas AS v ";

        try {
            this.select(sql);

            while(this.nextResult()) {
                lista.add(Venda.make(result()));
            }

            this.closeConnection();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas "+erro);
            return null;
        }

        return lista;
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
            venda.setCreatedAt(resultado.getString("created_at"));
            venda.setLogin(resultado.getString("login"));
            lista.add(venda);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
        
        return lista;
    }

}
