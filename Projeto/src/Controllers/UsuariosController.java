package Controllers;

import Models.Usuario;
import DAO.UsuarioDAO;
import Models.Senha;
import java.util.ArrayList;


public class UsuariosController {
    
    public void cadastraUsuario(Usuario usuario) {
        usuario.setTipo(usuario.getTipo().equals("Usuário") ? "U" : "A");
        new UsuarioDAO().cadastrarUsuario(usuario);
    }
    
    
    public ArrayList<Usuario> buscarUsuarios() {
        return new UsuarioDAO().buscarUsuarios();
    }
    
    
    public void setUsuarioAtual(String id) {
        Usuario usuario = new UsuarioDAO().buscarUsuario(id);
        Usuario.setAtual(usuario);
    }
    
    
    public boolean validarId(String id) {
        Usuario usuario;
        usuario = new UsuarioDAO().buscarUsuario(id);
        return usuario.getId() != null;
    }
    
    
    public boolean getValidadeSenha(String senha, String id) {
        Usuario usuario;
        usuario = new UsuarioDAO().buscarUsuario(id);
        
        senha = Senha.criptografarSenha(senha);
        return usuario.getSenha().equals(senha);
    }
    
    
    public Usuario buscarUsuario(String id) {
        return new UsuarioDAO().buscarUsuario(id);
    }
    
    
    public void atualizarUsuario(Usuario usuario) {
        new UsuarioDAO().atualizarUsuario(usuario);
    }
    
    
    public void alterarSenhaUsuario(String senha, String id) {
        new UsuarioDAO().alterarSenha(senha, id);
    }
    
    public void removeUsuario (String id) {
        new UsuarioDAO().removerUsuario(id);
    }
    
}
