package services;

import java.sql.SQLException;

import app.DB;
import helpers.Senha;
import models.Usuario;

public class AuthService {
    private static Usuario user;

    /**
     * @return the user
     */
    public static Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public static void setUser(Usuario user) {
        AuthService.user = user;
    }

    public static boolean login(String login, String senha) throws SQLException {
        DB db  = new DB();

        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        db.select(sql, login, Senha.encrypt(senha));
        
        
        if (db.nextResult()) {
            AuthService.setUser(Usuario.make(db.result()));
            return true;
        }

        db.closeConnection();
        
        return false;
    }
}