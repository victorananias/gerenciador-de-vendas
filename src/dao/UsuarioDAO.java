package dao;

import models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO extends DAO{
    
    public void insert(Usuario usuario) {
        String sql = "INSERT INTO usuario(login, nome, cpf, senha, tipo)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    usuario.getLogin(),
                    usuario.getNome(),
                    usuario.getCpf(),
                    usuario.getSenha(),
                    usuario.getTipo());
            
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
    
    public Usuario buscarUsuario(String login) {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        try {
            listaUsuarios = this.buscar("WHERE login='"+login+"'");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar usuario "+erro);
        }
        
        if(!listaUsuarios.isEmpty()) {
            usuario = listaUsuarios.get(0);
        }
        return usuario;
    }
    
    public ArrayList<Usuario> buscar(String where) throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        String sql = "SELECT id, login, nome, cpf, senha, tipo FROM usuarios "+where;
        
        ResultSet resultado = getConexao().prepareStatement(sql).executeQuery();

        while (resultado.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultado.getInt("id"));
            usuario.setLogin(resultado.getString("login"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setCpf(resultado.getString("cpf"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setTipo(
                    resultado.getString("tipo").equals("A") ?
                            "Admin" : "Usuário");
            lista.add(usuario);
        }
        
        resultado.close();
        getConexao().close();
        
        return lista;
    }
    
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET login = ?, "
                + "nome = ? , cpf = ?, tipo = ? "
                + "WHERE id = ?";
        
        try {
            update(sql, usuario.getId(), usuario.getLogin(), 
                    usuario.getNome(), usuario.getCpf(), usuario.getTipo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do usuário "+e);
            
        }
    }
    
    public void alterarSenha(String senha, int id) {
        String sql = "UPDATE usuarios SET senha = ? WHERE id = ?";
        try {
            this.update(sql, id, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha "+e);
            
        }
    }
    
    public void removerUsuario(String login) {
        String sql = "DELETE FROM usuarios WHERE login = ?";
        
        try {
            delete(sql, login);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário "+e);
        }
    }
}
