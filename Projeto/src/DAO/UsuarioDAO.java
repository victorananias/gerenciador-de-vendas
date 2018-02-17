package DAO;

import Models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO extends DAOGenerico{
    
    public void cadastrarUsuario(Usuario usuarios) {
        String sql = "INSERT INTO usuarios(id, nome, cpf, senha, tipo)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    usuarios.getId(),
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
    
    public Usuario buscarUsuario(String id) {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> listaUsuarios = filtrarUsuarios(id);
        if(!listaUsuarios.isEmpty()) {
            usuario = listaUsuarios.get(0);
        }
        return usuario;
    }
    
    public ArrayList<Usuario> filtrarUsuarios(String id) {
        try {
            return buscar("where id='"+id+"'");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario "+erro);
            return null;
        }
    }
    
    public ArrayList<Usuario> buscar(String where) throws SQLException {
        ArrayList<Usuario> lista = new ArrayList();
        
        String sql = "SELECT id, nome, cpf, senha, tipo FROM usuarios "+where;
        
        PreparedStatement pStmt = getConexao().prepareStatement(sql);
        ResultSet resultado = pStmt.executeQuery();

        while (resultado.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultado.getString("id"));
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
