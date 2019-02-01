package controllers;

import models.Usuario;
import models.Venda;
import services.AuthService;

import java.sql.SQLException;
import java.util.ArrayList;

public class VendasController {

    public void registrarVenda(Venda venda) throws SQLException {
        venda.setUsuarioId(AuthService.getUser().getId());
        venda.save();
    }

    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) throws SQLException {
        if (usuario.isAdmin()) {
            return Venda.all();
        } else {
            return usuario.getVendas();
        }
    }
    
}
