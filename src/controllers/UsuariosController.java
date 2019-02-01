package controllers;

import models.Usuario;
import services.AuthService;
import helpers.Senha;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosController {

    public void cadastraUsuario(String login, String nome, String cpf, String senha, String tipo)
            throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setSenha(Senha.encrypt(senha));
        usuario.setTipo(tipo.equals("Usuário") ? 'U' : 'A');
        usuario.save();
    }
    
    public ArrayList<Usuario> buscarUsuarios() throws SQLException {
        return Usuario.all();
    }

    public boolean login(String login, String senha) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        return AuthService.login(login, senha);
    }
}
