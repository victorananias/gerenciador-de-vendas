package Controllers;

import Models.Usuario;
import DAO.UsuarioDAO;
import Helpers.SenhaHelper;
import java.util.ArrayList;


public class UsuariosController {
    
    public void cadastraUsuario(Usuario usuario) {
        usuario.setTipo(usuario.getTipo().equals("Usuário") ? "U" : "A");
        new UsuarioDAO().cadastrarUsuario(usuario);
    }
    
    
    public ArrayList<Usuario> buscarUsuarios() {
        return new UsuarioDAO().buscarUsuarios();
    }
    
    
    public void setUsuarioAtual(String nomeUsuario) {
        Usuario usuario = new UsuarioDAO().buscarUsuario(nomeUsuario);
        Usuario.setAtual(usuario);
    }
    
    
    public boolean validarNomeUsuario(String nomeUsuario) {
        Usuario usuario;
        usuario = new UsuarioDAO().buscarUsuario(nomeUsuario);
        return usuario.getNomeUsuario() != null;
    }
    
    
    public boolean getValidadeSenha(String senha, String nomeUsuario) {
        Usuario usuario;
        usuario = new UsuarioDAO().buscarUsuario(nomeUsuario);
        
        senha = new SenhaHelper().criptografarSenha(senha);
        return usuario.getSenha().equals(senha);
    }
    
    
    public Usuario buscarUsuario(String nomeUsuario) {
        return new UsuarioDAO().buscarUsuario(nomeUsuario);
    }
    
    public void atualizarUsuario(Usuario usuario) {
        new UsuarioDAO().atualizarUsuario(usuario);
    }
    
    
    public void alterarSenhaUsuario(String senha, String nomeUsuario) {
        new UsuarioDAO().alterarSenha(senha, nomeUsuario);
    }
    
    public void removeUsuario(String nomeUsuario) {
        new UsuarioDAO().removerUsuario(nomeUsuario);
    }
    
}
