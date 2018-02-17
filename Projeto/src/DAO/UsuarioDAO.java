package DAO;

import Models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO extends DAOGenerico{
    
    public void cadastrarUsuario(Usuario usuarios) {
        String sql = "INSERT INTO usuarios(nome_usuario, nome, cpf, senha, tipo)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    usuarios.getNomeUsuario(),
                    usuarios.getNome(),
                    usuarios.getCpf(),
                    usuarios.getSenha(),
                    usuarios.getTipo());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuario "+e);
        }
    }
    
    public ArrayList<Usuario> buscarUsuarios() {
        try {
            return buscar("");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuarios "+erro);
            return null;
        }
    }
    
    public Usuario buscarUsuario(String nomeUsuario) {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        try {
            listaUsuarios = buscar("where nome_usuario='"+nomeUsuario+"'");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar usuario "+erro);
        }
        
        if(!listaUsuarios.isEmpty()) {
            usuario = listaUsuarios.get(0);
        }
        return usuario;
    }
    
    public ArrayList<Usuario> buscar(String where) throws SQLException {
        ArrayList<Usuario> lista = new ArrayList();
        
        String sql = "SELECT id, nome_usuario, nome, cpf, senha, tipo FROM usuarios "+where;
        
        PreparedStatement pStmt = getConexao().prepareStatement(sql);
        ResultSet resultado = pStmt.executeQuery();

        while (resultado.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultado.getInt("id"));
            usuario.setNomeUsuario(resultado.getString("nome_usuario"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setCpf(resultado.getString("cpf"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setTipo(
                    resultado.getString("tipo").equals("A") ?
                            "Admin" : "Usuário");
            lista.add(usuario);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
        
        return lista;
    }
    
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios set nome_usuario = ?, "
                + "nome = ? , cpf = ?, tipo = ? "
                + "where id = ?";
        
        try {
            update(sql, usuario.getId(), usuario.getNomeUsuario(), 
                    usuario.getNome(), usuario.getCpf(), usuario.getTipo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do usuário "+e);
            
        }
    }
    
    public void alterarSenha(String senha, String nomeUsuario) {
        String sql = "UPDATE usuarios set senha = ? where nome_usuario = ?";
        try {
            update(sql, nomeUsuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha "+e);
            
        }
    }
    
    public void removerUsuario(String nomeUsuario) {
        String sql = "DELETE FROM usuarios where nome_usuario = ?";
        try {
            delete(sql, nomeUsuario);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário "+e);
        }
    }
}
