package services;

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
}