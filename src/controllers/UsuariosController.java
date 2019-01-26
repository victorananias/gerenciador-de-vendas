package controllers;

import models.Usuario;
import services.AuthService;
import dao.UsuarioDAO;
import helpers.SenhaHelper;
import java.util.ArrayList;


public class UsuariosController {
    
    public void cadastraUsuario(Usuario usuario) {
        usuario.setTipo(usuario.getTipo().equals("Usuário") ? "U" : "A");
        new UsuarioDAO().insert(usuario);
    }
    
    
    public ArrayList<Usuario> buscarUsuarios() {
        return new UsuarioDAO().buscarUsuarios();
    }
    
    
    public void setUsuarioAtual(String login) {
        Usuario usuario = new UsuarioDAO().buscarUsuario(login);
        AuthService.setUser(usuario);
    }
    
    
    public boolean validarLogin(String login) {
        Usuario usuario;
        usuario = new UsuarioDAO().buscarUsuario(login);
        return usuario.getLogin() != null;
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
    
    
    public void alterarSenhaUsuario(String senha, int id) {
        new UsuarioDAO().alterarSenha(senha, id);
    }
    
    public void removeUsuario(String login) {
        new UsuarioDAO().removerUsuario(login);
    }
    
}
